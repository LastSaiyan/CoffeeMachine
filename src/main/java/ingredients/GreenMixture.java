package ingredients;

import enums.IngredientsEnum;

public class GreenMixture extends Ingredient{
    public GreenMixture(int requiredQuantity){
        super(requiredQuantity, IngredientsEnum.green_mixture);
    }
}
