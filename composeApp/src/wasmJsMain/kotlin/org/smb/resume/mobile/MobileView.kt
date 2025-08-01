package org.smb.resume.mobile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.smb.resume.mobile.content.ContentMobileView
import org.smb.resume.mobile.footer.FooterMobileView
import org.smb.resume.mobile.header.HeaderMobileView
import org.smb.resume.ui.theme.color_inverse

@Composable
fun MobileView() {
    Column(modifier = Modifier.verticalScroll(state = rememberScrollState())) {
        HeaderMobileView()
        ContentMobileView(
            modifier = Modifier.background(color = color_inverse)
        )
        FooterMobileView()
    }

}