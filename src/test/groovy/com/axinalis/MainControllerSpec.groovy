package com.axinalis

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class MainControllerSpec extends Specification implements ControllerUnitTest<MainController> {

    def mainController = new MainController()

    def setup() {
    }

    def cleanup() {
    }

    void "Test main controller's action index returns correct response"() {
        when:
        mainController.index()

        then:
        response.getJson()["user name"] == "/exampleName"
        response.getJson()["user info"] == "/exampleName/profile"
        response.getJson()["account statistics"] == "/exampleName/statistics"
        response.getJson()["transfers info"] == "/exampleName/transfer"
    }
}
