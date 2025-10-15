package br.com.wgc.design_system.components.images

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import br.com.wgc.design_system.mock.MockData
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter

@Composable
fun AsyncImageDefault(
    modifier: Modifier = Modifier,
    image: String = "",
) {
    var isLoading by remember { mutableStateOf(false) }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = image,
            contentDescription = "Imagem do produto",
            contentScale = ContentScale.Crop,
            onState = { state: AsyncImagePainter.State ->
                when(state){
                    is AsyncImagePainter.State.Empty -> TODO()
                    is AsyncImagePainter.State.Error -> TODO()
                    is AsyncImagePainter.State.Loading -> TODO()
                    is AsyncImagePainter.State.Success -> TODO()
                }
            },
        )

        if (isLoading) {
            CircularProgressIndicator()
        }
    }
}

@Preview(showBackground = true, name = "Only Component")
@Composable
private fun AsyncImageDefaultPreview() {
    AsyncImageDefault(
        image = MockData.listItemSectionCardModel[1].image
    )
}

@Preview(showSystemUi = true, showBackground = true, name = "Component and SystemUi")
@Composable
private fun AsyncImageDefaultPreview2() {
    AsyncImageDefault()
}