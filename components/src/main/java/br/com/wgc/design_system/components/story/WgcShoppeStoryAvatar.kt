package br.com.wgc.design_system.components.story

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import coil3.compose.AsyncImage

/**
 * Avatar Oficial de Story de Moda do Shoppe (WgcMegaStoreStoryAvatar).
 * Apresenta anel de gradiente azul ativo, foto circular e etiqueta de "LIVE" opcional.
 */
@Composable
fun WgcMegaStoreStoryAvatar(
    modifier: Modifier = Modifier,
    imageUrl: String = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=300",
    name: String = "Summer Sale",
    isLive: Boolean = false,
    hasUnseenStory: Boolean = true,
    onClick: () -> Unit = {}
) {
    val gradientBrush = Brush.linearGradient(
        colors = if (isLive) {
            listOf(Color(WgcCoreDsColors.red500), Color(WgcCoreDsColors.orange500))
        } else if (hasUnseenStory) {
            listOf(Color(WgcCoreDsColors.megaStorePrimary), Color(WgcCoreDsColors.megaStorePrimaryLight))
        } else {
            listOf(Color(WgcCoreDsColors.megaStoreBorder), Color(WgcCoreDsColors.megaStoreBorder))
        }
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable(onClick = onClick)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Box(
                modifier = Modifier
                    .size(68.dp)
                    .clip(CircleShape)
                    .border(2.5.dp, gradientBrush, CircleShape)
                    .padding(3.dp)
                    .clip(CircleShape)
                    .background(Color(WgcCoreDsColors.megaStoreBackground)),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(60.dp).clip(CircleShape)
                )
            }

            if (isLive) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                        .background(Color(WgcCoreDsColors.red500))
                        .padding(horizontal = WgcCoreDsSpacing.xs.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = "LIVE",
                        color = Color.White,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Black
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))

        Text(
            text = name,
            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Medium),
            color = Color(WgcCoreDsColors.megaStoreDark),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 11.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcShoppeStoryAvatarPreview() {
    MaterialTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            WgcMegaStoreStoryAvatar(isLive = true)
        }
    }
}
