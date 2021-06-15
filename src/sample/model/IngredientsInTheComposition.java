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

public class IngredientsInTheComposition {

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
    private Button updateButton;

    public Button getUpdateButton() {
        return updateButton;
    }

    @FXML
    private Label label2;

    @FXML
    private Label label1;

    @FXML
    private TextField nameIngredient;

    @FXML
    private TextField nameBluda;

    @FXML
    private TextField count;

    @FXML
    private Label label3;

    public TextField getNameIngredient() {
        return nameIngredient;
    }

    public TextField getNameBluda() {
        return nameBluda;
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
        assert nameIngredient != null : "fx:id=\"nameIngredient\" was not injected: check your FXML file 'Untitled'.";
        assert nameBluda != null : "fx:id=\"nameBluda\" was not injected: check your FXML file 'Untitled'.";
        assert count != null : "fx:id=\"count\" was not injected: check your FXML file 'Untitled'.";
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
            stage.setTitle("Ингредиенты в составе");
            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = IngredientsInTheComposition.class.getResource("IngredientsInTheComposition.fxml");
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
        String SQL = "Insert into Ингредиенты_в_составе(Код_ингредиента, Код_блюда, Количество) Values((Select Код From Ингредиенты Where Название = ?), (Select Код From Блюда Where Название_блюда = ?), ?)";
        try {
            pst = getConnection().prepareStatement(SQL);
            pst.setString(1, getNameIngredient().getText());
            pst.setString(2, getNameBluda().getText());
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