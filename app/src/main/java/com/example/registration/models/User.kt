package com.example.registration.models

class User {
    var displayName:String? = null
    var photoLink:String? = null

    constructor(displayName: String?, photoLink: String?) {
        this.displayName = displayName
        this.photoLink = photoLink
    }

    constructor()

    override fun toString(): String {
        return "User(displayName=$displayName, photoLink=$photoLink)"
    }
}