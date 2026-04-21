package org.smb.resume.desktop.content.experience

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
fun ExperienceSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color_black)
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
                text = stringResource(Res.string.exp_label),
                style = Typography().labelMedium.copy(fontWeight = FontWeight.Bold),
                color = color_white
            )
            Text(
                text = stringResource(Res.string.exp_title),
                style = Typography().headlineLarge,
                color = color_white,
                textAlign = TextAlign.End
            )
        }

        // Job list
        Column(modifier = Modifier.fillMaxWidth()) {
            Divider()
            JobEntry(
                year = stringResource(Res.string.exp_job1_year),
                title = stringResource(Res.string.exp_job1_title),
                company = stringResource(Res.string.exp_job1_company),
                description = stringResource(Res.string.exp_job1_desc)
            )
            Divider()
            JobEntry(
                year = stringResource(Res.string.exp_job2_year),
                title = stringResource(Res.string.exp_job2_title),
                company = stringResource(Res.string.exp_job2_company),
                description = stringResource(Res.string.exp_job2_desc)
            )
            Divider()
            JobEntry(
                year = stringResource(Res.string.exp_job3_year),
                title = stringResource(Res.string.exp_job3_title),
                company = stringResource(Res.string.exp_job3_company),
                description = stringResource(Res.string.exp_job3_desc)
            )
            Divider()
            JobEntry(
                year = stringResource(Res.string.exp_job4_year),
                title = stringResource(Res.string.exp_job4_title),
                company = stringResource(Res.string.exp_job4_company),
                description = stringResource(Res.string.exp_job4_desc)
            )
            Divider()
            JobEntry(
                year = stringResource(Res.string.exp_job5_year),
                title = stringResource(Res.string.exp_job5_title),
                company = stringResource(Res.string.exp_job5_company),
                description = stringResource(Res.string.exp_job5_desc)
            )
            Divider()
            JobEntry(
                year = stringResource(Res.string.exp_job6_year),
                title = stringResource(Res.string.exp_job6_title),
                company = stringResource(Res.string.exp_job6_company),
                description = stringResource(Res.string.exp_job6_desc)
            )
            Divider()
        }
    }
}

@Composable
private fun JobEntry(
    year: String,
    title: String,
    company: String,
    description: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp),
        horizontalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        Text(
            text = year,
            style = Typography().labelMedium,
            color = color_zinc_500,
            modifier = Modifier.width(200.dp)
        )
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = title,
                style = Typography().headlineSmall,
                color = color_white
            )
            Text(
                text = company,
                style = Typography().bodyMedium,
                color = color_zinc_500
            )
            Text(
                text = description,
                style = Typography().bodySmall,
                color = color_zinc_400
            )
        }
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
