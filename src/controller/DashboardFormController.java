package controller;

import bo.BOFactory;
import bo.custom.impl.DashboardBOImpl;
import dto.ProgrammeDTO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import view.tm.ProgrammeTM;
import view.tm.StudentTM;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DashboardFormController {


    public AnchorPane dashboardNavContext;
    public  AnchorPane dashboardContext;
    public TableView tblStudent;
    public TableColumn colSRegID;
    public TableColumn colStudentName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableView tblTraninngProgramme;
    public TableColumn colProgrammeID;
    public TableColumn colProgrammeName;
    public TableColumn colDuration;
    public TableColumn colFee;
    public TableColumn colGender;
    DashboardBOImpl dashboardBO= BOFactory.getBOFactory().getBO(BOFactory.BoTypes.DASHBOARD);
    public void initialize(){
        try {
           setStudentToTable();
           setProgrammeToTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        colSRegID.setCellValueFactory(new PropertyValueFactory<>("student_registerNumber"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("student_name"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

        colProgrammeID.setCellValueFactory(new PropertyValueFactory<>("programme_id"));
        colProgrammeName.setCellValueFactory(new PropertyValueFactory<>("programme_name"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));

    }


    public void manageStudent_mouseCliked(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/StudentManageForm.fxml");
        Parent load = FXMLLoader.load(resource);
        dashboardNavContext.getChildren().clear();
        dashboardNavContext.getChildren().add(load);
    }

    public void home_mouseClicked(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        dashboardContext.getChildren().clear();
        dashboardContext.getChildren().add(load);
    }

    public void manageProgram_mouseCliked(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/TraningProgramManageForm.fxml");
        Parent load = FXMLLoader.load(resource);
        dashboardNavContext.getChildren().clear();
        dashboardNavContext.getChildren().add(load);
    }

    public void programDetails_MouseClicked(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/ProgramDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        dashboardNavContext.getChildren().clear();
        dashboardNavContext.getChildren().add(load);
    }
    private void setStudentToTable() throws Exception {
        ObservableList<StudentTM> tmList = FXCollections.observableArrayList();
        List<StudentDTO> all = dashboardBO.loadAllStudent();
        for (StudentDTO dto : all) {

            StudentTM tm = new StudentTM(
                    dto.getStudent_registerNumber(), dto.getStudent_name(), dto.getAddress(), dto.getContact(), dto.getGender()
            );
            tmList.add(tm);
            tblStudent.setItems(tmList);
        }
    }
    private void setProgrammeToTable() throws Exception {
        ObservableList<ProgrammeTM> tmList = FXCollections.observableArrayList();
        List<ProgrammeDTO> all = dashboardBO.loadAllProgramme();
        for (ProgrammeDTO dto : all) {

            ProgrammeTM tm = new ProgrammeTM(
                    dto.getProgramme_id(),dto.getProgramme_name(),dto.getDuration(),dto.getFee()
            );
            tmList.add(tm);
            tblTraninngProgramme.setItems(tmList);
        }
    }
}
