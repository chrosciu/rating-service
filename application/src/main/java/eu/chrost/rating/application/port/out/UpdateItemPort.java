package eu.chrost.rating.application.port.out;

import eu.chrost.rating.domain.Item;

public interface UpdateItemPort {
    void updateItem(Item item);
}
