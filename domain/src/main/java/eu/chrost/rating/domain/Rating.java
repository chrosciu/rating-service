package eu.chrost.rating.domain;

import lombok.Value;

@Value
public class Rating {
    double value;
    String review;
}
