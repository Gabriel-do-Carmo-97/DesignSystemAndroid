package br.com.wgc.design_system.cardPrice

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.R

@Composable
fun CardPrice(modifier: Modifier = Modifier){
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = R.drawable.baseline_add_box_24),
            contentDescription = "Produto",
            modifier = Modifier.size(90.dp).padding(end = 8.dp)
        )
        Column {
            Text(text = "Titulo!")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "R$ 70,00")
        }
    }
}