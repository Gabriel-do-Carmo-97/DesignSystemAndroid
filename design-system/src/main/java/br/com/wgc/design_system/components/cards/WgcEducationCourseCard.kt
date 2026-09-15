package br.com.wgc.design_system.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.buttons.WgcClassicButton

@Composable
fun WgcEducationCourseCard(
    courseTitle: String,
    instructorOrTrack: String,
    progressPercentage: Float,
    modifier: Modifier = Modifier,
    onContinueClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.xs2.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(WgcCoreDsSpacing.md16.dp)) {
            Text(
                text = instructorOrTrack,
                fontSize = 14.sp.sp,
                color = Color(WgcCoreDsColors.aluraBlue),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = courseTitle,
                fontSize = 14.sp.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            LinearProgressIndicator(
                progress = { progressPercentage },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.s6.dp)
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)),
                color = Color(WgcCoreDsColors.duolingoGreen),
                trackColor = Color.LightGray
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm12.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "${(progressPercentage * 100).toInt()}% Concluído",
                    fontSize = 14.sp.sp,
                    color = Color.Gray,
                    modifier = Modifier.weight(1f)
                )

                WgcClassicButton(
                    text = "Continuar",
                    onClick = onContinueClick,
                    containerColor = Color(WgcCoreDsColors.duolingoGreen),
                    contentColor = Color.White
                )
            }
        }
    }
}
