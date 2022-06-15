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
        "/$user/statistics"(controller: "statistics")
        "/$user/profile"(controller: "userProfile")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
