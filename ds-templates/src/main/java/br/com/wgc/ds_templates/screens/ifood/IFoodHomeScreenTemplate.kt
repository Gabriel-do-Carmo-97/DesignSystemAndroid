package br.com.wgc.ds_templates.screens.ifood

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
import br.com.wgc.design_system.components.ifood.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class IFoodRestaurant(
    val id: String,
    val name: String,
    val rating: String,
    val category: String,
    val distance: String,
    val deliveryTime: String,
    val deliveryFee: String,
    val isSuper: Boolean = true
)

data class IFoodHomeUiState(
    val address: String = "Rua Augusta, 1000 - Consolação",
    val searchQuery: String = "",
    val categories: List<WgcIFoodCategoryItem> = listOf(
        WgcIFoodCategoryItem("1", "Restaurantes", "🍔", Color(0xFFFDE8EA)),
        WgcIFoodCategoryItem("2", "Mercado", "🛒", Color(0xFFE3F2FD)),
        WgcIFoodCategoryItem("3", "Farmácia", "💊", Color(0xFFE8F5E9)),
        WgcIFoodCategoryItem("4", "Bebidas", "🍾", Color(0xFFFFF3E0)),
        WgcIFoodCategoryItem("5", "Pet", "🐶", Color(0xFFF3E5F5))
    ),
    val restaurants: List<IFoodRestaurant> = listOf(
        IFoodRestaurant("1", "Mcdonald's", "4.8", "Lanches", "1.1 km", "20-30 min", "Grátis", true),
        IFoodRestaurant("2", "Outback Steakhouse", "4.9", "Carnes", "2.5 km", "35-45 min", "R$ 7,99", true),
        IFoodRestaurant("3", "Sushi Hiroshi", "4.7", "Japonesa", "3.0 km", "40-50 min", "Grátis", false)
    ),
    val hasCartItems: Boolean = true,
    val cartItemCount: Int = 2,
    val cartTotal: String = "R$ 54,90",
    val cartRestaurantName: String = "McDonald's"
)

abstract class BaseIFoodHomeViewModel : ViewModel() {
    abstract val uiState: StateFlow<IFoodHomeUiState>
    abstract fun onSearchQueryChange(query: String)
    abstract fun onAddressClick()
    abstract fun onCartClick()
}

class FakeIFoodHomeViewModel : BaseIFoodHomeViewModel() {
    override val uiState: StateFlow<IFoodHomeUiState> = MutableStateFlow(IFoodHomeUiState()).asStateFlow()
    override fun onSearchQueryChange(query: String) {}
    override fun onAddressClick() {}
    override fun onCartClick() {}
}

@Composable
fun IFoodHomeScreenTemplate(viewModel: BaseIFoodHomeViewModel) {
    val state by viewModel.uiState.collectAsState()
    IFoodHomeScreenContent(
        state = state,
        onSearchQueryChange = { viewModel.onSearchQueryChange(it) },
        onAddressClick = { viewModel.onAddressClick() },
        onCartClick = { viewModel.onCartClick() }
    )
}

@Composable
fun IFoodHomeScreenContent(
    modifier: Modifier = Modifier,
    state: IFoodHomeUiState,
    onSearchQueryChange: (String) -> Unit,
    onAddressClick: () -> Unit,
    onCartClick: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (state.hasCartItems) {
                WgcIFoodStickyCartBar(
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
                .background(Color(0xFFF7F7F7))
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            Surface(color = MaterialTheme.colorScheme.surface) {
                WgcIFoodAddressHeader(
                    address = state.address,
                    searchQuery = state.searchQuery,
                    onAddressClick = onAddressClick,
                    onSearchQueryChange = onSearchQueryChange
                )
            }

            WgcIFoodCategoryGrid(categories = state.categories)

            PaddingBox {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFEA1D2C))
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
                    WgcIFoodRestaurantCard(
                        name = restaurant.name,
                        rating = restaurant.rating,
                        category = restaurant.category,
                        distance = restaurant.distance,
                        deliveryTime = restaurant.deliveryTime,
                        deliveryFee = restaurant.deliveryFee,
                        isSuperRestaurant = restaurant.isSuper
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
private fun IFoodHomePreview() {
    MaterialTheme {
        IFoodHomeScreenContent(
            state = IFoodHomeUiState(),
            onSearchQueryChange = {},
            onAddressClick = {},
            onCartClick = {}
        )
    }
}
