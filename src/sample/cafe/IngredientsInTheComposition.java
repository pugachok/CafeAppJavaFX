package sample.cafe;

public class IngredientsInTheComposition {

    private int idIngredientInTheComposition;
    private int getIdIngredient;
    private int idDishes;
    private int amount;

    public IngredientsInTheComposition(int idIngredientInTheComposition, int getIdIngredient, int idDishes, int amount) {
        this.idIngredientInTheComposition = idIngredientInTheComposition;
        this.getIdIngredient = getIdIngredient;
        this.idDishes = idDishes;
        this.amount = amount;
    }

    public int getIdIngredientInTheComposition() {
        return idIngredientInTheComposition;
    }

    public void setIdIngredientInTheComposition(int idIngredientInTheComposition) {
        this.idIngredientInTheComposition = idIngredientInTheComposition;
    }

    public int getGetIdIngredient() {
        return getIdIngredient;
    }

    public void setGetIdIngredient(int getIdIngredient) {
        this.getIdIngredient = getIdIngredient;
    }

    public int getIdDishes() {
        return idDishes;
    }

    public void setIdDishes(int idDishes) {
        this.idDishes = idDishes;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
