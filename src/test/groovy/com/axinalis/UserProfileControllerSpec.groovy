package com.axinalis

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class UserProfileControllerSpec extends Specification implements ControllerUnitTest<UserProfileController> {

    def userProfileController = new UserProfileController()

    def setup() {
    }

    def cleanup() {
    }

    void "User profile is visited correct response is returned"() {
        when:
        userProfileController.index()

        then:
        response.getJson()["username"] != null
    }
}
