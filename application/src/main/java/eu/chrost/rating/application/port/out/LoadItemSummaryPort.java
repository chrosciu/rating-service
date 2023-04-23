package eu.chrost.rating.application.port.out;

import eu.chrost.rating.application.port.in.query.ItemSummary;

import java.util.Optional;

public interface LoadItemSummaryPort {
    Optional<ItemSummary> loadItemSummary(String id);
}
