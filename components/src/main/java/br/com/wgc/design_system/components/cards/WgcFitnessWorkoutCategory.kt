package br.com.wgc.design_system.components.cards

import br.com.wgc.design_system.core.theme.WgcCoreDsColors

enum class WgcFitnessWorkoutCategory(val label: String, val colorHex: Int) {
    HIIT("HIIT", WgcCoreDsColors.orange500),
    STRENGTH("FORÇA", WgcCoreDsColors.green28),
    YOGA("YOGA", WgcCoreDsColors.blue30),
    MOBILITY("MOBILIDADE", WgcCoreDsColors.purple5),
    ENDURANCE("RESISTÊNCIA", WgcCoreDsColors.green28)
}
