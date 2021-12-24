package controller;

import bo.BOFactory;
import bo.custom.impl.StudentDeleteandUpdateBOImpl;
import entity.Student;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class StudentUpdateandDeleteFormController {
    public AnchorPane studentUpdateAndDeleteContext;
    public TextField txtStudentName;
    public TextField txtAddress;
    public TextField txtContact;
    public ComboBox cmbStu_RejNumber;
    public TextField txtGender;
    StudentDeleteandUpdateBOImpl studentDeleteandUpdateBO= BOFactory.getBOFactory().getBO(BOFactory.BoTypes.STUDENTDELETEANDUPDATE);

    public void initialize(){
        loadStudentIds();

        cmbStu_RejNumber.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    try {
                        setStudentDate((String) newValue);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

    }

    public void back_mouseClicked(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/StudentManageForm.fxml");
        Parent load = FXMLLoader.load(resource);
        studentUpdateAndDeleteContext.getChildren().clear();
        studentUpdateAndDeleteContext.getChildren().add(load);
    }

    public void loadStudentIds(){
        cmbStu_RejNumber.getItems().addAll(studentDeleteandUpdateBO.getStudentids());
    }
    public void setStudentDate(String id) throws Exception {
        Student student=studentDeleteandUpdateBO.getStudentDate(id);
        txtStudentName.setText(student.getStudent_name());
        txtAddress.setText(student.getAddress());
        txtContact.setText(student.getContact());
        txtGender.setText(student.getGender());
    }
}
