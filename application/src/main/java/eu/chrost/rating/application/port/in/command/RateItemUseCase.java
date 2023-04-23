package eu.chrost.rating.application.port.in.command;

public interface RateItemUseCase {
    boolean rateItem(RateItemCommand command);
}
