package eu.chrost.rating.application.service;

import eu.chrost.rating.application.port.in.command.RateItemCommand;
import eu.chrost.rating.application.port.in.command.RateItemUseCase;
import eu.chrost.rating.application.port.out.LoadItemPort;
import eu.chrost.rating.application.port.out.UpdateItemPort;
import eu.chrost.rating.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
class RateItemService implements RateItemUseCase {
    private final LoadItemPort loadItemPort;
    private final UpdateItemPort updateItemPort;
    @Override
    public boolean rateItem(RateItemCommand command) {
        var item = loadItemPort.loadItem(command.getId())
                .orElseGet(() -> Item.create(command.getId()));
        if (item.rate(command.getRating())) {
            updateItemPort.updateItem(item);
            return true;
        } else {
            return false;
        }
    }
}
