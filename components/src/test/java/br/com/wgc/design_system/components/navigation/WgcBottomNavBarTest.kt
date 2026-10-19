package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcBottomNavBarTest {

    @Test
    fun wgcNavItem_defaultProperties() {
        val item = WgcNavItem(
            route = "home",
            label = "Início",
            icon = Icons.Default.Home
        )

        assertEquals("home", item.route)
        assertEquals("Início", item.label)
        assertEquals(Icons.Default.Home, item.icon)
        assertEquals(Icons.Default.Home, item.selectedIcon)
        assertNull(item.badgeCount)
    }

    @Test
    fun wgcNavItem_customPropertiesAndClick() {
        var clicked = false
        val item = WgcNavItem(
            route = "profile",
            label = "Perfil",
            icon = Icons.Default.Person,
            badgeCount = 5,
            onClick = { clicked = true }
        )

        assertEquals("profile", item.route)
        assertEquals(5, item.badgeCount)
        item.onClick?.invoke()
        assertTrue(clicked)
    }

    @Test
    fun wgcNavPresets_allPresetsNonEmpty() {
        assertTrue(WgcNavPresets.fitness.isNotEmpty())
        assertTrue(WgcNavPresets.grocery.isNotEmpty())
        assertTrue(WgcNavPresets.pharmacy.isNotEmpty())
        assertTrue(WgcNavPresets.ecommerce.isNotEmpty())
        assertTrue(WgcNavPresets.personalFinance.isNotEmpty())
        assertTrue(WgcNavPresets.gym.isNotEmpty())
        assertTrue(WgcNavPresets.realEstate.isNotEmpty())
        assertTrue(WgcNavPresets.wellness.isNotEmpty())
    }

    @Test
    fun wgcNavPresets_fitnessPresetsHaveValidRoutes() {
        val fitness = WgcNavPresets.fitness
        assertEquals(5, fitness.size)
        assertEquals("home", fitness[0].route)
        assertEquals("workouts", fitness[1].route)
        assertEquals("explore", fitness[2].route)
        assertEquals("activity", fitness[3].route)
        assertEquals("profile", fitness[4].route)
    }

    @Test
    fun wgcNavPresets_personalFinancePresetsHaveValidRoutes() {
        val finance = WgcNavPresets.personalFinance
        assertEquals(4, finance.size)
        assertEquals("dashboard", finance[0].route)
        assertEquals("transactions", finance[1].route)
        assertEquals("reports", finance[2].route)
        assertEquals("cards", finance[3].route)
    }
}
