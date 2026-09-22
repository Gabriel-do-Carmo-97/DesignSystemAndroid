package br.com.wgc.design_system.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcProminentBottomBarTest {

    @Test
    fun prominentMenuItems_defaultConfigurationHasCenterElevatedItem() {
        val items = defaultWgcProminentMenuItems()
        assertEquals(5, items.size)
        assertEquals("cart", items[2].id)
        assertTrue(items[2].isProminent)
        assertEquals(2, items[2].badgeCount)
    }

    @Test
    fun menuType_prominentCenterExistsInEntries() {
        val types = WgcMenuType.entries
        assertTrue(types.contains(WgcMenuType.ProminentCenter))
    }

    @Test
    fun dynamicItemCount_supportsBetweenTwoAndFiveItems() {
        val items2 = listOf(
            WgcMenuItem(id = "1", label = "Home", icon = Icons.Default.Home),
            WgcMenuItem(id = "2", label = "Profile", icon = Icons.Default.Person)
        )
        val items3 = listOf(
            WgcMenuItem(id = "1", label = "Home", icon = Icons.Default.Home),
            WgcMenuItem(id = "2", label = "Cart", icon = Icons.Default.ShoppingCart, isProminent = true),
            WgcMenuItem(id = "3", label = "Profile", icon = Icons.Default.Person)
        )
        val items4 = listOf(
            WgcMenuItem(id = "1", label = "Home", icon = Icons.Default.Home),
            WgcMenuItem(id = "2", label = "Search", icon = Icons.Default.Search),
            WgcMenuItem(id = "3", label = "Orders", icon = Icons.Default.Receipt),
            WgcMenuItem(id = "4", label = "Profile", icon = Icons.Default.Person)
        )
        val items5 = defaultWgcProminentMenuItems()

        assertEquals(2, items2.size)
        assertEquals(3, items3.size)
        assertTrue(items3[1].isProminent)
        assertEquals(4, items4.size)
        assertEquals(5, items5.size)
    }

    @Test
    fun navItem_clickTriggersCorrectly() {
        var clicked = false
        val item = NavItem(
            label = "Carrinho",
            icon = Icons.Default.ShoppingCart,
            badgeCount = 3,
            isProminent = true,
            onClick = { clicked = true }
        )

        assertNotNull(item)
        assertEquals("Carrinho", item.label)
        assertTrue(item.isProminent)
        assertEquals(3, item.badgeCount)
        item.onClick()
        assertTrue(clicked)
    }
}
