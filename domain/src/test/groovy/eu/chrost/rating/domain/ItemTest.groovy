package eu.chrost.rating.domain

import spock.lang.Specification

class ItemTest extends Specification {
    def 'new item should be created with no ratings'() {
        when:
        def item = Item.create(UUID.randomUUID().toString())

        then:
        item.ratings.empty
    }

    def 'rating item with negative value should not succeed'() {
        given:
        def item = Item.create(UUID.randomUUID().toString())

        when:
        def result = item.rate(ratingOfValue(-1.5d))

        then:
        !result
    }

    def 'rating item with positive value should succeed'() {
        given:
        def item = Item.create(UUID.randomUUID().toString())

        when:
        def result = item.rate(ratingOfValue(0.5d))

        then:
        result
        item.ratings == [ratingOfValue(0.5d)]
    }

    def ratingOfValue(def value) {
        new Rating(value, null)
    }
}
