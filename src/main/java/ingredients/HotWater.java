package ingredients;

import enums.IngredientsEnum;

public class HotWater extends Ingredient{
    public HotWater(int quantity){
        super(quantity, IngredientsEnum.hot_water);
    }
}
