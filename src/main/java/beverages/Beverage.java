package beverages;

import enums.BeveragesEnum;
import ingredients.Ingredient;

import java.util.ArrayList;
import java.util.List;

public abstract class Beverage {
    private List<Ingredient> ingredients;
    private BeveragesEnum name;
    public Beverage(BeveragesEnum name) {
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

    public BeveragesEnum getName(){
        return name;
    }

    public boolean isBeverageServiceable(){
        return false;
    }

}
