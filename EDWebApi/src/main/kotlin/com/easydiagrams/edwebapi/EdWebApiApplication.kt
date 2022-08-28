package com.easydiagrams.edwebapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.easydiagrams.edwebapi"])
class EdWebApiApplication

fun main(args: Array<String>) {
    runApplication<EdWebApiApplication>(*args)
}
