package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.EventNote
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Itens de navegação inferior do Gym & Fitness.
 */
enum class WgcGymFitnessNavItem(val label: String, val icon: ImageVector) {
    HOME("Início", Icons.Default.Home),
    WORKOUTS("Treinos", Icons.Default.FitnessCenter),
    CLASSES("Aulas", Icons.AutoMirrored.Filled.EventNote),
    GO("Gym & Fitness GO", Icons.Default.PlayCircle),
    PROFILE("Acesso", Icons.Default.Person)
}
