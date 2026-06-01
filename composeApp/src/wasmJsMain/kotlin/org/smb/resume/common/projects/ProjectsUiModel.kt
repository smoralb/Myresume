package org.smb.resume.common.projects

import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class ProjectUiModel(
    val imageUrl: DrawableResource? = null,
    val tag: StringResource,
    val title: StringResource,
    val description: StringResource,
    val linkText: StringResource,
    val url: String? = null,
    val isCompact: Boolean = false
)

fun getProjects(): List<ProjectUiModel> {
    return listOf(
        ProjectUiModel(
            imageUrl = Res.drawable.ic_what_before,
            tag = Res.string.proj_card2_tag,
            title = Res.string.proj_card2_title,
            description = Res.string.proj_card2_desc,
            linkText = Res.string.proj_card2_link,
            url = "https://smoralb.github.io/WhatBefore/"
        ),
        ProjectUiModel(
            imageUrl = null,
            tag = Res.string.proj_card3_tag,
            title = Res.string.proj_card3_title,
            description = Res.string.proj_card3_desc,
            linkText = Res.string.proj_card3_link,
            isCompact = true
        )
    )
}