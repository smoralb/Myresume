package org.smb.resume.common.projects

import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class ProjectUiModel(
    val imageUrl: DrawableResource,
    val tag: StringResource,
    val title: StringResource,
    val description: StringResource,
    val linkText: StringResource
)

fun getProjects(): List<ProjectUiModel> {
    return listOf(
        ProjectUiModel(
            imageUrl = Res.drawable.ic_idealista,
            tag = Res.string.proj_card1_tag,
            title = Res.string.proj_card1_title,
            description = Res.string.proj_card1_desc,
            linkText = Res.string.proj_card1_link
        ),
        ProjectUiModel(
            imageUrl = Res.drawable.ic_android,
            tag = Res.string.proj_card2_tag,
            title = Res.string.proj_card2_title,
            description = Res.string.proj_card2_desc,
            linkText = Res.string.proj_card2_link
        ),
        ProjectUiModel(
            imageUrl = Res.drawable.ic_project_app,
            tag = Res.string.proj_card3_tag,
            title = Res.string.proj_card3_title,
            description = Res.string.proj_card3_desc,
            linkText = Res.string.proj_card3_link
        )
    )
}