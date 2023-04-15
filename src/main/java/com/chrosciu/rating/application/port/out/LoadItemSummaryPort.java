package com.chrosciu.rating.application.port.out;

import com.chrosciu.rating.application.port.in.ItemSummary;

import java.util.Optional;

public interface LoadItemSummaryPort {
    Optional<ItemSummary> loadItemSummary(String id);
}
