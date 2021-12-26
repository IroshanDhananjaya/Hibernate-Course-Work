package controller;

import bo.BOFactory;
import bo.custom.impl.ProgrammeManageBOImpl;
import dto.ProgrammeDTO;
import entity.Programme;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class TraningProgramManageFormController {
    public TextField txtProgrammeID;
    public TextField txtProgrammeName;
    public TextField txtDuration;
    public TextField txtFee;
    public TextField txtProgrammeUpdateName;
    public TextField txtProgrammeUpdateDuration;
    public TextField txtUpdateFee;
    public ComboBox cmbProgrammeID;

    ProgrammeManageBOImpl programmeManageBO= BOFactory.getBOFactory().getBO(BOFactory.BoTypes.MANAGEPROGRAMME);

    public void initialize(){
        loadProgrammeIds();
        cmbProgrammeID.getSelectionModel().selectedItemProperty().
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
    public void programmeAddOnAction(ActionEvent actionEvent) {
        try {


        if(programmeManageBO.add(new ProgrammeDTO(txtProgrammeID.getText(),txtProgrammeName.getText(),txtDuration.getText(),txtFee.getText()))){
            new Alert(Alert.AlertType.CONFIRMATION, "Do you wanna Save it?").showAndWait();
        }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }
    }
    public void loadProgrammeIds(){cmbProgrammeID.getItems().addAll(programmeManageBO.getProgrammeids());
    }
    public void setProgrammeData(String id) throws Exception {
        Programme programme=programmeManageBO.getProgrammeData(id);
        txtProgrammeUpdateName.setText(programme.getProgramme_name());
        txtProgrammeUpdateDuration.setText(programme.getDuration());
        txtUpdateFee.setText(programme.getFee());
    }

    public void updateOnAction(ActionEvent actionEvent) {
        try {
            if(programmeManageBO.updateProgramme(new ProgrammeDTO((String) cmbProgrammeID.getValue(),txtProgrammeUpdateName.getText(),txtProgrammeUpdateDuration.getText(),txtUpdateFee.getText()))){
                new Alert(Alert.AlertType.CONFIRMATION, "Do you wanna Update it?").showAndWait();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }
    }

    public void btnProgrammeDeleteOnAction(ActionEvent actionEvent) {
        try {
            if(programmeManageBO.removeProgramme((String) cmbProgrammeID.getValue())){
                new Alert(Alert.AlertType.CONFIRMATION, "Do you wanna Delete it?").showAndWait();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }
    }
}
