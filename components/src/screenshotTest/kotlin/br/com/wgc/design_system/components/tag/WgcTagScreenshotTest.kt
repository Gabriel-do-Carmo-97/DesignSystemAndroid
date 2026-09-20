package br.com.wgc.design_system.components.tag

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.tools.screenshot.PreviewTest

class WgcTagScreenshotTest {

    @PreviewTest
    @Preview(showBackground = true, name = "Tag Variants Preview")
    @Composable
    private fun TagVariantsPreview() {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            WgcTag(text = "Novo", variant = WgcTagVariant.Primary)
            WgcTag(text = "Destaque", variant = WgcTagVariant.Success, leadingIcon = {
                Icon(Icons.Default.Star, contentDescription = null)
            })
            WgcTag(text = "Promoção", variant = WgcTagVariant.Warning, style = WgcTagStyle.Outlined)
            WgcTag(text = "Esgotado", variant = WgcTagVariant.Error, size = WgcTagSize.Small)
        }
    }
}
