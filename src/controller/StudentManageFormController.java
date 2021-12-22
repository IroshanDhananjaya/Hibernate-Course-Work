package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class StudentManageFormController {
    public AnchorPane studentManageContext;
    public TextField txtSRejNumber;
    public TextField txtStudentName;
    public TextField txtSAddress;
    public TextField txtContact;

    public void studentUpdateandDelete_MouseCliked(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/StudentUpdateandDeleteForm.fxml");
        Parent load = FXMLLoader.load(resource);
        studentManageContext.getChildren().clear();
        studentManageContext.getChildren().add(load);
    }


    public void addStudentOnAction(ActionEvent actionEvent) {
    }
}
