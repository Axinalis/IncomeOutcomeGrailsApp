package com.axinalis

import grails.gorm.transactions.Transactional

@Transactional
class MoneyTransferService {

    def serviceMethod() {

    }

    def list(){
        MoneyTransfer.list()
    }

    def get(id){
        MoneyTransfer.get(id)
    }

    def save(moneyTransfer){
        moneyTransfer.save()
    }

    def delete(id){
        MoneyTransfer.delete(id)
    }


}
