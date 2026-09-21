package br.com.wgc.design_system.templates.screens.review

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcFeedbackReviewTemplateTest {

    @Test
    fun `initial state has correct default values`() {
        val state = WgcFeedbackReviewUiState()
        assertEquals(5, state.rating)
        assertEquals(5, state.quickTags.size)
        assertEquals(2, state.selectedTags.size)
        assertTrue(state.wouldRecommend)
        assertFalse(state.isAnonymous)
        assertFalse(state.isSubmittedSuccess)
    }

    @Test
    fun `rating change coerces between 1 and 5`() {
        val viewModel = FakeFeedbackReviewViewModel()
        viewModel.onRatingChange(3)
        assertEquals(3, viewModel.uiState.value.rating)

        viewModel.onRatingChange(0)
        assertEquals(1, viewModel.uiState.value.rating)

        viewModel.onRatingChange(10)
        assertEquals(5, viewModel.uiState.value.rating)
    }

    @Test
    fun `tag toggle adds and removes tags`() {
        val viewModel = FakeFeedbackReviewViewModel()
        val tag = "Bom Custo-Benefício"
        assertFalse(viewModel.uiState.value.selectedTags.contains(tag))

        viewModel.onTagToggle(tag)
        assertTrue(viewModel.uiState.value.selectedTags.contains(tag))

        viewModel.onTagToggle(tag)
        assertFalse(viewModel.uiState.value.selectedTags.contains(tag))
    }

    @Test
    fun `comment change respects max length`() {
        val viewModel = FakeFeedbackReviewViewModel()
        viewModel.onCommentChange("Excelente experiência de compra!")
        assertEquals("Excelente experiência de compra!", viewModel.uiState.value.comment)
    }

    @Test
    fun `submit review sets submitted success flag`() {
        val viewModel = FakeFeedbackReviewViewModel()
        assertFalse(viewModel.uiState.value.isSubmittedSuccess)

        viewModel.onSubmitReview()
        assertTrue(viewModel.uiState.value.isSubmittedSuccess)
    }
}
