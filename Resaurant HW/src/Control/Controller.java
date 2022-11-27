package Control;

import java.net.URL;
import java.util.ResourceBundle;

import Kitchen.Chef;
import Kitchen.Record;
import Register.Cashier;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;


public class Controller  implements Initializable  {
	
	private Chef chef;
	private Cashier cashier;
	private Waiter waiter;

    @FXML
    private TextArea CashierText;

    @FXML
    private TextArea ChefText;

    @FXML
    private ComboBox<String> CookBox;

    @FXML
    private Button MakeButton;

    @FXML
    private ComboBox<String> MeatBox;

    @FXML
    private ComboBox<String> SpiceBox;

    
    public void initialize(URL url,ResourceBundle resourceBundle)
    {
    	chef = Chef.getChef();
		cashier = Cashier.getCashier();
		waiter = new Waiter(new Record("","",""));
		
		
		String[] dishes = {"Beef","Chicken","Fish","Llama"};
		String[] cooks = {"Boil","Grill"};
		String[] spices = {"Cinnamon","Garlic"};
		SpiceBox.getItems().addAll(spices);
		CookBox.getItems().addAll(cooks);
    	MeatBox.getItems().addAll(dishes);
		
		chef.addPropertyChangeListener(cashier);
		waiter.addPropertyChangeListener(chef);
		
		CookBox.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
				Record record = waiter.getRecord();
		    	Record newRecord = new Record(record.getDish(),CookBox.getValue(),record.getSpice());
		    	waiter.setRecord(newRecord);
			}
	    	
		});
		
		MeatBox.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
				Record record = waiter.getRecord();
		    	Record newRecord = new Record(MeatBox.getValue(),record.getCook(),record.getSpice());
		    	waiter.setRecord(newRecord);
			}
	    	
		});
		
		SpiceBox.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
				Record record = waiter.getRecord();
		    	Record newRecord = new Record(record.getDish(),record.getCook(),SpiceBox.getValue());
		    	waiter.setRecord(newRecord);
			}
	    	
		});
    }
    
    @FXML
    public void cookIt(ActionEvent event) {
		ChefText.appendText(chef.newDish());
		CashierText.appendText("$" + cashier.getBill());
    }
    
    
    
 

}

