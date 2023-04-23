package eu.chrost.rating.application.service;

import eu.chrost.rating.application.port.in.query.ItemSummary;
import eu.chrost.rating.application.port.in.query.ItemSummaryQuery;
import eu.chrost.rating.application.port.out.LoadItemSummaryPort;
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
