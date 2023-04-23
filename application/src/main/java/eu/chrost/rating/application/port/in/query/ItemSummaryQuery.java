package eu.chrost.rating.application.port.in.query;

import java.util.Optional;

public interface ItemSummaryQuery {
    Optional<ItemSummary> getSummaryForItem(String id);
}
