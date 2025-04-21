package com.server.entities

import java.util.*

class User(val name: String) {
    val id: String = UUID.randomUUID().toString()
}