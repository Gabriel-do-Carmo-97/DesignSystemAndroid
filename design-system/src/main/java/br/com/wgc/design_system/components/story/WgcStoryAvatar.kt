package br.com.wgc.design_system.components.story

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.commons.WgcComponentPreviews
import br.com.wgc.design_system.components.avatar.WgcAvatar

enum class StoryState {
    UNSEEN, SEEN, CLOSE_FRIENDS
}

@Composable
fun WgcStoryAvatar(
    modifier: Modifier = Modifier,
    userName: String,
    imageUrl: String? = null,
    initials: String? = null,
    storyState: StoryState = StoryState.UNSEEN,
    isUserStory: Boolean = false,
    avatarSize: Dp = 64.dp,
    onClick: () -> Unit
) {
    val ringBorder = when (storyState) {
        StoryState.UNSEEN -> Brush.sweepGradient(
            listOf(
                Color(0xFF833AB4),
                Color(0xFFFD1D1D),
                Color(0xFFF77737),
                Color(0xFF833AB4)
            )
        )
        StoryState.CLOSE_FRIENDS -> Brush.horizontalGradient(
            listOf(Color(0xFF4CAF50), Color(0xFF81C784))
        )
        StoryState.SEEN -> Brush.horizontalGradient(
            listOf(Color(0xFFBDBDBD), Color(0xFFE0E0E0))
        )
    }

    val stateDesc = when (storyState) {
        StoryState.UNSEEN -> "Story não visto de $userName"
        StoryState.CLOSE_FRIENDS -> "Story de Amigos Próximos de $userName"
        StoryState.SEEN -> "Story já visto de $userName"
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .semantics(mergeDescendants = true) {
                role = Role.Button
                stateDescription = stateDesc
            }
            .clickable(onClick = onClick)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Box(
                modifier = Modifier
                    .size(avatarSize + 8.dp)
                    .clip(CircleShape)
                    .border(width = 2.5.dp, brush = ringBorder, shape = CircleShape)
                    .padding(4.dp)
            ) {
                WgcAvatar(
                    imageUrl = imageUrl,
                    initials = initials ?: userName.take(2),
                    size = avatarSize
                )
            }

            if (isUserStory) {
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(20.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, Color.White, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Surface(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Adicionar story",
                            tint = Color.White,
                            modifier = Modifier.padding(2.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))

        Text(
            text = userName,
            style = MaterialTheme.typography.labelSmall,
            maxLines = 1
        )
    }
}

data class StoryTrayItem(
    val id: String,
    val userName: String,
    val imageUrl: String? = null,
    val storyState: StoryState = StoryState.UNSEEN,
    val isUserStory: Boolean = false
)

@Composable
fun WgcStoryTray(
    modifier: Modifier = Modifier,
    stories: List<StoryTrayItem>,
    onStoryClick: (StoryTrayItem) -> Unit
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = WgcCoreDsSpacing.md16.dp),
        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
    ) {
        items(stories, key = { it.id }) { story ->
            WgcStoryAvatar(
                userName = story.userName,
                imageUrl = story.imageUrl,
                storyState = story.storyState,
                isUserStory = story.isUserStory,
                onClick = { onStoryClick(story) }
            )
        }
    }
}

@WgcComponentPreviews
@Composable
private fun WgcStoryAvatarPreview() {
    MaterialTheme {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            WgcStoryAvatar(userName = "Seu Story", isUserStory = true, onClick = {})
            WgcStoryAvatar(userName = "Maria", storyState = StoryState.UNSEEN, onClick = {})
            WgcStoryAvatar(userName = "Lucas", storyState = StoryState.CLOSE_FRIENDS, onClick = {})
            WgcStoryAvatar(userName = "Ana", storyState = StoryState.SEEN, onClick = {})
        }
    }
}
