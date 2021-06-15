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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.service.ConnectBD;
import sample.Controller;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Menu {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

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
    private TextField nameDishes;

    @FXML
    private TextField priceDishes;

    @FXML
    private DatePicker date;

    @FXML
    private Label label3;

    public Button getUpdate() {
        return update;
    }

    public TextField getNameDishes() {
        return nameDishes;
    }

    public TextField getPriceDishes() {
        return priceDishes;
    }

    public DatePicker getDate() {
        return date;
    }

    @FXML
    void initialize() {
        assert closing != null : "fx:id=\"closing\" was not injected: check your FXML file 'Untitled'.";
        assert adding != null : "fx:id=\"adding\" was not injected: check your FXML file 'Untitled'.";
        assert label2 != null : "fx:id=\"label2\" was not injected: check your FXML file 'Untitled'.";
        assert label1 != null : "fx:id=\"label1\" was not injected: check your FXML file 'Untitled'.";
        assert nameDishes != null : "fx:id=\"nameDishes\" was not injected: check your FXML file 'Untitled'.";
        assert priceDishes != null : "fx:id=\"priceDishes\" was not injected: check your FXML file 'Untitled'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'Untitled'.";
        assert label3 != null : "fx:id=\"label3\" was not injected: check your FXML file 'Untitled'.";
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
            stage.setTitle("Меню");
            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = Menu.class.getResource("Menu.fxml");
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

    @FXML
    private void addingToTable(ActionEvent actionEvent) {
        String SQL = "Insert into Меню(Код_блюда, Цена_блюда, Дата) Values((Select Код From Блюда Where Название_блюда = ?), ?, ?)";
        try {
            pst = getConnection().prepareStatement(SQL);
            pst.setString(1, nameDishes.getText());
            pst.setString(2, priceDishes.getText());
            pst.setString(3, date.getValue().toString());
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
