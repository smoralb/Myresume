package org.smb.resume.mobile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.smb.resume.desktop.content.ContentView
import org.smb.resume.desktop.footer.FooterView
import org.smb.resume.mobile.header.HeaderMobileView
import org.smb.resume.ui.theme.color_inverse

@Composable
fun MobileView() {
    Column {
        HeaderMobileView()
        ContentView(
            modifier = Modifier.background(color = color_inverse)
        )
        FooterView()
    }

}