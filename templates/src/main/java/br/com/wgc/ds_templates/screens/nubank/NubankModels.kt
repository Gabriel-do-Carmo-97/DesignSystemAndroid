package br.com.wgc.ds_templates.screens.nubank

data class NubankTransaction(
    val id: String,
    val title: String,
    val category: String,
    val amount: Double,
    val date: String,
    val isPositive: Boolean = false
)

data class NubankCaixinha(
    val id: String,
    val name: String,
    val targetAmount: Double,
    val currentAmount: Double,
    val yieldPercentage: String
)

data class NubankCreditCardData(
    val currentInvoice: Double,
    val availableLimit: Double,
    val dueDate: String,
    val bestDayToBuy: String
)

object NubankMockData {
    val sampleTransactions = listOf(
        NubankTransaction("1", "Supermercado Pão de Açúcar", "Alimentação", 342.50, "Hoje, 14:32"),
        NubankTransaction("2", "Transferência Pix recebida de Mariana", "Transferência", 120.00, "Hoje, 11:15", isPositive = true),
        NubankTransaction("3", "Assinatura Netflix Premium", "Streaming", 55.90, "Ontem, 08:00"),
        NubankTransaction("4", "Farmácia Droga Raia", "Saúde", 89.90, "12 Set"),
        NubankTransaction("5", "Posto Ipiranga Combustível", "Transporte", 250.00, "10 Set")
    )

    val sampleCaixinhas = listOf(
        NubankCaixinha("1", "Reserva de Emergência", 15000.0, 12450.80, "100% do CDI"),
        NubankCaixinha("2", "Viagem para Europa 2027", 30000.0, 8900.00, "104% do CDI"),
        NubankCaixinha("3", "Reforma do Apartamento", 20000.0, 14300.50, "RDB Resgate Diário")
    )

    val sampleCard = NubankCreditCardData(
        currentInvoice = 2341.80,
        availableLimit = 7658.20,
        dueDate = "15 de Outubro",
        bestDayToBuy = "08 de Outubro"
    )
}
