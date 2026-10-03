@file:Suppress("LongMethod", "MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system.components.avatar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Avatar individual com iniciais ou placeholder.
 */
data class WgcAvatarData(
    val id: String,
    val name: String,
    val initials: String = name.take(2).uppercase()
)

/**
 * WgcAvatarGroup
 *
 * Pilha de avatares com sobreposição horizontal e indicador de membros excedentes (+N).
 */
@Composable
fun WgcAvatarGroup(
    avatars: List<WgcAvatarData>,
    modifier: Modifier = Modifier,
    maxVisible: Int = 4,
    avatarSize: Dp = 36.dp,
    overlapOffset: Dp = 12.dp
) {
    val visibleAvatars = avatars.take(maxVisible)
    val overflowCount = avatars.size - maxVisible

    Row(modifier = modifier) {
        visibleAvatars.forEachIndexed { index, avatar ->
            Box(
                modifier = Modifier
                    .offset(x = (-overlapOffset * index))
                    .size(avatarSize)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colorScheme.surface, CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = avatar.initials,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        if (overflowCount > 0) {
            Box(
                modifier = Modifier
                    .offset(x = (-overlapOffset * visibleAvatars.size))
                    .size(avatarSize)
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colorScheme.surface, CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+$overflowCount",
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
