package sample.cafe;

public class DishesInOrder {

    private int idDishes;
    private int idMenu;
    private int idOrderWithDelivery;
    private int amount;

    public DishesInOrder(int idDishes, int idMenu, int idOrderWithDelivery, int amount) {
        this.idDishes = idDishes;
        this.idMenu = idMenu;
        this.idOrderWithDelivery = idOrderWithDelivery;
        this.amount = amount;
    }

    public int getIdDishes() {
        return idDishes;
    }

    public void setIdDishes(int idDishes) {
        this.idDishes = idDishes;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdOrderWithDelivery() {
        return idOrderWithDelivery;
    }

    public void setIdOrderWithDelivery(int idOrderWithDelivery) {
        this.idOrderWithDelivery = idOrderWithDelivery;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
