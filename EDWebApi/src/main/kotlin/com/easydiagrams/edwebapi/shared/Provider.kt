package com.easydiagrams.edwebapi.shared

interface Provider<T> {

    fun provide(): T

    fun provide(name: String): T

}