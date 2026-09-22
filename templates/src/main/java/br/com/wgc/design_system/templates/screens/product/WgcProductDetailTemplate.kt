@file:Suppress("LongMethod", "CyclomaticComplexMethod", "TooManyFunctions", "UnusedPrivateMember")

package br.com.wgc.design_system.templates.screens.product

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import br.com.wgc.design_system.commons.WgcDevicePreviews
import br.com.wgc.design_system.components.accordion.WgcAccordion
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Estado de dados da Tela de Detalhes do Produto (PDP).
 */
data class WgcProductDetailUiState(
    val productId: String = "prod_101",
    val title: String = "Smartphone WGC Pro Max 256GB Titanium",
    val brand: String = "WGC Technology",
    val rating: Float = 4.8f,
    val reviewCount: Int = 1420,
    val originalPrice: String = "R$ 4.999,00",
    val currentPrice: String = "R$ 4.299,00",
    val installmentInfo: String = "10x de R$ 429,90 sem juros",
    val discountPercentage: String = "14% OFF",
    val badgeText: String? = "Mais Vendido",
    val images: List<String> = listOf("img_1", "img_2", "img_3", "img_4"),
    val selectedImageIndex: Int = 0,
    val colors: List<String> = listOf("Titanium Black", "Prata Estelar", "Azul Noturno"),
    val selectedColor: String = "Titanium Black",
    val sizes: List<String> = listOf("128GB", "256GB", "512GB", "1TB"),
    val selectedSize: String = "256GB",
    val description: String = "O mais potente smartphone com acabamento em titânio de grau aeroespacial, " +
        "sistema avançado de câmera tripla de 50MP e bateria para o dia todo com carregamento ultra-rápido.",
    val specifications: Map<String, String> = mapOf(
        "Tela" to "6.7\" OLED Super Retina XDR 120Hz",
        "Processador" to "WGC Octa-Core Bionic 4nm",
        "Memória RAM" to "12GB LPDDR5X",
        "Armazenamento" to "256GB UFS 4.0",
        "Bateria" to "5.000 mAh com carga de 65W",
        "Conectividade" to "5G, Wi-Fi 7, Bluetooth 5.4, NFC"
    ),
    val quantity: Int = 1,
    val isFavorite: Boolean = false,
    val isLoading: Boolean = false
)

/**
 * ViewModel base para a Tela de Detalhes do Produto.
 */
abstract class BaseProductDetailViewModel : ViewModel() {
    abstract val uiState: StateFlow<WgcProductDetailUiState>
    abstract fun onSelectImage(index: Int)
    abstract fun onSelectColor(color: String)
    abstract fun onSelectSize(size: String)
    abstract fun onQuantityChange(quantity: Int)
    abstract fun onAddToCartClick()
    abstract fun onBuyNowClick()
    abstract fun onShareClick()
    abstract fun onFavoriteClick()
}

/**
 * Fake ViewModel para Preview e Testes.
 */
class FakeProductDetailViewModel(
    initialState: WgcProductDetailUiState = WgcProductDetailUiState()
) : BaseProductDetailViewModel() {
    private val _uiState = MutableStateFlow(initialState)
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

    override fun onQuantityChange(quantity: Int) {
        if (quantity >= 1) {
            _uiState.value = _uiState.value.copy(quantity = quantity)
        }
    }

    override fun onAddToCartClick() = Unit
    override fun onBuyNowClick() = Unit
    override fun onShareClick() = Unit
    override fun onFavoriteClick() {
        _uiState.value = _uiState.value.copy(isFavorite = !_uiState.value.isFavorite)
    }
}

/**
 * Template Oficial da Tela de Detalhes do Produto (PDP) do Design System WGC.
 */
@Composable
fun WgcProductDetailTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseProductDetailViewModel = remember { FakeProductDetailViewModel() },
    headerSlot: (@Composable () -> Unit)? = null,
    gallerySlot: (@Composable () -> Unit)? = null,
    priceSlot: (@Composable () -> Unit)? = null,
    variantsSlot: (@Composable () -> Unit)? = null,
    detailsSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null,
    onBackClick: () -> Unit = {}
) {
    val state by viewModel.uiState.collectAsState()

    WgcProductDetailContent(
        modifier = modifier,
        state = state,
        headerSlot = headerSlot,
        gallerySlot = gallerySlot,
        priceSlot = priceSlot,
        variantsSlot = variantsSlot,
        detailsSlot = detailsSlot,
        bottomBarSlot = bottomBarSlot,
        onBackClick = onBackClick,
        onSelectImage = { viewModel.onSelectImage(it) },
        onSelectColor = { viewModel.onSelectColor(it) },
        onSelectSize = { viewModel.onSelectSize(it) },
        onQuantityChange = { viewModel.onQuantityChange(it) },
        onAddToCart = { viewModel.onAddToCartClick() },
        onBuyNow = { viewModel.onBuyNowClick() },
        onShare = { viewModel.onShareClick() },
        onFavorite = { viewModel.onFavoriteClick() }
    )
}

/**
 * Conteúdo visual desacoplado da PDP (Stateless).
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcProductDetailContent(
    modifier: Modifier = Modifier,
    state: WgcProductDetailUiState,
    headerSlot: (@Composable () -> Unit)? = null,
    gallerySlot: (@Composable () -> Unit)? = null,
    priceSlot: (@Composable () -> Unit)? = null,
    variantsSlot: (@Composable () -> Unit)? = null,
    detailsSlot: (@Composable () -> Unit)? = null,
    bottomBarSlot: (@Composable () -> Unit)? = null,
    onBackClick: () -> Unit = {},
    onSelectImage: (Int) -> Unit = {},
    onSelectColor: (String) -> Unit = {},
    onSelectSize: (String) -> Unit = {},
    onQuantityChange: (Int) -> Unit = {},
    onAddToCart: () -> Unit = {},
    onBuyNow: () -> Unit = {},
    onShare: () -> Unit = {},
    onFavorite: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            headerSlot?.invoke() ?: TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onFavorite) {
                        Icon(
                            imageVector = if (state.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Favoritar",
                            tint = if (state.isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
                        )
                    }
                    IconButton(onClick = onShare) {
                        Icon(imageVector = Icons.Default.Share, contentDescription = "Compartilhar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        },
        bottomBar = {
            bottomBarSlot?.invoke() ?: WgcProductDetailStickyBottomBar(
                quantity = state.quantity,
                onQuantityChange = onQuantityChange,
                onAddToCart = onAddToCart,
                onBuyNow = onBuyNow
            )
        }
    ) { padding ->
        if (state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(bottom = WgcCoreDsSpacing.xl32.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                // 1. Galeria de Imagens
                item {
                    gallerySlot?.invoke() ?: WgcProductImageGallery(
                        images = state.images,
                        selectedIndex = state.selectedImageIndex,
                        onSelectImage = onSelectImage
                    )
                }

                // 2. Preço e Título
                item {
                    priceSlot?.invoke() ?: WgcProductHeaderInfo(state = state)
                }

                // 3. Seleção de Variantes (Cores e Tamanhos)
                item {
                    variantsSlot?.invoke() ?: WgcProductVariantsSection(
                        colors = state.colors,
                        selectedColor = state.selectedColor,
                        onSelectColor = onSelectColor,
                        sizes = state.sizes,
                        selectedSize = state.selectedSize,
                        onSelectSize = onSelectSize
                    )
                }

                // 4. Detalhes, Descrição e Ficha Técnica
                item {
                    detailsSlot?.invoke() ?: WgcProductDetailsAccordion(
                        description = state.description,
                        specifications = state.specifications
                    )
                }
            }
        }
    }
}

@Composable
private fun WgcProductImageGallery(
    images: List<String>,
    selectedIndex: Int,
    onSelectImage: (Int) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(br.com.wgc.design_system.core.WgcCoreDsSize.s280.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f),
                modifier = Modifier.size(br.com.wgc.design_system.core.WgcCoreDsSize.s64.dp)
            )
        }

        // Miniaturas
        LazyRow(
            contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp),
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            itemsIndexed(images) { index, _ ->
                val isSelected = index == selectedIndex
                Box(
                    modifier = Modifier
                        .size(br.com.wgc.design_system.core.WgcCoreDsSize.s56.dp)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .border(
                            width = if (isSelected) br.com.wgc.design_system.core.WgcCoreDsSize.s2.dp else 0.dp,
                            color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp)
                        )
                        .clickable { onSelectImage(index) },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "${index + 1}",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun WgcProductHeaderInfo(state: WgcProductDetailUiState) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WgcCoreDsSpacing.md16.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
    ) {
        state.badgeText?.let { badge ->
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xs2.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxs4.dp)
            ) {
                Text(
                    text = badge,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Text(
            text = state.title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(WgcCoreDsSpacing.md16.dp)
                )
                Spacer(Modifier.width(br.com.wgc.design_system.core.WgcCoreDsSize.s4.dp))
                Text(
                    text = "${state.rating}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = "(${state.reviewCount} avaliações)",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Text(
                text = state.currentPrice,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = state.originalPrice,
                style = MaterialTheme.typography.bodyMedium,
                textDecoration = TextDecoration.LineThrough,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xs2.dp))
                    .background(MaterialTheme.colorScheme.errorContainer)
                    .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxs4.dp)
            ) {
                Text(
                    text = state.discountPercentage,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onErrorContainer,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Text(
            text = state.installmentInfo,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun WgcProductVariantsSection(
    colors: List<String>,
    selectedColor: String,
    onSelectColor: (String) -> Unit,
    sizes: List<String>,
    selectedSize: String,
    onSelectSize: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WgcCoreDsSpacing.md16.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
    ) {
        // Cores
        Text(
            text = "Cor: $selectedColor",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.SemiBold
        )
        Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
            colors.forEach { color ->
                FilterChip(
                    selected = selectedColor == color,
                    onClick = { onSelectColor(color) },
                    label = { Text(color, fontSize = 12.sp) }
                )
            }
        }

        // Tamanhos / Capacidade
        Text(
            text = "Capacidade: $selectedSize",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.SemiBold
        )
        Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
            sizes.forEach { size ->
                FilterChip(
                    selected = selectedSize == size,
                    onClick = { onSelectSize(size) },
                    label = { Text(size, fontSize = 12.sp) }
                )
            }
        }
    }
}

@Composable
private fun WgcProductDetailsAccordion(
    description: String,
    specifications: Map<String, String>
) {
    var isDescExpanded by remember { mutableStateOf(true) }
    var isSpecsExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = WgcCoreDsSpacing.md16.dp),
        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
    ) {
        WgcAccordion(
            title = "Descrição do Produto",
            isExpanded = isDescExpanded,
            onToggle = { isDescExpanded = !isDescExpanded }
        ) {
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        WgcAccordion(
            title = "Especificações Técnicas",
            isExpanded = isSpecsExpanded,
            onToggle = { isSpecsExpanded = !isSpecsExpanded }
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                specifications.forEach { (key, value) ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = key,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = value,
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
                }
            }
        }
    }
}

@Composable
private fun WgcProductDetailStickyBottomBar(
    quantity: Int,
    onQuantityChange: (Int) -> Unit,
    onAddToCart: () -> Unit,
    onBuyNow: () -> Unit
) {
    Surface(
        tonalElevation = WgcCoreDsElevation.level3.dp,
        shadowElevation = WgcCoreDsElevation.level3.dp,
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            // Seletor de Quantidade
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .border(
                        width = br.com.wgc.design_system.core.WgcCoreDsSize.s1.dp,
                        color = MaterialTheme.colorScheme.outline,
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                    )
                    .padding(horizontal = WgcCoreDsSpacing.xs8.dp, vertical = WgcCoreDsSpacing.xxs4.dp)
            ) {
                IconButton(
                    onClick = { onQuantityChange(quantity - 1) },
                    modifier = Modifier.size(WgcCoreDsSpacing.lg24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = "Diminuir",
                        modifier = Modifier.size(WgcCoreDsSpacing.md16.dp)
                    )
                }
                Spacer(Modifier.width(WgcCoreDsSpacing.xs8.dp))
                Text(
                    text = "$quantity",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.width(WgcCoreDsSpacing.xs8.dp))
                IconButton(
                    onClick = { onQuantityChange(quantity + 1) },
                    modifier = Modifier.size(WgcCoreDsSpacing.lg24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Aumentar",
                        modifier = Modifier.size(WgcCoreDsSpacing.md16.dp)
                    )
                }
            }

            // Ações de Compra
            OutlinedButton(
                onClick = onAddToCart,
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
            ) {
                Text("Carrinho", maxLines = 1)
            }

            WgcClassicButton(
                textButton = "Comprar",
                onClick = onBuyNow,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@WgcDevicePreviews
@Composable
private fun WgcProductDetailTemplatePreview() {
    MaterialTheme {
        WgcProductDetailContent(
            state = WgcProductDetailUiState()
        )
    }
}
