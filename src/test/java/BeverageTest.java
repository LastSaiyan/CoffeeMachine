import beverages.Beverage;
import com.fasterxml.jackson.databind.ObjectMapper;
import enums.BeveragesEnum;
import enums.IngredientsEnum;
import ingredients.Ingredient;
import input.InputRequest;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.BeverageService;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeverageTest {

    private InputRequest inputRequest = null;
    Map<IngredientsEnum, Ingredient> ingredients = new HashMap<>();

    @Before
    public void setup() throws Exception {
        String inputFilePath = "src/main/resources/input.json";
        ObjectMapper objectMapper = new ObjectMapper();
        inputRequest = objectMapper.readValue(new File(inputFilePath), InputRequest.class);
        for(Map.Entry<IngredientsEnum, Integer> ingredient: inputRequest.machine.totalItemsQuantity.entrySet()){
            ingredients.put(ingredient.getKey(), ingredient.getKey().getIngredient(ingredient.getValue()));
        }
    }

    @Test
    public void test() throws Exception {
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
        Beverage blackTea = BeveragesEnum.black_tea.getBeverage();
        for(Map.Entry<IngredientsEnum, Integer> ingredient : blackTeaIngredients.entrySet()){
            blackTea.addIngredient(ingredient.getKey().getIngredient(ingredient.getValue()));
        }


        BeverageService beverageService = new BeverageService(ingredients);
        List<String> messages = beverageService.prepareBeverage(hotCoffee);
        Assert.assertArrayEquals(Lists.newArrayList("hot_coffee is prepared").toArray(), messages.toArray());
        messages = beverageService.prepareBeverage(hotTea);
        Assert.assertArrayEquals(Lists.newArrayList("hot_tea is prepared").toArray(), messages.toArray());
        messages = beverageService.prepareBeverage(greenTea);
        Assert.assertArrayEquals(Lists.newArrayList("green_tea cannot be prepared because sugar_syrup is not sufficient",
                "green_tea cannot be prepared because green_mixture is not available").toArray(), messages.toArray());
        messages = beverageService.prepareBeverage(blackTea);
        Assert.assertArrayEquals(Lists.newArrayList("black_tea cannot be prepared because hot_water is not sufficient",
                "black_tea cannot be prepared because sugar_syrup is not sufficient").toArray(), messages.toArray());
    }

}
