package br.com.wgc.design_system.components.buttons.fab

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FAButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    fabType: FABType = FABType.MEDIUM,
    shape: RoundedCornerShape = CircleShape,
    description: String = "Button",
    content: @Composable () -> Unit
) {
    when(fabType){
        FABType.SMALL -> SmallFloatingActionButton(
            onClick = onClick,
            modifier = modifier,
            shape = shape,
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary,
            content = content,
        )
        FABType.MEDIUM -> FloatingActionButton(
            modifier =modifier,
            onClick = onClick,
            shape =shape,
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary,
            content = content

        )
        FABType.LARGE -> LargeFloatingActionButton(
            modifier = modifier,
            onClick = onClick,
            shape = shape,
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary,
            content =content
        )

        FABType.DESCRIPTION -> ExtendedFloatingActionButton(
            modifier =modifier,
            onClick = onClick,
            shape =shape,
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary,
        ) { Text(text = description) }
    }
}

@Preview(name = "FAB Small")
@Composable
private fun FAButtonSmallPreview() {
    FAButton(
        onClick = {},
        fabType = FABType.SMALL
    ) {
        Icon(Icons.Default.Add, contentDescription = "Adicionar")
    }
}

@Preview(name = "FAB Medium")
@Composable
private fun FAButtonMediumPreview() {
    FAButton(
        onClick = {}
    ) {
        Icon(Icons.Default.Add, contentDescription = "Adicionar")
    }
}

@Preview(name = "FAB Large")
@Composable
private fun FAButtonLargePreview() {
    FAButton(
        onClick = {},
        fabType = FABType.LARGE
    ) {
        Icon(Icons.Default.Add, contentDescription = "Adicionar")
    }
}

@Preview(name = "FAB Description")
@Composable
private fun FAButtonDescriptionPreview() {
    FAButton(
        onClick = {},
        fabType = FABType.DESCRIPTION,
        description = "Floating Button"
    ) {
        Icon(Icons.Default.Add, contentDescription = "Adicionar")
    }
}