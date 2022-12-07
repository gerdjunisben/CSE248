package Control;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import Model.College;
import Model.Query;
import Util.Connect;
import Util.CurrentUser;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CollegeSearchController implements Initializable {

	@FXML
    private Button saveButton;

    @FXML
    private TextField saveText;
    
    @FXML
    private Button addButton;

    @FXML
    private TableColumn<Query, String> attribute;

    @FXML
    private ComboBox<String> attributeBox;

    @FXML
    private ListView<College> listArea;

    @FXML
    private TableColumn<Query, String> query;

    @FXML
    private TextField queryText;

    @FXML
    private Button removeButton;

    @FXML
    private TableView<Query> searchTable;
    
    @FXML
    private Button showButton;

    @FXML
    void addClick(ActionEvent event) {
    	if(attributeBox.getValue() != null && (queryText.getText()!= null || !queryText.getText().equals("")))
    	{
    		char type;
    		if(attributeBox.getValue().equals("Admission") || attributeBox.getValue().equals("Completion"))
    			type = 'd';
    		else if(attributeBox.getValue().equals("InState") || attributeBox.getValue().equals("OutState"))
    			type='i';
    		else
    			type='s';
    		Query query = new Query(attributeBox.getValue(),queryText.getText(),type);
    		ObservableList<Query> list = searchTable.getItems();
    		boolean exists = false;
    		for(int i = 0;i<list.size();i++)
    		{
    			if(list.get(i).getAttribute().equals(attributeBox.getValue()))
    			{
    				exists=true;
    			}
    		}
    		if(!exists)
    		{
    			list.add(query);
    			searchTable.setItems(list);
    		}
    	}
    	searchTable.refresh();
    	if(searchTable.getItems().size()!=0)
    		updateSearch();
    	else
    		listArea.getItems().clear();
    }

    @FXML
    void removeClick(ActionEvent event) {
    	if(attributeBox.getValue() != null)
    	{
    		
    		ObservableList<Query> list = searchTable.getItems();
    		for(int i = 0;i<list.size();i++)
    		{
    			if(list.get(i).getAttribute().equals(attributeBox.getValue()))
    			{
    				list.remove(i);
    				i--;
    			}
    		}
    		searchTable.setItems(list);
    	}
    	searchTable.refresh();
    	if(searchTable.getItems().size()!=0)
    		updateSearch();
    	else
    		listArea.getItems().clear();
    }
    
    public void updateSearch()
    {
    	listArea.getItems().clear();
    	listArea.getItems().addAll(Connect.getSomeColleges(searchTable.getItems()));
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		attribute.setCellValueFactory(
                new PropertyValueFactory<Query, String>("attribute"));
		query.setCellValueFactory(
                new PropertyValueFactory<Query, String>("query"));
		String[] attributes = {"Id","Name","Zip","City","Admission","Completion","InState","OutState"};
		attributeBox.getItems().addAll(attributes);
		
	}
	
	@FXML
    void saveClick(ActionEvent event) {
		Connect.current.addCollege(Integer.parseInt(saveText.getText()));
    }
	
	 @FXML
	 void showClick(ActionEvent event) {
		 listArea.getItems().clear();
		 LinkedList<College> colleges = Connect.getSavedColleges();
		 if(colleges!=null)
			 listArea.getItems().addAll();
	 }

}

