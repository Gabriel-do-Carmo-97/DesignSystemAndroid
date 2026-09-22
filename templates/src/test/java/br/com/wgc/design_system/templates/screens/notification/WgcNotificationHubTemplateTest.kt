package br.com.wgc.design_system.templates.screens.notification

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcNotificationHubTemplateTest {

    @Test
    fun `unread count is calculated accurately`() {
        val state = WgcNotificationHubUiState(
            notifications = listOf(
                WgcNotificationItem(id = "1", title = "T1", message = "M1", timestamp = "Now", isRead = false),
                WgcNotificationItem(id = "2", title = "T2", message = "M2", timestamp = "Now", isRead = true),
                WgcNotificationItem(id = "3", title = "T3", message = "M3", timestamp = "Now", isRead = false)
            )
        )
        assertEquals(2, state.unreadCount)
    }

    @Test
    fun `mark as read updates specific notification item`() {
        val viewModel = FakeNotificationHubViewModel()
        viewModel.onMarkAsRead("notif-1")

        val target = viewModel.uiState.value.notifications.find { it.id == "notif-1" }
        assertTrue(target?.isRead == true)
    }

    @Test
    fun `mark all as read sets all to true`() {
        val viewModel = FakeNotificationHubViewModel()
        viewModel.onMarkAllAsRead()

        val allRead = viewModel.uiState.value.notifications.all { it.isRead }
        assertTrue(allRead)
        assertEquals(0, viewModel.uiState.value.unreadCount)
    }

    @Test
    fun `delete notification removes item from list`() {
        val viewModel = FakeNotificationHubViewModel()
        val initialSize = viewModel.uiState.value.notifications.size

        viewModel.onDeleteNotification("notif-1")
        assertEquals(initialSize - 1, viewModel.uiState.value.notifications.size)
    }
}
