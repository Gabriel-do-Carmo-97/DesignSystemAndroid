package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.theme.WgcTheme
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing

/**
 * Card de mídia rica com suporte a banner de imagem/vídeo, tags contextuais e rodapé de autor.
 */
@Suppress("LongMethod")
@Composable
fun WgcRichMediaCard(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
    tag: String? = null,
    author: String? = null,
    onClick: () -> Unit = {},
    mediaSlot: @Composable () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.MD8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Slot de Mídia (Imagem ou Vídeo)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(topStart = WgcCoreDsBorderRadius.MD8.dp, topEnd = WgcCoreDsBorderRadius.MD8.dp))
            ) {
                mediaSlot()
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(WgcCoreDsSpacing.MD16.dp)
            ) {
                if (tag != null) {
                    Text(
                        text = tag.uppercase(),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(bottom = WgcCoreDsSpacing.XXS4.dp)
                    )
                }

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = WgcCoreDsSpacing.XXS4.dp)
                )

                if (author != null) {
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.SM8.dp))
                    Text(
                        text = "Por $author",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
        }
    }
}

@Preview(name = "WgcRichMediaCard Preview", showBackground = true)
@Composable
private fun WgcRichMediaCardPreview() {
    WgcTheme {
        Box(modifier = Modifier.padding(WgcCoreDsSpacing.MD16.dp)) {
            WgcRichMediaCard(
                title = "Explorando as Novidades do Jetpack Compose no Android",
                subtitle = "Descubra como os novos recursos de UI declarativa facilitam o desenvolvimento de aplicativos modernos e responsivos.",
                tag = "Tecnologia",
                author = "WGC Engineering Team",
                onClick = {},
                mediaSlot = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Mídia / Banner",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            )
        }
    }
}
