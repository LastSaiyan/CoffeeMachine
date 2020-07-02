package enums;

import beverages.Beverage;
import ingredients.*;

public enum Ingredients {
    hot_water {
        public Ingredient getIngredient(int requiredQuantity) {
            return new HotWater(requiredQuantity);
        }
    },
    hot_milk {
        public Ingredient getIngredient(int requiredQuantity) {
            return new HotMilk(requiredQuantity);
        }
    },
    ginger_syrup {
        public Ingredient getIngredient(int requiredQuantity) {
            return new GingerSyrup(requiredQuantity);
        }
    },
    sugar_syrup {
        public Ingredient getIngredient(int requiredQuantity) {
            return new SugarSyrup(requiredQuantity);
        }
    },
    tea_leaves_syrup {
        public Ingredient getIngredient(int requiredQuantity) {
            return new TeaLeavesSyrup(requiredQuantity);
        }
    },
    green_mixture {
        public Ingredient getIngredient(int requiredQuantity) {
            return new GreenMixture(requiredQuantity);
        }
    };

    /*
    This is default ingredient
    If none of the above ingredients matches it reaches here
    */
    public Ingredient getIngredient(int requiredQuantity) throws Exception {
        throw new Exception("Invalid Ingredient." +
                "Please add it in Ingredients Enum before using");
    }
}
