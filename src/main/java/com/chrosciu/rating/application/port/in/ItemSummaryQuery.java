package com.chrosciu.rating.application.port.in;

import java.util.Optional;

public interface ItemSummaryQuery {
    Optional<ItemSummary> getSummaryForItem(String id);
}
