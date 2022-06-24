package com.axinalis

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

@Integration
@Rollback
class MoneyTransferControllerSpec extends Specification implements ControllerUnitTest<MoneyTransferController> {

    def setup() {
    }

    def cleanup() {
    }

    void "Test that index action returns correct response"() {
        given:
        def service = new MoneyTransferService()
        service.save(new MoneyTransfer(
                id: 1,
                user: "Anton",
                amount: 100,
                date: new GregorianCalendar(2022, 2, 2).time,
                type: "INCOME"))
        service.save(new MoneyTransfer(
                id: 2,
                user: "Bob",
                amount: 10,
                date: new GregorianCalendar(2022, 2, 2).time,
                type: "OUTCOME"))
        /*
        def cont = new StatisticsController()
        def moneyTransferController = new MoneyTransferController()
        cont.getProperties().keySet().sort().each {
            println it.toString()
        }
        println "-------------------"
        moneyTransferController.getProperties().keySet().sort().each {
            println it.toString()
        }

        controller.moneyTransferService = Mock(MoneyTransferService) {
            it.list() >> [new MoneyTransfer(
                    id: 1,
                    user: "Anton",
                    amount: 100,
                    date: new GregorianCalendar(2022, 2, 2).time,
                    type: "INCOME")]
        }
        */

        when:
        controller.index()

        then:
        response.getJson()[0]["user"] == "Anton"
    }
}
