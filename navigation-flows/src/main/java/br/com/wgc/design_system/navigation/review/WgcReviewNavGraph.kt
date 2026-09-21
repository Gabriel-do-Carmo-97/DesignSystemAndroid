package br.com.wgc.design_system.navigation.review

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import br.com.wgc.design_system.templates.screens.review.FakeFeedbackReviewViewModel
import br.com.wgc.design_system.templates.screens.review.WgcFeedbackReviewContent
import br.com.wgc.design_system.templates.screens.review.WgcFeedbackReviewUiState
import kotlinx.serialization.Serializable

@Serializable
object WgcReviewGraphRoute

@Serializable
data class WgcReviewFormRoute(
    val orderId: String = "89210",
    val productName: String = "Smartphone WGC Pro Max"
)

/**
 * Grafo de navegação completo para fluxos de avaliação de compras e feedback de serviços.
 *
 * @param navController Controlador de navegação.
 * @param onReviewCompleted Callback disparado após conclusão da avaliação com sucesso.
 * @param onCloseReview Callback disparado ao cancelar ou fechar o fluxo de avaliação.
 */
@Suppress("UnusedParameter")
fun NavGraphBuilder.wgcReviewNavGraph(
    navController: NavController,
    onReviewCompleted: () -> Unit = {},
    onCloseReview: () -> Unit = {}
) {
    navigation<WgcReviewGraphRoute>(startDestination = WgcReviewFormRoute()) {
        composable<WgcReviewFormRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<WgcReviewFormRoute>()
            val fakeVm = FakeFeedbackReviewViewModel(
                initialState = WgcFeedbackReviewUiState(
                    targetTitle = "Avaliação do Pedido #${route.orderId}",
                    targetSubtitle = route.productName
                )
            )

            WgcFeedbackReviewContent(
                state = fakeVm.uiState.value,
                onBackClick = onCloseReview,
                onRatingChange = fakeVm::onRatingChange,
                onTagToggle = fakeVm::onTagToggle,
                onCommentChange = fakeVm::onCommentChange,
                onRecommendToggle = fakeVm::onRecommendToggle,
                onAnonymousToggle = fakeVm::onAnonymousToggle,
                onPickPhoto = fakeVm::onPickPhoto,
                onRemovePhoto = fakeVm::onRemovePhoto,
                onSubmitReview = {
                    fakeVm.onSubmitReview()
                    onReviewCompleted()
                }
            )
        }
    }
}
