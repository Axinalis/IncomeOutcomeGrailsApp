package com.axinalis

import groovy.json.JsonOutput

class MoneyTransferController{

    def moneyTransferService

    def index() {
        String json = JsonOutput.toJson(moneyTransferService.list())
        render(text: json, contentType: "application/json", encoding: "UTF-8")
    }

    def create(){
        respond new MoneyTransfer(params)
    }

    def show(id){
        respond moneyTransferService.get(id)
    }

    def save(MoneyTransfer transfer){
        respond moneyTransferService.save(transfer)
    }

    def delete(id){
        respond moneyTransferService.delete(id)
    }

}
