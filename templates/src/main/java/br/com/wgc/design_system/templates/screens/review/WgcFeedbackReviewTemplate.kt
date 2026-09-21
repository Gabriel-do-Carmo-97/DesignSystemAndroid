@file:Suppress("LongMethod", "CyclomaticComplexMethod", "TooManyFunctions", "UnusedPrivateMember")

package br.com.wgc.design_system.templates.screens.review

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import br.com.wgc.design_system.commons.WgcDevicePreviews
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.media.WgcMediaPicker
import br.com.wgc.design_system.components.media.WgcMediaUploadState
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

private const val MIN_STARS = 1
private const val MAX_STARS = 5

/**
 * Estado de dados da tela de Avaliação e Feedback corporativa.
 */
data class WgcFeedbackReviewUiState(
    val targetTitle: String = "Avaliação da Compra - Pedido #89210",
    val targetSubtitle: String = "Smartphone WGC Pro Max 256GB Titanium",
    val rating: Int = 5,
    val quickTags: List<String> = listOf(
        "Entrega Rápida",
        "Produto Excelente",
        "Embalagem Segura",
        "Bom Custo-Benefício",
        "Atendimento Ágil"
    ),
    val selectedTags: Set<String> = setOf("Entrega Rápida", "Produto Excelente"),
    val comment: String = "",
    val maxCommentLength: Int = 500,
    val mediaUploadState: WgcMediaUploadState = WgcMediaUploadState.Idle,
    val wouldRecommend: Boolean = true,
    val isAnonymous: Boolean = false,
    val isSubmitting: Boolean = false,
    val isSubmittedSuccess: Boolean = false
)

/**
 * ViewModel base para a Tela de Avaliação e Feedback.
 */
abstract class BaseFeedbackReviewViewModel : ViewModel() {
    abstract val uiState: StateFlow<WgcFeedbackReviewUiState>
    abstract fun onRatingChange(rating: Int)
    abstract fun onTagToggle(tag: String)
    abstract fun onCommentChange(comment: String)
    abstract fun onRecommendToggle(recommend: Boolean)
    abstract fun onAnonymousToggle(anonymous: Boolean)
    abstract fun onPickPhoto()
    abstract fun onRemovePhoto()
    abstract fun onSubmitReview()
}

/**
 * Fake ViewModel para Preview e Testes.
 */
class FakeFeedbackReviewViewModel(
    initialState: WgcFeedbackReviewUiState = WgcFeedbackReviewUiState()
) : BaseFeedbackReviewViewModel() {
    private val _uiState = MutableStateFlow(initialState)
    override val uiState: StateFlow<WgcFeedbackReviewUiState> = _uiState.asStateFlow()

    override fun onRatingChange(rating: Int) {
        _uiState.value = _uiState.value.copy(rating = rating.coerceIn(MIN_STARS, MAX_STARS))
    }

    override fun onTagToggle(tag: String) {
        val current = _uiState.value.selectedTags
        _uiState.value = _uiState.value.copy(
            selectedTags = if (current.contains(tag)) current - tag else current + tag
        )
    }

    override fun onCommentChange(comment: String) {
        if (comment.length <= _uiState.value.maxCommentLength) {
            _uiState.value = _uiState.value.copy(comment = comment)
        }
    }

    override fun onRecommendToggle(recommend: Boolean) {
        _uiState.value = _uiState.value.copy(wouldRecommend = recommend)
    }

    override fun onAnonymousToggle(anonymous: Boolean) {
        _uiState.value = _uiState.value.copy(isAnonymous = anonymous)
    }

    override fun onPickPhoto() {
        _uiState.value = _uiState.value.copy(
            mediaUploadState = WgcMediaUploadState.Success("foto_avaliacao.jpg", "2.4 MB")
        )
    }

    override fun onRemovePhoto() {
        _uiState.value = _uiState.value.copy(mediaUploadState = WgcMediaUploadState.Idle)
    }

    override fun onSubmitReview() {
        _uiState.value = _uiState.value.copy(isSubmittedSuccess = true)
    }
}

/**
 * Template Oficial da Tela de Avaliação e Feedback do Design System WGC.
 */
@Composable
fun WgcFeedbackReviewTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseFeedbackReviewViewModel = remember { FakeFeedbackReviewViewModel() },
    headerSlot: (@Composable () -> Unit)? = null,
    targetInfoSlot: (@Composable () -> Unit)? = null,
    ratingBarSlot: (@Composable () -> Unit)? = null,
    tagsSlot: (@Composable () -> Unit)? = null,
    commentInputSlot: (@Composable () -> Unit)? = null,
    mediaUploadSlot: (@Composable () -> Unit)? = null,
    submitButtonSlot: (@Composable () -> Unit)? = null,
    onBackClick: () -> Unit = {}
) {
    val state by viewModel.uiState.collectAsState()

    WgcFeedbackReviewContent(
        modifier = modifier,
        state = state,
        headerSlot = headerSlot,
        targetInfoSlot = targetInfoSlot,
        ratingBarSlot = ratingBarSlot,
        tagsSlot = tagsSlot,
        commentInputSlot = commentInputSlot,
        mediaUploadSlot = mediaUploadSlot,
        submitButtonSlot = submitButtonSlot,
        onBackClick = onBackClick,
        onRatingChange = { viewModel.onRatingChange(it) },
        onTagToggle = { viewModel.onTagToggle(it) },
        onCommentChange = { viewModel.onCommentChange(it) },
        onRecommendToggle = { viewModel.onRecommendToggle(it) },
        onAnonymousToggle = { viewModel.onAnonymousToggle(it) },
        onPickPhoto = { viewModel.onPickPhoto() },
        onRemovePhoto = { viewModel.onRemovePhoto() },
        onSubmitReview = { viewModel.onSubmitReview() }
    )
}

/**
 * Conteúdo visual desacoplado da Avaliação e Feedback (Stateless).
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun WgcFeedbackReviewContent(
    modifier: Modifier = Modifier,
    state: WgcFeedbackReviewUiState,
    headerSlot: (@Composable () -> Unit)? = null,
    targetInfoSlot: (@Composable () -> Unit)? = null,
    ratingBarSlot: (@Composable () -> Unit)? = null,
    tagsSlot: (@Composable () -> Unit)? = null,
    commentInputSlot: (@Composable () -> Unit)? = null,
    mediaUploadSlot: (@Composable () -> Unit)? = null,
    submitButtonSlot: (@Composable () -> Unit)? = null,
    onBackClick: () -> Unit = {},
    onRatingChange: (Int) -> Unit = {},
    onTagToggle: (String) -> Unit = {},
    onCommentChange: (String) -> Unit = {},
    onRecommendToggle: (Boolean) -> Unit = {},
    onAnonymousToggle: (Boolean) -> Unit = {},
    onPickPhoto: () -> Unit = {},
    onRemovePhoto: () -> Unit = {},
    onSubmitReview: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            headerSlot?.invoke() ?: TopAppBar(
                title = {
                    Text(
                        text = "Avaliação",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        }
    ) { padding ->
        if (state.isSubmittedSuccess) {
            WgcReviewSuccessState(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                onBackClick = onBackClick
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(
                    horizontal = WgcCoreDsSpacing.md16.dp,
                    vertical = WgcCoreDsSpacing.md16.dp
                ),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp)
            ) {
                // 1. Info do Alvo (Produto ou Serviço)
                item {
                    targetInfoSlot?.invoke() ?: Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {
                        Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                            Text(
                                text = state.targetTitle,
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                            Text(
                                text = state.targetSubtitle,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }

                // 2. Classificação por Estrelas
                item {
                    ratingBarSlot?.invoke() ?: Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Text(
                            text = "Como você avalia sua experiência?",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.SemiBold
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            for (star in MIN_STARS..MAX_STARS) {
                                val isSelected = star <= state.rating
                                Icon(
                                    imageVector = if (isSelected) Icons.Default.Star else Icons.Default.StarBorder,
                                    contentDescription = "$star estrelas",
                                    tint = if (isSelected) MaterialTheme.colorScheme.primary
                                    else MaterialTheme.colorScheme.outline,
                                    modifier = Modifier
                                        .size(br.com.wgc.design_system.core.WgcCoreDsSize.s40.dp)
                                        .clickable { onRatingChange(star) }
                                )
                            }
                        }
                    }
                }

                // 3. Tags Rápidas de Avaliação
                item {
                    tagsSlot?.invoke() ?: Column(
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Text(
                            text = "O que você mais gostou?",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.SemiBold
                        )
                        FlowRow(
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp),
                            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            state.quickTags.forEach { tag ->
                                val isSelected = state.selectedTags.contains(tag)
                                FilterChip(
                                    selected = isSelected,
                                    onClick = { onTagToggle(tag) },
                                    label = { Text(tag, fontSize = 12.sp) }
                                )
                            }
                        }
                    }
                }

                // 4. Campo de Comentário Detalhado
                item {
                    commentInputSlot?.invoke() ?: Column(
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                    ) {
                        Text(
                            text = "Escreva seu comentário",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.SemiBold
                        )
                        OutlinedTextField(
                            value = state.comment,
                            onValueChange = onCommentChange,
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text("Conte mais detalhes sobre o produto ou entrega...") },
                            minLines = 4,
                            maxLines = 6,
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                        )
                        Text(
                            text = "${state.comment.length}/${state.maxCommentLength}",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.align(Alignment.End)
                        )
                    }
                }

                // 5. Upload de Mídia (Fotos do Produto)
                item {
                    mediaUploadSlot?.invoke() ?: WgcMediaPicker(
                        label = "Adicionar Fotos ou Vídeo",
                        supportingText = "Envie imagens reais do produto recebido (máx. 3 fotos)",
                        state = state.mediaUploadState,
                        onPickFile = onPickPhoto,
                        onRemoveFile = onRemovePhoto
                    )
                }

                // 6. Opções Adicionais (Recomendaria / Anônimo)
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Recomendaria este produto?",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Switch(
                                    checked = state.wouldRecommend,
                                    onCheckedChange = onRecommendToggle
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Publicar como avaliação anônima",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Checkbox(
                                    checked = state.isAnonymous,
                                    onCheckedChange = onAnonymousToggle
                                )
                            }
                        }
                    }
                }

                // 7. Botão CTA de Envio
                item {
                    submitButtonSlot?.invoke() ?: WgcClassicButton(
                        textButton = "Enviar Avaliação",
                        onClick = onSubmitReview,
                        isLoading = state.isSubmitting,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
private fun WgcReviewSuccessState(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    Column(
        modifier = modifier.padding(WgcCoreDsSpacing.xl32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(br.com.wgc.design_system.core.WgcCoreDsSize.s64.dp)
        )
        Spacer(Modifier.height(WgcCoreDsSpacing.md16.dp))
        Text(
            text = "Avaliação Enviada com Sucesso!",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(WgcCoreDsSpacing.xs8.dp))
        Text(
            text = "Obrigado por ajudar outros clientes com sua opinião sincera.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(WgcCoreDsSpacing.xl32.dp))
        WgcClassicButton(
            textButton = "Voltar aos Pedidos",
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@WgcDevicePreviews
@Composable
private fun WgcFeedbackReviewTemplatePreview() {
    MaterialTheme {
        WgcFeedbackReviewContent(
            state = WgcFeedbackReviewUiState()
        )
    }
}
