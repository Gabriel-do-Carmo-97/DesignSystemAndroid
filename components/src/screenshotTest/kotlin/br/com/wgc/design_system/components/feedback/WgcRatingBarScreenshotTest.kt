package br.com.wgc.design_system.components.feedback

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing

class WgcRatingBarScreenshotTest {

    @Preview(showBackground = true)
    @Composable
    fun WgcRatingBarVariantsPreview() {
        Column(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
            WgcRatingBar(rating = 5f, reviewCount = 1420)
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))
            WgcRatingBar(rating = 3.5f, reviewCount = 85)
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))
            WgcRatingBar(rating = 1.0f, reviewCount = 12)
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))
            WgcRatingBar(rating = 4f, isInteractive = true, onRatingChange = {})
        }
    }
}
