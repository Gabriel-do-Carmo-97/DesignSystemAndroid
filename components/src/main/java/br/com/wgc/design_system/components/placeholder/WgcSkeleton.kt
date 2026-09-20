package br.com.wgc.design_system.components.placeholder

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.shimmerEffect
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Elemento atômico de esqueleto para estados de carregamento (WgcSkeleton).
 *
 * @param modifier Modificador de layout
 * @param shape Formato geométrico (BOX, CIRCLE, ROUNDED)
 * @param cornerRadius Raio de borda caso [shape] seja [WgcSkeletonShape.ROUNDED]
 */
@Composable
fun WgcSkeleton(
    modifier: Modifier = Modifier,
    shape: WgcSkeletonShape = WgcSkeletonShape.ROUNDED,
    cornerRadius: Dp = WgcCoreDsBorderRadius.sm.dp
) {
    val clipShape: Shape = when (shape) {
        WgcSkeletonShape.BOX -> RoundedCornerShape(0.dp)
        WgcSkeletonShape.CIRCLE -> CircleShape
        WgcSkeletonShape.ROUNDED -> RoundedCornerShape(cornerRadius)
    }

    Box(
        modifier = modifier
            .clip(clipShape)
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
            .shimmerEffect(isLoading = true)
    )
}

/**
 * Molécula pré-moldada de Skeleton para cartões de conteúdo.
 */
@Suppress("MagicNumber")
@Composable
fun WgcSkeletonCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
            WgcSkeleton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                shape = WgcSkeletonShape.ROUNDED,
                cornerRadius = WgcCoreDsBorderRadius.sm.dp
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))
            WgcSkeleton(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(20.dp)
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))
            WgcSkeleton(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .height(14.dp)
            )
        }
    }
}

/**
 * Molécula pré-moldada de Skeleton para itens de lista com avatar e textos.
 */
@Suppress("MagicNumber")
@Composable
fun WgcSkeletonListItem(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = WgcCoreDsSpacing.xs.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        WgcSkeleton(
            modifier = Modifier.size(48.dp),
            shape = WgcSkeletonShape.CIRCLE
        )
        Spacer(modifier = Modifier.size(WgcCoreDsSpacing.md.dp))
        Column(modifier = Modifier.weight(1f)) {
            WgcSkeleton(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(16.dp)
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs.dp))
            WgcSkeleton(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(12.dp)
            )
        }
    }
}

/**
 * Molécula pré-moldada de Skeleton para telas de perfil.
 */
@Suppress("MagicNumber")
@Composable
fun WgcSkeletonProfile(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(WgcCoreDsSpacing.lg.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        WgcSkeleton(
            modifier = Modifier.size(96.dp),
            shape = WgcSkeletonShape.CIRCLE
        )
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))
        WgcSkeleton(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(24.dp)
        )
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs.dp))
        WgcSkeleton(
            modifier = Modifier
                .fillMaxWidth(0.35f)
                .height(16.dp)
        )
    }
}

@Preview(name = "Skeleton Variants Preview", showBackground = true)
@Composable
private fun WgcSkeletonPreview() {
    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
        WgcSkeletonProfile()
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))
        WgcSkeletonListItem()
        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))
        WgcSkeletonCard()
    }
}
