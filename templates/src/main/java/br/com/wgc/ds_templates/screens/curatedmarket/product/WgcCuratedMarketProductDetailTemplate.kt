package br.com.wgc.ds_templates.screens.curatedmarket.product

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault
import br.com.wgc.ds_templates.screens.curatedmarket.model.CuratedMarketMockData
import br.com.wgc.ds_templates.screens.curatedmarket.model.TasselProduct

/**
 * Tela de detalhes de produto oficial do ecossistema Tassel (WgcTasselProductDetailTemplate).
 * Apresenta galeria superior expansiva de fotos, selo da marca, pílulas de seleção de cor e tamanho,
 * seções de detalhes e sustentabilidade, além do botão de rodapé fixo "Add to Bag".
 */
@Composable
fun WgcTasselProductDetailTemplate(
    modifier: Modifier = Modifier,
    product: TasselProduct = CuratedMarketMockData.products[0],
    selectedColor: String = "Blue",
    selectedSize: String = "28 - S",
    onBackClick: () -> Unit = {},
    onBookmarkToggle: () -> Unit = {},
    onColorSelect: (String) -> Unit = {},
    onSizeSelect: (String) -> Unit = {},
    onAddToBagClick: () -> Unit = {},
    customGallerySlot: (@Composable () -> Unit)? = null,
    customSelectorsSlot: (@Composable () -> Unit)? = null,
    customBottomBarSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        bottomBar = {
            if (customBottomBarSlot != null) {
                customBottomBarSlot()
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(WgcCoreDsSpacing.lg24.dp)
                ) {
                    Button(
                        onClick = onAddToBagClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(WgcCoreDsSize.s52.dp),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(WgcCoreDsColors.curatedMarketPrimary),
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Add to Bag",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = WgcCoreDsSpacing.lg24.dp,
                        vertical = WgcCoreDsSpacing.md16.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .size(WgcCoreDsSize.s40.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.curatedMarketSurface))
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.curatedMarketDark),
                        modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                    )
                }

                Row(horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
                    IconButton(
                        onClick = onBookmarkToggle,
                        modifier = Modifier
                            .size(WgcCoreDsSize.s40.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.curatedMarketSurface))
                    ) {
                        Icon(
                            imageVector = if (product.isBookmarked) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                            contentDescription = "Salvar",
                            tint = if (product.isBookmarked) Color(WgcCoreDsColors.curatedMarketPrimary) else Color(WgcCoreDsColors.curatedMarketDark),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                    }

                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .size(WgcCoreDsSize.s40.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.curatedMarketSurface))
                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Mais opções",
                            tint = Color(WgcCoreDsColors.curatedMarketDark),
                            modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                        )
                    }
                }
            }

            // Galeria de Fotos do Produto
            if (customGallerySlot != null) {
                customGallerySlot()
            } else {
                val gallery = if (product.galleryImages.isNotEmpty()) product.galleryImages else listOfNotNull(product.imageUrl)
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.lg24.dp),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    items(gallery) { imgUrl ->
                        Box(
                            modifier = Modifier
                                .width(WgcCoreDsSize.s240.dp)
                                .height(WgcCoreDsSize.s300.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
                                .background(Color(WgcCoreDsColors.curatedMarketSurface))
                        ) {
                            AsyncImageDefault(
                                image = imgUrl,
                                contentDescription = product.title,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Informações Principais
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = product.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.curatedMarketDark)
                    )

                    // Selo da Marca
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                            .background(Color(WgcCoreDsColors.curatedMarketSurface))
                            .padding(
                                horizontal = WgcCoreDsSpacing.sm12.dp,
                                vertical = WgcCoreDsSpacing.xxs4.dp
                            )
                    ) {
                        Text(
                            text = product.brand,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.curatedMarketDark)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Text(
                    text = product.price,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.curatedMarketDark)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Seletor de Opções (Pílulas de Cor e Tamanho)
            if (customSelectorsSlot != null) {
                customSelectorsSlot()
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    // Pílula de Cor
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .height(WgcCoreDsSize.s48.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                            .background(Color(WgcCoreDsColors.curatedMarketSurface))
                            .clickable { onColorSelect(selectedColor) }
                            .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s12.dp)
                                .clip(CircleShape)
                                .background(Color(WgcCoreDsColors.curatedMarketDenimBlue))
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                        Text(
                            text = selectedColor,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(WgcCoreDsColors.curatedMarketDark)
                        )
                    }

                    // Pílula de Tamanho
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .height(WgcCoreDsSize.s48.dp)
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                            .background(Color(WgcCoreDsColors.curatedMarketSurface))
                            .clickable { onSizeSelect(selectedSize) }
                            .padding(horizontal = WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Size: $selectedSize",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(WgcCoreDsColors.curatedMarketDark)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Detalhes
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
            ) {
                Text(
                    text = "Details",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.curatedMarketDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Text(
                    text = product.details,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(WgcCoreDsColors.curatedMarketSecondaryText)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                Text(
                    text = "Description",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.curatedMarketDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                Text(
                    text = product.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(WgcCoreDsColors.curatedMarketSecondaryText)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcTasselProductDetailTemplatePreview() {
    WgcTasselProductDetailTemplate()
}
