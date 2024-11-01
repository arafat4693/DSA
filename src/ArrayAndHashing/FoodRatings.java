package ArrayAndHashing;

import java.util.HashMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

public class FoodRatings {
    class State{
        String food;
        int rating;
        State(String food, int rating){
            this.food = food;
            this.rating = rating;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State state)) return false;
            return rating == state.rating && Objects.equals(food, state.food);
        }

        @Override
        public int hashCode() {
            return Objects.hash(food, rating);
        }
    }

    HashMap<String, Integer> foodRating;
    HashMap<String, String> foodCuisine;
    HashMap<String, TreeSet<State>> cuisineFood;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineFood = new HashMap<>();
        foodRating = new HashMap<>();
        foodCuisine = new HashMap<>();

        for(int i = 0; i < foods.length; i++){
            cuisineFood.putIfAbsent(cuisines[i], new TreeSet<>((a, b) -> {
                if(a.rating == b.rating) return a.food.compareTo(b.food);
                return b.rating - a.rating;
            }));

            cuisineFood.get(cuisines[i]).add(new State(foods[i], ratings[i]));
            foodCuisine.put(foods[i], cuisines[i]);
            foodRating.put(foods[i], ratings[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        int oldRating = foodRating.get(food);
        String cuisine = foodCuisine.get(food);
        foodRating.put(food, newRating);
        cuisineFood.get(cuisine).remove(new State(food, oldRating));
        cuisineFood.get(cuisine).add(new State(food, newRating));
    }

    public String highestRated(String cuisine) {
        return cuisineFood.get(cuisine).first().food;
    }
}
