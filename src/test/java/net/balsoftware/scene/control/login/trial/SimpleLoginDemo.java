package net.balsoftware.scene.control.login.trial;


import java.util.Locale;
import java.util.ResourceBundle;

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
        Locale myLocale = Locale.getDefault();
        ResourceBundle resources = ResourceBundle.getBundle("net.balsoftware.scene.control.login.trial.NewLogin", myLocale);
        Login root = new Login(resources, null, (p) -> null);
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
