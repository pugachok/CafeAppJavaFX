package sample.model;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Controller;
import sample.service.ConnectBD;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Orders {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button closing;

    @FXML
    private Button adding;

    @FXML
    private Button update;

    @FXML
    private Label label2;

    @FXML
    private Label label1;

    @FXML
    private TextField FIOCoworker;

    @FXML
    private TextField nameBluda;

    @FXML
    private Label label3;

    @FXML
    private DatePicker date;

    @FXML
    private Label label4;

    @FXML
    private TextField time;

    @FXML
    private Label label5;

    @FXML
    private TextField numberTable;

    @FXML
    private Label label6;

    @FXML
    private TextField count;

    public Button getUpdate() {
        return update;
    }

    public TextField getFIOCoworker() {
        return FIOCoworker;
    }

    public TextField getNameBluda() {
        return nameBluda;
    }

    public DatePicker getDate() {
        return date;
    }

    public TextField getTime() {
        return time;
    }

    public TextField getNumberTable() {
        return numberTable;
    }

    public TextField getCount() {
        return count;
    }

    @FXML
    void initialize() {
        assert closing != null : "fx:id=\"closing\" was not injected: check your FXML file 'Untitled'.";
        assert adding != null : "fx:id=\"adding\" was not injected: check your FXML file 'Untitled'.";
        assert label2 != null : "fx:id=\"label2\" was not injected: check your FXML file 'Untitled'.";
        assert label1 != null : "fx:id=\"label1\" was not injected: check your FXML file 'Untitled'.";
        assert FIOCoworker != null : "fx:id=\"FIOCoworker\" was not injected: check your FXML file 'Untitled'.";
        assert nameBluda != null : "fx:id=\"nameBluda\" was not injected: check your FXML file 'Untitled'.";
        assert label3 != null : "fx:id=\"label3\" was not injected: check your FXML file 'Untitled'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'Untitled'.";
        assert label4 != null : "fx:id=\"label4\" was not injected: check your FXML file 'Untitled'.";
        assert time != null : "fx:id=\"time\" was not injected: check your FXML file 'Untitled'.";
        assert label5 != null : "fx:id=\"label5\" was not injected: check your FXML file 'Untitled'.";
        assert numberTable != null : "fx:id=\"numberTable\" was not injected: check your FXML file 'Untitled'.";
        assert label6 != null : "fx:id=\"label6\" was not injected: check your FXML file 'Untitled'.";
        assert count != null : "fx:id=\"count\" was not injected: check your FXML file 'Untitled'.";

    }

    ConnectBD connectBD = new ConnectBD();
    Connection connection;
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
            stage.setTitle("Заказы");
            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = Orders.class.getResource("Orders.fxml");
            loader.setLocation(xmlUrl);
            Parent root = null;
            root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ObservableList data;
    Controller controller = new Controller();
    PreparedStatement pst = null;



    public void addingToTable(ActionEvent actionEvent) {
        String SQL = "Insert into Заказы(Код_сотрудника, Код_меню, Дата, Время, Номер_столика, Количество) " +
                "Values((Select Код From Сотрудники Where ФИО = ?), (Select Код From Меню Where Код_блюда = (Select Код From Блюда Where Название_блюда = ?)), ?, ?, ?, ?)";
        try {
            pst = getConnection().prepareStatement(SQL);
            pst.setString(1, FIOCoworker.getText());
            pst.setString(2, nameBluda.getText());
            pst.setString(3, date.getValue().toString());
            pst.setString(4, time.getText());
            pst.setString(5, numberTable.getText());
            pst.setString(6, count.getText());
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
}
