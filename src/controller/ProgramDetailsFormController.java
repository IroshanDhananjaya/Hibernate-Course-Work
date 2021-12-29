package controller;

import bo.BOFactory;
import bo.custom.impl.ProgrammeDetailsBOImpl;
import bo.custom.impl.ProgrammeManageBOImpl;
import com.jfoenix.controls.JFXComboBox;
import dto.CustomDTO;
import dto.StudentDTO;
import entity.CustomEntity;
import entity.Programme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.StudentTM;
import view.tm.StudentandProgrammeDetailsTM;

import java.sql.SQLException;
import java.util.List;

public class ProgramDetailsFormController {
    public TableView tblProgramDetails;
    public TableColumn colStudentID;
    public TableColumn colStudentName;
    public TableColumn colRejisterDate;
    public JFXComboBox cmbPID;
    public Label lblProgrammeName;
    public Label lblProgrammeDuration;
    public Label lblFee;

    ProgrammeDetailsBOImpl programmeDetailsBO = BOFactory.getBOFactory().getBO(BOFactory.BoTypes.PROGRAMMEDETAILS);

    public void initialize(){
        loadProgrammeIds();

        cmbPID.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    try {
                        setProgrammeData((String)newValue);
                       setProgrammeDetailsToTable((String) newValue);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        colStudentID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colRejisterDate.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));

    }



    private void setProgrammeDetailsToTable(String id) throws Exception {
        ObservableList<CustomEntity> tmList = FXCollections.observableArrayList();
        List<CustomEntity> all = programmeDetailsBO.loadAllProgrammeDetails(id);
        for (CustomEntity dto : all) {
            StudentandProgrammeDetailsTM studentTM= new StudentandProgrammeDetailsTM(
                   dto.getProgrammeId(),dto.getStudentName(),dto.getRegDate()
            );
            tmList.add(dto);
            tblProgramDetails.setItems(tmList);
        }
    }
    public void loadProgrammeIds() {
        cmbPID.getItems().addAll(programmeDetailsBO.getProgrammeids());
    }

    public void setProgrammeData(String id) throws Exception {
        Programme programme=programmeDetailsBO.getProgrammeData(id);
        lblProgrammeName.setText(programme.getProgramme_name());
        lblProgrammeDuration.setText(programme.getDuration());
        lblFee.setText(programme.getFee());

    }
}
