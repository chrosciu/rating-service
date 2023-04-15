package com.chrosciu.rating.application.port.in;

import com.chrosciu.rating.domain.Rating;
import lombok.Value;

@Value
public class RateItemCommand {
    String id;
    Rating rating;
}
