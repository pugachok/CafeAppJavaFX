package sample.cafe;

public class Dishes {

    private int idDishes;
    private String nameDishes;
    private String edIzmereniya;

    public Dishes(int idDishes, String nameDishes, String edIzmereniya) {
        this.idDishes = idDishes;
        this.nameDishes = nameDishes;
        this.edIzmereniya = edIzmereniya;
    }

    public int getIdDishes() {
        return idDishes;
    }

    public void setIdDishes(int idDishes) {
        this.idDishes = idDishes;
    }

    public String getNameDishes() {
        return nameDishes;
    }

    public void setNameDishes(String nameDishes) {
        this.nameDishes = nameDishes;
    }

    public String getEdIzmereniya() {
        return edIzmereniya;
    }

    public void setEdIzmereniya(String edIzmereniya) {
        this.edIzmereniya = edIzmereniya;
    }
}
