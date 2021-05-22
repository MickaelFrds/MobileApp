package com.example.mobileapp

import java.nio.file.attribute.GroupPrincipal
import java.util.*

class Restaurant (
    val name: String = "AA",
    val description : String = "aa",
    val adresse : String = "24 b",
    val horaire : String = "14h à 17h",
    val imagePrincipal : String,
    var liked : Boolean = false
)