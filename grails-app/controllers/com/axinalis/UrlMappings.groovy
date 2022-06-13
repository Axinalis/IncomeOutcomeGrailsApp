package com.axinalis

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/$user/transfer"(resource: "moneyTransfer")
        "/"(controller: "main")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
