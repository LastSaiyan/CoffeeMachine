package beverages;

import enums.Beverages;
import ingredients.Ingredient;

import java.util.ArrayList;
import java.util.List;

public abstract class Beverage {
    private List<Ingredient> ingredients;
    private Beverages name;
    public Beverage(Beverages name) {
        this.ingredients = new ArrayList<>();
        this.name = name;
    }

    public Beverage addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public Beverages getName(){
        return name;
    }

    public boolean isBeverageServiceable(){
        return false;
    }

}
