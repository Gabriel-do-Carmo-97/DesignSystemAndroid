package br.com.wgc.design_system.components.placeholder

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class WgcSkeletonTest {

    @Test
    fun skeletonShapes_containAllExpectedValues() {
        val shapes = WgcSkeletonShape.values()
        assertEquals(3, shapes.size)
        assertNotNull(WgcSkeletonShape.valueOf("BOX"))
        assertNotNull(WgcSkeletonShape.valueOf("CIRCLE"))
        assertNotNull(WgcSkeletonShape.valueOf("ROUNDED"))
    }
}
