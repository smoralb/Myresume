package org.smb.resume.content.model

import org.jetbrains.compose.resources.DrawableResource

data class ExperienceUiModel(
    val logoUrl: DrawableResource,
    val companyName: String,
    val date: String,
    val role: String,
    val jobDescription: List<BaseJobDescription>
)

open class BaseJobDescription(
    open val title: String,
    open val description: String
)

data class JobDescription(
    override val title: String,
    override val description: String
): BaseJobDescription (title, description)

data class TechDescription(
    override val title: String,
    override val description: String
): BaseJobDescription (title, description)
