package br.com.wgc.design_system.components.buttons.fab

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.tools.screenshot.PreviewTest


class FAButtonScreenshotTest {

    /**
     * Captura uma imagem do `FAButton` no seu tamanho SMALL
     * para validar sua aparência visual padrão.
     */
    @PreviewTest
    @Preview(showBackground = true)
    @Composable
    fun verifySmallFabAppearance() {
        FAButton(
            onClick = {},
            fabType = FABType.SMALL,
            description = "description",
            icon = Icons.Default.Description
        )
    }

    /**
     * Captura uma imagem do `FAButton` no seu tamanho MEDIUM
     * para garantir que sua cor e elevação estão corretas.
     */
    @PreviewTest
    @Preview
    @Composable
    fun verifyMediumFabAppearance() {
        FAButton(
            onClick = {},
            fabType = FABType.MEDIUM,
            description = "description",
            icon = Icons.Default.Description
        )
    }

    /**
     * Captura uma imagem do `FAButton` no seu tamanho LARGE
     * para validar seu maior tamanho e aparência.
     */
    @PreviewTest
    @Preview
    @Composable
    fun verifyLargeFabAppearance() {
        FAButton(
            onClick = {},
            fabType = FABType.LARGE,
            description = "description",
            icon = Icons.Default.Description
        )
    }

    /**
     * Captura uma imagem do `FAButton` no seu tipo EXTENDED,
     * validando o alinhamento e espaçamento entre o ícone e o texto.
     */
    @PreviewTest
    @Preview
    @Composable
    fun verifyExtendedFabAppearance() {
        FAButton(
            onClick = {},
            fabType = FABType.DESCRIPTION,
            description = "description",
            icon = Icons.Default.Description
        )
    }

    /**
     * Captura uma imagem de um FAB com um formato customizado
     * (ex: `RoundedCornerShape(16.dp)`) para garantir que a propriedade `shape`
     * está sendo aplicada visualmente.
     */
    @PreviewTest
    @Preview
    @Composable
    fun verifyFabWithCustomShapeAppearance() {
        FAButton(
            onClick = {},
            fabType = FABType.SMALL,
            description = "description",
            shape = RoundedCornerShape(4.dp),
            icon = Icons.Default.Description
        )
    }
}