package br.com.wgc.design_system.factories.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.cards.WgcEducationCourseCard

enum class WgcEducationScreen {
    LANGUAGE,
    TECH,
    MARKETPLACE
}

@Composable
fun WgcEducationFactory(
    modifier: Modifier = Modifier,
    screen: WgcEducationScreen = WgcEducationScreen.LANGUAGE
) {
    Scaffold(
        modifier = modifier.fillMaxSize()) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                WgcEducationCourseCard(
                    courseTitle = "InglÃªs IntermediÃ¡rio - MÃ³dulo 3",
                    instructorOrTrack = "Trilha Idiomas InglÃªs",
                    progressPercentage = 0.85f
                )
            }
            item {
                WgcEducationCourseCard(
                    courseTitle = "Kotlin AvanÃ§ado e Coroutines",
                    instructorOrTrack = "FormaÃ§Ã£o Android Developer",
                    progressPercentage = 0.40f
                )
            }
        }
    }
}
