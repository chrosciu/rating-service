package eu.chrost.rating.application.port.out;

import eu.chrost.rating.domain.Item;

import java.util.Optional;

public interface LoadItemPort {
    Optional<Item> loadItem(String id);
}
