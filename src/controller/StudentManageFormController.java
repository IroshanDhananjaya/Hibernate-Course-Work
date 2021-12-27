package controller;

import bo.BOFactory;
import bo.custom.impl.StudentManageBOImpl;
import com.jfoenix.controls.JFXDatePicker;
import dto.ProgrammeDTO;
import dto.ProgrammeRejistrationDTO;
import dto.StudentDTO;
import entity.Programme;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class StudentManageFormController {
    public AnchorPane studentManageContext;
    public TextField txtSRejNumber;
    public TextField txtStudentName;
    public TextField txtSAddress;
    public TextField txtContact;
    public TextField txtGender;
    public ComboBox cmb_StudentID;
    public Label lblSName;
    public Label lblAddress;
    public Label lblContact;
    public Label lblGender;
    public ComboBox cmbCourseID;
    public JFXDatePicker date;
    public Label lblCourseName;
    public Label lblDuration;
    public Label lblFee;
    public Label lblrejFormNum;

    StudentManageBOImpl studentManageBO = BOFactory.getBOFactory().getBO(BOFactory.BoTypes.MANAGESTUDENT);

    public void initialize(){
        loadStudentIds();
        loadProgrammeIds();


        cmb_StudentID.getSelectionModel().selectedItemProperty().
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
        cmbCourseID.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    try {
                        setProgrammeData((String) newValue);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

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
    public void loadStudentIds(){
        cmb_StudentID.getItems().addAll(studentManageBO.getStudentids());
    }
    public void loadProgrammeIds(){
        cmbCourseID.getItems().addAll(studentManageBO.getProgrammeids());
    }
    public void setStudentDate(String id) throws Exception {
        Student student=studentManageBO.getStudentDate(id);
        lblSName.setText(student.getStudent_name());
        lblAddress.setText(student.getAddress());
        lblContact.setText(student.getContact());
        lblGender.setText(student.getGender());
    }
    public void setProgrammeData(String id) throws Exception {
        Programme programme=studentManageBO.getProgrammeData(id);
        lblCourseName.setText(programme.getProgramme_name());
        lblDuration.setText(programme.getDuration());
        lblFee.setText(programme.getFee());

    }

    public void rejisterOnAction(ActionEvent actionEvent) throws Exception {

        StudentDTO studentDTO=new StudentDTO(cmb_StudentID.getValue().toString());

        ProgrammeDTO programmeDTO=new ProgrammeDTO(cmbCourseID.getValue().toString());

        if(studentManageBO.addRejistration(new ProgrammeRejistrationDTO(lblrejFormNum.getText(),date.getValue().toString(),studentDTO,programmeDTO))){
        new Alert(Alert.AlertType.CONFIRMATION, "Do you wanna Save it?").showAndWait();

        } else{
        new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }
    }
  /*  private void generateRejFormId(){
        try {
            lblrejFormNum.setText(studentManageBO.getNewOrderId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
