package net.balsoftware.internal.scene.control.login;

import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import javafx.util.Pair;

public class LoginBorderPane extends BorderPane
{
    @FXML private Label organizationNameLabel;
    @FXML private TextField usernameTextField;
    @FXML private PasswordField passwordField;
    @FXML private Button signInButton;
    
    public LoginBorderPane(ResourceBundle resources, String initialUsername, Callback<Pair<String, String>, Void> loginCallback)
    {
        super();
        FXMLUtilities.loadFxml(LoginBorderPane.class.getResource("Login.fxml"), this, resources);
        usernameTextField.setText(initialUsername);
        signInButton.setOnMouseClicked((EventHandler<? super MouseEvent>) (event) -> 
        {
            loginCallback.call(new Pair<>(usernameTextField.getText(), passwordField.getText()));
        });
    }
    
        /** Convenience method to load FXML files */
    protected static void loadFxml(URL fxmlFile, Object rootController, ResourceBundle bundle)
    {
        FXMLLoader loader = new FXMLLoader(fxmlFile);
        loader.setController(rootController);
        loader.setRoot(rootController);
        if (bundle != null) loader.setResources(bundle);
        try {
            loader.load();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
