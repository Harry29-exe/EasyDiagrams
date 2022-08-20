package com.easydiagrams.edwebapi.shared

import org.yaml.snakeyaml.events.Event

interface DaoService<ID : Comparable<ID>, DOMAIN : Domain<ID>> {

    fun get(id: ID): DOMAIN?

    fun getAll(): List<DOMAIN>

    fun create(domain: DOMAIN): ID?

    fun update(domain: DOMAIN): Boolean

    fun delete(id: ID): Boolean

}