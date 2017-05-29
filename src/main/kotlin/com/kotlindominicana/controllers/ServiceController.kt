package com.kotlindominicana.controllers


import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by frang on 5/29/2017.
 */
@RestController
@RequestMapping("/")
class ServiceController {

    //Data classes to avoid creating new class files
    data class User(var username: String, var password: String, var firsName: String, var lastName: String, var age: Long)
    data class Error(var error: Boolean, var message: String)
    data class UserData(var user: User?, var error: Error)

    @RequestMapping("/")
    fun index(): String {
        return "Welcome to the kotlin test service..."
    }

    // The code is auto rendered as JSON
    /*
        {
        "user": {
        "username": "Fhernandez",
        "password": "1234",
        "firsName": "Frangel",
        "lastName": "Hernandez",
        "age": 25
        },
        "error": {
        "error": false,
        "message": "Everything good..."
        }
        }

      */
    @RequestMapping("/test")
    fun test(username: String?): UserData? {
        val ret: UserData? // This to allow nullable variable since kotlin doesn't have nullability
        if (username is String) {
            val user = User(firsName = "Frangel", lastName = "Hernandez", username = "Fhernandez", password = "1234", age = 25)
            ret = UserData(user,Error(false,"Everything good..."))
        } else {
            val error = Error(true, "Username cannot be null!")
            ret  = UserData(null,error)
        }
        return ret // the framework auto render object as a JSON
    }


}