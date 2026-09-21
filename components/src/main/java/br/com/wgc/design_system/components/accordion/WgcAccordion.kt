@file:Suppress("LongMethod")
package br.com.wgc.design_system.components.accordion

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsMotion
import br.com.wgc.design_system.core.WgcCoreDsSpacing

/**
 * Componente corporativo de Acordeão / Card Expansível com animação suave de rotação e expansão.
 *
 * @param modifier Modificador de layout
 * @param title Título principal do cabeçalho
 * @param subtitle Subtítulo opcional de apoio
 * @param isExpanded Estado de expansão controlado externamente (State Hoisting)
 * @param onToggle Callback acionado ao tocar para expandir ou recolher
 * @param leadingIcon Slot opcional para ícone ou avatar à esquerda
 * @param content Conteúdo expansível renderizado no corpo do acordeão
 */
@Composable
fun WgcAccordion(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String? = null,
    isExpanded: Boolean = false,
    onToggle: () -> Unit = {},
    leadingIcon: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit
) {
    val rotationAngle by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f,
        animationSpec = tween(
            durationMillis = WgcCoreDsMotion.durationStandard300,
            easing = androidx.compose.animation.core.FastOutSlowInEasing
        ),
        label = "AccordionChevronRotation"
    )

    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        color = MaterialTheme.colorScheme.surface,
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
        )
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = onToggle)
                    .padding(WgcCoreDsSpacing.md16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
            ) {
                leadingIcon?.invoke()

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    if (!subtitle.isNullOrBlank()) {
                        Text(
                            text = subtitle,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = if (isExpanded) "Recolher" else "Expandir",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .size(24.dp)
                        .rotate(rotationAngle)
                )
            }

            AnimatedVisibility(
                visible = isExpanded,
                enter = fadeIn(tween(WgcCoreDsMotion.durationNormal200)) +
                    expandVertically(tween(WgcCoreDsMotion.durationStandard300)),
                exit = fadeOut(tween(WgcCoreDsMotion.durationFast100)) +
                    shrinkVertically(tween(WgcCoreDsMotion.durationNormal200))
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    HorizontalDivider(
                        color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp)
                    ) {
                        content()
                    }
                }
            }
        }
    }
}

@Preview(name = "WgcAccordion - Preview", showBackground = true)
@Composable
private fun WgcAccordionPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            WgcAccordion(
                title = "Como funciona o reembolso?",
                subtitle = "Dúvidas frequentes sobre pagamentos",
                isExpanded = true
            ) {
                Text(
                    text = "O estorno é realizado automaticamente na mesma forma de pagamento " +
                        "utilizada na compra em até 48 horas úteis.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            WgcAccordion(
                title = "Quais as formas de entrega disponíveis?",
                isExpanded = false
            ) {
                Text(text = "Entrega expressa (em até 2h) ou convencional (em até 2 dias úteis).")
            }
        }
    }
}
