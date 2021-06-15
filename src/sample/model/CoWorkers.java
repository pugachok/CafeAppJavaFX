package sample.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.service.ConnectBD;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CoWorkers {

    @FXML
    private ResourceBundle resources;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button closing;

    @FXML
    private Button adding;

    @FXML
    private Button update;

    public Button getUpdate() {
        return update;
    }

    @FXML
    private Label label2;

    @FXML
    private Label label1;

    @FXML
    private TextField FIO;

    @FXML
    private TextField Position;

    public TextField getFIO() {
        return FIO;
    }

    public TextField getPosition() {
        return Position;
    }

    @FXML
    void initialize() {
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'CoWorkers.fxml'.";
        assert closing != null : "fx:id=\"closing\" was not injected: check your FXML file 'CoWorkers.fxml'.";
        assert adding != null : "fx:id=\"adding\" was not injected: check your FXML file 'CoWorkers.fxml'.";
        assert label2 != null : "fx:id=\"label2\" was not injected: check your FXML file 'CoWorkers.fxml'.";
        assert label1 != null : "fx:id=\"label1\" was not injected: check your FXML file 'CoWorkers.fxml'.";
        assert FIO != null : "fx:id=\"FIO\" was not injected: check your FXML file 'CoWorkers.fxml'.";
        assert Position != null : "fx:id=\"Position\" was not injected: check your FXML file 'CoWorkers.fxml'.";
    }

    private PreparedStatement pst = null;
    private ConnectBD connectBD = new ConnectBD();
    private Connection connection;
    {
        try {
            connection = DriverManager.getConnection(connectBD.getConnectionString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private Connection getConnection() {
        return connection;
    }

    public static void newWin() {
        try {
            Stage stage = new Stage();
            stage.setTitle("Сотрудники");
            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = CoWorkers.class.getResource("CoWorkers.fxml");
            loader.setLocation(xmlUrl);
            Parent root = null;
            root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addingToTable(ActionEvent actionEvent) {
        String SQL = "Insert into Сотрудники(ФИО, Код_должность) Values(?, (Select Код From Должность Where Должность.Должность = ?))";
        try {
            pst = getConnection().prepareStatement(SQL);
            pst.setString(1, getFIO().getText());
            pst.setString(2, getPosition().getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Added");
            close(actionEvent);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ошибка ввода :(");
            e.printStackTrace();
        }
    }

    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) closing.getScene().getWindow();
        stage.close();
    }

    public void update(ActionEvent actionEvent) {}
}
