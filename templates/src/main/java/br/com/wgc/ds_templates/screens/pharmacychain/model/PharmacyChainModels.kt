package br.com.wgc.ds_templates.screens.pharmacychain.model

import br.com.wgc.design_system.components.cards.PharmacyMedicineStripe

data class PharmacyProduct(
    val id: String,
    val title: String,
    val laboratory: String,
    val presentation: String,
    val price: Double,
    val originalPrice: Double? = null,
    val pharmacyClientPrice: Double? = null,
    val stripe: PharmacyMedicineStripe = PharmacyMedicineStripe.NONE,
    val requiresPrescription: Boolean = false,
    val hasSubscription: Boolean = false
)

data class PharmacySubscriptionItem(
    val id: String,
    val medicineName: String,
    val frequency: String,
    val nextDeliveryDate: String,
    val price: Double
)

data class PharmacyUserProfile(
    val name: String,
    val cpfMasked: String,
    val pointsBalance: Int,
    val address: String
)

object PharmacyMockData {
    val defaultUser = PharmacyUserProfile(
        name = "Lucas Ferreira",
        cpfMasked = "342.***.***-18",
        pointsBalance = 680,
        address = "Av. Paulista, 1200 - Bela Vista, SP"
    )

    val sampleProducts = listOf(
        PharmacyProduct(
            id = "1",
            title = "Dipirona Monoidratada 500mg/mL",
            laboratory = "EMS Genéricos",
            presentation = "Gotas Frasco 20mL",
            price = 14.50,
            originalPrice = 19.90,
            pharmacyClientPrice = 9.90,
            stripe = PharmacyMedicineStripe.GENERIC,
            requiresPrescription = false,
            hasSubscription = true
        ),
        PharmacyProduct(
            id = "2",
            title = "Amoxicilina + Clavulanato 875mg",
            laboratory = "Eurofarma",
            presentation = "14 Comprimidos Revestidos",
            price = 54.90,
            originalPrice = 69.90,
            pharmacyClientPrice = 49.90,
            stripe = PharmacyMedicineStripe.RED,
            requiresPrescription = true,
            hasSubscription = false
        ),
        PharmacyProduct(
            id = "3",
            title = "Vitamina C + Zinco Efervescente",
            laboratory = "Redoxon",
            presentation = "30 Comprimidos Efervescentes",
            price = 39.90,
            originalPrice = 48.00,
            pharmacyClientPrice = 32.90,
            stripe = PharmacyMedicineStripe.NONE,
            requiresPrescription = false,
            hasSubscription = true
        ),
        PharmacyProduct(
            id = "4",
            title = "Clonazepam 2mg",
            laboratory = "Medley",
            presentation = "30 Comprimidos",
            price = 18.20,
            pharmacyClientPrice = 13.90,
            stripe = PharmacyMedicineStripe.BLACK,
            requiresPrescription = true,
            hasSubscription = false
        )
    )

    val sampleSubscriptions = listOf(
        PharmacySubscriptionItem(
            id = "sub1",
            medicineName = "Losartana Potássica 50mg",
            frequency = "A cada 30 dias",
            nextDeliveryDate = "05/10/2026",
            price = 18.90
        ),
        PharmacySubscriptionItem(
            id = "sub2",
            medicineName = "Glifage XR 500mg",
            frequency = "A cada 60 dias",
            nextDeliveryDate = "22/10/2026",
            price = 34.50
        )
    )
}
