package com.axinalis

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

@Integration
@Rollback
class MoneyTransferServiceSpec extends Specification implements ServiceUnitTest<MoneyTransferService>{

    //def moneyTransferService = new MoneyTransferService()

    def setup() {
    }

    def cleanup() {
    }

    void "Test that service returns data"() {
        when:
        service.list()

        then:
        service.list() != null
        service.list().size() == 0
    }

    void "Test that service saves data"() {
        setup:
        service.save(new MoneyTransfer(
                id: 1,
                user: 'Anton',
                amount: 100,
                date: new GregorianCalendar(2022, 2, 2).time,
                type: "INCOME"))

        when:
        service.list()

        then:
        service.list().size() == 1
        service.list()[0].user == "Anton"
        service.list()[0].amount == 100
    }

    void "Test that get method returns correct info"() {
        setup:
        service.save(new MoneyTransfer(
                id: 1,
                user: 'Anton',
                amount: 100,
                date: new GregorianCalendar(2022, 2, 2).time,
                type: "INCOME"))

        when:
        service.get(1)

        then:
        service.list().size() > 0
        service.list().first() != null
        service.list().first().id == "Anton"
        service.get(0).user == "Anton"
    }

    void "Test that service deletes data"() {
        setup:
        service.save(new MoneyTransfer(
                id: 1,
                user: 'Anton',
                amount: 100,
                date: new GregorianCalendar(2022, 2, 2).time,
                type: "INCOME"))
        service.save(new MoneyTransfer(
                id: 2,
                user: 'Bob',
                amount: 10,
                date: new GregorianCalendar(2022, 1, 2).time,
                type: "OUTCOME"))

        when:
        service.delete(0)

        then:
        service.list().size() == 1
        service.get(2).user == "Bob"
    }
}
