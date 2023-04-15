package com.chrosciu.rating.application.port.in;

import lombok.Value;

@Value
public class ItemSummary {
    long ratingsCount;
    double averageRating;
}
