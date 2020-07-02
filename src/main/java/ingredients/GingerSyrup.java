package ingredients;

import enums.IngredientsEnum;

public class GingerSyrup extends  Ingredient{
    public GingerSyrup(int requiredQuantity){
        super(requiredQuantity, IngredientsEnum.ginger_syrup);
    }
}
