package br.com.wgc.design_system.templates.screens.trendfashion.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.wgc.design_system.core.WgcCoreDsColors
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.components.avatar.WgcAvatar
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.fields.SimpleTextField
import br.com.wgc.design_system.templates.screens.trendfashion.model.StylishUserProfile

/**
 * Tela 16: Profile (Gestão completa de perfil, endereços e dados bancários).
 * (Figma ID: 1:17411)
 */
@Composable
fun WgcStylishProfileScreenTemplate(
    modifier: Modifier = Modifier,
    profile: StylishUserProfile = StylishUserProfile(),
    onProfileChange: (StylishUserProfile) -> Unit = {},
    onBackClick: () -> Unit = {},
    onSaveClick: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = WgcCoreDsSpacing.md.dp, vertical = WgcCoreDsSpacing.sm.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(WgcCoreDsColors.trendFashionDark)
                    )
                }
                Text(
                    text = "Profile",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color(WgcCoreDsColors.trendFashionDark)
                )
            }
        },
        bottomBar = {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shadowElevation = 8.dp,
                color = Color.White
            ) {
                Box(modifier = Modifier.padding(WgcCoreDsSpacing.md.dp)) {
                    WgcButton(
                        text = "Save",
                        onClick = onSaveClick,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = WgcCoreDsSpacing.md.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.md.dp))

            // Avatar Header
            WgcAvatar(
                initials = profile.fullName.take(2).uppercase(),
                size = 96.dp
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

            // 1. Personal Details
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Personal Details",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color(WgcCoreDsColors.trendFashionDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

                SimpleTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = profile.email,
                    onValueChange = { onProfileChange(profile.copy(email = it)) },
                    label = "Email Address",
                    leadingIcon = Icons.Outlined.Email,
                    keyboardType = KeyboardType.Email
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

                SimpleTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "••••••••",
                    onValueChange = {},
                    label = "Password",
                    leadingIcon = Icons.Outlined.Lock,
                    isPasswordField = true
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

            // 2. Business / Delivery Address Details
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Business Address Details",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color(WgcCoreDsColors.trendFashionDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

                SimpleTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = profile.pincode,
                    onValueChange = { onProfileChange(profile.copy(pincode = it)) },
                    label = "Pincode",
                    keyboardType = KeyboardType.Number
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

                SimpleTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = profile.address,
                    onValueChange = { onProfileChange(profile.copy(address = it)) },
                    label = "Address",
                    leadingIcon = Icons.Outlined.Home
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

                SimpleTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = profile.city,
                    onValueChange = { onProfileChange(profile.copy(city = it)) },
                    label = "City"
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

                SimpleTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = profile.state,
                    onValueChange = { onProfileChange(profile.copy(state = it)) },
                    label = "State"
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

                SimpleTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = profile.country,
                    onValueChange = { onProfileChange(profile.copy(country = it)) },
                    label = "Country"
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.lg.dp))

            // 3. Bank Account Details
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Bank Account Details",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color(WgcCoreDsColors.trendFashionDark)
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

                SimpleTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = profile.bankAccountNumber,
                    onValueChange = { onProfileChange(profile.copy(bankAccountNumber = it)) },
                    label = "Bank Account Number",
                    leadingIcon = Icons.Outlined.AccountBalance,
                    keyboardType = KeyboardType.Number
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

                SimpleTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = profile.accountHolderName,
                    onValueChange = { onProfileChange(profile.copy(accountHolderName = it)) },
                    label = "Account Holder's Name",
                    leadingIcon = Icons.Outlined.Person
                )

                Spacer(modifier = Modifier.height(WgcCoreDsSpacing.sm.dp))

                SimpleTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = profile.ifscCode,
                    onValueChange = { onProfileChange(profile.copy(ifscCode = it)) },
                    label = "IFSC Code"
                )
            }

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl.dp))
        }
    }
}

@Preview(name = "Profile Screen Preview", showBackground = true)
@Composable
private fun WgcStylishProfilePreview() {
    var prof by remember { mutableStateOf(StylishUserProfile()) }
    WgcStylishProfileScreenTemplate(
        profile = prof,
        onProfileChange = { prof = it }
    )
}
