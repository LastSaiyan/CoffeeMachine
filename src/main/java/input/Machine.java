package input;

import com.fasterxml.jackson.annotation.JsonProperty;
import enums.BeveragesEnum;
import enums.IngredientsEnum;

import java.util.Map;

public class Machine {
    public Map<String, Integer> outlets;
    @JsonProperty("total_items_quantity")
    public Map<IngredientsEnum, Integer> totalItemsQuantity;
    public Map<BeveragesEnum, Map<IngredientsEnum, Integer>> beverages;
}
