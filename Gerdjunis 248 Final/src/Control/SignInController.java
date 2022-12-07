package Control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Util.Connect;
import Util.CurrentUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;




public class SignInController implements Initializable {

    @FXML
    private TextField passwordBox;

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
    	int success = Connect.signIn(usernameBox.getText(), passwordBox.getText());
    	if(success==0)
    	{
    		label.setText("User doesn't exist");
    	}
    	else if(success==-1)
    	{
    		label.setText("Login failure");
    	}
    	else
    	{
    		Parent root;
			try {
				Connect.current = CurrentUser.makeUser(Connect.getUser(usernameBox.getText(),passwordBox.getText()));
			
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

    @FXML
    void signUpClick(ActionEvent event)  {
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Connect.setQuery("https://api.data.gov/ed/collegescorecard/v1/schools.json?school.degrees_awarded.predominant=2,3,4&_fields=id,school.name,school.city,school.zip,latest.academics.program.bachelors.computer,latest.admissions.admission_rate.overall,latest.completion.completion_rate_4yr_150nt,latest.cost.tuition.in_state,latest.cost.tuition.out_of_state&api_key=nSTCffEr2yiN7QOxzqiGTZ4W0SGs7YJTXz9WitvF&per_page=100");
		Connect.setConnection("colleges.sqlite");
		
	}

}
