package be.lsinf1225.ezmealgroupee;

/**
 * Created by Gaetan on 22/06/2017.
 */

public class objetIngredient {
    private String ingredient;

    objetIngredient(String nom){
        this.ingredient=nom;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
