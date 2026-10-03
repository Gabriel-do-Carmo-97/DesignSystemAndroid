package br.com.wgc.design_system.components.placeholder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Fábrica universal de esqueletos de carregamento pré-moldados (WgcSkeletonFactory).
 */
object WgcSkeletonFactory {

    @Composable
    fun List(
        itemCount: Int = 5,
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm.dp)
        ) {
            repeat(itemCount) {
                WgcSkeletonListItem()
            }
        }
    }

    @Composable
    fun CardList(
        itemCount: Int = 3,
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(WgcCoreDsSpacing.md.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md.dp)
        ) {
            repeat(itemCount) {
                WgcSkeletonCard()
            }
        }
    }
}
