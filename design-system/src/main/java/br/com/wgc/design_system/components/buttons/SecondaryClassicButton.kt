package br.com.wgc.design_system.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp

@Composable
fun SecondaryClassicButton(
   modifier: Modifier = Modifier,
   onClick: () -> Unit = {},
   color: Color = MaterialTheme.colorScheme.primary,
   textButton: String = "Button"
){
    ElevatedButton(
        modifier = modifier.fillMaxWidth(),
        onClick = { onClick()},
        shape = RoundedCornerShape(15),
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
            contentColor = MaterialTheme.colorScheme.secondary,
            disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
            disabledContentColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
        ),
        border = BorderStroke(
            width = Dp(value = 2.0f),
            color = color
        )
    ){
        Text(text = textButton)

    }
}

@Preview(showBackground = true , name = "Only Component")
@Composable
private fun SecondaryClassicButtonPreview() = SecondaryClassicButton()


@Preview(showSystemUi = true, showBackground = true , name = "Component and SystemUi")
@Composable
private fun SecondaryClassicButtonPreview2() {
    SecondaryClassicButton()
}
