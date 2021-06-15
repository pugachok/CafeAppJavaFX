package sample.cafe;

import java.time.LocalDate;

public class Purchase {

    private int idPurchase;
    private int idIngredient;
    private int amount;
    private int idContractor;
    private LocalDate date;
    private double price;

    public Purchase(int idPurchase, int idIngredient, int amount, int idContractor, LocalDate date, double price) {
        this.idPurchase = idPurchase;
        this.idIngredient = idIngredient;
        this.amount = amount;
        this.idContractor = idContractor;
        this.date = date;
        this.price = price;
    }

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIdContractor() {
        return idContractor;
    }

    public void setIdContractor(int idContractor) {
        this.idContractor = idContractor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
