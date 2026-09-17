package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault

/**
 * Card horizontal para a seção "Top Products" do ecossistema Nexkart (WgcGadgetShopTopProductRow).
 * Exibe badge com a posição no ranking (1, 2, ...), miniatura quadrada do produto, título em negrito,
 * descrição explicativa e preço destacado em azul royal (#2D60FF).
 */
@Composable
fun WgcGadgetShopTopProductRow(
    modifier: Modifier = Modifier,
    rank: Int,
    title: String,
    description: String,
    price: String,
    imageUrl: String? = null,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp))
            .background(Color(WgcCoreDsColors.gadgetShopSurface))
            .clickable(onClick = onClick)
            .padding(WgcCoreDsSpacing.sm12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Badge de ranking (ex: 1, 2)
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                .background(Color(WgcCoreDsColors.gadgetShopPrimary)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = rank.toString(),
                style = MaterialTheme.typography.labelSmall,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

        // Miniatura da imagem do produto
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp))
                .background(Color.White)
        ) {
            if (!imageUrl.isNullOrEmpty()) {
                AsyncImageDefault(
                    image = imageUrl,
                    contentDescription = title,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(WgcCoreDsColors.gadgetShopPrimaryLight)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title.take(2).uppercase(),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color(WgcCoreDsColors.gadgetShopPrimary),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

        // Detalhes do Produto: Título e Descrição
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color(WgcCoreDsColors.gadgetShopDark),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = Color(WgcCoreDsColors.gadgetShopSecondaryText),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }

        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

        // Preço
        Text(
            text = price,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = Color(WgcCoreDsColors.gadgetShopPrimary)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcNexkartTopProductRowPreview() {
    WgcGadgetShopTopProductRow(
        rank = 1,
        title = "Scent Tray",
        description = "Minimalist organizer tray for bedroom and desk accessories",
        price = "USD 68.00"
    )
}
