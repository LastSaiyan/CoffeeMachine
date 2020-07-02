package ingredients;

import beverages.Beverage;
import enums.Ingredients;

public class SugarSyrup extends  Ingredient{
    public SugarSyrup(int quantity){
        super(quantity, Ingredients.sugar_syrup);
    }
}
