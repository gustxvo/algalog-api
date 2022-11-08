package com.algaworks.algalog.api.model.input

import javax.validation.constraints.NotBlank

class OccurrenceInput(
    @field:NotBlank val description: String
)