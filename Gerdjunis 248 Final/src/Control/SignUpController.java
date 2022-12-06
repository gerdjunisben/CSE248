package Control;

import java.io.IOException;

import Util.Connect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private TextField passwordBox1;

    @FXML
    private TextField passwordBox2;

    @FXML
    private Button signInButton;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField usernameBox;
    
    @FXML
    private Label label;

    @FXML
    void signInClick(ActionEvent event) {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("../view/signup.fxml"));
			Scene scene = new Scene(root);
			Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
			window.setScene(scene);
			window.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void signUpClick(ActionEvent event) {
    	if(usernameBox.getText()!=null || !usernameBox.getText().equals(""))
    	{
    		if(!passwordBox1.getText().equals("") && passwordBox1.getText().equals(passwordBox2.getText()))
    		{
    			int success = Connect.addUser(usernameBox.getText(), passwordBox1.getText());
    			if(success==0)
    			{
    				label.setText("User already exists");
    			}
    			else if(success==-1)
    			{
    				label.setText("Sign up failure");
    			}
    			else
    			{
    				Parent root;
    				try {
    					root = FXMLLoader.load(getClass().getResource("../view/collegeSearch.fxml"));
    					Scene scene = new Scene(root);
    					Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
    					window.setScene(scene);
    					window.show();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    		}
    	}
    }

}
