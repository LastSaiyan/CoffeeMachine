package ingredients;

import beverages.Beverage;
import enums.Ingredients;

public class GingerSyrup extends  Ingredient{
    public GingerSyrup(int requiredQuantity){
        super(requiredQuantity, Ingredients.ginger_syrup);
    }
}
