package eu.chrost.rating.adapter.in.web;

import eu.chrost.rating.application.port.in.command.RateItemCommand;
import eu.chrost.rating.application.port.in.command.RateItemUseCase;
import eu.chrost.rating.domain.Rating;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class RateItemController {
    private final RateItemUseCase rateItemUseCase;

    @PutMapping("/item/{id}")
    public void rateItem(@PathVariable("id") String id,
                         @RequestParam("value") double value,
                         @RequestParam(value = "review", required = false) String review) {
        RateItemCommand rateItemCommand = new RateItemCommand(id, new Rating(value, review));
        rateItemUseCase.rateItem(rateItemCommand);
    }

}
