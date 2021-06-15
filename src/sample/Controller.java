package sample;

import com.gembox.spreadsheet.ExcelFile;
import com.gembox.spreadsheet.ExcelWorksheet;
import com.gembox.spreadsheet.SpreadsheetInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.model.Menu;
import sample.model.*;
import sample.service.ConnectBD;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class Controller {

    private PreparedStatement pst = null;

    private Stage stage = new Stage();

    private ObservableList data;
    ConnectBD connectBD = new ConnectBD();
    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(connectBD.getConnectionString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    static {
        SpreadsheetInfo.setLicense("FREE-LIMITED-KEY");
    }

    @FXML
    private TextField selectId;

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button saver;

    @FXML
    private TableView<?> tableView;

    public TableView<?> getTableView() {
        return tableView;
    }

    @FXML
    private ComboBox<String> chooseTable;

    public ComboBox<String> getChooseTable() {
        return chooseTable;
    }

    @FXML
    public void initialize() {
        assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert editButton != null : "fx:id=\"editButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file 'sample.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'sample.fxml'.";
        assert chooseTable != null : "fx:id=\"chooseTable\" was not injected: check your FXML file 'sample.fxml'.";

        selectTable();

        chooseTable.setValue("Выберите таблицу");
        chooseTable.getItems().addAll(
                "Должность",
                "Сотрудники",
                "Поставщики",
                "Ингредиенты",
                "Блюда",
                "Блюда_в_доставке",
                "Заказ_с_доставкой",
                "Заказы",
                "Закупка",
                "Ингредиенты_в_составе",
                "Меню"
        );
    }

    @FXML
    public void selectTableAdd() {
        if (chooseTable.getValue().equals("Ингредиенты_в_составе")) {
            IngredientsInTheComposition.newWin();
        } else if (chooseTable.getValue().equals("Ингредиенты")) {
            Ingredients.newWin();
        } else if (chooseTable.getValue().equals("Блюда")) {
            Dishes.newWin();
        } else if (chooseTable.getValue().equals("Должность")) {
            Position.newWin();
        } else if (chooseTable.getValue().equals("Сотрудники")) {
            CoWorkers.newWin();
        } else if (chooseTable.getValue().equals("Заказ_с_доставкой")) {
            OrderWithDelivery.newWin();
        } else if (chooseTable.getValue().equals("Блюда_в_доставке")) {
            DishesInDelivery.newWin();
        } else if (chooseTable.getValue().equals("Поставщики")) {
            Providers.newWin();
        } else if (chooseTable.getValue().equals("Меню")) {
            Menu.newWin();
        } else if (chooseTable.getValue().equals("Заказы")) {
            Orders.newWin();
        } else if (chooseTable.getValue().equals("Закупка")) {
            Purchase.newWin();
        } else {
            JOptionPane.showMessageDialog(null, "Выберите таблицу.");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void buildData(String tableName) {
        data = FXCollections.observableArrayList();
        try {
            String SQL = "Select * From " + tableName + "Представление";
            ResultSet rs = getConnection().createStatement().executeQuery(SQL);
            tableView.getColumns().clear();
            for(int i = 0 ; i < rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
                tableView.getColumns().addAll(col);
                tableView.getColumns().get(0).setMaxWidth(0);
                tableView.getColumns().get(0).setMinWidth(0);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i = 1 ; i <= rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            //System.out.println(tableView.getColumns().get(1).getText());
            saver.setVisible(false);
            tableView.setItems(data);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void selectTable() {
        chooseTable.setOnAction(actionEvent -> buildData(chooseTable.getValue()));
    }




    public void buttonRemove(ActionEvent actionEvent) {
        PreparedStatement pst = null;
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        ObservableList selectedCells = tableView.getSelectionModel().getSelectedCells();

        TablePosition tablePosition = (TablePosition) selectedCells.get(0);
        Object id = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
        String SQL = "Delete From " + chooseTable.getValue() + " Where Код = " + id;

        try {
            pst = getConnection().prepareStatement(SQL);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Запись удалена.");
            tableView.getSelectionModel().setCellSelectionEnabled(false);

            ObservableList<?> allItem, singleItem;
            allItem = tableView.getItems();
            singleItem = tableView.getSelectionModel().getSelectedItems();
            singleItem.forEach(allItem::remove);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Запись НЕ удалена.");
            tableView.getSelectionModel().setCellSelectionEnabled(false);
            e.printStackTrace();
        }

    }


    private void executeSQL(String SQL) {
        try {
            pst = getConnection().prepareStatement(SQL);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Изменения применены.");
            buildData(chooseTable.getValue());
            stage.close();
        } catch (SQLException throwables) {
            JOptionPane.showMessageDialog(null, "Не корректный ввод данных.");
            throwables.printStackTrace();
        }
    }

    public void updateTable(ActionEvent actionEvent) throws IOException {
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            FXMLLoader loader = new FXMLLoader();

            stage.setTitle(chooseTable.getValue());
            Parent root = null;

            ObservableList<String> row = (ObservableList<String>) getTableView().getItems().get(tableView.getSelectionModel().getSelectedCells().get(0).getRow());
            switch (chooseTable.getValue()) {
                case "Сотрудники":
                        loader.setLocation(CoWorkers.class.getResource("CoWorkers.fxml"));
                        root = loader.load();
                        stage.setScene(new Scene(root));
                        stage.show();
                        CoWorkers coWorkers = loader.getController();
                        coWorkers.getFIO().setText(row.get(1));
                        coWorkers.getPosition().setText(row.get(2));
                        coWorkers.getUpdate().setOnAction(e -> {
                            String SQL = "Update Сотрудники SET ФИО = '" + coWorkers.getFIO().getText() +
                                    "', Код_должность = (Select Код From Должность Where Должность.Должность = '" +
                                    coWorkers.getPosition().getText() + "')  Where ФИО = '" + row.get(1) +
                                    "' and Код_должность = (Select Код From Должность Where Должность.Должность = '" + row.get(2) + "')";
                            executeSQL(SQL);
                        });
                break;
                case "Ингредиенты_в_составе":
                        loader.setLocation(IngredientsInTheComposition.class.getResource("IngredientsInTheComposition.fxml"));
                        root = loader.load();
                        stage.setScene(new Scene(root));
                        stage.show();
                        IngredientsInTheComposition ingredientsInTheComposition = loader.getController();
                        ingredientsInTheComposition.getNameIngredient().setText(row.get(1));
                        ingredientsInTheComposition.getNameBluda().setText(row.get(2));
                        ingredientsInTheComposition.getCount().setText(row.get(3));
                        ingredientsInTheComposition.getUpdateButton().setOnAction(e -> {
                            String SQL = "Update Ингредиенты_в_составе SET Код_ингредиента = (Select Код From Ингредиенты Where Название = '" + ingredientsInTheComposition.getNameIngredient().getText() +
                                    "'), Код_блюда = (Select Код From Блюда Where Название_блюда = '" + ingredientsInTheComposition.getNameBluda().getText() + "'), Количество = '" + ingredientsInTheComposition.getCount().getText() +
                                    "' Where Код_ингредиента = (Select Код From Ингредиенты Where Название = '" + row.get(1) + "') and Код_блюда = (Select Код From Блюда Where Название_блюда = '" + row.get(2) + "') and Количество = '" + row.get(3) + "'";
                            executeSQL(SQL);
                        });
                break;
                case "Ингредиенты":
                    loader.setLocation(Ingredients.class.getResource("Ingredients.fxml"));
                    root = loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                    Ingredients ingredients = loader.getController();
                    ingredients.getNameIngredient().setText(row.get(1));
                    ingredients.getEdIzmer().setText(row.get(2));
                    ingredients.getUpdate().setOnAction(e -> {
                        String SQL = "Update Ингредиенты SET Название = '" + ingredients.getNameIngredient().getText() + "', Единица_измерения = '" + ingredients.getEdIzmer().getText() + "' Where Код = '" + row.get(0) + "'";
                        executeSQL(SQL);
                    });
                break;
                case "Блюда":
                    loader.setLocation(Dishes.class.getResource("Dishes.fxml"));
                    root = loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                    Dishes dishes = loader.getController();
                    dishes.getNameDishes().setText(row.get(1));
                    dishes.getEdIzmer().setText(row.get(2));
                    dishes.getUpdate().setOnAction(e -> {
                        String SQL = "Update Блюда SET Название_блюда = '" + dishes.getNameDishes().getText() + "', Единица_измерения = '" + dishes.getEdIzmer().getText() + "' Where Код = '" + row.get(0) + "'";
                        executeSQL(SQL);
                    });
                break;
                case "Должность":
                    loader.setLocation(Position.class.getResource("Position.fxml"));
                    root = loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                    Position position = loader.getController();
                    position.getNamePosition().setText(row.get(1));
                    position.getUpdate().setOnAction(e -> {
                        String SQL = "Update Должность SET Должность = '" + position.getNamePosition().getText() + "' Where Код = '" + row.get(0) + "'";
                        executeSQL(SQL);
                    });
                break;
                case "Заказ_с_доставкой":
                    loader.setLocation(OrderWithDelivery.class.getResource("OrderWithDelivery.fxml"));
                    root = loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                    OrderWithDelivery orderWithDelivery = loader.getController();
                    orderWithDelivery.getAddress().setText(row.get(1));
                    orderWithDelivery.getPhoneNumber().setText(row.get(2));
                    orderWithDelivery.getDate().setValue(LocalDate.parse(row.get(3)));
                    orderWithDelivery.getUpdate().setOnAction(e -> {
                        String SQL = "Update Заказ_с_доставкой SET Адрес = '" + orderWithDelivery.getAddress().getText() + "', Телефон = '" + orderWithDelivery.getPhoneNumber().getText() + "', Дата = '" + orderWithDelivery.getDate().getValue() + "' Where Код = '" + row.get(0) + "'";
                        executeSQL(SQL);
                    });
                break;
                case "Блюда_в_доставке":
                    loader.setLocation(DishesInDelivery.class.getResource("DishesInDelivery.fxml"));
                    root = loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                    DishesInDelivery dishesInDelivery = loader.getController();
                    dishesInDelivery.getNameDishes().setText(row.get(1));
                    dishesInDelivery.getAddressDelivery().setText(row.get(2));
                    dishesInDelivery.getCount().setText(row.get(3));
                    dishesInDelivery.getUpdate().setOnAction(e -> {
                        String SQL = "Update Блюда_в_доставке SET Код_меню = (Select Код From Меню Where Код_блюда = (Select Код From Блюда Where Название_блюда = '" + dishesInDelivery.getNameDishes().getText() + "'))," +
                                "Код_заказа_с_доставкой = (Select Код From Заказ_с_доставкой Where Адрес = '" + dishesInDelivery.getAddressDelivery().getText() + "'), Количество = '" + dishesInDelivery.getCount().getText() + "'" +
                                " Where Код = '" + row.get(0) + "'";
                        executeSQL(SQL);
                    });
                break;
                case "Поставщики":
                    loader.setLocation(Providers.class.getResource("Providers.fxml"));
                    root = loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                    Providers providers = loader.getController();
                    providers.getNameProvider().setText(row.get(1));
                    providers.getAddress().setText(row.get(2));
                    providers.getPhoneNumber().setText(row.get(3));
                    providers.getUpdate().setOnAction(e -> {
                        String SQL = "Update Поставщики SET Название = '" + providers.getNameProvider().getText() + "', Адрес = '" + providers.getAddress().getText() + "', Телефон = '" + providers.getPhoneNumber().getText() + "'" +
                                " Where Код = '" + row.get(0) + "'";
                        executeSQL(SQL);
                    });
                break;
                case "Меню":
                    loader.setLocation(Menu.class.getResource("Menu.fxml"));
                    root = loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                    Menu menu = loader.getController();
                    menu.getNameDishes().setText(row.get(1));
                    menu.getPriceDishes().setText(row.get(2));
                    menu.getDate().setValue(LocalDate.parse(row.get(3)));
                    menu.getUpdate().setOnAction(e -> {
                        String SQL = "Update Меню SET Код_блюда = (Select Код From Блюда Where Название_блюда = '" + menu.getNameDishes().getText() + "'), Цена_блюда = '" + menu.getPriceDishes().getText() + "', Дата = '" + menu.getDate().getValue() + "'" +
                                " Where Код = '" + row.get(0) + "'";
                        executeSQL(SQL);
                    });
                break;
                case "Заказы":
                    loader.setLocation(Orders.class.getResource("Orders.fxml"));
                    root = loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                    Orders orders = loader.getController();
                    orders.getFIOCoworker().setText(row.get(1));
                    orders.getNameBluda().setText(row.get(2));
                    orders.getDate().setValue(LocalDate.parse(row.get(3)));
                    orders.getTime().setText(row.get(4));
                    orders.getNumberTable().setText(row.get(5));
                    orders.getCount().setText(row.get(6));
                    orders.getUpdate().setOnAction(e -> {
                        String SQL = "UPDATE Заказы SET Код_сотрудника = (Select Код From Сотрудники Where ФИО = '" + orders.getFIOCoworker().getText() + "')" +
                                ",Код_меню = (Select Код From Меню Where Код_блюда = (Select Код From Блюда Where Название_блюда = '" + orders.getNameBluda().getText() + "'))" +
                                ",Дата = '" + orders.getDate().getValue() + "'" +
                                ",Время = '" + orders.getTime().getText() + "'" +
                                ",Номер_столика = '" + orders.getNumberTable().getText() + "'" +
                                ",Количество = '" + orders.getCount().getText() + "'" +
                                " Where Код = '" + row.get(0) + "'";
                        executeSQL(SQL);
                    });
                break;
                case "Закупка":
                    loader.setLocation(Purchase.class.getResource("Purchase.fxml"));
                    root = loader.load();
                    stage.setScene(new Scene(root));
                    stage.show();
                    Purchase purchase = loader.getController();
                    purchase.getNameIngredient().setText(row.get(1));
                    purchase.getCount().setText(row.get(2));
                    purchase.getProvider().setText(row.get(3));
                    purchase.getDate().setValue(LocalDate.parse(row.get(4)));
                    purchase.getPrice().setText(row.get(5));
                    purchase.getUpdate().setOnAction(e -> {
                        String SQL = "UPDATE Закупка SET Код_ингредиента = (Select Код From Ингредиенты Where Название = '" + purchase.getNameIngredient().getText() + "')" +
                                ",Количество = '" + purchase.getCount().getText() + "'" +
                                ",Код_поставщика = (Select Код From Поставщики Where Название = '" + purchase.getProvider().getText() + "')" +
                                ",Дата = '" + purchase.getDate().getValue() + "'" +
                                ",Цена = '" + purchase.getPrice().getText() + "'" +
                                " Where Код = '" + row.get(0) + "'";
                        executeSQL(SQL);
                    });
                break;
            }
        }
    }

    public void refresh(ActionEvent actionEvent) {
        buildData(chooseTable.getValue());
    }

    public void openView1(ActionEvent actionEvent) {
        outView("Select * From Блюда_в_доставке_Представление");
        saver.setVisible(true);
    }

    public void openView2(ActionEvent actionEvent) {
        outView("Select * From ПоставщикиПредставление");
        saver.setVisible(true);
    }

    public void openView3(ActionEvent actionEvent) {
        outView("Select * From ЗаказыДоступныхБлюд08102019");
        saver.setVisible(true);

    }

    public void clearTable(ActionEvent actionEvent) {
        tableView.getColumns().clear();
        //chooseTable.getSelectionModel().clearSelection();
    }

    public void outView(String SQL) {
        data = FXCollections.observableArrayList();
        try {
            //String SQL = "Select * From Блюда_в_доставке_Представление";
            ResultSet rs = getConnection().createStatement().executeQuery(SQL);
            tableView.getColumns().clear();
            for(int i = 0 ; i < rs.getMetaData().getColumnCount(); i++){
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
                tableView.getColumns().addAll(col);
                tableView.getColumns().get(0).setMaxWidth(0);
                tableView.getColumns().get(0).setMinWidth(0);
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i = 1 ; i <= rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            tableView.setItems(data);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void saveDataInFile(ActionEvent actionEvent) throws IOException {
        ExcelFile file = new ExcelFile();
        ExcelWorksheet worksheet = file.addWorksheet("sheet");
        for (int i = 1; i < tableView.getColumns().size(); i++) {
            worksheet.getCell(0, i).setValue(tableView.getColumns().get(i).getText());
        }
        for (int row = 1; row < tableView.getItems().size() + 1; row++) {
            ObservableList cells = (ObservableList) tableView.getItems().get(row - 1);
            for (int column = 1; column < cells.size(); column++) {
                if (cells.get(column) != null) {
                    tableView.getColumns().get(column).getText();
                    worksheet.getCell(row, column).setValue(cells.get(column).toString());
                }
            }
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("XLSX files (*.xlsx)", "*.xlsx"),
                new FileChooser.ExtensionFilter("XLS files (*.xls)", "*.xls"),
                new FileChooser.ExtensionFilter("ODS files (*.ods)", "*.ods"),
                new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv"),
                new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html")
        );
        File saveFile = fileChooser.showSaveDialog(tableView.getScene().getWindow());

        file.save(saveFile.getAbsolutePath());

    }
}