package br.com.wgc.design_system.components.placeholder

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing

class WgcSkeletonScreenshotTest {

    @Preview(showBackground = true)
    @Composable
    fun WgcSkeletonVariantsPreview() {
        Column(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
            WgcSkeletonListItem()
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))
            WgcSkeletonCard()
        }
    }
}
