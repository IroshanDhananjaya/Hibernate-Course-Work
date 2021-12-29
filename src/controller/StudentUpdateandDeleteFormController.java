package controller;

import bo.BOFactory;
import bo.custom.impl.StudentDeleteandUpdateBOImpl;
import com.jfoenix.controls.JFXButton;
import dto.StudentDTO;
import entity.CustomEntity;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import view.tm.StudentandProgrammeDetailsTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class StudentUpdateandDeleteFormController {
    public AnchorPane studentUpdateAndDeleteContext;
    public TextField txtStudentName;
    public TextField txtAddress;
    public TextField txtContact;
    public ComboBox cmbStu_RejNumber;
    public TextField txtGender;
    public TableView<CustomEntity>tblStudentProgrammeTable;
    public TableColumn colRegId;
    public TableColumn colProgrammeId;
    public TableColumn colProgrammeName;
    public TableColumn colRegDate;

    StudentDeleteandUpdateBOImpl studentDeleteandUpdateBO= BOFactory.getBOFactory().getBO(BOFactory.BoTypes.STUDENTDELETEANDUPDATE);

    public void initialize(){
        loadStudentIds();

        cmbStu_RejNumber.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    try {
                        setStudentDate((String) newValue);
                        setStudentProgrammeTable((String) newValue);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        colRegId.setCellValueFactory(new PropertyValueFactory<>("regFormNumber"));
        colProgrammeId.setCellValueFactory(new PropertyValueFactory<>("programmeId"));
        colProgrammeName.setCellValueFactory(new PropertyValueFactory<>("programmeName"));
        colRegDate.setCellValueFactory(new PropertyValueFactory<>("regDate"));

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

    public void btnupdateOnAction(ActionEvent actionEvent) {
        try {
            if(studentDeleteandUpdateBO.updateStudentData(new StudentDTO((String)cmbStu_RejNumber.getValue(),txtStudentName.getText(),txtAddress.getText(),txtContact.getText(),txtGender.getText()))){
                new Alert(Alert.AlertType.CONFIRMATION, "Do you wanna Update it?").showAndWait();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {
        try {
            if(studentDeleteandUpdateBO.deleteStudent((String) cmbStu_RejNumber.getValue())){
                new Alert(Alert.AlertType.CONFIRMATION, "Do you wanna Delete it?").showAndWait();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }
    }

    public void btnRemoveCourseOnAction(ActionEvent actionEvent) throws Exception {
        if(tblStudentProgrammeTable.getSelectionModel().getSelectedItem()!=null){
            CustomEntity customEntity=tblStudentProgrammeTable.getSelectionModel().getSelectedItem();
            if(studentDeleteandUpdateBO.removeProgrammeFromStudent(String.valueOf(customEntity.getRegFormNumber()))){
                new Alert(Alert.AlertType.CONFIRMATION, "Do you wanna Delete it?").showAndWait();
            }else {
                new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
            }
        }
    }
    private void setStudentProgrammeTable(String id) throws Exception {
        ObservableList<CustomEntity> tmList = FXCollections.observableArrayList();
        List<CustomEntity> all = studentDeleteandUpdateBO.loadAllStudentProgramme(id);
        for (CustomEntity dto : all) {
            tmList.add(dto);
            tblStudentProgrammeTable.setItems(tmList);
        }
    }

}
