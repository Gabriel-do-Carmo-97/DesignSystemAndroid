package br.com.wgc.ds_templates.screens.premiumgrocery.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.navigation.WgcSupermarketBottomNav
import br.com.wgc.design_system.components.navigation.WgcSupermarketNavItem
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PdaCartItem
import br.com.wgc.ds_templates.screens.premiumgrocery.model.PremiumGroceryMockData
import java.util.Locale

@Composable
fun WgcPdaGourmetCartTemplate(
    modifier: Modifier = Modifier,
    cartItems: List<PdaCartItem> = PremiumGroceryMockData.cartItems,
    selectedNavItem: WgcSupermarketNavItem = WgcSupermarketNavItem.CART,
    onNavItemClick: (WgcSupermarketNavItem) -> Unit = {},
    onQuantityChange: (String, Int) -> Unit = { _, _ -> },
    onCheckoutClick: () -> Unit = {},
    headerSlot: (@Composable () -> Unit)? = null,
    footerSlot: (@Composable () -> Unit)? = null
) {
    var includeThermalBag by remember { mutableStateOf(true) }

    val subtotalRegular = cartItems.sumOf { it.product.originalPrice * it.quantity }
    val subtotalMais = cartItems.sumOf { it.product.clienteMaisPrice * it.quantity }
    val totalDiscount = subtotalRegular - subtotalMais
    val deliveryFee = 0.00
    val finalTotal = subtotalMais + deliveryFee

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
                .padding(innerPadding)
        ) {
            item {
                if (headerSlot != null) {
                    headerSlot()
                }
            }
            item {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    Text("Carrinho Gourmet (${cartItems.size} itens)", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                }
            }
            items(cartItems) { item ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xxs4.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp), verticalAlignment = Alignment.CenterVertically) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(item.product.title, fontWeight = FontWeight.Bold)
                            Text("R$ ${String.format(Locale.getDefault(), "%.2f", item.product.clienteMaisPrice)}", color = Color(WgcCoreDsColors.premiumGroceryGreen))
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(onClick = { onQuantityChange(item.product.id, item.quantity - 1) }) {
                                Icon(Icons.Default.Remove, contentDescription = null)
                            }
                            Text(item.quantity.toString(), fontWeight = FontWeight.Bold)
                            IconButton(onClick = { onQuantityChange(item.product.id, item.quantity + 1) }) {
                                Icon(Icons.Default.Add, contentDescription = null)
                            }
                        }
                    }
                }
            }
            item {
                Column(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    Text("Total: R$ ${String.format(Locale.getDefault(), "%.2f", finalTotal)}", fontWeight = FontWeight.Bold)
                    Button(onClick = onCheckoutClick, modifier = Modifier.fillMaxWidth().padding(top = WgcCoreDsSpacing.md16.dp)) {
                        Text("Finalizar Pedido")
                    }
                }
            }
        }
    }
}

@Preview(name = "Supermarket Cart Template", showBackground = true)
@Composable
private fun WgcPdaGourmetCartTemplatePreview() {
    WgcPdaGourmetCartTemplate()
}
