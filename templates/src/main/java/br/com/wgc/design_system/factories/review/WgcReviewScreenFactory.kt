package br.com.wgc.design_system.factories.review

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.factories.verticals.boutique.templates.reviews.WgcLazaReviewsTemplate
import br.com.wgc.design_system.factories.review.templates.FakeFeedbackReviewViewModel
import br.com.wgc.design_system.factories.review.templates.WgcFeedbackReviewTemplate
import br.com.wgc.design_system.theme.WgcTheme

/**
 * Fábrica Universal de Telas de Avaliação e Feedback (WgcReviewScreenFactory).
 */
@Composable
fun WgcReviewScreenFactory(
    modifier: Modifier = Modifier,
    variant: WgcReviewVariant = WgcReviewVariant.STANDARD,
    onBackClick: () -> Unit = {}
) {
    when (variant) {
        WgcReviewVariant.BOUTIQUE -> WgcLazaReviewsTemplate(
            modifier = modifier,
            onBackClick = onBackClick
        )
        WgcReviewVariant.STANDARD -> WgcFeedbackReviewTemplate(
            modifier = modifier,
            viewModel = FakeFeedbackReviewViewModel(),
            onBackClick = onBackClick
        )
    }
}

@Preview(name = "WgcReviewScreenFactory - Preview", showBackground = true)
@Composable
private fun WgcReviewScreenFactoryPreview() {
    WgcTheme {
        WgcReviewScreenFactory()
    }
}
