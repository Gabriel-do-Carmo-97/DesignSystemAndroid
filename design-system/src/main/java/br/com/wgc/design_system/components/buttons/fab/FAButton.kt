package br.com.wgc.design_system.components.buttons.fab

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Sensors
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FAButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    fabType: FABType = FABType.MEDIUM,
    shape: RoundedCornerShape = CircleShape,
    description: String = "Button",
    icon: ImageVector = Icons.Default.Add,
) {
    when(fabType){
        FABType.SMALL -> SmallFloatingActionButton(
            onClick = onClick,
            modifier = modifier,
            shape = shape,
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary,
            content = { Icon(icon, description) },
        )
        FABType.MEDIUM -> FloatingActionButton(
            modifier =modifier,
            onClick = onClick,
            shape =shape,
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary,
            content = { Icon(icon, description) }

        )
        FABType.LARGE -> LargeFloatingActionButton(
            modifier = modifier,
            onClick = onClick,
            shape = shape,
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary,
            content ={ Icon(icon, description) }
        )

        FABType.DESCRIPTION -> ExtendedFloatingActionButton(
            modifier =modifier,
            onClick = onClick,
            shape =shape,
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary,
            content = {
                Icon(icon, description)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = description)
            }
        )
    }
}

@Preview(name = "FAB Small")
@Composable
private fun FAButtonSmallPreview() {
    FAButton(
        onClick = {},
        fabType = FABType.SMALL,
        icon = Icons.Default.Add,
        description = "Adicionar"
    )
}

@Preview(name = "FAB Medium")
@Composable
private fun FAButtonMediumPreview() {
    FAButton(
        onClick = {},
        fabType = FABType.MEDIUM,
        icon = Icons.Default.Search,
        description = "Pesquisar"
    )
}

@Preview(name = "FAB Large")
@Composable
private fun FAButtonLargePreview() {
    FAButton(
        onClick = {},
        fabType = FABType.LARGE,
        icon = Icons.Default.Sensors,
        description = "Sensor"
    )
}

@Preview(name = "FAB Description")
@Composable
private fun FAButtonDescriptionPreview() {
    FAButton(
        onClick = {},
        fabType = FABType.DESCRIPTION,
        icon = Icons.Default.ShoppingCart,
        description = "Carrinho"
    )
}