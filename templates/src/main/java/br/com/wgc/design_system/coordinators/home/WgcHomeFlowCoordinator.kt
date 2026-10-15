package br.com.wgc.design_system.coordinators.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.cart.WgcCartScreenFactory
import br.com.wgc.design_system.factories.home.WgcHomeScreenFactory
import br.com.wgc.design_system.factories.home.WgcHomeVariant
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Coordenador de Fluxo da Tela Inicial com Tabs (WgcHomeFlowCoordinator).
 */
@Composable
fun WgcHomeFlowCoordinator(
    currentTab: WgcHomeTab = WgcHomeTab.Feed,
    modifier: Modifier = Modifier,
    variant: WgcHomeVariant = WgcHomeVariant.FINTECH,
    onTabSelected: (WgcHomeTab) -> Unit = {},
    feedScreen: @Composable () -> Unit = {
        WgcHomeScreenFactory(modifier = modifier, variant = variant)
    },
    searchScreen: @Composable () -> Unit = {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Tela de Busca e Exploração")
        }
    },
    cartScreen: @Composable () -> Unit = {
        WgcCartScreenFactory(modifier = modifier)
    },
    profileScreen: @Composable () -> Unit = {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Perfil do Usuário e Configurações")
        }
    }
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = currentTab == WgcHomeTab.Feed,
                    onClick = { onTabSelected(WgcHomeTab.Feed) },
                    icon = { Text("🏠") },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = currentTab == WgcHomeTab.Search,
                    onClick = { onTabSelected(WgcHomeTab.Search) },
                    icon = { Text("🔍") },
                    label = { Text("Busca") }
                )
                NavigationBarItem(
                    selected = currentTab == WgcHomeTab.Cart,
                    onClick = { onTabSelected(WgcHomeTab.Cart) },
                    icon = { Text("🛒") },
                    label = { Text("Carrinho") }
                )
                NavigationBarItem(
                    selected = currentTab == WgcHomeTab.Profile,
                    onClick = { onTabSelected(WgcHomeTab.Profile) },
                    icon = { Text("👤") },
                    label = { Text("Perfil") }
                )
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            when (currentTab) {
                WgcHomeTab.Feed -> feedScreen()
                WgcHomeTab.Search -> searchScreen()
                WgcHomeTab.Cart -> cartScreen()
                WgcHomeTab.Profile -> profileScreen()
            }
        }
    }
}

@Preview(name = "WgcHomeFlowCoordinator - Preview", showBackground = true)
@Composable
private fun WgcHomeFlowCoordinatorPreview() {
    WgcTheme {
        WgcHomeFlowCoordinator()
    }
}
