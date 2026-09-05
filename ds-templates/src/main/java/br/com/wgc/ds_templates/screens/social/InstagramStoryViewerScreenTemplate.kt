package br.com.wgc.ds_templates.screens.social

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.avatar.WgcAvatar
import br.com.wgc.design_system.components.buttons.WgcIconButton
import br.com.wgc.design_system.components.fields.SimpleTextField
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class InstagramStoryViewerUiState(
    val userName: String = "maria.silva",
    val timeAgo: String = "2 h",
    val segmentCount: Int = 3,
    val activeSegmentIndex: Int = 0,
    val mediaUrl: String? = null,
    val isLiked: Boolean = false,
    val replyText: String = ""
)

abstract class BaseInstagramStoryViewerViewModel : ViewModel() {
    abstract val uiState: StateFlow<InstagramStoryViewerUiState>
    abstract fun onToggleLike()
    abstract fun onReplyChange(text: String)
    abstract fun onCloseClick()
}

class FakeInstagramStoryViewerViewModel : BaseInstagramStoryViewerViewModel() {
    override val uiState: StateFlow<InstagramStoryViewerUiState> = MutableStateFlow(InstagramStoryViewerUiState()).asStateFlow()
    override fun onToggleLike() {}
    override fun onReplyChange(text: String) {}
    override fun onCloseClick() {}
}

@Composable
fun InstagramStoryViewerScreenTemplate(viewModel: BaseInstagramStoryViewerViewModel) {
    val state by viewModel.uiState.collectAsState()
    InstagramStoryViewerScreenContent(
        state = state,
        onToggleLike = { viewModel.onToggleLike() },
        onReplyChange = { viewModel.onReplyChange(it) },
        onCloseClick = { viewModel.onCloseClick() }
    )
}

@Composable
fun InstagramStoryViewerScreenContent(
    modifier: Modifier = Modifier,
    state: InstagramStoryViewerUiState,
    onToggleLike: () -> Unit,
    onReplyChange: (String) -> Unit,
    onCloseClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Conteúdo Mídia do Story",
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
                .align(Alignment.TopCenter)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = WgcCoreDsSpacing.xs8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                repeat(state.segmentCount) { index ->
                    LinearProgressIndicator(
                        progress = { if (index <= state.activeSegmentIndex) 1f else 0f },
                        modifier = Modifier
                            .weight(1f)
                            .height(2.dp),
                        color = Color.White,
                        trackColor = Color.White.copy(alpha = 0.4f),
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    WgcAvatar(initials = state.userName.take(2), size = 32.dp)
                    Text(text = state.userName, color = Color.White, fontWeight = FontWeight.Bold)
                    Text(text = state.timeAgo, color = Color.White.copy(alpha = 0.7f), style = MaterialTheme.typography.labelMedium)
                }

                WgcIconButton(
                    onClick = onCloseClick,
                    icon = Icons.Default.Close,
                    contentDescription = "Fechar Story"
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md16.dp)
                .align(Alignment.BottomCenter),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            SimpleTextField(
                value = state.replyText,
                onValueChange = onReplyChange,
                label = "Enviar mensagem",
                modifier = Modifier.weight(1f)
            )

            WgcIconButton(
                onClick = onToggleLike,
                icon = if (state.isLiked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = "Curtir Story"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InstagramStoryViewerPreview() {
    MaterialTheme {
        InstagramStoryViewerScreenContent(
            state = InstagramStoryViewerUiState(),
            onToggleLike = {},
            onReplyChange = {},
            onCloseClick = {}
        )
    }
}
