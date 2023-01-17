package com.anushka.viewmodelscopedemo.model

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUser(): List<User> {
        delay(8000)
        val users : List<User> = listOf(
            User(1, "Ardi"),
            User(2, "Uhuy"),
            User(3, "Mardi"),
            User(4, "Tukimen"),
            User(5, "Omen"),
            User(6, "Jett"),
            User(7, "Sage")
        )
        return users

    }
}