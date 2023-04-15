package com.chrosciu.rating.application.port.out;

import com.chrosciu.rating.domain.Item;

import java.util.Optional;

public interface LoadItemPort {
    Optional<Item> loadItem(String id);
}
