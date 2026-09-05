package br.com.wgc.design_system.components.chip

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android.tools.screenshot.PreviewTest

class WgcChipScreenshotTest {
    @PreviewTest
    @Preview(showBackground = true, name = "Chip Selected")
    @Composable
    private fun SelectedChipPreview() {
        WgcChip(label = "Ativo", selected = true, onClick = {})
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Chip Unselected")
    @Composable
    private fun UnselectedChipPreview() {
        WgcChip(label = "Inativo", selected = false, onClick = {})
    }

    @PreviewTest
    @Preview(showBackground = true, name = "Chip With Leading Icon")
    @Composable
    private fun ChipWithLeadingIconPreview() {
        WgcChip(label = "Favorito", selected = false, leadingIcon = Icons.Default.Star, onClick = {})
    }
}
