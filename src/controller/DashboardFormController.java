package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class DashboardFormController {


    public AnchorPane dashboardNavContext;
    public  AnchorPane dashboardContext;

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
}
