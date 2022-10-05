package app;

import javafx.application.Application;
import javafx.stage.Stage;
import model.StringBag;

public class Main extends Application {
	private static final int MAX_SIZE = 100;
	private static StringBag theBag = new StringBag(MAX_SIZE);
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public static StringBag getBag()
	{
		return theBag;
	}
}
