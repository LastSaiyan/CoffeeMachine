package beverages;

import enums.BeveragesEnum;
import ingredients.Ingredient;

import java.util.ArrayList;
import java.util.List;

public abstract class Beverage {
    /**
     * ingredients required to make a beverage
     * we will keep adding the required ingredients for a beverage
     */
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

}
