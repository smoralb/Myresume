package org.smb.resume.model

import org.jetbrains.compose.resources.DrawableResource

data class ExperienceUiModel(
    val logoUrl: DrawableResource? = null,
    val companyName: String,
    val date: String,
    val role: String,
    val jobDescription: String
)
