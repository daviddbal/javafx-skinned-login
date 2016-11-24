package net.balsoftware.scene.control.login;

import static org.junit.Assert.assertEquals;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx.util.Pair;

public class LoginTest extends org.loadui.testfx.GuiTest
{

	Object result;
	String username;
	
	@Override
    public Parent getRootNode()
    {
		Callback<Pair<String, String>, Void> loginCallback = (credentials) ->
		{
			username = credentials.getKey();
			String password = credentials.getValue();
			if (username.equals("David") && password.equals("password"))
			{
				result = "login ok";
			} else
			{
				result  = "login failed";
			}
			System.out.println(username + ", " + password + ":" + result);
			return null;
		};

        Locale myLocale = Locale.getDefault();
		ResourceBundle resources = ResourceBundle.getBundle("net.balsoftware.scene.control.login.LoginDefault", myLocale);
		Login root = new Login(resources, "David", loginCallback);
		root.setPrefSize(300, 400);
    	return root;
    }
    
    @Test
    public void canDisplayLogin()
    {
    	find("#Login-Default");
    }
    
    @Test
    public void canCheckCredentials()
    {
    	TextField usernameTextField = find("#usernameTextField");
    	PasswordField passwordField = find("#passwordField");
    	usernameTextField.setText("David");
    	passwordField.setText("password");
    	click("#signInButton");
    	assertEquals("login ok", result);
    }
}
