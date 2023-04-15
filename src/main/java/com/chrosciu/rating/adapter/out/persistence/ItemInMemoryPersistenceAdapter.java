package com.chrosciu.rating.adapter.out.persistence;

import com.chrosciu.rating.application.port.in.ItemSummary;
import com.chrosciu.rating.application.port.out.LoadItemPort;
import com.chrosciu.rating.application.port.out.LoadItemSummaryPort;
import com.chrosciu.rating.application.port.out.UpdateItemPort;
import com.chrosciu.rating.domain.Item;
import com.chrosciu.rating.domain.Rating;
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
