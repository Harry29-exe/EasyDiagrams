package com.easydiagrams.edwebapi.shared

interface DtoMapper<Domain, DTO> {

    fun dto(domain: Domain): DTO

    fun domain(dto: DTO): Domain

}