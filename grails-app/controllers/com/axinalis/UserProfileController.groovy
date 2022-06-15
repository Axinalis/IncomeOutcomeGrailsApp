package com.axinalis

import groovy.json.JsonOutput

class UserProfileController {

    def index() {
        def json = JsonOutput.toJson([
                username: "${params.user}"
        ])
        render(text: json, contentType: "application/json", encoding: "UTF-8")
    }
}
