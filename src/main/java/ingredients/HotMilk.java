package ingredients;

import enums.IngredientsEnum;

public class HotMilk extends Ingredient{
    public HotMilk(int requiredQuantity){
        super(requiredQuantity, IngredientsEnum.hot_milk);
    }
}
