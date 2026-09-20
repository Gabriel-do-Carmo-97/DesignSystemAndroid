package br.com.wgc.design_system.templates.screens.notifications

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class WgcNotificationCenterTemplateTest {

    private lateinit var viewModel: FakeNotificationCenterViewModel

    @Before
    fun setup() {
        viewModel = FakeNotificationCenterViewModel()
    }

    @Test
    fun categorySelection_updatesCategoryInUiState() {
        assertEquals(WgcNotificationCategory.ALL, viewModel.uiState.value.selectedCategory)

        viewModel.onCategorySelected(WgcNotificationCategory.UNREAD)
        assertEquals(WgcNotificationCategory.UNREAD, viewModel.uiState.value.selectedCategory)

        viewModel.onCategorySelected(WgcNotificationCategory.TRANSACTIONAL)
        assertEquals(WgcNotificationCategory.TRANSACTIONAL, viewModel.uiState.value.selectedCategory)
    }

    @Test
    fun notificationClick_marksItemAsRead() {
        val initialItem = viewModel.uiState.value.notifications.first { it.id == "1" }
        assertFalse(initialItem.isRead)

        viewModel.onNotificationClick("1")
        val updatedItem = viewModel.uiState.value.notifications.first { it.id == "1" }
        assertTrue(updatedItem.isRead)
    }

    @Test
    fun markAllAsRead_setsAllNotificationsToRead() {
        viewModel.onMarkAllAsRead()
        assertTrue(viewModel.uiState.value.notifications.all { it.isRead })
    }

    @Test
    fun clearAll_emptiesNotificationsList() {
        viewModel.onClearAll()
        assertTrue(viewModel.uiState.value.notifications.isEmpty())
    }
}
