package com.easydiagrams.edwebapi.diagram.api

import com.easydiagrams.edwebapi.generated.api.DiagramApi
import com.easydiagrams.edwebapi.generated.model.CreateProjectDTO
import com.easydiagrams.edwebapi.generated.model.ProjectDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class DiagramApiController : DiagramApi {

    override fun createDiagram(createProjectDTO: CreateProjectDTO?): ResponseEntity<Unit> {
        return super.createDiagram(createProjectDTO)
    }

    override fun deleteDiagram(uuid: UUID): ResponseEntity<Unit> {
        return super.deleteDiagram(uuid)
    }

    override fun getAllDiagrams(page: String, itemsPerPage: String): ResponseEntity<List<ProjectDTO>> {
        return super.getAllDiagrams(page, itemsPerPage)
    }
}