package eu.chrost.rating.adapter.in.web;

import eu.chrost.rating.application.port.in.ItemSummary;
import eu.chrost.rating.application.port.in.ItemSummaryQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class ItemQueryController {
    private final ItemSummaryQuery itemSummaryQuery;

    @GetMapping("/item/{id}")
    public ResponseEntity<ItemSummary> rateItem(@PathVariable("id") String id) {
        return itemSummaryQuery.getSummaryForItem(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }
}
