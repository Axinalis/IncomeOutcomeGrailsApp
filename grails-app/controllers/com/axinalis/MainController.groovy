package com.axinalis

import groovy.json.JsonOutput

class MainController {

    MainController() {

    }

    def index() {
        def json = JsonOutput.toJson([
                "user name": "/exampleName",
                "user info": "/exampleName/profile",
                "account statistics": "/exampleName/statistics",
                "transfers info": "/exampleName/transfer"
        ])
        render json
    }
}
