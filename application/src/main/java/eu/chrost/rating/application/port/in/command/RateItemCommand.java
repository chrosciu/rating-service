package eu.chrost.rating.application.port.in.command;

import eu.chrost.rating.domain.Rating;
import lombok.Value;

@Value
public class RateItemCommand {
    String id;
    Rating rating;
}
