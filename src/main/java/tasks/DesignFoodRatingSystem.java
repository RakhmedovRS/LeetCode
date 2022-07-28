package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Ruslan Rakhmedov
 * @created 7/28/2022
 * @Ruslan Rakhmedov$
 * @1.0$
 */
@LeetCode(
        id = 2353,
        name = "Design a Food Rating System",
        url = "https://leetcode.com/problems/design-a-food-rating-system/",
        difficulty = Difficulty.MEDIUM
)
public class DesignFoodRatingSystem
{
    class FoodRatings
    {
        Map<String, String> foodToCuisine;
        Map<String, Integer> foodToRating;
        Map<String, TreeSet<String>> rating;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings)
        {
            foodToCuisine = new HashMap<>();
            foodToRating = new HashMap<>();
            rating = new HashMap<>();

            for (int i = 0; i < foods.length; i++)
            {
                foodToCuisine.put(foods[i], cuisines[i]);
                foodToRating.put(foods[i], ratings[i]);

                rating.putIfAbsent(cuisines[i], new TreeSet<>((a, b) ->
                {
                    if (foodToRating.getOrDefault(a, 0).equals(foodToRating.getOrDefault(b, 0)))
                    {
                        return a.compareTo(b);
                    }

                    return foodToRating.get(b) - foodToRating.get(a);
                }));

                rating.get(cuisines[i]).add(foods[i]);
            }

        }

        public void changeRating(String food, int newRating)
        {
            String cuisine = foodToCuisine.get(food);
            rating.get(cuisine).remove(food);
            foodToRating.put(food, newRating);
            rating.get(cuisine).add(food);
        }

        public String highestRated(String cuisine)
        {
            return rating.get(cuisine).first();
        }
    }
}
