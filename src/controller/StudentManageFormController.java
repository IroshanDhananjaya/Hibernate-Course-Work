package controller;

import bo.BOFactory;
import bo.custom.impl.StudentManageBOImpl;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class StudentManageFormController {
    public AnchorPane studentManageContext;
    public TextField txtSRejNumber;
    public TextField txtStudentName;
    public TextField txtSAddress;
    public TextField txtContact;
    public TextField txtGender;

    StudentManageBOImpl studentManageBO = BOFactory.getBOFactory().getBO(BOFactory.BoTypes.MANAGESTUDENT);

    public void studentUpdateandDelete_MouseCliked(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/StudentUpdateandDeleteForm.fxml");
        Parent load = FXMLLoader.load(resource);
        studentManageContext.getChildren().clear();
        studentManageContext.getChildren().add(load);
    }


    public void addStudentOnAction(ActionEvent actionEvent) {
        try {
            if (studentManageBO.add(new StudentDTO(txtSRejNumber.getText(), txtStudentName.getText(), txtSAddress.getText(), txtContact.getText(),txtGender.getText()))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Do you wanna Save it?").showAndWait();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }

    }
}
