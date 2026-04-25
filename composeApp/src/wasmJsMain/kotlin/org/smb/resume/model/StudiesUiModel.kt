package org.smb.resume.model

import org.jetbrains.compose.resources.DrawableResource

data class StudiesUiModel(
    val logoUrl: DrawableResource? = null,
    val name: String,
    val degree: String
)