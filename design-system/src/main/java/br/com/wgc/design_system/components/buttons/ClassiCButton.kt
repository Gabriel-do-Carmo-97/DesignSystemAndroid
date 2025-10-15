package br.com.wgc.design_system.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ClassiCButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    isEnabled: Boolean = true,
    textButton: String = "Button"
) {
    ElevatedButton(
        modifier = modifier.fillMaxWidth(),
        onClick = { onClick() },
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
            disabledContentColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
        ),
        enabled = isEnabled,
        shape = RoundedCornerShape(10),
        content = {
            Text(text = textButton)
        },
    )
}

@Preview(showBackground = true , name = "Only Component")
@Composable
private fun ButtonClassicPreview() = ClassiCButton(
    isEnabled = false
)


@Preview(showBackground = true, showSystemUi = true, name = "Component and SystemUi")
@Composable
private fun ButtonClassicPreview2() = ClassiCButton()