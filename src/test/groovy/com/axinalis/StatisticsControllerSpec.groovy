package com.axinalis

import grails.testing.web.controllers.ControllerUnitTest
import org.apache.commons.lang.time.DateFormatUtils
import spock.lang.Specification

import java.text.DateFormat
import java.util.logging.Logger

class StatisticsControllerSpec extends Specification implements ControllerUnitTest<StatisticsController> {

    def setup() {
    }

    def cleanup() {
    }

    void "Test the index action returns the correct response"() {
        given:
        controller.moneyTransferService = Mock(MoneyTransferService) {
            it.list() >> [new MoneyTransfer(
                    id: 1,
                    user: "Anton",
                    amount: 100,
                    date: new GregorianCalendar(2022, 2, 2).time,
                    type: "INCOME")]
        }

        when:"The index action is executed"
        controller.index()

        then:"The model is correct"
        response.getJson()["balance"] == 100
    }
}
