package ingredients;

import beverages.Beverage;
import enums.Ingredients;

public class HotWater extends Ingredient{
    public HotWater(int quantity){
        super(quantity, Ingredients.hot_water);
    }
}
