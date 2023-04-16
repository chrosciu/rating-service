package eu.chrost.rating.application.port.in;

import java.util.Optional;

public interface ItemSummaryQuery {
    Optional<ItemSummary> getSummaryForItem(String id);
}
