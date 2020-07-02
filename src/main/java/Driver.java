import beverages.Beverage;
import com.fasterxml.jackson.databind.ObjectMapper;
import enums.Beverages;
import enums.Ingredients;
import ingredients.Ingredient;
import input.InputRequest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Driver {
    public static void main(String[] args) throws Exception {
        String inputFilePath = "src/main/resources/input.json";
        ObjectMapper objectMapper = new ObjectMapper();
        InputRequest inputRequest = objectMapper.readValue(new File(inputFilePath), InputRequest.class);
        System.out.println(inputRequest.machine);
        System.out.println(inputRequest.machine.beverages);
        System.out.println(inputRequest.machine.totalItemsQuantity);
        System.out.println(inputRequest.machine.totalItemsQuantity.get(Ingredients.hot_water));

        Map<Ingredients, Integer> hotCoffeeIngredients= inputRequest.machine.beverages.get(Beverages.hot_coffee);
        Beverage hotCoffee = Beverages.hot_coffee.getBeverage();
        for(Map.Entry<Ingredients, Integer> ingredient : hotCoffeeIngredients.entrySet()){
            hotCoffee.addIngredient(ingredient.getKey().getIngredient(ingredient.getValue()));
        }

        System.out.println(hotCoffee.getIngredients().get(0).getRequiredQuantity());

        List<Ingredient> ingredients = new ArrayList<>();
        for(Map.Entry<Ingredients, Integer> ingredient: inputRequest.machine.totalItemsQuantity.entrySet()){
            ingredients.add(ingredient.getKey().getIngredient(ingredient.getValue()));
        }

        System.out.println(ingredients);
        System.out.println(ingredients.get(0).getRequiredQuantity());

    }
}
