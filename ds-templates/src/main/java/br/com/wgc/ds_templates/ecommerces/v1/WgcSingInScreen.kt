package br.com.wgc.ds_templates.ecommerces.v1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun WgcSingInScreen() {
    // Definindo as cores baseadas no seu código Flutter
    val deepOrange = Color(0xFFFF5722)
    val amber = Color(0xFFFFC107)

    Scaffold(
        containerColor = deepOrange
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(deepOrange)
            )

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(
                            topStart = 45.dp,
                            topEnd = 45.dp
                        )
                    )
                    .background(Color.White)
            )
        }
    }
}


@Preview
@Composable
fun WgcSingInScreenPreview(){
    WgcSingInScreen()
}

@Preview(showBackground = true)
@Composable
fun WgcSingInScreenPreview2(){
    WgcSingInScreen()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WgcSingInScreenPreview3(){
    WgcSingInScreen()
}