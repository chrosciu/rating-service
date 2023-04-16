package eu.chrost.rating.adapter.out.persistence;

import eu.chrost.rating.application.port.in.ItemSummary;
import eu.chrost.rating.application.port.out.LoadItemPort;
import eu.chrost.rating.application.port.out.LoadItemSummaryPort;
import eu.chrost.rating.application.port.out.UpdateItemPort;
import eu.chrost.rating.domain.Item;
import eu.chrost.rating.domain.Rating;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
class ItemInMemoryPersistenceAdapter implements LoadItemPort, LoadItemSummaryPort, UpdateItemPort {
    private final Map<String, Item> items = new HashMap<>();

    @Override
    public Optional<Item> loadItem(String id) {
        return Optional.ofNullable(items.get(id));
    }

    @Override
    public Optional<ItemSummary> loadItemSummary(String id) {
        return loadItem(id)
                .map(item -> item.getRatings().stream().mapToDouble(Rating::getValue).summaryStatistics())
                .map(stats -> new ItemSummary(stats.getCount(), stats.getAverage()));
    }

    @Override
    public void updateItem(Item item) {
        items.put(item.getId(), item);
    }

}
