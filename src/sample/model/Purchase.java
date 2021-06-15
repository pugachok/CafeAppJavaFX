package sample.model;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
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

public class Purchase {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nameIngredient;

    @FXML
    private TextField count;

    @FXML
    private TextField provider;

    @FXML
    private TextField price;

    @FXML
    private DatePicker date;

    @FXML
    private Button add;

    @FXML
    private Button closing;

    @FXML
    private Button update;

    public TextField getNameIngredient() {
        return nameIngredient;
    }

    public TextField getCount() {
        return count;
    }

    public TextField getProvider() {
        return provider;
    }

    public TextField getPrice() {
        return price;
    }

    public DatePicker getDate() {
        return date;
    }

    public Button getUpdate() {
        return update;
    }

    @FXML
    void initialize() {
        assert nameIngredient != null : "fx:id=\"nameIngredient\" was not injected: check your FXML file 'Untitled'.";
        assert count != null : "fx:id=\"count\" was not injected: check your FXML file 'Untitled'.";
        assert provider != null : "fx:id=\"provider\" was not injected: check your FXML file 'Untitled'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'Untitled'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'Untitled'.";
        assert add != null : "fx:id=\"add\" was not injected: check your FXML file 'Untitled'.";

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
            stage.setTitle("Закупка");
            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = Purchase.class.getResource("Purchase.fxml");
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
        String SQL = "Insert into Закупка(Код_ингредиента, Количество, Код_поставщика, Дата, Цена) " +
                "Values((Select Код From Ингредиенты Where Название = ?), ?, (Select Код From Поставщики Where Название = ?), ?, ?)";
        try {
            pst = getConnection().prepareStatement(SQL);
            pst.setString(1, nameIngredient.getText());
            pst.setString(2, count.getText());
            pst.setString(3, provider.getText());
            pst.setString(4, date.getValue().toString());
            pst.setString(5, price.getText());
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
