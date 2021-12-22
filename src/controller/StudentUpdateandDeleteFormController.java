package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class StudentUpdateandDeleteFormController {
    public AnchorPane studentUpdateAndDeleteContext;

    public void back_mouseClicked(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/StudentManageForm.fxml");
        Parent load = FXMLLoader.load(resource);
        studentUpdateAndDeleteContext.getChildren().clear();
        studentUpdateAndDeleteContext.getChildren().add(load);
    }
}
