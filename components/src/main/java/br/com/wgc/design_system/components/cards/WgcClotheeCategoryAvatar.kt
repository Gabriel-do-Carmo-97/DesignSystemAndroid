package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault

/**
 * Avatar circular de categoria do ecossistema Clothee (WgcClotheeCategoryAvatar).
 * Apresenta thumbnail circular com fundo cinza suave e rótulo descritivo abaixo.
 */
@Composable
fun WgcClotheeCategoryAvatar(
    modifier: Modifier = Modifier,
    name: String,
    imageUrl: String? = null,
    isSelected: Boolean = false,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .width(68.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(
                    if (isSelected) Color(WgcCoreDsColors.clotheePrimaryLight)
                    else Color(WgcCoreDsColors.clotheeSurface)
                ),
            contentAlignment = Alignment.Center
        ) {
            if (!imageUrl.isNullOrEmpty()) {
                AsyncImageDefault(
                    image = imageUrl,
                    contentDescription = name,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Text(
                    text = name.take(2).uppercase(),
                    style = MaterialTheme.typography.titleMedium,
                    color = if (isSelected) Color(WgcCoreDsColors.clotheePrimary) else Color(WgcCoreDsColors.clotheeDark),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

        Text(
            text = name,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) Color(WgcCoreDsColors.clotheePrimary) else Color(WgcCoreDsColors.clotheeDark),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcClotheeCategoryAvatarPreview() {
    WgcClotheeCategoryAvatar(
        name = "Hoodies",
        isSelected = true
    )
}
