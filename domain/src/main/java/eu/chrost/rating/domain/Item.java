package eu.chrost.rating.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Item {
    String id;
    List<Rating> ratings;

    public static Item create(String id) {
        return new Item(id, new ArrayList<>());
    }

    public static Item build(String id, List<Rating> ratings) {
        return new Item(id, new ArrayList<>(ratings));
    }

    public boolean rate(Rating rating) {
        if (rating.getValue() < 0) {
            return false;
        }
        ratings.add(rating);
        return true;
    }


}
