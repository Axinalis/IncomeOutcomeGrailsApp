package com.axinalis

import grails.rest.RestfulController

class MoneyTransferController extends RestfulController<MoneyTransfer>{

    def id
    def moneyTransferService

    MoneyTransferController() {
        super(MoneyTransfer)
    }

    MoneyTransferController(boolean readOnly) {
        super(MoneyTransfer, readOnly)
    }

    def index() {
        respond moneyTransferService.list()
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
