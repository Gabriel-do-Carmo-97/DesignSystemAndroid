package br.com.wgc.ds_templates.screens.apparel.profile

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.core_ds.WgcCoreDsBorderRadius
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.design_system.components.images.AsyncImageDefault

/**
 * Tela de configurações e perfil do usuário do Clothee (WgcClotheeSettingsTemplate).
 * Apresenta avatar, card de perfil com ação Edit, opções de navegação e Sign Out em vermelho.
 */
@Composable
fun WgcClotheeSettingsTemplate(
    modifier: Modifier = Modifier,
    userName: String = "Gilbert Jones",
    userEmail: String = "Gilbertjones001@gmail.com",
    userPhone: String = "121-224-7890",
    avatarUrl: String? = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=200",
    onEditProfileClick: () -> Unit = {},
    onAddressClick: () -> Unit = {},
    onWishlistClick: () -> Unit = {},
    onPaymentClick: () -> Unit = {},
    onHelpClick: () -> Unit = {},
    onSupportClick: () -> Unit = {},
    onSignOutClick: () -> Unit = {},
    customHeaderSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = WgcCoreDsSpacing.lg24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            if (customHeaderSlot != null) {
                customHeaderSlot()
            } else {
                // Avatar circular
                Box(
                    modifier = Modifier
                        .size(88.dp)
                        .clip(CircleShape)
                        .background(Color(WgcCoreDsColors.apparelSurface)),
                    contentAlignment = Alignment.Center
                ) {
                    if (!avatarUrl.isNullOrEmpty()) {
                        AsyncImageDefault(
                            image = avatarUrl,
                            contentDescription = userName,
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        Text(
                            text = userName.take(1),
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.apparelPrimary)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg24.dp))

            // Card com informações pessoais
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                    .background(Color(WgcCoreDsColors.apparelSurface))
                    .padding(WgcCoreDsSpacing.md16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = userName,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.apparelDark)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                    Text(
                        text = userEmail,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.apparelSecondaryText)
                    )
                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                    Text(
                        text = userPhone,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.apparelSecondaryText)
                    )
                }

                TextButton(onClick = onEditProfileClick) {
                    Text(
                        text = "Edit",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color(WgcCoreDsColors.apparelPrimary)
                    )
                }
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))

            // Lista de configurações
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
            ) {
                SettingsItemRow(
                    title = "Address",
                    icon = Icons.Default.LocationOn,
                    onClick = onAddressClick
                )

                SettingsItemRow(
                    title = "Wishlist",
                    icon = Icons.Default.Favorite,
                    onClick = onWishlistClick
                )

                SettingsItemRow(
                    title = "Payment",
                    icon = Icons.Default.CreditCard,
                    onClick = onPaymentClick
                )

                SettingsItemRow(
                    title = "Help",
                    icon = Icons.AutoMirrored.Filled.HelpOutline,
                    onClick = onHelpClick
                )

                SettingsItemRow(
                    title = "Support",
                    icon = Icons.Default.SupportAgent,
                    onClick = onSupportClick
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxl48.dp))

            // Botão Sign Out em vermelho
            TextButton(
                onClick = onSignOutClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Sign Out",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.apparelAlertRed)
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
        }
    }
}

@Composable
private fun SettingsItemRow(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
            .background(Color(WgcCoreDsColors.apparelSurface))
            .clickable(onClick = onClick)
            .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.md16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = Color(WgcCoreDsColors.apparelDark),
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = Color(WgcCoreDsColors.apparelDark)
            )
        }

        Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = "Abrir",
            tint = Color(WgcCoreDsColors.apparelSecondaryText)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcClotheeSettingsTemplatePreview() {
    WgcClotheeSettingsTemplate()
}
