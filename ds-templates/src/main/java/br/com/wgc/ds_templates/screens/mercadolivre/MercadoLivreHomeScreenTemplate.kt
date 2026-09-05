package br.com.wgc.ds_templates.screens.mercadolivre

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.mercadolivre.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MercadoLivreProduct(
    val id: String,
    val title: String,
    val originalPrice: String,
    val currentPrice: String,
    val discountPercent: String,
    val installments: String,
    val isFreeShipping: Boolean = true
)

data class MercadoLivreHomeUiState(
    val address: String = "Enviar para Gabriel - Rua Augusta 1000",
    val searchQuery: String = "",
    val categories: List<WgcMercadoLivreCategoryItem> = listOf(
        WgcMercadoLivreCategoryItem("1", "Ofertas", "⚡", Color(0xFFFFF9C4)),
        WgcMercadoLivreCategoryItem("2", "Mercado", "🛒", Color(0xFFE3F2FD)),
        WgcMercadoLivreCategoryItem("3", "Meli+", "⭐", Color(0xFFE8EAF6)),
        WgcMercadoLivreCategoryItem("4", "Moda", "👕", Color(0xFFF3E5F5)),
        WgcMercadoLivreCategoryItem("5", "Veículos", "🚗", Color(0xFFE0F2F1))
    ),
    val products: List<MercadoLivreProduct> = listOf(
        MercadoLivreProduct("1", "Smart TV 50\" 4K UHD Samsung", "R$ 2.499", "R$ 1.899", "24% OFF", "em 10x R$ 189,90 sem juros"),
        MercadoLivreProduct("2", "Fone Sem Fio Bluetooth Noise Cancelling", "R$ 499", "R$ 299", "40% OFF", "em 6x R$ 49,83 sem juros"),
        MercadoLivreProduct("3", "Console de Videogame 1TB 4K", "R$ 4.299", "R$ 3.499", "18% OFF", "em 12x R$ 291,58 sem juros")
    )
)

abstract class BaseMercadoLivreHomeViewModel : ViewModel() {
    abstract val uiState: StateFlow<MercadoLivreHomeUiState>
    abstract fun onSearchQueryChange(query: String)
    abstract fun onAddressClick()
    abstract fun onCartClick()
}

class FakeMercadoLivreHomeViewModel : BaseMercadoLivreHomeViewModel() {
    override val uiState: StateFlow<MercadoLivreHomeUiState> = MutableStateFlow(MercadoLivreHomeUiState()).asStateFlow()
    override fun onSearchQueryChange(query: String) {}
    override fun onAddressClick() {}
    override fun onCartClick() {}
}

@Composable
fun MercadoLivreHomeScreenTemplate(viewModel: BaseMercadoLivreHomeViewModel) {
    val state by viewModel.uiState.collectAsState()
    MercadoLivreHomeScreenContent(
        state = state,
        onSearchQueryChange = { viewModel.onSearchQueryChange(it) },
        onAddressClick = { viewModel.onAddressClick() },
        onCartClick = { viewModel.onCartClick() }
    )
}

@Composable
fun MercadoLivreHomeScreenContent(
    modifier: Modifier = Modifier,
    state: MercadoLivreHomeUiState,
    onSearchQueryChange: (String) -> Unit,
    onAddressClick: () -> Unit,
    onCartClick: () -> Unit
) {
    Scaffold(modifier = modifier.fillMaxSize()) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFEBEBEB))
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            WgcMercadoLivreHeader(
                address = state.address,
                searchQuery = state.searchQuery,
                onAddressClick = onAddressClick,
                onSearchQueryChange = onSearchQueryChange,
                onCartClick = onCartClick
            )

            WgcMercadoLivreCategoryGrid(categories = state.categories)

            PaddingBox {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF2D3277))
                ) {
                    Column(
                        modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(text = "meli+ • Assine por R$ 17,90/mês", color = Color.White, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                        Text(text = "Frete grátis em milhões de produtos + Disney+ incluído 🎬", color = Color.White.copy(alpha = 0.9f), style = MaterialTheme.typography.bodySmall)
                    }
                }
            }

            PaddingBox {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Ofertas do Dia ⚡",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF333333)
                    )
                    Text(
                        text = "Ver todas",
                        style = MaterialTheme.typography.labelLarge,
                        color = Color(0xFF1976D2),
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            LazyRow(
                contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp),
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
            ) {
                items(state.products, key = { it.id }) { product ->
                    WgcMercadoLivreProductCard(
                        title = product.title,
                        originalPrice = product.originalPrice,
                        currentPrice = product.currentPrice,
                        discountPercent = product.discountPercent,
                        installments = product.installments,
                        isFreeShipping = product.isFreeShipping
                    )
                }
            }

            Spacer(Modifier.height(32.dp))
        }
    }
}

@Composable
private fun PaddingBox(content: @Composable () -> Unit) {
    Box(modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp)) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
private fun MercadoLivreHomePreview() {
    MaterialTheme {
        MercadoLivreHomeScreenContent(
            state = MercadoLivreHomeUiState(),
            onSearchQueryChange = {},
            onAddressClick = {},
            onCartClick = {}
        )
    }
}
