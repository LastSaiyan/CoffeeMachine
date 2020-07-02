package ingredients;

import beverages.Beverage;
import enums.Ingredients;

public class HotMilk extends Ingredient{
    public HotMilk(int requiredQuantity){
        super(requiredQuantity, Ingredients.hot_milk);
    }
}
