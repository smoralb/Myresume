package org.smb.resume.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RowItem() {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        content = {
            Row {
                //image
                //Date
                Column {
                    //title
                    //Description
                }
            }
            //Animatable expand description
        }
    )
}