package br.com.wgc.design_system.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ClassicButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    isEnabled: Boolean = true,
    textButton: String = "Button"
) {
    ElevatedButton(
        modifier = modifier.fillMaxWidth().heightIn(56.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
            disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
        ),
        enabled = isEnabled,
        shape = RoundedCornerShape(10),
        content = {
            Text(text = textButton, fontSize = 14.sp)
        },
    )
}

@Preview(showBackground = true , name = "Only Component")
@Composable
private fun ButtonClassicPreview() = ClassicButton(
    isEnabled = false
)


@Preview(showBackground = true, showSystemUi = true, name = "Component and SystemUi")
@Composable
private fun ButtonClassicPreview2() = ClassicButton()