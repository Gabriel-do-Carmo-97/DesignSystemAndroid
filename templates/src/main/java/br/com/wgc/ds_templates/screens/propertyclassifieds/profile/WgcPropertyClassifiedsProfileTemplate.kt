package br.com.wgc.ds_templates.screens.propertyclassifieds.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.filled.AddHome
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import br.com.wgc.core_ds.WgcCoreDsElevation
import br.com.wgc.core_ds.WgcCoreDsSize
import br.com.wgc.core_ds.WgcCoreDsSpacing

/**
 * Template da Tela de Perfil e Anunciante do Zap Imóveis.
 */
@Composable
fun WgcZapProfileTemplate(
    userName: String = "Gabriel do Carmo",
    userEmail: String = "gabriel.carmo@wgc.com.br",
    activePropertiesCount: Int = 2,
    leadsReceivedCount: Int = 18,
    onAnnouncePropertyClick: () -> Unit = {},
    onMyPropertiesClick: () -> Unit = {},
    onLeadsClick: () -> Unit = {},
    onFinancingSimulatorClick: () -> Unit = {},
    onFipeConsultingClick: () -> Unit = {},
    onSecurityTipsClick: () -> Unit = {},
    onHelpClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(WgcCoreDsColors.propertyClassifiedsSurface))
                    .padding(
                        horizontal = WgcCoreDsSpacing.md16.dp,
                        vertical = WgcCoreDsSpacing.sm12.dp
                    )
            ) {
                Text(
                    text = "Meu Perfil",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.md16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Card de Perfil do Usuário
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyClassifiedsSurface)),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(WgcCoreDsSize.s56.dp)
                                    .clip(CircleShape)
                                    .background(Color(WgcCoreDsColors.propertyClassifiedsPrimary)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(WgcCoreDsSize.s32.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))

                            Column {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = userName,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                                    )
                                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                                    Icon(
                                        imageVector = Icons.Default.Verified,
                                        contentDescription = "Verificado",
                                        tint = Color(WgcCoreDsColors.propertyClassifiedsBlue),
                                        modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                                Text(
                                    text = userEmail,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md16.dp))

                        // Botão CTA Laranja Oficial Zap: Anunciar Imóvel
                        Button(
                            onClick = onAnnouncePropertyClick,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(WgcCoreDsSize.s48.dp),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(WgcCoreDsColors.propertyClassifiedsOrange),
                                contentColor = Color.White
                            )
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.AddHome,
                                    contentDescription = null,
                                    modifier = Modifier.size(WgcCoreDsSize.s20.dp)
                                )
                                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                                Text(
                                    text = "Anunciar Imóvel no Zap",
                                    style = MaterialTheme.typography.labelLarge,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            // Painel do Anunciante: Métricas Rápidas
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .clickable(onClick = onMyPropertiesClick),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyClassifiedsSurface)),
                        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(WgcCoreDsSpacing.md16.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.propertyClassifiedsPrimary),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                            Text(
                                text = "$activePropertiesCount ativos",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                            )
                            Text(
                                text = "Meus Anúncios",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                            )
                        }
                    }

                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .clickable(onClick = onLeadsClick),
                        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyClassifiedsSurface)),
                        elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(WgcCoreDsSpacing.md16.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.propertyClassifiedsOrange),
                                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xs8.dp))
                            Text(
                                text = "$leadsReceivedCount contatos",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                            )
                            Text(
                                text = "Leads Recebidos",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                            )
                        }
                    }
                }
            }

            // Seção Serviços & Inteligência Zap
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyClassifiedsSurface)),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Serviços Exclusivos Zap",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.propertyClassifiedsDark),
                            modifier = Modifier.padding(
                                horizontal = WgcCoreDsSpacing.md16.dp,
                                vertical = WgcCoreDsSpacing.sm12.dp
                            )
                        )
                        HorizontalDivider(color = Color(WgcCoreDsColors.propertyClassifiedsBorder))

                        ZapProfileMenuItem(
                            icon = Icons.Default.Calculate,
                            title = "Simulador de Financiamento",
                            subtitle = "Compare taxas de juros dos principais bancos",
                            onClick = onFinancingSimulatorClick
                        )
                        HorizontalDivider(color = Color(WgcCoreDsColors.propertyClassifiedsBorder))

                        ZapProfileMenuItem(
                            icon = Icons.Default.Analytics,
                            title = "Consultoria FipeZAP",
                            subtitle = "Relatórios detalhados de precificação por região",
                            onClick = onFipeConsultingClick
                        )
                    }
                }
            }

            // Seção Suporte & Segurança
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.lg12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyClassifiedsSurface)),
                    elevation = CardDefaults.cardElevation(defaultElevation = WgcCoreDsElevation.level1.dp)
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        ZapProfileMenuItem(
                            icon = Icons.Default.Lock,
                            title = "Dicas de Segurança",
                            subtitle = "Como negociar imóveis com total segurança",
                            onClick = onSecurityTipsClick
                        )
                        HorizontalDivider(color = Color(WgcCoreDsColors.propertyClassifiedsBorder))

                        ZapProfileMenuItem(
                            icon = Icons.AutoMirrored.Filled.HelpOutline,
                            title = "Central de Ajuda Zap",
                            subtitle = "Perguntas frequentes e canais de atendimento",
                            onClick = onHelpClick
                        )
                        HorizontalDivider(color = Color(WgcCoreDsColors.propertyClassifiedsBorder))

                        ZapProfileMenuItem(
                            icon = Icons.Default.Info,
                            title = "Sobre o Zap Imóveis",
                            subtitle = "Termos de uso, privacidade e versão 8.4.2",
                            onClick = {}
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ZapProfileMenuItem(
    icon: ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.sm12.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(WgcCoreDsColors.propertyClassifiedsPrimary),
                modifier = Modifier.size(WgcCoreDsSize.s24.dp)
            )
            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.md16.dp))
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(WgcCoreDsColors.propertyClassifiedsDark)
                )
                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxxs2.dp))
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText)
                )
            }
        }

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            tint = Color(WgcCoreDsColors.propertyClassifiedsSecondaryText),
            modifier = Modifier.size(WgcCoreDsSize.s14.dp)
        )
    }
}

@Preview(name = "WgcZapProfileTemplate - Default", showBackground = true)
@Composable
private fun WgcZapProfileTemplatePreview() {
    MaterialTheme {
        WgcZapProfileTemplate()
    }
}
