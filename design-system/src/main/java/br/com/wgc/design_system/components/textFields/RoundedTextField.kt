package br.com.wgc.design_system.components.textFields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RoundedTextField(
    modifier: Modifier = Modifier
){
    var rememberTExt by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = rememberTExt,
        onValueChange = { newValue ->
            rememberTExt = newValue
        },
        modifier = modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(100),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search"
            )
        },
        label = {
            Text(text = "Pesquisar")
        },
        placeholder = {
            Text(text = "O que você procura?")
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun RoundedTextFieldPreview() = RoundedTextField()


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RoundedTextFieldPreview2() = RoundedTextField()
