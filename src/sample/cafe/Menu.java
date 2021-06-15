package sample.cafe;

import java.time.LocalDate;

public class Menu {

    private int idMenu;
    private int idDishes;
    private double price;
    private LocalDate date;

    public Menu(int idMenu, int idDishes, double price, LocalDate date) {
        this.idMenu = idMenu;
        this.idDishes = idDishes;
        this.price = price;
        this.date = date;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdDishes() {
        return idDishes;
    }

    public void setIdDishes(int idDishes) {
        this.idDishes = idDishes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
