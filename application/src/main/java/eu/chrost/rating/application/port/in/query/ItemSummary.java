package eu.chrost.rating.application.port.in.query;

import lombok.Value;

@Value
public class ItemSummary {
    long ratingsCount;
    double averageRating;
}
