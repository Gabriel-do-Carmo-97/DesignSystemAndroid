package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.tokens.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.theme.WgcCoreDsColors
import br.com.wgc.design_system.core.tokens.WgcCoreDsElevation
import br.com.wgc.design_system.core.tokens.WgcCoreDsSize
import br.com.wgc.design_system.core.tokens.WgcCoreDsSpacing
import br.com.wgc.design_system.theme.WgcTheme

@Composable
fun WgcEducationCourseCard(
    courseTitle: String,
    instructorOrTrack: String,
    progressPercentage: Float,
    modifier: Modifier = Modifier,
    onContinueClick: () -> Unit = {},
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.XL16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.LEVEL1.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.MD16.dp)) {
            Text(
                text = instructorOrTrack,
                fontSize = 14.sp,
                color = Color(WgcCoreDsColors.blue24),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = courseTitle,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.SM12.dp))

            LinearProgressIndicator(
                progress = { progressPercentage },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.S6.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.CIRCULAR999.dp)),
                color = Color(WgcCoreDsColors.green19),
                trackColor = Color.LightGray
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.SM12.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "${(progressPercentage * 100).toInt()}% Concluído",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.weight(1f)
                )

                WgcClassicButton(
                    textButton = "Continuar",
                    onClick = onContinueClick,
                    modifier = Modifier.width(130.dp)
                )
            }
        }
    }
}

@Preview(name = "WgcEducationCourseCard Preview", showBackground = true)
@Composable
private fun WgcEducationCourseCardPreview() {
    WgcTheme {
        Column(modifier = Modifier.padding(WgcCoreDsSpacing.MD16.dp)) {
            WgcEducationCourseCard(
                courseTitle = "Android Jetpack Compose do Zero ao Avançado",
                instructorOrTrack = "Formação Mobile Master",
                progressPercentage = 0.65f,
                onContinueClick = {}
            )
        }
    }
}

