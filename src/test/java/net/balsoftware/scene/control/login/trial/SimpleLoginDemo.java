package net.balsoftware.scene.control.login.trial;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.balsoftware.scene.control.login.Login;
/**
 * Default login control demo
 * 
 * @author David Bal
 *
 */
public class SimpleLoginDemo extends Application
{
    public static void main(String[] args) {
        launch(args);       
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Login root = new Login();
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
