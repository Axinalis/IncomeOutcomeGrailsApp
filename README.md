# IncomeOutcomeGrailsApp

This app is a simple prototype of Grails web application.

Application can store information of money transfers and users, count some statistics.

Entrypoint for app is http://localhost:8080

---
Technical information
---

Example of json for creating new transfer:

{
"id":1,
"user":"Bob",
"amount":45,
"date":"2022-06-13",
"type":"INCOME"
}

To start app:
1. Without Docker if you have **grails** installed on local machine, type *grails run-app*, otherwise run ./grailsw script
2. With Docker, just build the image using DockerfileDev and run as usually.