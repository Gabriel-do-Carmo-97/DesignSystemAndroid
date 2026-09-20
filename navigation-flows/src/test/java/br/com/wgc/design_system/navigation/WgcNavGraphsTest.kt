package br.com.wgc.design_system.navigation

import br.com.wgc.design_system.navigation.search.WgcSearchGraphRoute
import br.com.wgc.design_system.navigation.search.WgcSearchMainRoute
import br.com.wgc.design_system.navigation.search.WgcSearchResultDetailRoute
import br.com.wgc.design_system.navigation.settings.WgcSettingsGraphRoute
import br.com.wgc.design_system.navigation.settings.WgcSettingsOverviewRoute
import br.com.wgc.design_system.navigation.settings.WgcSettingsPreferencesRoute
import br.com.wgc.design_system.navigation.settings.WgcSettingsSecurityRoute
import br.com.wgc.design_system.navigation.settings.WgcSettingsTermsRoute
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class WgcNavGraphsTest {

    @Test
    fun `search nav graph routes should instantiate correctly`() {
        assertNotNull(WgcSearchGraphRoute)
        assertNotNull(WgcSearchMainRoute)

        val detailRoute = WgcSearchResultDetailRoute(
            itemId = "item-999",
            itemTitle = "Produto Teste",
            itemPrice = "R$ 99,90"
        )
        assertEquals("item-999", detailRoute.itemId)
        assertEquals("Produto Teste", detailRoute.itemTitle)
        assertEquals("R$ 99,90", detailRoute.itemPrice)
    }

    @Test
    fun `settings nav graph routes should instantiate correctly`() {
        assertNotNull(WgcSettingsGraphRoute)
        assertNotNull(WgcSettingsOverviewRoute)
        assertNotNull(WgcSettingsSecurityRoute)
        assertNotNull(WgcSettingsPreferencesRoute)
        assertNotNull(WgcSettingsTermsRoute)
    }

    @Test
    fun `notifications nav graph routes should instantiate correctly`() {
        assertNotNull(br.com.wgc.design_system.navigation.notifications.NotificationsRoute.List)
        val detail = br.com.wgc.design_system.navigation.notifications.NotificationsRoute.Detail("notif-123")
        assertEquals("notif-123", detail.notificationId)
    }

    @Test
    fun `profile nav graph routes should instantiate correctly`() {
        assertNotNull(br.com.wgc.design_system.navigation.profile.ProfileRoute.View)
        assertNotNull(br.com.wgc.design_system.navigation.profile.ProfileRoute.Edit)
        assertNotNull(br.com.wgc.design_system.navigation.profile.ProfileRoute.Security)
    }
}
