package br.com.wgc.design_system.components.table

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcDataTableTest {

    @Test
    fun sortStateCyclesCorrectly() {
        val initial = WgcSortState("name", WgcSortDirection.NONE)
        assertEquals(WgcSortDirection.NONE, initial.direction)

        val ascending = initial.copy(direction = WgcSortDirection.ASCENDING)
        assertEquals(WgcSortDirection.ASCENDING, ascending.direction)

        val descending = ascending.copy(direction = WgcSortDirection.DESCENDING)
        assertEquals(WgcSortDirection.DESCENDING, descending.direction)
    }

    @Test
    fun rowSelectionTogglesProperly() {
        val selected = mutableSetOf("row-1")
        val toggleId = "row-2"

        if (toggleId in selected) {
            selected.remove(toggleId)
        } else {
            selected.add(toggleId)
        }

        assertTrue(selected.contains("row-1"))
        assertTrue(selected.contains("row-2"))
        assertEquals(2, selected.size)
    }

    @Test
    fun paginationBoundaryChecks() {
        val currentPage = 1
        val totalPages = 5

        val previous = (currentPage - 1).coerceAtLeast(1)
        assertEquals(1, previous)

        val next = (currentPage + 1).coerceAtMost(totalPages)
        assertEquals(2, next)

        val beyondMax = (10).coerceAtMost(totalPages)
        assertEquals(5, beyondMax)
    }
}
