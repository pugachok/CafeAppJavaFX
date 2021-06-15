package sample.cafe;

import java.time.LocalDate;

public class Orders {

    private int idOrder;
    private int idCoworker;
    private int idMenu;
    private LocalDate dateOrder;
    private int time;
    private int tableNumber;
    private int amount;


    public Orders(int idOrder, int idCoworker, int idMenu, LocalDate dateOrder, int time, int tableNumber, int amount) {
        this.idOrder = idOrder;
        this.idCoworker = idCoworker;
        this.idMenu = idMenu;
        this.dateOrder = dateOrder;
        this.time = time;
        this.tableNumber = tableNumber;
        this.amount = amount;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdCoworker() {
        return idCoworker;
    }

    public void setIdCoworker(int idCoworker) {
        this.idCoworker = idCoworker;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
