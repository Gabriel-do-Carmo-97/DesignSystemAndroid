package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.EventRepeat
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Spa

/**
 * Presets de itens de navegação para uso imediato com [WgcBottomNavBar].
 * Elimina boilerplate e configurações manuais repetidas para cada vertical.
 */
object WgcNavPresets {

    /** Itens padrão para verticais de Fitness & Treino */
    val fitness: List<WgcNavItem> by lazy {
        listOf(
            WgcNavItem(route = "home", label = "Início", icon = Icons.Default.Home),
            WgcNavItem(route = "workouts", label = "Treinos", icon = Icons.Default.FitnessCenter),
            WgcNavItem(route = "explore", label = "Explorar", icon = Icons.Default.Search),
            WgcNavItem(route = "activity", label = "Atividade", icon = Icons.Default.PlayCircle),
            WgcNavItem(route = "profile", label = "Perfil", icon = Icons.Default.Person)
        )
    }

    /** Itens padrão para verticais de Supermercado & Mercearia */
    val grocery: List<WgcNavItem> by lazy {
        listOf(
            WgcNavItem(route = "home", label = "Início", icon = Icons.Default.Home),
            WgcNavItem(route = "coupons", label = "Cupons", icon = Icons.Default.LocalOffer),
            WgcNavItem(route = "flyer", label = "Folheto", icon = Icons.AutoMirrored.Filled.MenuBook),
            WgcNavItem(route = "cart", label = "Carrinho", icon = Icons.Default.ShoppingCart),
            WgcNavItem(route = "loyalty", label = "Clube", icon = Icons.Default.CreditCard)
        )
    }

    /** Itens padrão para verticais de Farmácia & Saúde */
    val pharmacy: List<WgcNavItem> by lazy {
        listOf(
            WgcNavItem(route = "home", label = "Início", icon = Icons.Default.Home),
            WgcNavItem(route = "repeat", label = "Assinatura", icon = Icons.Default.EventRepeat),
            WgcNavItem(route = "prescriptions", label = "Receitas", icon = Icons.Default.Description),
            WgcNavItem(route = "cart", label = "Carrinho", icon = Icons.Default.ShoppingCart),
            WgcNavItem(route = "profile", label = "Perfil", icon = Icons.Default.Person)
        )
    }

    /** Itens padrão para verticais de E-Commerce & Varejo */
    val ecommerce: List<WgcNavItem> by lazy {
        listOf(
            WgcNavItem(route = "home", label = "Início", icon = Icons.Default.Home),
            WgcNavItem(route = "search", label = "Buscar", icon = Icons.Default.Search),
            WgcNavItem(route = "cart", label = "Carrinho", icon = Icons.Default.ShoppingCart),
            WgcNavItem(route = "favorites", label = "Favoritos", icon = Icons.Default.Favorite),
            WgcNavItem(route = "profile", label = "Perfil", icon = Icons.Default.Person)
        )
    }

    /** Itens padrão para verticais de Finanças Pessoais & Contabilidade */
    val personalFinance: List<WgcNavItem> by lazy {
        listOf(
            WgcNavItem(route = "dashboard", label = "Início", icon = Icons.Default.Home),
            WgcNavItem(route = "transactions", label = "Lançamentos", icon = Icons.AutoMirrored.Filled.List),
            WgcNavItem(route = "reports", label = "Relatórios", icon = Icons.Default.PieChart),
            WgcNavItem(route = "cards", label = "Cartões", icon = Icons.Default.CreditCard)
        )
    }

    /** Itens padrão para verticais de Academia & Esportes */
    val gym: List<WgcNavItem> by lazy {
        listOf(
            WgcNavItem(route = "home", label = "Início", icon = Icons.Default.Home),
            WgcNavItem(route = "workouts", label = "Treinos", icon = Icons.Default.FitnessCenter),
            WgcNavItem(route = "explore", label = "Aulas", icon = Icons.Default.Search),
            WgcNavItem(route = "activity", label = "Histórico", icon = Icons.Default.PlayCircle),
            WgcNavItem(route = "profile", label = "Perfil", icon = Icons.Default.Person)
        )
    }

    /** Itens padrão para verticais de Imóveis & Classificados */
    val realEstate: List<WgcNavItem> by lazy {
        listOf(
            WgcNavItem(route = "search", label = "Buscar", icon = Icons.Default.Search),
            WgcNavItem(route = "favorites", label = "Favoritos", icon = Icons.Default.Favorite),
            WgcNavItem(route = "messages", label = "Mensagens", icon = Icons.Default.ChatBubbleOutline),
            WgcNavItem(route = "profile", label = "Perfil", icon = Icons.Default.Person)
        )
    }

    /** Itens padrão para verticais de Bem-Estar Corporativo */
    val wellness: List<WgcNavItem> by lazy {
        listOf(
            WgcNavItem(route = "home", label = "Início", icon = Icons.Default.Home),
            WgcNavItem(route = "explore", label = "Explorar", icon = Icons.Default.Search),
            WgcNavItem(route = "checkin", label = "Check-in", icon = Icons.Default.CheckCircle),
            WgcNavItem(route = "spa", label = "Terapias", icon = Icons.Default.Spa),
            WgcNavItem(route = "profile", label = "Perfil", icon = Icons.Default.Person)
        )
    }
}
