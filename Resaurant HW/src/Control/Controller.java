package Control;

import java.net.URL;
import java.util.ResourceBundle;

import Kitchen.Chef;
import Kitchen.Record;
import Register.Cashier;
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
    }
    
    @FXML
    void cookIt(ActionEvent event) {
		ChefText.appendText(chef.newDish());
		CashierText.appendText("$" + cashier.getBill());
    }
    
    @FXML
    void cookChange(ActionEvent event) {
    	waiter.setRecord(waiter.getRecord().setCook(CookBox.getValue()));
    }


    @FXML
    void meatChange(ActionEvent event) {
    	waiter.setRecord(waiter.getRecord().setDish(MeatBox.getValue()));
    }

    @FXML
    void spiceChange(ActionEvent event) {
    	waiter.setRecord(waiter.getRecord().setSpice(SpiceBox.getValue()));
    }

}

