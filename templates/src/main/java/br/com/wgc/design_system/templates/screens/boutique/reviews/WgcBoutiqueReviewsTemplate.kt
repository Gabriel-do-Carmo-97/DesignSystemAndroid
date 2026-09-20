package br.com.wgc.design_system.templates.screens.boutique.reviews

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Star
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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault
import br.com.wgc.design_system.templates.screens.boutique.model.BoutiqueMockData
import br.com.wgc.design_system.templates.screens.boutique.model.LazaReview

/**
 * Tela de avaliações oficial do Laza (WgcLazaReviewsTemplate).
 * Apresenta Top Bar com título centralizado, cabeçalho de nota consolidada com estrelas,
 * botão "Add Review" e lista com os depoimentos completos dos clientes.
 */
@Composable
fun WgcLazaReviewsTemplate(
    modifier: Modifier = Modifier,
    reviews: List<LazaReview> = BoutiqueMockData.reviews,
    totalReviewsCount: Int = 245,
    averageRating: Float = 4.8f,
    onBackClick: () -> Unit = {},
    onAddReviewClick: () -> Unit = {},
    customRatingHeaderSlot: (@Composable () -> Unit)? = null,
    customReviewItemSlot: (@Composable (LazaReview) -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Top Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = WgcCoreDsSpacing.lg24.dp,
                        vertical = WgcCoreDsSpacing.md16.dp
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .size(WgcCoreDsSize.s44.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.boutiqueSurface))
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.boutiqueDark),
                        modifier = Modifier.size(WgcCoreDsSize.s22.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Reviews",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.boutiqueDark)
                )

                Spacer(modifier = Modifier.weight(1f))

                // Spacer balanceador do botão voltar
                Spacer(modifier = Modifier.size(WgcCoreDsSize.s44.dp))
            }

            // Cabeçalho de Nota Consolidada
            if (customRatingHeaderSlot != null) {
                customRatingHeaderSlot()
            } else {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "$totalReviewsCount Reviews",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.boutiqueDark)
                        )

                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = averageRating.toString(),
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.boutiqueDark)
                            )
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                            repeat(5) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.boutiqueGold),
                                    modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                                )
                            }
                        }
                    }

                    // Botão "Add Review" em destaque
                    Button(
                        onClick = onAddReviewClick,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(WgcCoreDsColors.boutiqueGold),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        modifier = Modifier.height(WgcCoreDsSize.s40.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = null,
                            modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                        )
                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                        Text(
                            text = "Add Review",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Lista de Reviews
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.lg24.dp),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
            ) {
                items(reviews, key = { it.id }) { review ->
                    if (customReviewItemSlot != null) {
                        customReviewItemSlot(review)
                    } else {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                .background(Color(WgcCoreDsColors.boutiqueSurface))
                                .padding(WgcCoreDsSpacing.md16.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .size(WgcCoreDsSize.s40.dp)
                                            .clip(CircleShape)
                                            .background(Color.White),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (!review.avatarUrl.isNullOrEmpty()) {
                                            AsyncImageDefault(
                                                image = review.avatarUrl,
                                                contentDescription = review.authorName,
                                                modifier = Modifier.fillMaxSize()
                                            )
                                        } else {
                                            Text(
                                                text = review.authorName.take(1),
                                                fontWeight = FontWeight.Bold,
                                                color = Color(WgcCoreDsColors.boutiquePrimary)
                                            )
                                        }
                                    }

                                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                                    Column {
                                        Text(
                                            text = review.authorName,
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(WgcCoreDsColors.boutiqueDark)
                                        )
                                        Text(
                                            text = review.date,
                                            style = MaterialTheme.typography.labelSmall,
                                            color = Color(WgcCoreDsColors.boutiqueSecondaryText)
                                        )
                                    }
                                }

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "${review.rating}",
                                        style = MaterialTheme.typography.bodySmall,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(WgcCoreDsColors.boutiqueDark)
                                    )
                                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "Estrela",
                                        tint = Color(WgcCoreDsColors.boutiqueGold),
                                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                            Text(
                                text = review.comment,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.boutiqueSecondaryText)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcLazaReviewsTemplatePreview() {
    WgcLazaReviewsTemplate()
}
