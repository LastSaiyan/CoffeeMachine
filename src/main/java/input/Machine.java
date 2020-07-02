package input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Beverages;
import enums.Ingredients;

import java.util.Map;

public class Machine {
    public Map<String, Integer> outlets;
    @JsonProperty("total_items_quantity")
    public Map<Ingredients, Integer> totalItemsQuantity;
    public Map<Beverages, Map<Ingredients, Integer>> beverages;
}
