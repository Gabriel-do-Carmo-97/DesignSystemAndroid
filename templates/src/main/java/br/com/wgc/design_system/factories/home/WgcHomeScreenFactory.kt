package br.com.wgc.design_system.factories.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.templates.screens.home.fintech.FakeFintechHomeViewModel
import br.com.wgc.design_system.templates.screens.home.fintech.FintechHomeScreenTemplate
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Home (WgcHomeScreenFactory).
 */
@Composable
fun WgcHomeScreenFactory(
    modifier: Modifier = Modifier,
    variant: WgcHomeVariant = WgcHomeVariant.FINTECH,
    topBarSlot: (@Composable () -> Unit)? = null,
    bannersSlot: (@Composable () -> Unit)? = null,
    contentSlot: (@Composable () -> Unit)? = null,
    bottomNavSlot: (@Composable () -> Unit)? = null
) {
    if (hasCustomHomeSlots(topBarSlot, bannersSlot, contentSlot, bottomNavSlot)) {
        CustomSlotsHomeLayout(
            modifier = modifier,
            topBarSlot = topBarSlot,
            bannersSlot = bannersSlot,
            contentSlot = contentSlot,
            bottomNavSlot = bottomNavSlot
        )
    } else {
        RenderHomeVariant(variant = variant)
    }
}

@Composable
private fun CustomSlotsHomeLayout(
    modifier: Modifier,
    topBarSlot: (@Composable () -> Unit)?,
    bannersSlot: (@Composable () -> Unit)?,
    contentSlot: (@Composable () -> Unit)?,
    bottomNavSlot: (@Composable () -> Unit)?
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { topBarSlot?.invoke() },
        bottomBar = { bottomNavSlot?.invoke() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(WgcCoreDsSpacing.md16.dp)
        ) {
            bannersSlot?.invoke()
            Box(modifier = Modifier.weight(1f).fillMaxWidth()) {
                contentSlot?.invoke() ?: Text("Conteúdo Principal da Home")
            }
        }
    }
}

@Composable
private fun RenderHomeVariant(
    variant: WgcHomeVariant
) {
    when (variant) {
        WgcHomeVariant.FINTECH,
        WgcHomeVariant.ECOMMERCE,
        WgcHomeVariant.STREAMING,
        WgcHomeVariant.FITNESS -> FintechHomeScreenTemplate(
            viewModel = FakeFintechHomeViewModel()
        )
    }
}

private fun hasCustomHomeSlots(
    topBarSlot: (@Composable () -> Unit)?,
    bannersSlot: (@Composable () -> Unit)?,
    contentSlot: (@Composable () -> Unit)?,
    bottomNavSlot: (@Composable () -> Unit)?
): Boolean {
    val hasTop = topBarSlot != null || bannersSlot != null
    val hasBottom = contentSlot != null || bottomNavSlot != null
    return hasTop || hasBottom
}

@Preview(name = "WgcHomeScreenFactory - Preview", showBackground = true)
@Composable
private fun WgcHomeScreenFactoryPreview() {
    WgcTheme {
        WgcHomeScreenFactory()
    }
}
