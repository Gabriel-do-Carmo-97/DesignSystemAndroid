package br.com.wgc.ds_templates.screens.quickfooddelivery

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
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcMerchantListingCard
import br.com.wgc.design_system.components.navigation.WgcAddressHeaderBar
import br.com.wgc.design_system.components.navigation.WgcFloatingCartSummaryBar
import br.com.wgc.design_system.components.sections.WgcDepartmentCategoryGrid
import br.com.wgc.design_system.components.sections.WgcSquareCategoryItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class QuickFoodDeliveryRestaurantItem(
    val id: String,
    val name: String,
    val rating: String,
    val category: String,
    val deliveryTime: String,
    val deliveryFee: String,
    val discountTag: String
)

data class QuickFoodDeliveryHomeUiState(
    val address: String = "Av. Paulista, 1000 - Bela Vista",
    val searchQuery: String = "",
    val categories: List<WgcSquareCategoryItem> = listOf(
        WgcSquareCategoryItem("1", "Entrega 15m", "⚡", Color(WgcCoreDsColors.foodDeliveryDarkBlue)),
        WgcSquareCategoryItem("2", "Restaurantes", "🍕", Color(WgcCoreDsColors.quickShopCardBlue)),
        WgcSquareCategoryItem("3", "Cupons", "🎟️", Color(WgcCoreDsColors.quickShopPeachBg)),
        WgcSquareCategoryItem("4", "Mercado", "🛒", Color(WgcCoreDsColors.premiumGroceryGreenLight)),
        WgcSquareCategoryItem("5", "Bebidas", "🥤", Color(WgcCoreDsColors.quickShopCardPurple))
    ),
    val restaurants: List<QuickFoodDeliveryRestaurantItem> = listOf(
        QuickFoodDeliveryRestaurantItem("1", "Pizza Express", "4.9", "Pizzaria", "15-25 min", "Grátis", "R$ 12 OFF"),
        QuickFoodDeliveryRestaurantItem("2", "Burger House", "4.6", "Lanches", "20-30 min", "R$ 3,99", "Frete Grátis"),
        QuickFoodDeliveryRestaurantItem("3", "Wok Asian", "4.8", "Chinesa", "25-35 min", "Grátis", "Cupom 20%")
    ),
    val hasCartItems: Boolean = true,
    val cartItemCount: Int = 3,
    val cartTotal: String = "R$ 62,50",
    val cartRestaurantName: String = "Pizza Express"
)

abstract class BaseQuickFoodDeliveryHomeViewModel : ViewModel() {
    abstract val uiState: StateFlow<QuickFoodDeliveryHomeUiState>
    abstract fun onSearchQueryChange(query: String)
    abstract fun onAddressClick()
    abstract fun onCartClick()
}

class FakeQuickFoodDeliveryHomeViewModel : BaseQuickFoodDeliveryHomeViewModel() {
    override val uiState: StateFlow<QuickFoodDeliveryHomeUiState> = MutableStateFlow(QuickFoodDeliveryHomeUiState()).asStateFlow()
    override fun onSearchQueryChange(query: String) {}
    override fun onAddressClick() {}
    override fun onCartClick() {}
}

@Composable
fun WgcQuickFoodDeliveryHomeScreenTemplate(viewModel: BaseQuickFoodDeliveryHomeViewModel) {
    val state by viewModel.uiState.collectAsState()
    WgcQuickFoodDeliveryHomeScreenContent(
        state = state,
        onSearchQueryChange = { viewModel.onSearchQueryChange(it) },
        onAddressClick = { viewModel.onAddressClick() },
        onCartClick = { viewModel.onCartClick() }
    )
}

@Composable
fun WgcQuickFoodDeliveryHomeScreenContent(
    modifier: Modifier = Modifier,
    state: QuickFoodDeliveryHomeUiState,
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
                .background(Color(WgcCoreDsColors.grey100))
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            WgcAddressHeaderBar(
                address = state.address,
                searchQuery = state.searchQuery,
                onAddressClick = onAddressClick,
                onSearchQueryChange = onSearchQueryChange
            )

            WgcDepartmentCategoryGrid(categories = state.categories)

            PaddingBox {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.foodDeliveryDarkBlue))
                ) {
                    Column(
                        modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(text = "Club • Cupons Exclusivos 🔥", color = Color.White, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                        Text(text = "Descontos de até R$ 20,00 e frete grátis ilimitado", color = Color.White.copy(alpha = 0.9f), style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }

            PaddingBox {
                Text(
                    text = "Restaurantes em Destaque",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.foodDeliveryDarkBlue)
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
                        deliveryTime = restaurant.deliveryTime,
                        deliveryFee = restaurant.deliveryFee
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
private fun QuickFoodDeliveryHomePreview() {
    MaterialTheme {
        WgcQuickFoodDeliveryHomeScreenContent(
            state = QuickFoodDeliveryHomeUiState(),
            onSearchQueryChange = {},
            onAddressClick = {},
            onCartClick = {}
        )
    }
}
