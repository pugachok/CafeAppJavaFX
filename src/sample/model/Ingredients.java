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

public class Ingredients {

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
    private TextField nameIngredient;

    @FXML
    private TextField edIzmer;

    public Button getUpdate() {
        return update;
    }

    public TextField getNameIngredient() {
        return nameIngredient;
    }

    public TextField getEdIzmer() {
        return edIzmer;
    }

    @FXML
    void initialize() {
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file 'Ingredients.fxml'.";
        assert closing != null : "fx:id=\"closing\" was not injected: check your FXML file 'Ingredients.fxml'.";
        assert adding != null : "fx:id=\"adding\" was not injected: check your FXML file 'Ingredients.fxml'.";
        assert label2 != null : "fx:id=\"label2\" was not injected: check your FXML file 'Ingredients.fxml'.";
        assert label1 != null : "fx:id=\"label1\" was not injected: check your FXML file 'Ingredients.fxml'.";
        assert nameIngredient != null : "fx:id=\"nameIngredient\" was not injected: check your FXML file 'Ingredients.fxml'.";
        assert edIzmer != null : "fx:id=\"edIzmer\" was not injected: check your FXML file 'Ingredients.fxml'.";

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
            stage.setTitle("Ингредиенты");
            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = Ingredients.class.getResource("Ingredients.fxml");
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
        String SQL = "Insert into Ингредиенты(Название, Единица_измерения) Values(?, ?)";
        try {
            pst = getConnection().prepareStatement(SQL);
            pst.setString(1, getNameIngredient().getText());
            pst.setString(2, getEdIzmer().getText());
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

    public void update(ActionEvent actionEvent) {
    }
}
