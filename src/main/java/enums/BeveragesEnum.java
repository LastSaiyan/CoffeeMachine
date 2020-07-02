package enums;

import beverages.*;

/**
 * This enum class will help us to
 * give us an beverage object based on the value if required
 */
public enum BeveragesEnum {
    hot_tea {
        public Beverage getBeverage() {
            return new HotTea();
        }
    },
    hot_coffee {
        public Beverage getBeverage() {
            return new HotCoffee();
        }
    },
    green_tea {
        public Beverage getBeverage() {
            return new GreenTea();
        }
    },
    black_tea {
        public Beverage getBeverage() {
            return new BlackTea();
        }
    };

    /*
    This is default beverage
    If none of the above beverages matches it reaches here
     */
    public Beverage getBeverage() throws Exception {
        throw new Exception("Invalid Beverage." +
                "Please add it in Beverage Enum before using");
    }
}
