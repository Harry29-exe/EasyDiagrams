package com.easydiagrams.edwebapi.shared

interface DaoService<DOMAIN, ID> {

    fun get(id: ID): DOMAIN?

    fun getAll(): List<DOMAIN>

    fun create(domain: DOMAIN): ID?

    fun update(domain: DOMAIN): Boolean

    fun delete(id: ID): Boolean

}