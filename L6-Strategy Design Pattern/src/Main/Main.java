package Main;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import p1.Cinnamon;
import p1.CookBehavior;
import p1.Dish;
import p1.Fish;
import p1.Garlic;
import p1.Grill;
import p1.SpiceBehavior;

public class Main extends Application {
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


}
