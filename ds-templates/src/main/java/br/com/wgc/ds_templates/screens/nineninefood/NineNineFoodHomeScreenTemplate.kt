package br.com.wgc.ds_templates.screens.nineninefood

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.nineninefood.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class NineNineRestaurant(
    val id: String,
    val name: String,
    val rating: String,
    val category: String,
    val deliveryTime: String,
    val deliveryFee: String,
    val discountTag: String
)

data class NineNineFoodHomeUiState(
    val address: String = "Av. Paulista, 1000 - Bela Vista",
    val searchQuery: String = "",
    val categories: List<WgcNineNineCategoryItem> = listOf(
        WgcNineNineCategoryItem("1", "Entrega 15m", "⚡", Color(0xFF0B2545)),
        WgcNineNineCategoryItem("2", "Restaurantes", "🍕", Color(0xFFE3F2FD)),
        WgcNineNineCategoryItem("3", "Cupons", "🎟️", Color(0xFFFFF8E1)),
        WgcNineNineCategoryItem("4", "Mercado", "🛒", Color(0xFFE8F5E9)),
        WgcNineNineCategoryItem("5", "Bebidas", "🥤", Color(0xFFF3E5F5))
    ),
    val restaurants: List<NineNineRestaurant> = listOf(
        NineNineRestaurant("1", "Pizza Hut", "4.9", "Pizzaria", "15-25 min", "Grátis", "R$ 12 OFF"),
        NineNineRestaurant("2", "Habib's", "4.6", "Esfiha", "20-30 min", "R$ 3,99", "Frete Grátis"),
        NineNineRestaurant("3", "China in Box", "4.8", "Chinesa", "25-35 min", "Grátis", "Cupom 20%")
    ),
    val hasCartItems: Boolean = true,
    val cartItemCount: Int = 3,
    val cartTotal: String = "R$ 62,50",
    val cartRestaurantName: String = "Pizza Hut"
)

abstract class BaseNineNineFoodHomeViewModel : ViewModel() {
    abstract val uiState: StateFlow<NineNineFoodHomeUiState>
    abstract fun onSearchQueryChange(query: String)
    abstract fun onAddressClick()
    abstract fun onCartClick()
}

class FakeNineNineFoodHomeViewModel : BaseNineNineFoodHomeViewModel() {
    override val uiState: StateFlow<NineNineFoodHomeUiState> = MutableStateFlow(NineNineFoodHomeUiState()).asStateFlow()
    override fun onSearchQueryChange(query: String) {}
    override fun onAddressClick() {}
    override fun onCartClick() {}
}

@Composable
fun NineNineFoodHomeScreenTemplate(viewModel: BaseNineNineFoodHomeViewModel) {
    val state by viewModel.uiState.collectAsState()
    NineNineFoodHomeScreenContent(
        state = state,
        onSearchQueryChange = { viewModel.onSearchQueryChange(it) },
        onAddressClick = { viewModel.onAddressClick() },
        onCartClick = { viewModel.onCartClick() }
    )
}

@Composable
fun NineNineFoodHomeScreenContent(
    modifier: Modifier = Modifier,
    state: NineNineFoodHomeUiState,
    onSearchQueryChange: (String) -> Unit,
    onAddressClick: () -> Unit,
    onCartClick: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (state.hasCartItems) {
                WgcNineNineStickyCartBar(
                    itemCount = state.cartItemCount,
                    totalPrice = state.cartTotal,
                    restaurantName = state.cartRestaurantName,
                    onClick = onCartClick
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF5F5F5))
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            WgcNineNineAddressHeader(
                address = state.address,
                searchQuery = state.searchQuery,
                onAddressClick = onAddressClick,
                onSearchQueryChange = onSearchQueryChange
            )

            WgcNineNineCategoryGrid(categories = state.categories)

            PaddingBox {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF0B2545))
                ) {
                    Column(
                        modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(text = "99Club • Cupons Exclusivos 🔥", color = Color.White, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                        Text(text = "Descontos de até R$ 20,00 e frete grátis ilimitado", color = Color.White.copy(alpha = 0.9f), style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }

            PaddingBox {
                Text(
                    text = "Restaurantes em Destaque na 99Food",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0B2545)
                )
            }

            Column(
                modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                state.restaurants.forEach { restaurant ->
                    WgcNineNineRestaurantCard(
                        name = restaurant.name,
                        rating = restaurant.rating,
                        category = restaurant.category,
                        deliveryTime = restaurant.deliveryTime,
                        deliveryFee = restaurant.deliveryFee,
                        discountTag = restaurant.discountTag
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
private fun NineNineFoodHomePreview() {
    MaterialTheme {
        NineNineFoodHomeScreenContent(
            state = NineNineFoodHomeUiState(),
            onSearchQueryChange = {},
            onAddressClick = {},
            onCartClick = {}
        )
    }
}
