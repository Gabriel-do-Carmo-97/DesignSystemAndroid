@file:Suppress("MatchingDeclarationName")

package br.com.wgc.design_system.templates.factories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.wgc.design_system.factories.verticals.boutique.templates.reviews.WgcLazaReviewsTemplate
import br.com.wgc.design_system.factories.review.templates.BaseFeedbackReviewViewModel
import br.com.wgc.design_system.factories.review.templates.FakeFeedbackReviewViewModel
import br.com.wgc.design_system.factories.review.templates.WgcFeedbackReviewTemplate

/**
 * Variantes de Avaliação suportadas pela [WgcReviewFactory].
 */
enum class WgcReviewType {
    STANDARD,
    BOUTIQUE
}

/**
 * Fábrica Universal de Telas de Avaliação e Depoimentos (WgcReviewFactory).
 */
@Composable
fun WgcReviewFactory(
    modifier: Modifier = Modifier,
    type: WgcReviewType = WgcReviewType.STANDARD,
    viewModel: BaseFeedbackReviewViewModel = FakeFeedbackReviewViewModel(),
    headerSlot: (@Composable () -> Unit)? = null,
    targetInfoSlot: (@Composable () -> Unit)? = null,
    ratingBarSlot: (@Composable () -> Unit)? = null,
    tagsSlot: (@Composable () -> Unit)? = null,
    commentInputSlot: (@Composable () -> Unit)? = null,
    mediaUploadSlot: (@Composable () -> Unit)? = null,
    submitButtonSlot: (@Composable () -> Unit)? = null,
    onBackClick: () -> Unit = {}
) {
    val hasCustomSlots = headerSlot != null || targetInfoSlot != null ||
        ratingBarSlot != null || tagsSlot != null || commentInputSlot != null ||
        mediaUploadSlot != null || submitButtonSlot != null

    if (!hasCustomSlots && type == WgcReviewType.BOUTIQUE) {
        WgcLazaReviewsTemplate(
            modifier = modifier,
            onBackClick = onBackClick
        )
        return
    }

    WgcFeedbackReviewTemplate(
        modifier = modifier,
        viewModel = viewModel,
        headerSlot = headerSlot,
        targetInfoSlot = targetInfoSlot,
        ratingBarSlot = ratingBarSlot,
        tagsSlot = tagsSlot,
        commentInputSlot = commentInputSlot,
        mediaUploadSlot = mediaUploadSlot,
        submitButtonSlot = submitButtonSlot,
        onBackClick = onBackClick
    )
}
