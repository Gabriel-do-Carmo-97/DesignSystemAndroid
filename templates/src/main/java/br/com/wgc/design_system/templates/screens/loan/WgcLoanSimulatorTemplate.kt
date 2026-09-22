@file:Suppress("LongMethod", "UnusedPrivateMember", "MagicNumber")

package br.com.wgc.design_system.templates.screens.loan

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import br.com.wgc.design_system.components.buttons.WgcClassicButton
import br.com.wgc.design_system.core.WgcCoreDsBorderRadius
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.math.roundToInt

private const val DEFAULT_LOAN_AMOUNT = 10000f
private const val MIN_LOAN_AMOUNT = 1000f
private const val MAX_LOAN_AMOUNT = 50000f
private const val DEFAULT_INSTALLMENTS = 24
private const val INTEREST_RATE_PERCENT = 0.0199f

/**
 * Estado corporativo da simulação e contratação de empréstimo.
 */
data class WgcLoanSimulatorUiState(
    val title: String = "Simulador de Empréstimo",
    val requestedAmount: Float = DEFAULT_LOAN_AMOUNT,
    val minAmount: Float = MIN_LOAN_AMOUNT,
    val maxAmount: Float = MAX_LOAN_AMOUNT,
    val availableInstallments: List<Int> = listOf(6, 12, 24, 36, 48),
    val selectedInstallments: Int = DEFAULT_INSTALLMENTS,
    val availableGracePeriodsDays: List<Int> = listOf(30, 60, 90),
    val selectedGracePeriodDays: Int = 30,
    val monthlyInterestRate: String = "1,99% a.m.",
    val annualCet: String = "26,82% a.a.",
    val termsAccepted: Boolean = false,
    val isContractHired: Boolean = false
) {
    val estimatedMonthlyPayment: Float
        get() {
            val totalWithInterest = requestedAmount * (1f + INTEREST_RATE_PERCENT * selectedInstallments)
            return totalWithInterest / selectedInstallments
        }

    val totalPayableAmount: Float
        get() = estimatedMonthlyPayment * selectedInstallments
}

/**
 * ViewModel base para simulação de crédito e empréstimo.
 */
abstract class BaseLoanSimulatorViewModel : ViewModel() {
    abstract val uiState: StateFlow<WgcLoanSimulatorUiState>
    abstract fun onAmountChange(amount: Float)
    abstract fun onInstallmentsSelect(installments: Int)
    abstract fun onGracePeriodSelect(days: Int)
    abstract fun onTermsToggle(accepted: Boolean)
    abstract fun onHireLoan()
}

/**
 * Fake ViewModel para Testes e Previews.
 */
class FakeLoanSimulatorViewModel(
    initialState: WgcLoanSimulatorUiState = WgcLoanSimulatorUiState()
) : BaseLoanSimulatorViewModel() {
    private val _uiState = MutableStateFlow(initialState)
    override val uiState: StateFlow<WgcLoanSimulatorUiState> = _uiState.asStateFlow()

    override fun onAmountChange(amount: Float) {
        _uiState.value = _uiState.value.copy(requestedAmount = amount)
    }

    override fun onInstallmentsSelect(installments: Int) {
        _uiState.value = _uiState.value.copy(selectedInstallments = installments)
    }

    override fun onGracePeriodSelect(days: Int) {
        _uiState.value = _uiState.value.copy(selectedGracePeriodDays = days)
    }

    override fun onTermsToggle(accepted: Boolean) {
        _uiState.value = _uiState.value.copy(termsAccepted = accepted)
    }

    override fun onHireLoan() {
        _uiState.value = _uiState.value.copy(isContractHired = true)
    }
}

/**
 * Template completo corporativo de simulação e contratação de crédito.
 */
@Composable
fun WgcLoanSimulatorTemplate(
    modifier: Modifier = Modifier,
    viewModel: BaseLoanSimulatorViewModel = FakeLoanSimulatorViewModel(),
    headerSlot: (@Composable () -> Unit)? = null,
    signatureSlot: (@Composable () -> Unit)? = null
) {
    val state by viewModel.uiState.collectAsState()

    WgcLoanSimulatorContent(
        state = state,
        modifier = modifier,
        onAmountChange = viewModel::onAmountChange,
        onInstallmentsSelect = viewModel::onInstallmentsSelect,
        onGracePeriodSelect = viewModel::onGracePeriodSelect,
        onTermsToggle = viewModel::onTermsToggle,
        onHireLoan = viewModel::onHireLoan,
        headerSlot = headerSlot,
        signatureSlot = signatureSlot
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WgcLoanSimulatorContent(
    state: WgcLoanSimulatorUiState,
    modifier: Modifier = Modifier,
    onAmountChange: (Float) -> Unit = {},
    onInstallmentsSelect: (Int) -> Unit = {},
    onGracePeriodSelect: (Int) -> Unit = {},
    onTermsToggle: (Boolean) -> Unit = {},
    onHireLoan: () -> Unit = {},
    onBackClick: () -> Unit = {},
    headerSlot: (@Composable () -> Unit)? = null,
    signatureSlot: (@Composable () -> Unit)? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            if (headerSlot != null) {
                headerSlot()
            } else {
                TopAppBar(
                    title = { Text(state.title, style = MaterialTheme.typography.titleLarge) },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
                )
            }
        },
        bottomBar = {
            Surface(tonalElevation = WgcCoreDsSpacing.xs8.dp, modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp)) {
                    WgcClassicButton(
                        textButton = "Contratar Empréstimo",
                        onClick = onHireLoan,
                        isEnabled = state.termsAccepted,
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
                .padding(horizontal = WgcCoreDsSpacing.md16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.lg24.dp)
        ) {
            LoanAmountSection(
                amount = state.requestedAmount,
                min = state.minAmount,
                max = state.maxAmount,
                onAmountChange = onAmountChange
            )

            InstallmentsSelectorSection(
                installments = state.availableInstallments,
                selected = state.selectedInstallments,
                onSelect = onInstallmentsSelect
            )

            GracePeriodSection(
                periods = state.availableGracePeriodsDays,
                selected = state.selectedGracePeriodDays,
                onSelect = onGracePeriodSelect
            )

            LoanSummaryCard(state = state)

            if (signatureSlot != null) {
                signatureSlot()
            }

            LoanTermsCheckboxRow(
                accepted = state.termsAccepted,
                onToggle = onTermsToggle
            )

            Spacer(modifier = Modifier.height(WgcCoreDsSpacing.xl32.dp))
        }
    }
}

@Composable
private fun LoanAmountSection(
    amount: Float,
    min: Float,
    max: Float,
    onAmountChange: (Float) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.sm12.dp)
        ) {
            Text(text = "Quanto você precisa?", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text(
                text = "R$ ${amount.roundToInt()},00",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Slider(
                value = amount,
                onValueChange = onAmountChange,
                valueRange = min..max,
                steps = 49,
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Mín: R$ ${min.roundToInt()}", style = MaterialTheme.typography.labelSmall)
                Text(text = "Máx: R$ ${max.roundToInt()}", style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}

@Composable
private fun InstallmentsSelectorSection(
    installments: List<Int>,
    selected: Int,
    onSelect: (Int) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
        Text(text = "Número de Parcelas", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.SemiBold)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            for (count in installments) {
                FilterChip(
                    selected = count == selected,
                    onClick = { onSelect(count) },
                    label = { Text("${count}x") },
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                )
            }
        }
    }
}

@Composable
private fun GracePeriodSection(
    periods: List<Int>,
    selected: Int,
    onSelect: (Int) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)) {
        Text(text = "Primeira Parcela Em (Carência)", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.SemiBold)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            for (days in periods) {
                FilterChip(
                    selected = days == selected,
                    onClick = { onSelect(days) },
                    label = { Text("$days dias") },
                    shape = RoundedCornerShape(WgcCoreDsBorderRadius.circular999.dp)
                )
            }
        }
    }
}

@Composable
private fun LoanSummaryCard(state: WgcLoanSimulatorUiState) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(WgcCoreDsBorderRadius.md8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(
            modifier = Modifier.padding(WgcCoreDsSpacing.md16.dp),
            verticalArrangement = Arrangement.spacedBy(WgcCoreDsSpacing.xs8.dp)
        ) {
            Text(
                text = "${state.selectedInstallments}x de R$ ${state.estimatedMonthlyPayment.roundToInt()},00",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            SummaryRow(label = "Total a Pagar:", value = "R$ ${state.totalPayableAmount.roundToInt()},00")
            SummaryRow(label = "Taxa de Juros:", value = state.monthlyInterestRate)
            SummaryRow(label = "CET Anual:", value = state.annualCet)
        }
    }
}

@Composable
private fun SummaryRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onPrimaryContainer)
        Text(text = value, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onPrimaryContainer)
    }
}

@Composable
private fun LoanTermsCheckboxRow(
    accepted: Boolean,
    onToggle: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = accepted, onCheckedChange = onToggle)
        Text(
            text = "Declaro que li e concordo com os Termos e Condições do Contrato de Crédito WGC.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(name = "WgcLoanSimulatorTemplate Preview", showBackground = true)
@Composable
private fun WgcLoanSimulatorTemplatePreview() {
    MaterialTheme {
        WgcLoanSimulatorContent(state = WgcLoanSimulatorUiState())
    }
}
