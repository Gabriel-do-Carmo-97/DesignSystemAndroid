package br.com.wgc.design_system.navigation

import br.com.wgc.design_system.navigation.deeplink.WgcDeepLinkHandler
import br.com.wgc.design_system.navigation.guard.WgcAuthGuard
import br.com.wgc.design_system.navigation.guard.WgcBiometricGuard
import br.com.wgc.design_system.navigation.guard.WgcKycGuard
import br.com.wgc.design_system.navigation.help.WgcHelpCenterFaqDetailRoute
import br.com.wgc.design_system.navigation.help.WgcHelpCenterGraphRoute
import br.com.wgc.design_system.navigation.help.WgcHelpCenterHomeRoute
import br.com.wgc.design_system.navigation.help.WgcHelpCenterTicketDetailRoute
import br.com.wgc.design_system.navigation.review.WgcReviewFormRoute
import br.com.wgc.design_system.navigation.review.WgcReviewGraphRoute
import br.com.wgc.design_system.navigation.card.WgcCardGraphRoute
import br.com.wgc.design_system.navigation.card.WgcCardHomeRoute
import br.com.wgc.design_system.navigation.loan.WgcLoanGraphRoute
import br.com.wgc.design_system.navigation.loan.WgcLoanHomeRoute
import br.com.wgc.design_system.navigation.pix.WgcPixGraphRoute
import br.com.wgc.design_system.navigation.pix.WgcPixHomeRoute
import br.com.wgc.design_system.navigation.statement.WgcStatementDetailRoute
import br.com.wgc.design_system.navigation.statement.WgcStatementGraphRoute
import br.com.wgc.design_system.navigation.statement.WgcStatementHomeRoute
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class WgcNewNavGraphsTest {

    @Test
    fun `help center routes instantiate correctly`() {
        assertNotNull(WgcHelpCenterGraphRoute)
        assertNotNull(WgcHelpCenterHomeRoute)
        val faq = WgcHelpCenterFaqDetailRoute("faq-1", "Como pagar?", "Use PIX")
        assertEquals("faq-1", faq.faqId)
        assertEquals("Como pagar?", faq.question)
        assertEquals("Use PIX", faq.answer)

        val ticket = WgcHelpCenterTicketDetailRoute("ticket-99")
        assertEquals("ticket-99", ticket.ticketId)
    }

    @Test
    fun `statement routes instantiate correctly`() {
        assertNotNull(WgcStatementGraphRoute)
        assertNotNull(WgcStatementHomeRoute)
        val detail = WgcStatementDetailRoute(
            transactionId = "tx-123",
            title = "Supermercado",
            amount = "- R$ 150,00",
            isCredit = false,
            date = "Hoje, 10:00"
        )
        assertEquals("tx-123", detail.transactionId)
        assertEquals("Supermercado", detail.title)
        assertEquals("- R$ 150,00", detail.amount)
        assertFalse(detail.isCredit)
    }

    @Test
    fun `review routes instantiate correctly`() {
        assertNotNull(WgcReviewGraphRoute)
        val form = WgcReviewFormRoute(orderId = "1010", productName = "Notebook Pro")
        assertEquals("1010", form.orderId)
        assertEquals("Notebook Pro", form.productName)
    }

    @Test
    fun `deeplink handler parses custom scheme uris correctly`() {
        val statement = WgcDeepLinkHandler.parseUri("wgc://statement")
        assertEquals(WgcStatementHomeRoute, statement)

        val statementDetail = WgcDeepLinkHandler.parseUri("wgc://statement/tx-789")
        assertTrue(statementDetail is WgcStatementDetailRoute)
        assertEquals("tx-789", (statementDetail as WgcStatementDetailRoute).transactionId)

        val help = WgcDeepLinkHandler.parseUri("wgc://help")
        assertEquals(WgcHelpCenterHomeRoute, help)

        val faq = WgcDeepLinkHandler.parseUri("wgc://help/faq/faq-42")
        assertTrue(faq is WgcHelpCenterFaqDetailRoute)
        assertEquals("faq-42", (faq as WgcHelpCenterFaqDetailRoute).faqId)

        val review = WgcDeepLinkHandler.parseUri("wgc://review/999")
        assertTrue(review is WgcReviewFormRoute)
        assertEquals("999", (review as WgcReviewFormRoute).orderId)
    }

    @Test
    fun `deeplink handler creates correct uri strings`() {
        assertEquals("wgc://statement", WgcDeepLinkHandler.createDeepLink(WgcStatementHomeRoute))
        assertEquals("wgc://statement/tx-1", WgcDeepLinkHandler.createDeepLink(WgcStatementDetailRoute("tx-1")))
        assertEquals("wgc://help", WgcDeepLinkHandler.createDeepLink(WgcHelpCenterHomeRoute))
        assertEquals("wgc://help/faq/f-1", WgcDeepLinkHandler.createDeepLink(WgcHelpCenterFaqDetailRoute("f-1")))
        assertEquals("wgc://review/888", WgcDeepLinkHandler.createDeepLink(WgcReviewFormRoute("888")))
        assertEquals("wgc://pix", WgcDeepLinkHandler.createDeepLink(WgcPixHomeRoute))
        assertEquals("wgc://card", WgcDeepLinkHandler.createDeepLink(WgcCardHomeRoute))
        assertEquals("wgc://loan", WgcDeepLinkHandler.createDeepLink(WgcLoanHomeRoute))
    }

    @Test
    fun `pix routes and deeplinks resolve correctly`() {
        assertNotNull(WgcPixGraphRoute)
        assertEquals(WgcPixHomeRoute, WgcDeepLinkHandler.parseUri("wgc://pix"))
    }

    @Test
    fun `card routes and deeplinks resolve correctly`() {
        assertNotNull(WgcCardGraphRoute)
        assertEquals(WgcCardHomeRoute, WgcDeepLinkHandler.parseUri("wgc://card"))
    }

    @Test
    fun `loan routes and deeplinks resolve correctly`() {
        assertNotNull(WgcLoanGraphRoute)
        assertEquals(WgcLoanHomeRoute, WgcDeepLinkHandler.parseUri("wgc://loan"))
    }

    @Test
    fun `route guards correctly evaluate and provide fallback`() {
        var isAuth = false
        val authGuard = WgcAuthGuard(isAuthenticated = { isAuth }, fallbackRoute = "login")
        assertFalse(authGuard.canNavigate("target"))
        assertEquals("login", authGuard.fallbackRoute)

        isAuth = true
        assertTrue(authGuard.canNavigate("target"))

        var isBio = false
        val bioGuard = WgcBiometricGuard(isBiometricUnlocked = { isBio }, fallbackRoute = "biometric")
        assertFalse(bioGuard.canNavigate("target"))
        isBio = true
        assertTrue(bioGuard.canNavigate("target"))

        var isKyc = false
        val kycGuard = WgcKycGuard(isKycVerified = { isKyc }, fallbackRoute = "kyc")
        assertFalse(kycGuard.canNavigate("target"))
        isKyc = true
        assertTrue(kycGuard.canNavigate("target"))
    }
}
