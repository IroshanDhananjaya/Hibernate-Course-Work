package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class LogInPageFormController {
    public AnchorPane loginPageContext;

    public void logIn_mouseCliked(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        loginPageContext.getChildren().clear();
        loginPageContext.getChildren().add(load);
    }
}
