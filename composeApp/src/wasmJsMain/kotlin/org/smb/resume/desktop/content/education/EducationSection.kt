package org.smb.resume.desktop.content.education

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import myresume.composeapp.generated.resources.*
import org.jetbrains.compose.resources.stringResource
import org.smb.resume.ui.theme.*

@Composable
fun EducationSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 100.dp, horizontal = 80.dp),
        verticalArrangement = Arrangement.spacedBy(60.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = stringResource(Res.string.edu_label),
                style = Typography().labelMedium.copy(fontWeight = FontWeight.Bold),
                color = color_black
            )
            Text(
                text = stringResource(Res.string.edu_title),
                style = Typography().headlineLarge,
                color = color_black,
                textAlign = TextAlign.End
            )
        }

        // Education list
        Column(modifier = Modifier.fillMaxWidth()) {
            Divider()
            EducationEntry(
                institution = stringResource(Res.string.edu_1_name),
                degree = stringResource(Res.string.edu_1_degree)
            )
            Divider()
            EducationEntry(
                institution = stringResource(Res.string.edu_2_name),
                degree = stringResource(Res.string.edu_2_degree)
            )
            Divider()
        }
    }
}

@Composable
private fun EducationEntry(
    institution: String,
    degree: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp),
        horizontalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        Text(
            text = institution,
            style = Typography().headlineSmall,
            color = color_black,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = degree,
            style = Typography().bodyMedium,
            color = color_zinc_500,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun Divider() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color_zinc_800)
    )
}
