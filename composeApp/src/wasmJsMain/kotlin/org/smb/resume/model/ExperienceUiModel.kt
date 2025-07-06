package org.smb.resume.model

import org.jetbrains.compose.resources.DrawableResource

data class ExperienceUiModel(
    val logoUrl: DrawableResource,
    val companyName: String,
    val date: String,
    val role: String,
    val jobDescription: List<JobDescription>
)

data class JobDescription(
    val title: String,
    val description: String
)
