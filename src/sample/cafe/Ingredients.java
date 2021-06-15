package sample.cafe;

public class Ingredients {

    private int idIngredient;
    private String nameIngredients;
    private String edIzmereniya;

    public Ingredients(int idIngredient, String nameIngredients, String edIzmereniya) {
        this.idIngredient = idIngredient;
        this.nameIngredients = nameIngredients;
        this.edIzmereniya = edIzmereniya;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getNameIngredients() {
        return nameIngredients;
    }

    public void setNameIngredients(String nameIngredients) {
        this.nameIngredients = nameIngredients;
    }

    public String getEdIzmereniya() {
        return edIzmereniya;
    }

    public void setEdIzmereniya(String edIzmereniya) {
        this.edIzmereniya = edIzmereniya;
    }
}
