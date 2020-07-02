package ingredients;

import enums.IngredientsEnum;

public abstract class Ingredient {
    protected int requiredQuantity;
    protected IngredientsEnum name;
    public Ingredient(int requiredQuantity, IngredientsEnum name){
        this.requiredQuantity = requiredQuantity;
        this.name = name;
    }

    public int getRequiredQuantity(){
        return this.requiredQuantity;
    }

    /**
     * This will help to set or update the quantity
     * @param requiredQuantity quantity to update or set
     */
    public void updateRequiredQuantity(int requiredQuantity){
        this.requiredQuantity = requiredQuantity;
    }

    public IngredientsEnum getName() {
        return name;
    }
}
