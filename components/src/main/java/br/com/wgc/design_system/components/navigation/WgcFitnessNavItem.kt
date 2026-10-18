package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

enum class WgcFitnessNavItem(val label: String, val icon: ImageVector) {
    HOME("Início", Icons.Default.Home),
    WORKOUTS("Treinos", Icons.Default.FitnessCenter),
    EXPLORE("Explorar", Icons.Default.Search),
    ACTIVITY("Atividade", Icons.Default.PlayCircle),
    PROFILE("Perfil", Icons.Default.Person)
}
