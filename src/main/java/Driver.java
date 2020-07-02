import beverages.Beverage;
import com.fasterxml.jackson.databind.ObjectMapper;
import enums.BeveragesEnum;
import enums.IngredientsEnum;
import ingredients.Ingredient;
import input.InputRequest;
import services.BeverageService;

import java.io.File;
import java.util.HashMap;
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
        System.out.println(inputRequest.machine.totalItemsQuantity.get(IngredientsEnum.hot_water));

        Map<IngredientsEnum, Ingredient> ingredients = new HashMap<>();
        for(Map.Entry<IngredientsEnum, Integer> ingredient: inputRequest.machine.totalItemsQuantity.entrySet()){
            ingredients.put(ingredient.getKey(), ingredient.getKey().getIngredient(ingredient.getValue()));
        }

        System.out.println(ingredients);



        Map<IngredientsEnum, Integer> hotCoffeeIngredients= inputRequest.machine.beverages.get(BeveragesEnum.hot_coffee);
        Beverage hotCoffee = BeveragesEnum.hot_coffee.getBeverage();
        for(Map.Entry<IngredientsEnum, Integer> ingredient : hotCoffeeIngredients.entrySet()){
            hotCoffee.addIngredient(ingredient.getKey().getIngredient(ingredient.getValue()));
        }


        Map<IngredientsEnum, Integer> hotTeaIngredients= inputRequest.machine.beverages.get(BeveragesEnum.hot_tea);
        Beverage hotTea = BeveragesEnum.hot_tea.getBeverage();
        for(Map.Entry<IngredientsEnum, Integer> ingredient : hotTeaIngredients.entrySet()){
            hotTea.addIngredient(ingredient.getKey().getIngredient(ingredient.getValue()));
        }


        Map<IngredientsEnum, Integer> greenTeaIngredients= inputRequest.machine.beverages.get(BeveragesEnum.green_tea);
        Beverage greenTea = BeveragesEnum.green_tea.getBeverage();
        for(Map.Entry<IngredientsEnum, Integer> ingredient : greenTeaIngredients.entrySet()){
            greenTea.addIngredient(ingredient.getKey().getIngredient(ingredient.getValue()));
        }


        Map<IngredientsEnum, Integer> blackTeaIngredients= inputRequest.machine.beverages.get(BeveragesEnum.black_tea);
        Beverage blacktea = BeveragesEnum.black_tea.getBeverage();
        for(Map.Entry<IngredientsEnum, Integer> ingredient : blackTeaIngredients.entrySet()){
            blacktea.addIngredient(ingredient.getKey().getIngredient(ingredient.getValue()));
        }

        BeverageService beverageService = new BeverageService(ingredients);
        List<String> errors = beverageService.prepareBeverage(hotCoffee);
        System.out.println(errors);
        errors = beverageService.prepareBeverage(hotTea);
        System.out.println(errors);
        errors = beverageService.prepareBeverage(greenTea);
        System.out.println(errors);
        errors = beverageService.prepareBeverage(blacktea);
        System.out.println(errors);
    }
}
