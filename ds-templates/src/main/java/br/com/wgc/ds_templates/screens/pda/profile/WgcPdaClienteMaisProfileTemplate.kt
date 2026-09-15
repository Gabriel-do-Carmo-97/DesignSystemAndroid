package br.com.wgc.ds_templates.screens.pda.profile

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Savings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import br.com.wgc.design_system.components.navigation.WgcPdaBottomNav
import br.com.wgc.ds_templates.screens.pda.model.PdaMockData
import br.com.wgc.ds_templates.screens.pda.model.PdaUserProfile
import java.util.Locale

/**
 * Template da Tela de Perfil VIP "Cliente Mais Pão de Açúcar".
 *
 * Apresenta QR Code de identificação no caixa físico, extrato de Stillo Moedas,
 * benefícios do nível Black/Gold e histórico de economia acumulada.
 */
@Composable
fun WgcPdaClienteMaisProfileTemplate(
    modifier: Modifier = Modifier,
    userProfile: PdaUserProfile = PdaMockData.defaultUser,
    selectedNavIndex: Int = 4,
    onNavSelect: (Int) -> Unit = {},
    headerSlot: (@Composable () -> Unit)? = null,
    footerSlot: (@Composable () -> Unit)? = null
) {
    val benefits = listOf(
        "Frete Grátis ilimitado acima de R$ 99",
        "Sommelier dedicado via WhatsApp para harmonizações",
        "Até 35% de desconto exclusivo em Vinhos & Queijos",
        "Acesso prioritário a lançamentos e edições limitadas",
        "Caixa preferencial VIP em lojas físicas"
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color(WgcCoreDsColors.pdaBackground),
        bottomBar = {
            footerSlot?.invoke() ?: WgcPdaBottomNav(
                selectedItem = selectedNavIndex,
                onItemSelected = onNavSelect
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Header Perfil VIP
            item {
                headerSlot?.invoke() ?: Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(WgcCoreDsColors.pdaTextPrimary))
                        .padding(WgcCoreDsSpacing.lg24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(WgcCoreDsSize.s72.dp)
                            .clip(CircleShape)
                            .background(Color(WgcCoreDsColors.pdaGoldLight))
                            .border(
                                width = WgcCoreDsSize.s1.dp,
                                color = Color(WgcCoreDsColors.pdaGold),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = Color(WgcCoreDsColors.pdaGoldDark),
                            modifier = Modifier.size(WgcCoreDsSize.s40.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    Text(
                        text = userProfile.name,
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "CPF: ${userProfile.cpfMasked}",
                        color = Color.White.copy(alpha = 0.7f),
                        style = MaterialTheme.typography.bodySmall
                    )

                    Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp))
                            .background(Color(WgcCoreDsColors.pdaGold))
                            .padding(
                                horizontal = WgcCoreDsSpacing.sm12.dp,
                                vertical = WgcCoreDsSpacing.xxs4.dp
                            )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xxs4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Diamond,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.pdaTextPrimary),
                                modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                            )
                            Text(
                                text = userProfile.tier.uppercase(Locale.ROOT),
                                color = Color(WgcCoreDsColors.pdaTextPrimary),
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Black
                            )
                        }
                    }
                }
            }

            // QR Code Central do Caixa
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.sm12.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(WgcCoreDsColors.pdaSurface)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = WgcCoreDsElevation.level3.dp
                    ),
                    border = androidx.compose.foundation.BorderStroke(
                        width = WgcCoreDsSize.s1.dp,
                        color = Color(WgcCoreDsColors.pdaGold)
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "IDENTIFICAÇÃO NO CAIXA",
                            color = Color(WgcCoreDsColors.pdaGreenDark),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Black
                        )

                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s140.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                .background(Color(WgcCoreDsColors.pdaBackground))
                                .border(
                                    width = WgcCoreDsSize.s1.dp,
                                    color = Color(WgcCoreDsColors.pdaBorder),
                                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.QrCode,
                                contentDescription = "QR Code Caixa",
                                tint = Color(WgcCoreDsColors.pdaGreenDark),
                                modifier = Modifier.size(WgcCoreDsSize.s100.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))

                        Text(
                            text = "Apresente este código no leitor do caixa para resgatar descontos e acumular Stillo Moedas.",
                            color = Color(WgcCoreDsColors.pdaTextSecondary),
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                    }
                }
            }

            // Benefícios do Nível Black
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(WgcCoreDsColors.pdaSurface)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = WgcCoreDsElevation.level1.dp
                    ),
                    border = androidx.compose.foundation.BorderStroke(
                        width = WgcCoreDsSize.s1.dp,
                        color = Color(WgcCoreDsColors.pdaBorder)
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.pdaGoldDark),
                                modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                            )
                            Text(
                                text = "SEUS BENEFÍCIOS VIP BLACK",
                                color = Color(WgcCoreDsColors.pdaTextPrimary),
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        benefits.forEach { benefit ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.pdaGreen),
                                    modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                                )
                                Text(
                                    text = benefit,
                                    color = Color(WgcCoreDsColors.pdaTextPrimary),
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        }
                    }
                }
            }

            // Economia Total no Ano
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = WgcCoreDsSpacing.md16.dp, vertical = WgcCoreDsSpacing.xs8.dp),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(WgcCoreDsColors.pdaGreenLight)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = WgcCoreDsElevation.level0.dp
                    )
                ) {
                    Row(
                        modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s48.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.sm4.dp))
                                .background(Color(WgcCoreDsColors.pdaGreen)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Savings,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                            )
                        }

                        Column {
                            Text(
                                text = "Economia Acumulada em 2026",
                                color = Color(WgcCoreDsColors.pdaGreenDark),
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "R$ 3.840,00",
                                color = Color(WgcCoreDsColors.pdaGreenDark),
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Black
                            )
                        }
                    }
                }
            }

            // Atalhos: Histórico de Pedidos e Cartão Pão de Açúcar Itaú
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = WgcCoreDsSpacing.md16.dp,
                            vertical = WgcCoreDsSpacing.sm12.dp
                        ),
                    verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {},
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(WgcCoreDsColors.pdaSurface)
                        ),
                        border = androidx.compose.foundation.BorderStroke(
                            width = WgcCoreDsSize.s1.dp,
                            color = Color(WgcCoreDsColors.pdaBorder)
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(WgcCoreDsSpacing.md16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.History,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.pdaGreenDark),
                                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                                )
                                Text(
                                    text = "Histórico de Pedidos e Notas Fiscais",
                                    color = Color(WgcCoreDsColors.pdaTextPrimary),
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.pdaTextSecondary),
                                modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                            )
                        }
                    }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {},
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(WgcCoreDsColors.pdaSurface)
                        ),
                        border = androidx.compose.foundation.BorderStroke(
                            width = WgcCoreDsSize.s1.dp,
                            color = Color(WgcCoreDsColors.pdaBorder)
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(WgcCoreDsSpacing.md16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.CreditCard,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.pdaGoldDark),
                                    modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                                )
                                Text(
                                    text = "Cartão Pão de Açúcar Itaú Platinum/Black",
                                    color = Color(WgcCoreDsColors.pdaTextPrimary),
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.pdaTextSecondary),
                                modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(name = "PDA Profile Template", showBackground = true)
@Composable
private fun WgcPdaClienteMaisProfileTemplatePreview() {
    WgcPdaClienteMaisProfileTemplate()
}
