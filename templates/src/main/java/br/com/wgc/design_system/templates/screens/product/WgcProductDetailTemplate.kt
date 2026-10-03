@file:Suppress("LongParameterList")

package br.com.wgc.design_system.templates.screens.product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class WgcProductDetailUiState(
    val productId: String = "prod_101",
    val title: String = "Tênis WGC Runner Pro 2.0",
    val price: String = "R$ 499,90",
    val installments: String = "em até 10x de R$ 49,99 sem juros",
    val description: String = "Desenvolvido com tecnologia de amortecimento responsivo e tecido respirável de alta durabilidade.",
    val rating: Float = 4.8f,
    val quantity: Int = 1,
    val isFavorite: Boolean = false,
    val selectedColor: String = "Titanium Black",
    val selectedSize: String = "256GB",
    val images: List<String> = listOf("img1", "img2", "img3", "img4"),
    val selectedImageIndex: Int = 0,
    val availableSizes: List<String> = listOf("128GB", "256GB", "512GB")
)

abstract class BaseProductDetailViewModel : ViewModel() {
    abstract val uiState: StateFlow<WgcProductDetailUiState>
    abstract fun onSelectImage(index: Int)
    abstract fun onSelectColor(color: String)
    abstract fun onSelectSize(size: String)
    abstract fun onQuantityChange(qty: Int)
    abstract fun onFavoriteClick()
    abstract fun onAddToCart()
    abstract fun onShare()
}

class FakeProductDetailViewModel : BaseProductDetailViewModel() {
    private val _uiState = MutableStateFlow(WgcProductDetailUiState())
    override val uiState: StateFlow<WgcProductDetailUiState> = _uiState.asStateFlow()

    override fun onSelectImage(index: Int) {
        _uiState.value = _uiState.value.copy(selectedImageIndex = index)
    }

    override fun onSelectColor(color: String) {
        _uiState.value = _uiState.value.copy(selectedColor = color)
    }

    override fun onSelectSize(size: String) {
        _uiState.value = _uiState.value.copy(selectedSize = size)
    }

    override fun onQuantityChange(qty: Int) {
        if (qty >= 1) {
            _uiState.value = _uiState.value.copy(quantity = qty)
        }
    }

    override fun onFavoriteClick() {
        _uiState.value = _uiState.value.copy(isFavorite = !_uiState.value.isFavorite)
    }

    override fun onAddToCart() {}
    override fun onShare() {}
}

/**
 * Ponto de entrada corporativo conectado ao BaseViewModel e com suporte granular a slots.
 */
@Composable
fun WgcProductDetailTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseProductDetailViewModel = FakeProductDetailViewModel(),
    headerSlot: (@Composable () -> Unit)? = null,
    gallerySlot: (@Composable () -> Unit)? = null,
    priceSlot: (@Composable () -> Unit)? = null,
    variantsSlot: (@Composable () -> Unit)? = null,
    detailsSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null,
    onBackClick: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()

    WgcProductDetailContent(
        uiState = uiState,
        modifier = modifier,
        headerSlot = headerSlot,
        gallerySlot = gallerySlot,
        priceSlot = priceSlot,
        variantsSlot = variantsSlot,
        detailsSlot = detailsSlot,
        bottomBarSlot = bottomBarSlot,
        onBack = onBackClick,
        onShare = { viewModel.onShare() },
        onFavorite = { viewModel.onFavoriteClick() },
        onSelectSize = { viewModel.onSelectSize(it) },
        onAddToCart = { viewModel.onAddToCart() }
    )
}

/**
 * Conteúdo visual desacoplado (stateless) para a tela de detalhes de produto.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcProductDetailContent(
    uiState: WgcProductDetailUiState = WgcProductDetailUiState(),
    modifier: Modifier = Modifier,
    headerSlot: (@Composable () -> Unit)? = null,
    gallerySlot: (@Composable () -> Unit)? = null,
    priceSlot: (@Composable () -> Unit)? = null,
    variantsSlot: (@Composable () -> Unit)? = null,
    detailsSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null,
    onBack: () -> Unit = {},
    onShare: () -> Unit = {},
    onFavorite: () -> Unit = {},
    onSelectSize: (String) -> Unit = {},
    onAddToCart: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (headerSlot != null) {
                headerSlot()
            } else {
                TopAppBar(
                    title = {},
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                        }
                    },
                    actions = {
                        IconButton(onClick = onShare) {
                            Icon(imageVector = Icons.Default.Share, contentDescription = "Compartilhar")
                        }
                        IconButton(onClick = onFavorite) {
                            Icon(
                                imageVector = if (uiState.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                contentDescription = "Favoritar",
                                tint = if (uiState.isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
                )
            }
        },
        bottomBar = {
            if (bottomBarSlot != null) {
                bottomBarSlot()
            } else {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shadowElevation = 8.dp,
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = "Total à vista", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.outline)
                            Text(text = uiState.price, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                        }

                        WgcClassicButton(
                            text = "Adicionar à Sacola",
                            onClick = onAddToCart,
                            modifier = Modifier.padding(start = WgcCoreDsSpacing.md16.dp)
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                if (gallerySlot != null) {
                    gallerySlot()
                } else {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(280.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Foto do Produto", color = MaterialTheme.colorScheme.outline)
                    }
                }
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(WgcCoreDsSpacing.lg24.dp),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
                ) {
                    Text(
                        text = uiState.title,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    if (priceSlot != null) {
                        priceSlot()
                    } else {
                        Column {
                            Text(
                                text = uiState.price,
                                style = MaterialTheme.typography.headlineMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = uiState.installments,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }

                    if (variantsSlot != null) {
                        variantsSlot()
                    } else {
                        Text(
                            text = "Tamanhos disponíveis",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )

                        Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm8.dp)) {
                            uiState.availableSizes.forEach { size ->
                                FilterChip(
                                    selected = size == uiState.selectedSize,
                                    onClick = { onSelectSize(size) },
                                    label = { Text(size) }
                                )
                            }
                        }
                    }

                    if (detailsSlot != null) {
                        detailsSlot()
                    } else {
                        Text(
                            text = "Descrição",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = uiState.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}
