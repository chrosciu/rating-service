package com.chrosciu.rating


import com.chrosciu.rating.application.port.in.ItemSummaryQuery
import com.chrosciu.rating.application.port.in.RateItemCommand
import com.chrosciu.rating.application.port.in.RateItemUseCase
import com.chrosciu.rating.domain.Rating
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class RatingApplicationTest extends Specification {
    @Autowired
    RateItemUseCase rateItemUseCase;
    @Autowired
    ItemSummaryQuery itemSummaryQuery;

    def 'contextLoads'() {
        when:
        def result = rateItemUseCase.rateItem(new RateItemCommand("1", new Rating(1.0, "")))

        then:
        result

        when:
        result = rateItemUseCase.rateItem(new RateItemCommand("1", new Rating(2.0, "")))

        then:
        result

        when:
        def summary = itemSummaryQuery.getSummaryForItem("1")

        then:
        summary.get().ratingsCount == 2
        summary.get().averageRating == 1.5d
    }
}
