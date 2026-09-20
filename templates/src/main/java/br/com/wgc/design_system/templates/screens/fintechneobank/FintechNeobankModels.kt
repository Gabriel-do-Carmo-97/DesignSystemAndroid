package br.com.wgc.design_system.templates.screens.fintechneobank

data class NeobankTransaction(
    val id: String,
    val title: String,
    val category: String,
    val amount: Double,
    val date: String,
    val isPositive: Boolean = false
)

data class NeobankCaixinha(
    val id: String,
    val name: String,
    val targetAmount: Double,
    val currentAmount: Double,
    val yieldPercentage: String
)

data class NeobankCreditCardData(
    val currentInvoice: Double,
    val availableLimit: Double,
    val dueDate: String,
    val bestDayToBuy: String
)

object FintechNeobankMockData {
    val sampleTransactions = listOf(
        NeobankTransaction("1", "Supermercado Gourmet", "Alimentação", 342.50, "Hoje, 14:32"),
        NeobankTransaction("2", "Transferência Pix recebida de Mariana", "Transferência", 120.00, "Hoje, 11:15", isPositive = true),
        NeobankTransaction("3", "Assinatura Vídeo Streaming Premium", "Streaming", 55.90, "Ontem, 08:00"),
        NeobankTransaction("4", "Farmácia Central", "Saúde", 89.90, "12 Set"),
        NeobankTransaction("5", "Posto Ipiranga Combustível", "Transporte", 250.00, "10 Set")
    )

    val sampleCaixinhas = listOf(
        NeobankCaixinha("1", "Reserva de Emergência", 15000.0, 12450.80, "100% do CDI"),
        NeobankCaixinha("2", "Viagem para Europa 2027", 30000.0, 8900.00, "104% do CDI"),
        NeobankCaixinha("3", "Reforma do Apartamento", 20000.0, 14300.50, "RDB Resgate Diário")
    )

    val sampleCard = NeobankCreditCardData(
        currentInvoice = 2341.80,
        availableLimit = 7658.20,
        dueDate = "15 de Outubro",
        bestDayToBuy = "08 de Outubro"
    )
}
