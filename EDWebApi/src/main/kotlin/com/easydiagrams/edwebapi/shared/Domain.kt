package com.easydiagrams.edwebapi.shared

interface Domain<ID> {

    val id: ID

}

interface DtoMappable<DTO> {

    fun dto(): DTO

}