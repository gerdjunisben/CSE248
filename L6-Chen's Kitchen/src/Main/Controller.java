package Main;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import p1.Beef;
import p1.Boil;
import p1.Cinnamon;
import p1.CookBehavior;
import p1.Dish;
import p1.Fish;
import p1.Garlic;
import p1.Grill;
import p1.SpiceBehavior;

public class Controller implements Initializable {

	
	
    @FXML
    private ComboBox<CookBehavior> CookBox;

    @FXML
    private Button CookBtn;

    @FXML
    private ComboBox<Dish> MeatBox;
    
    @FXML
    private Label RecipeArea;

    @FXML
    private ComboBox<SpiceBehavior> SpiceBox;
    
  
    @Override
    public void initialize(URL url,ResourceBundle resourceBundle)
    {
    	Dish[] dishes = {new Fish(),new Beef()};
    	CookBehavior[] cooks = {new Grill(),new Boil()};
    	SpiceBehavior[] spices = {new Cinnamon(),new Garlic()};
    	MeatBox.setItems(FXCollections.observableArrayList(dishes));
    	SpiceBox.setItems(FXCollections.observableArrayList(spices));
    	CookBox.setItems(FXCollections.observableArrayList(cooks));
    }
    
    
    public void cookClick(ActionEvent e) throws IOException
	{
    	
    	Dish dish = MeatBox.getValue();
    	if(dish!=null)
    	{
    		dish.setCookBehavior(CookBox.getValue());
    		dish.setSpiceBehavior(SpiceBox.getValue());
        	
    		if(dish.cook()!=null && dish.spice()!=null)
    		{

        		RecipeArea.setText(dish.recipe());
    		}
    		else
    		{
    			RecipeArea.setText("Invalid recipe");
    		}
    	}
    	else {
    		RecipeArea.setText("Invalid recipe");
    	}
		
	}
    
    
	
	

}