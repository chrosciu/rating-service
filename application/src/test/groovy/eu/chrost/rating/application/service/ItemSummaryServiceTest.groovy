package eu.chrost.rating.application.service

import eu.chrost.rating.application.port.in.query.ItemSummary
import eu.chrost.rating.application.port.out.LoadItemSummaryPort
import spock.lang.Specification

class ItemSummaryServiceTest extends Specification {
    def 'should fetch item summary'() {
        given:
        def loadItemSummaryPort = Mock(LoadItemSummaryPort)
        def itemSummaryService = new ItemSummaryService(loadItemSummaryPort)
        def someId = UUID.randomUUID().toString()
        loadItemSummaryPort.loadItemSummary(someId) >> Optional.of(new ItemSummary(2, 1.5))

        when:
        def itemSummary = itemSummaryService.getSummaryForItem(someId)

        then:
        itemSummary.present
        itemSummary.get() == (new ItemSummary(2, 1.5))
    }
}
