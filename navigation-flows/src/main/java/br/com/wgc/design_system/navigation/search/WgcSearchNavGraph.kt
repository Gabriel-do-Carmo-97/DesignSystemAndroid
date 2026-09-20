package br.com.wgc.design_system.navigation.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.navigation.toRoute
import br.com.wgc.design_system.commons.WgcDevicePreviews
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.templates.factories.WgcSearchFactory
import br.com.wgc.design_system.templates.factories.WgcSearchType
import kotlinx.serialization.Serializable

@Serializable
object WgcSearchGraphRoute

@Serializable
object WgcSearchMainRoute

@Serializable
data class WgcSearchResultDetailRoute(
    val itemId: String = "item-101",
    val itemTitle: String = "Fone de Ouvido Noise Cancelling",
    val itemPrice: String = "R$ 349,90"
)

/**
 * Grafo de navegação completo e type-safe para fluxos de busca e catálogo (WgcSearchNavGraph).
 *
 * @param navController Controlador de navegação.
 * @param onAddToCart Callback disparado quando o usuário adiciona um item ao carrinho.
 * @param onBackClick Callback disparado ao solicitar retorno ou fechar a busca.
 */
fun NavGraphBuilder.wgcSearchNavGraph(
    navController: NavController,
    onAddToCart: (itemId: String, title: String) -> Unit = { _, _ -> },
    onBackClick: () -> Unit = { navController.popBackStack() }
) {
    navigation<WgcSearchGraphRoute>(startDestination = WgcSearchMainRoute) {
        composable<WgcSearchMainRoute> {
            var query by remember { mutableStateOf("") }
            var category by remember { mutableStateOf("Todos") }

            WgcSearchFactory(
                type = WgcSearchType.STANDARD,
                searchQuery = query,
                onSearchQueryChange = { query = it },
                selectedCategory = category,
                onCategorySelect = { category = it },
                onResultClick = { product ->
                    navController.navigate(
                        WgcSearchResultDetailRoute(
                            itemId = "ID-${product.hashCode()}",
                            itemTitle = product,
                            itemPrice = "R$ 299,00"
                        )
                    )
                },
                onBackClick = onBackClick
            )
        }

        composable<WgcSearchResultDetailRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<WgcSearchResultDetailRoute>()
            WgcSearchResultDetailNavScreen(
                route = route,
                onNavigateBack = { navController.popBackStack() },
                onAddToCart = { onAddToCart(route.itemId, route.itemTitle) }
            )
        }
    }
}

@Suppress("LongMethod")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcSearchResultDetailNavScreen(
    route: WgcSearchResultDetailRoute,
    onNavigateBack: () -> Unit,
    onAddToCart: () -> Unit,
    modifier: Modifier = Modifier
) {
    var addedToCart by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Detalhes do Produto", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            Surface(
                tonalElevation = WgcCoreDsElevation.level8.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    WgcClassicButton(
                        textButton = if (addedToCart) "Adicionado ao Carrinho ✓" else "Adicionar ao Carrinho",
                        onClick = {
                            addedToCart = true
                            onAddToCart()
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Card(
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(32.dp)
                    )
                }
            }

            Text(
                text = route.itemTitle,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = route.itemPrice,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )

            HorizontalDivider()

            Text(
                text = "Descrição do Produto",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "Produto homologado pelo Design System WGC. Conta com garantia estendida, suporte corporativo e entrega rápida rastreada.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            if (addedToCart) {
                Surface(
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(WgcCoreDsSpacing.sm12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Icon(Icons.Default.CheckCircle, contentDescription = null, tint = MaterialTheme.colorScheme.onTertiaryContainer)
                        Text(
                            text = "Item pronto para finalização no Checkout!",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                    }
                }
            }
        }
    }
}

/**
 * Host independente do fluxo de busca para uso direto em qualquer tela.
 */
@Composable
fun WgcSearchNavHost(
    modifier: Modifier = Modifier,
    onAddToCart: (itemId: String, title: String) -> Unit = { _, _ -> },
    onClose: () -> Unit = {}
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = WgcSearchGraphRoute,
        modifier = modifier
    ) {
        wgcSearchNavGraph(
            navController = navController,
            onAddToCart = onAddToCart,
            onBackClick = onClose
        )
    }
}

@Preview(showBackground = true)
@WgcDevicePreviews
@Composable
private fun WgcSearchNavHostPreview() {
    MaterialTheme {
        WgcSearchNavHost()
    }
}
