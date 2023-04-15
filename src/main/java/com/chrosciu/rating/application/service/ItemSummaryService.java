package com.chrosciu.rating.application.service;

import com.chrosciu.rating.application.port.in.ItemSummary;
import com.chrosciu.rating.application.port.in.ItemSummaryQuery;
import com.chrosciu.rating.application.port.out.LoadItemSummaryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class ItemSummaryService implements ItemSummaryQuery {
    private final LoadItemSummaryPort loadItemSummaryPort;
    @Override
    public Optional<ItemSummary> getSummaryForItem(String id) {
        return loadItemSummaryPort.loadItemSummary(id);
    }
}
