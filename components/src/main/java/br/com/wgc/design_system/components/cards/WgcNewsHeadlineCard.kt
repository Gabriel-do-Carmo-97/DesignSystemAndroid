package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsElevation
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.theme.WgcTheme

@Composable
fun WgcNewsHeadlineCard(
    editoria: String,
    headline: String,
    publishedTime: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp)) {
            Text(
                text = editoria.uppercase(),
                fontSize = 14.sp,
                color = Color(WgcCoreDsColors.red5),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
            Text(
                text = headline,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
            Text(
                text = publishedTime,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

@Preview(name = "WgcNewsHeadlineCard Preview", showBackground = true)
@Composable
private fun WgcNewsHeadlineCardPreview() {
    WgcTheme {
        Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
            WgcNewsHeadlineCard(
                editoria = "Tecnologia",
                headline = "Jetpack Compose atinge novo marco de adoção global no ecossistema Android",
                publishedTime = "Há 15 minutos"
            )
        }
    }
}
