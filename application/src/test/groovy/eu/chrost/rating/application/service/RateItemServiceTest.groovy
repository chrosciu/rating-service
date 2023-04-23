package eu.chrost.rating.application.service

import eu.chrost.rating.application.port.in.command.RateItemCommand
import eu.chrost.rating.application.port.out.LoadItemPort
import eu.chrost.rating.application.port.out.UpdateItemPort
import eu.chrost.rating.domain.Item
import eu.chrost.rating.domain.Rating
import spock.lang.Specification

class RateItemServiceTest extends Specification {
    def 'should rate item'() {
        given:
        def loadItemPort = Mock(LoadItemPort)
        def updateItemPort = Mock(UpdateItemPort)
        def someId = UUID.randomUUID().toString()
        def item = Item.create(someId)
        def rateItemService = new RateItemService(loadItemPort, updateItemPort)
        loadItemPort.loadItem(someId) >> Optional.of(item)

        when:
        def result = rateItemService.rateItem(new RateItemCommand(someId, new Rating(1.5, null)))

        then:
        result
        1 * updateItemPort.updateItem(item)

    }
}
