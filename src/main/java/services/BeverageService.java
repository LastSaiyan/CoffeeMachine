package services;

import beverages.Beverage;
import enums.IngredientsEnum;
import ingredients.Ingredient;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BeverageService {
    private static final String unAvailableErrorMessage = "%s cannot be prepared because %s is not available";
    private static final String inSufficientErrorMessage = "%s cannot be prepared because %s is not sufficient";
    private static final String preparedMessage = "%s is prepared";

    /**
     * This is the initial object
     * which is created and beverages are created based on the ingredient quantity available here
     */
    Map<IngredientsEnum, Ingredient> ingredients;

    public BeverageService(Map<IngredientsEnum, Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * For now this method only allows one thread at a time to modify the data
     *
     * @param beverage beverage that need to prepared
     * @return either errors or prepared message
     */
    public synchronized List<String> prepareBeverage(Beverage beverage) {
        List<String> messages = new ArrayList<>();
        for (Ingredient ingredient : beverage.getIngredients()) {
            if (this.ingredients.get(ingredient.getName()) == null) {
                messages.add(String.format(unAvailableErrorMessage, beverage.getName(), ingredient.getName()));
            } else {
                int availableQuantity = this.ingredients.get(ingredient.getName()).getRequiredQuantity();
                if (ingredient.getRequiredQuantity() > availableQuantity) {
                    messages.add(String.format(inSufficientErrorMessage, beverage.getName(), ingredient.getName()));
                }
            }
        }
        if (CollectionUtils.isEmpty(messages)) {
            for (Ingredient ingredient : beverage.getIngredients()) {
                int availableQuantity = this.ingredients.get(ingredient.getName()).getRequiredQuantity();
                this.ingredients.get(ingredient.getName()).updateRequiredQuantity(availableQuantity - ingredient.getRequiredQuantity());
            }
            messages.add(String.format(preparedMessage, beverage.getName()));
        }
        return messages;
    }
}
