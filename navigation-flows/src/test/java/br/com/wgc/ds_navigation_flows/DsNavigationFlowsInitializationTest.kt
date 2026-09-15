package br.com.wgc.ds_navigation_flows

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class DsNavigationFlowsInitializationTest {

    @Test
    fun moduleInfo_returnsCorrectModuleName() {
        assertEquals("ds-navigation-flows", WgcNavigationFlowsInfo.MODULE_NAME)
    }

    @Test
    fun moduleInfo_returnsNonNullVersion() {
        assertNotNull(WgcNavigationFlowsInfo.VERSION)
    }
}
