package net.balsoftware.internal.scene.control.login;

import java.util.ResourceBundle;

import javafx.scene.control.SkinBase;
import javafx.util.Callback;
import javafx.util.Pair;
import net.balsoftware.scene.control.login.Login;

public class LoginSkin extends SkinBase<Login>
{
    public LoginSkin(
            Login control,
            ResourceBundle resources,
            String initialUsername,
            Callback<Pair<String, String>, Void> loginCallback)
    {
        super(control);
        LoginBorderPane borderPane = new LoginBorderPane(resources, initialUsername, loginCallback);
        borderPane.prefWidthProperty().bind(getSkinnable().widthProperty()); // the border pane is the same size as the whole skin
        borderPane.prefHeightProperty().bind(getSkinnable().heightProperty());
        getChildren().add(borderPane);
        getSkinnable().getStyleClass().add(getClass().getSimpleName()); // always add self as style class, because CSS should relate to the skin not the control
    }
}
