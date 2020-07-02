package services;

import beverages.Beverage;
import enums.Ingredients;
import ingredients.Ingredient;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BeverageService {
    private static final String unAvailableErrorMessage = "%s cannot be prepared because %s is not available";
    private static final String inSufficientErrorMessage = "%s cannot be prepared because %s is not sufficient";


    Map<Ingredients, Ingredient> ingredients;

    public BeverageService(Map<Ingredients, Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public synchronized List<String> prepareBeverage(Beverage beverage) {
        List<String> errors = new ArrayList<>();
        List<Ingredient> requiredBeverageIngredients = beverage.getIngredients();
        for (Ingredient ingredient : requiredBeverageIngredients) {
            if (this.ingredients.get(ingredient.getName()) == null) {
                errors.add(String.format(unAvailableErrorMessage, beverage.getName(), ingredient.getName()));
            } else {
                int availableQuantity = this.ingredients.get(ingredient.getName()).getRequiredQuantity();
                if (ingredient.getRequiredQuantity() > availableQuantity) {
                    errors.add(String.format(inSufficientErrorMessage, beverage.getName(), ingredient.getName()));
                }
            }
        }
        if(CollectionUtils.isEmpty(errors)){
            for (Ingredient ingredient : requiredBeverageIngredients) {
                int availableQuantity = this.ingredients.get(ingredient.getName()).getRequiredQuantity();
                this.ingredients.get(ingredient.getName()).updateRequiredQuantity(availableQuantity - ingredient.getRequiredQuantity());
            }
        }
        return errors;
    }
}
