package br.com.wgc.design_system.templates.screens.premiumgrocery.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.navigation.WgcSupermarketBottomNav
import br.com.wgc.design_system.components.navigation.WgcSupermarketNavItem
import br.com.wgc.design_system.templates.screens.premiumgrocery.model.PremiumGroceryMockData
import br.com.wgc.design_system.templates.screens.premiumgrocery.model.PdaUserProfile

@Composable
fun WgcPdaClienteMaisProfileTemplate(
    modifier: Modifier = Modifier,
    userProfile: PdaUserProfile = PremiumGroceryMockData.defaultUser,
    selectedNavItem: WgcSupermarketNavItem = WgcSupermarketNavItem.PROFILE,
    onNavItemClick: (WgcSupermarketNavItem) -> Unit = {},
    headerSlot: (@Composable () -> Unit)? = null,
    footerSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            footerSlot?.invoke() ?: WgcSupermarketBottomNav(
                selectedItem = selectedNavItem,
                onItemSelected = onNavItemClick
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            item {
                if (headerSlot != null) {
                    headerSlot()
                } else {
                    Text("Perfil Cliente Mais • VIP", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                }
            }
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                        Text(userProfile.name, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
                        Text(userProfile.tier, color = Color(WgcCoreDsColors.premiumGroceryGoldDark), fontWeight = FontWeight.SemiBold)
                        Text("CPF: ${userProfile.cpfMasked}", color = Color.Gray)
                        Text("Stillo Coins: ${userProfile.stilloCoins}", color = Color(WgcCoreDsColors.premiumGroceryGreen), fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Preview(name = "Supermarket Profile Template", showBackground = true)
@Composable
private fun WgcPdaClienteMaisProfileTemplatePreview() {
    WgcPdaClienteMaisProfileTemplate()
}
