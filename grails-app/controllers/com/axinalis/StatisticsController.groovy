package com.axinalis

import groovy.json.JsonOutput

class StatisticsController {

    def moneyTransferService

    def index() {
        Integer sum = 0
        moneyTransferService.list().each{ MoneyTransfer it ->
            sum += it.getAmount()
        }
        def json = JsonOutput.toJson([
                "balance": sum
        ])
        render(text: json, contentType: "application/json", encoding: "UTF-8")
    }
}
