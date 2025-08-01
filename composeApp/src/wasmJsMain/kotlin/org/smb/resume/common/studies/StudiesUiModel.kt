package org.smb.resume.common.studies

import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class StudiesUiModel(
    val logoUrl: DrawableResource? = null,
    val name: StringResource,
    val degree: StringResource
)


fun getStudies(): List<StudiesUiModel> {
    return listOf(
        StudiesUiModel(
            logoUrl = Res.drawable.ic_etsisi,
            name = Res.string.content_etsisi_app,
            degree = Res.string.content_etsisi_app_degree
        ), StudiesUiModel(
            logoUrl = Res.drawable.ic_coursera,
            name = Res.string.content_coursera,
            degree = Res.string.content_coursera_degree
        )
    )
}
