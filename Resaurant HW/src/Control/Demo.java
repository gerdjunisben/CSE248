package Control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Demo extends Application {
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		//--module-path "C:\Program Files\Java\Javafx-sdk-17.0.1\lib" --add-modules=javafx.controls,javafx.fxml
		try {
			Parent root = FXMLLoader.load(getClass().getResource("View/View.fxml"));
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