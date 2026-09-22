package br.com.wgc.design_system.templates.screens.propertylisting.contact

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSize
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.templates.screens.propertylisting.model.PropertyListingMockData
import br.com.wgc.design_system.templates.screens.propertylisting.model.PropertyListingPropertyModel

/**
 * Template de Envio de Contato / Lead para a Imobiliária do Property Listing:
 * - Resumo do imóvel selecionado
 * - Formulário de Nome, E-mail, Telefone e mensagem personalizada
 * - Opções de agendamento de visita e recebimento de alertas
 * - Botão de envio com a cor laranja oficial do Property Listing (#FF6600)
 */
@Composable
fun WgcPropertyListingContactLeadTemplate(
    modifier: Modifier = Modifier,
    property: PropertyListingPropertyModel = PropertyListingMockData.sampleProperty,
    onBackClick: () -> Unit = {},
    onSubmitLead: (name: String, email: String, phone: String, message: String) -> Unit = { _, _, _, _ -> },
    topBarSlot: (@Composable () -> Unit)? = null
) {
    var name by remember { mutableStateOf("Gabriel do Carmo") }
    var email by remember { mutableStateOf("gabriel@wgc.com.br") }
    var phone by remember { mutableStateOf("(11) 98765-4321") }
    var message by remember {
        mutableStateOf("Olá, tenho interesse neste imóvel (${property.code}). Por favor, entre em contato com mais informações.")
    }
    var scheduleVisitChecked by remember { mutableStateOf(true) }
    var similarOptionsChecked by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (topBarSlot != null) {
                topBarSlot()
            } else {
                PropertyListingContactTopBar(onBackClick = onBackClick)
            }
        },
        bottomBar = {
            PropertyListingContactBottomBar(
                onSubmitClick = {
                    onSubmitLead(name, email, phone, message)
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(
                horizontal = WgcCoreDsSpacing.md16.dp,
                vertical = WgcCoreDsSpacing.md16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.md16.dp)
        ) {
            // Resumo do Imóvel
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyListingSurface))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(WgcCoreDsSize.s60.dp)
                                .clip(RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp))
                                .background(Color(WgcCoreDsColors.propertyListingPrimaryLight)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null,
                                tint = Color(WgcCoreDsColors.propertyListingPrimary),
                                modifier = Modifier.size(WgcCoreDsSize.s28.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = property.title,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.propertyListingDark),
                                maxLines = 1
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                            Text(
                                text = property.price,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color(WgcCoreDsColors.propertyListingPrimary)
                            )
                            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xxs4.dp))
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Business,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.propertyListingSecondaryText),
                                    modifier = Modifier.size(WgcCoreDsSize.s14.dp)
                                )
                                Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xxs4.dp))
                                Text(
                                    text = property.agencyName,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color(WgcCoreDsColors.propertyListingSecondaryText)
                                )
                            }
                        }
                    }
                }
            }

            // Formulário de Contato
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(WgcCoreDsColors.propertyListingSurface))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(WgcCoreDsSpacing.md16.dp),
                        verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
                    ) {
                        Text(
                            text = "Seus dados de contato",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(WgcCoreDsColors.propertyListingDark)
                        )

                        // Nome
                        OutlinedTextField(
                            value = name,
                            onValueChange = { name = it },
                            label = { Text("Nome completo") },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(WgcCoreDsColors.propertyListingPrimary),
                                unfocusedBorderColor = Color(WgcCoreDsColors.propertyListingBorder)
                            )
                        )

                        // E-mail
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("E-mail") },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Email,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.propertyListingSecondaryText),
                                    modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                                )
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(WgcCoreDsColors.propertyListingPrimary),
                                unfocusedBorderColor = Color(WgcCoreDsColors.propertyListingBorder)
                            )
                        )

                        // Telefone / Contato
                        OutlinedTextField(
                            value = phone,
                            onValueChange = { phone = it },
                            label = { Text("Telefone / Celular") },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Phone,
                                    contentDescription = null,
                                    tint = Color(WgcCoreDsColors.propertyListingSecondaryText),
                                    modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                                )
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(WgcCoreDsColors.propertyListingPrimary),
                                unfocusedBorderColor = Color(WgcCoreDsColors.propertyListingBorder)
                            )
                        )

                        // Mensagem
                        OutlinedTextField(
                            value = message,
                            onValueChange = { message = it },
                            label = { Text("Mensagem") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(WgcCoreDsSize.s100.dp),
                            shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color(WgcCoreDsColors.propertyListingPrimary),
                                unfocusedBorderColor = Color(WgcCoreDsColors.propertyListingBorder)
                            )
                        )

                        // Checkboxes de interesse
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Checkbox(
                                checked = scheduleVisitChecked,
                                onCheckedChange = { scheduleVisitChecked = it },
                                colors = CheckboxDefaults.colors(checkedColor = Color(WgcCoreDsColors.propertyListingPrimary))
                            )
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                            Text(
                                text = "Gostaria de agendar uma visita ao imóvel",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(WgcCoreDsColors.propertyListingDark)
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Checkbox(
                                checked = similarOptionsChecked,
                                onCheckedChange = { similarOptionsChecked = it },
                                colors = CheckboxDefaults.colors(checkedColor = Color(WgcCoreDsColors.propertyListingPrimary))
                            )
                            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                            Text(
                                text = "Desejo receber opções similares de corretores parceiros",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color(WgcCoreDsColors.propertyListingSecondaryText)
                            )
                        }
                    }
                }
            }

            // Nota de Privacidade
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                        tint = Color(WgcCoreDsColors.propertyListingPrimary),
                        modifier = Modifier.size(WgcCoreDsSize.s16.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Text(
                        text = "Seus dados estão protegidos e serão compartilhados apenas com este anunciante.",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(WgcCoreDsColors.propertyListingSecondaryText)
                    )
                }
            }
        }
    }
}

@Composable
private fun PropertyListingContactTopBar(onBackClick: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(WgcCoreDsColors.propertyListingSurface),
        shadowElevation = WgcCoreDsSpacing.xxs4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = WgcCoreDsSpacing.md16.dp,
                    vertical = WgcCoreDsSpacing.sm12.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier.size(WgcCoreDsSize.s36.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color(WgcCoreDsColors.propertyListingDark)
                )
            }

            Spacer(modifier = Modifier.width(WgcCoreDsSpacing.sm12.dp))

            Text(
                text = "Falar com Anunciante",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color(WgcCoreDsColors.propertyListingDark)
            )
        }
    }
}

@Composable
private fun PropertyListingContactBottomBar(onSubmitClick: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(WgcCoreDsColors.propertyListingSurface),
        shadowElevation = WgcCoreDsSpacing.md16.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = WgcCoreDsSpacing.md16.dp,
                    vertical = WgcCoreDsSpacing.sm12.dp
                )
        ) {
            Button(
                onClick = onSubmitClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(WgcCoreDsSize.s48.dp),
                shape = RoundedCornerShape(WgcCoreDsBorderRadius.xl16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(WgcCoreDsColors.propertyListingOrange),
                    contentColor = Color.White
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        modifier = Modifier.size(WgcCoreDsSize.s18.dp)
                    )
                    Spacer(modifier = Modifier.width(WgcCoreDsSpacing.xs8.dp))
                    Text(
                        text = "Enviar Mensagem",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WgcPropertyListingContactLeadTemplatePreview() {
    WgcPropertyListingContactLeadTemplate()
}
