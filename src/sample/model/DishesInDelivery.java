package sample.model;

import javafx.collections.ObservableList;
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
import sample.Controller;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DishesInDelivery {
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

    @FXML
    private Label label2;

    @FXML
    private Label label1;

    @FXML
    private Label label3;

    @FXML
    private TextField nameDishes;

    @FXML
    private TextField addressDelivery;

    @FXML
    private TextField count;

    public Button getUpdate() {
        return update;
    }

    public TextField getNameDishes() {
        return nameDishes;
    }

    public TextField getAddressDelivery() {
        return addressDelivery;
    }

    public TextField getCount() {
        return count;
    }

    @FXML
    void initialize() {
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'DishesInDelivery.fxml'.";
        assert closing != null : "fx:id=\"closing\" was not injected: check your FXML file 'DishesInDelivery.fxml'.";
        assert adding != null : "fx:id=\"adding\" was not injected: check your FXML file 'DishesInDelivery.fxml'.";
        assert label2 != null : "fx:id=\"label2\" was not injected: check your FXML file 'DishesInDelivery.fxml'.";
        assert label1 != null : "fx:id=\"label1\" was not injected: check your FXML file 'DishesInDelivery.fxml'.";
        assert nameDishes != null : "fx:id=\"nameDishes\" was not injected: check your FXML file 'DishesInDelivery.fxml'.";
        assert addressDelivery != null : "fx:id=\"addressDelivery\" was not injected: check your FXML file 'DishesInDelivery.fxml'.";
        assert count != null : "fx:id=\"count\" was not injected: check your FXML file 'DishesInDelivery.fxml'.";
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
            stage.setTitle("Блюда в доставке");
            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = DishesInDelivery.class.getResource("DishesInDelivery.fxml");
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
        String SQL = "Insert into Блюда_в_доставке(Код_меню, Код_заказа_с_доставкой, Количество) Values((Select Код From Меню Where Код_блюда = (Select Код From Блюда Where Название_блюда = ?)), (Select Код From Заказ_с_доставкой Where Адрес = ?), ?)";
        try {
            pst = getConnection().prepareStatement(SQL);
            pst.setString(1, getNameDishes().getText());
            pst.setString(2, getAddressDelivery().getText());
            pst.setString(3, getCount().getText());
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
