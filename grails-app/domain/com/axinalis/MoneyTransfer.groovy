package com.axinalis

import grails.rest.Resource

@Resource(uri = "/*/transfer")
class MoneyTransfer {

    int id
    String user
    long amount
    Date date
    String type

}
