package br.com.wgc.design_system.components.shimmer

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.shimmerEffect

/**
 * Um Composable que exibe um efeito de shimmer enquanto o conteúdo está carregando.
 * Ele se adapta ao tamanho do Composable filho.
 *
 * @param modifier O modificador a ser aplicado.
 * @param isLoading Controla se o shimmer deve ser exibido.
 * @param contentAfterLoading O conteúdo opcional a ser exibido quando `isLoading` for `false`.
 *                            Se for nulo, nada será exibido dentro deste Box após o carregamento,
 *                            e o shimmer apenas desaparecerá.
 */
@Composable
fun ShimmerDefault(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    contentAfterLoading: (@Composable () -> Unit)? = null,
) {
    Box(modifier = modifier) {
        if (!isLoading && contentAfterLoading != null) {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                contentAfterLoading()
            }
        }

        AnimatedVisibility(visible = isLoading) {
            Box(
                modifier = Modifier
                    .matchParentSize() // Garante que o shimmer ocupe o mesmo espaço que o Box pai
                    .shimmerEffect(isLoading = true)
            )
        }
    }
}



@Preview(showBackground = true, name = "Shimmer em um Círculo")
@Composable
private fun ShimmerCirclePreview() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .shimmerEffect(isLoading = true)
    )
}

// Preview que mostra o comportamento com conteúdo depois do loading
@Preview(showBackground = true, name = "Com conteúdo após loading")
@Composable
private fun ShimmerWithContentPreview() {
    ShimmerDefault(
        isLoading = false, // Simula o fim do carregamento
        modifier = Modifier.size(width = 200.dp, height = 100.dp),
        contentAfterLoading = {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Text("Conteúdo Carregado!")
            }
        }
    )
}

@Preview(showBackground = true, name = "Sem conteúdo após loading (só some)")
@Composable
private fun ShimmerWithoutContentPreview() {
    Box(
        modifier = Modifier.size(width = 200.dp, height = 100.dp),
        contentAlignment = Alignment.Center
    ) {
        if (!true) {
            Text("Outro Componente")
        }

        ShimmerDefault(
            isLoading = true,
            modifier = Modifier.matchParentSize(),
            contentAfterLoading = null
        )
    }
}