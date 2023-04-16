package eu.chrost.rating.application.port.in;

public interface RateItemUseCase {
    boolean rateItem(RateItemCommand command);
}
