package br.com.wgc.design_system.templates.screens.fooddelivery

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
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcMerchantListingCard
import br.com.wgc.design_system.components.navigation.WgcAddressHeaderBar
import br.com.wgc.design_system.components.navigation.WgcFloatingCartSummaryBar
import br.com.wgc.design_system.components.sections.WgcCircularCategoryItem
import br.com.wgc.design_system.components.sections.WgcCircularCategoryRow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class FoodDeliveryRestaurant(
    val id: String,
    val name: String,
    val rating: String,
    val category: String,
    val distance: String,
    val deliveryTime: String,
    val deliveryFee: String,
    val isFeatured: Boolean
)

data class FoodDeliveryHomeUiState(
    val address: String = "Rua Augusta, 1000 - Consolação",
    val searchQuery: String = "",
    val categories: List<WgcCircularCategoryItem> = listOf(
        WgcCircularCategoryItem("1", "Restaurantes", "🍔", Color(WgcCoreDsColors.carePharmacyRedLight)),
        WgcCircularCategoryItem("2", "Mercado", "🛒", Color(WgcCoreDsColors.quickShopCardBlue)),
        WgcCircularCategoryItem("3", "Farmácia", "💊", Color(WgcCoreDsColors.premiumGroceryGreenLight)),
        WgcCircularCategoryItem("4", "Bebidas", "🍾", Color(WgcCoreDsColors.quickShopCardOrange)),
        WgcCircularCategoryItem("5", "Pet", "🐶", Color(WgcCoreDsColors.quickShopCardPurple))
    ),
    val restaurants: List<FoodDeliveryRestaurant> = listOf(
        FoodDeliveryRestaurant("1", "Burger Bistro", "4.8", "Lanches", "1.1 km", "20-30 min", "Grátis", true),
        FoodDeliveryRestaurant("2", "Prime Steakhouse", "4.9", "Carnes", "2.5 km", "35-45 min", "R$ 7,99", true),
        FoodDeliveryRestaurant("3", "Sushi Master", "4.7", "Japonesa", "3.0 km", "40-50 min", "Grátis", false)
    ),
    val hasCartItems: Boolean = true,
    val cartItemCount: Int = 2,
    val cartTotal: String = "R$ 54,90",
    val cartRestaurantName: String = "Burger Bistro"
)

abstract class BaseFoodDeliveryHomeViewModel : ViewModel() {
    abstract val uiState: StateFlow<FoodDeliveryHomeUiState>
    abstract fun onSearchQueryChange(query: String)
    abstract fun onAddressClick()
    abstract fun onCartClick()
}

class FakeFoodDeliveryHomeViewModel : BaseFoodDeliveryHomeViewModel() {
    override val uiState: StateFlow<FoodDeliveryHomeUiState> = MutableStateFlow(FoodDeliveryHomeUiState()).asStateFlow()
    override fun onSearchQueryChange(query: String) {}
    override fun onAddressClick() {}
    override fun onCartClick() {}
}

@Composable
fun WgcFoodDeliveryHomeScreenTemplate(viewModel: BaseFoodDeliveryHomeViewModel) {
    val state by viewModel.uiState.collectAsState()
    WgcFoodDeliveryHomeScreenContent(
        state = state,
        onSearchQueryChange = { viewModel.onSearchQueryChange(it) },
        onAddressClick = { viewModel.onAddressClick() },
        onCartClick = { viewModel.onCartClick() }
    )
}

@Composable
fun WgcFoodDeliveryHomeScreenContent(
    modifier: Modifier = Modifier,
    state: FoodDeliveryHomeUiState,
    onSearchQueryChange: (String) -> Unit,
    onAddressClick: () -> Unit,
    onCartClick: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (state.hasCartItems) {
                WgcFloatingCartSummaryBar(
                    itemCount = state.cartItemCount,
                    totalPrice = state.cartTotal,
                    establishmentName = state.cartRestaurantName,
                    onClick = onCartClick
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(WgcCoreDsColors.foodDeliveryBgGray))
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Surface(color = MaterialTheme.colorScheme.surface) {
                WgcAddressHeaderBar(
                    address = state.address,
                    searchQuery = state.searchQuery,
                    onAddressClick = onAddressClick,
                    onSearchQueryChange = onSearchQueryChange
                )
            }

            WgcCircularCategoryRow(categories = state.categories)

            PaddingBox {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.foodDeliveryRed))
                ) {
                    Column(
                        modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(text = "Cupom de R$ 15,00 🎁", color = Color.White, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                        Text(text = "Em pedidos a partir de R$ 30,00 no seu almoço", color = Color.White.copy(alpha = 0.9f), style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }

            PaddingBox {
                Text(
                    text = "Lojas e Restaurantes",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
                modifier = Modifier.padding(horizontal = WgcCoreDsSpacing.md16.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
            ) {
                state.restaurants.forEach { restaurant ->
                    WgcMerchantListingCard(
                        name = restaurant.name,
                        rating = restaurant.rating,
                        category = restaurant.category,
                        distance = restaurant.distance,
                        deliveryTime = restaurant.deliveryTime,
                        deliveryFee = restaurant.deliveryFee,
                        isFeatured = restaurant.isFeatured
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
private fun FoodDeliveryHomePreview() {
    MaterialTheme {
        WgcFoodDeliveryHomeScreenContent(
            state = FoodDeliveryHomeUiState(),
            onSearchQueryChange = {},
            onAddressClick = {},
            onCartClick = {}
        )
    }
}
