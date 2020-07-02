package ingredients;

import enums.Ingredients;

public abstract class Ingredient {
    protected int requiredQuantity;
    protected Ingredients name;
    public Ingredient(int requiredQuantity, Ingredients name){
        this.requiredQuantity = requiredQuantity;
        this.name = name;
    }

    public int getRequiredQuantity(){
        return this.requiredQuantity;
    }

    public void updateRequiredQuantity(int requiredQuantity){
        this.requiredQuantity = requiredQuantity;
    }

    public Ingredients getName() {
        return name;
    }
}
