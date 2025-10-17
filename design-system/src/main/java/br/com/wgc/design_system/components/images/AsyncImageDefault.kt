package br.com.wgc.design_system.components.images

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.commons.shimmerEffect
import br.com.wgc.design_system.components.placeholder.PlaceholderDefault
import br.com.wgc.design_system.mock.MockData
import coil3.compose.AsyncImagePainter
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent

@Composable
fun AsyncImageDefault(
    modifier: Modifier = Modifier,
    image: String? = null,
    contentDescription: String? = null,
    onLoading: (AsyncImagePainter.State.Loading) -> Unit = {},
    onSuccess: (AsyncImagePainter.State.Success) -> Unit = {},
    onError: (AsyncImagePainter.State.Error) -> Unit = {},
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = image,
        onLoading = onLoading,
        loading = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .shimmerEffect(true)
            )
        },
        onError = onError,
        error = {
            PlaceholderDefault(isError = true)
        },
        onSuccess = onSuccess,
        success = {
            SubcomposeAsyncImageContent()
        },
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
    )
}


@Preview(showBackground = true, name = "Estado de Sucesso")
@Composable
private fun AsyncImageDefaultSuccessPreview() {
    AsyncImageDefault(
        modifier = Modifier.size(128.dp),
        image = MockData.listItemSectionCardModel[1].image
    )
}

@Preview(showBackground = true, name = "Estado de Erro")
@Composable
private fun AsyncImageDefaultErrorPreview() {
    AsyncImageDefault(
        modifier = Modifier.size(128.dp),
        image = "https://invalid-url-for-error.com/image.jpg"
    )
}

@Preview(showBackground = true, name = "Estado Vazio (Empty)")
@Composable
private fun AsyncImageDefaultEmptyPreview() {
    // 3. Novo preview para testar o estado 'empty'
    AsyncImageDefault(
        modifier = Modifier.size(128.dp),
        image = null // Passando null para ativar o bloco 'empty'
    )
}