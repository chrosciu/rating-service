package com.chrosciu.rating.application.port.out;

import com.chrosciu.rating.domain.Item;

public interface UpdateItemPort {
    void updateItem(Item item);
}
