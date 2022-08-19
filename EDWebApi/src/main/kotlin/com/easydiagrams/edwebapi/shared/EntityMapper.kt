package com.easydiagrams.edwebapi.shared

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.sql.Table

interface EntityMapper<DOMAIN, ID : Comparable<ID>, ENTITY : Entity<ID>> {

    fun domain(entity: ENTITY): DOMAIN

    fun entity(domain: DOMAIN): ENTITY

}