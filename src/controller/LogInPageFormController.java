package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class LogInPageFormController {
    public AnchorPane loginPageContext;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;

    public void logIn_mouseCliked(MouseEvent mouseEvent) throws IOException {
        if(txtUserName.getText().equalsIgnoreCase("sipsewana")&&txtPassword.getText().equalsIgnoreCase("1234")) {
            URL resource = getClass().getResource("../view/DashboardForm.fxml");
            Parent load = FXMLLoader.load(resource);
            loginPageContext.getChildren().clear();
            loginPageContext.getChildren().add(load);
        }else {
            new Alert(Alert.AlertType.ERROR,"User Name Or Password Incorrect..").show();
        }
    }
}
