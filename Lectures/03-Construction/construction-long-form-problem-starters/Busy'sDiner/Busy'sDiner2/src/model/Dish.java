package model;

import java.util.List;

public class Dish {

    private String name;
    private String description;
    private List<String> ingredients;
    private String recipe;

    public Dish(String name) {
        this.name = name;
    }

    public Dish(String name, String description, List<String> ingredients, String recipe) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.recipe = recipe;
    }



    // getters:
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getRecipe() {
        return recipe;
    }




    // setters:
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
