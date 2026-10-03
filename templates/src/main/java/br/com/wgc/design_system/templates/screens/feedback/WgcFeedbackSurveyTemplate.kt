@file:Suppress("LongMethod", "MagicNumber", "MatchingDeclarationName")

package br.com.wgc.design_system.templates.screens.feedback

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.components.rating.WgcRating
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Estado da pesquisa de satisfação (NPS / CSAT).
 */
data class WgcFeedbackSurveyUiState(
    val title: String = "Como foi a sua experiência?",
    val subtitle: String = "Sua opinião é fundamental para aprimorarmos nossos serviços.",
    val rating: Int = 5,
    val comments: String = "",
    val isSubmitted: Boolean = false
)

/**
 * Template corporativo para pesquisa de satisfação do usuário.
 */
@Composable
fun WgcFeedbackSurveyTemplate(
    uiState: WgcFeedbackSurveyUiState,
    onRatingChange: (Int) -> Unit,
    onCommentsChange: (String) -> Unit,
    onSubmit: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(WgcCoreDsSpacing.xl.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
            ) {
                Text(
                    text = uiState.title,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = uiState.subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )

                WgcRating(
                    rating = uiState.rating,
                    onRatingChange = onRatingChange,
                    modifier = Modifier.padding(vertical = WgcCoreDsSpacing.md.dp)
                )

                OutlinedTextField(
                    value = uiState.comments,
                    onValueChange = onCommentsChange,
                    label = { Text(text = "Conte-nos mais (opcional)") },
                    minLines = 3,
                    maxLines = 5,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            WgcClassicButton(
                text = "Enviar Avaliação",
                onClick = onSubmit,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
