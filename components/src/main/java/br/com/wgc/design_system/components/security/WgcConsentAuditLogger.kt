package br.com.wgc.design_system.components.security

import java.security.MessageDigest

/**
 * Registrador de auditoria de consentimento de privacidade com assinatura digital imutável SHA-256.
 */
object WgcConsentAuditLogger {

    data class ConsentAuditRecord(
        val userId: String,
        val consentVersion: String,
        val acceptedCategories: List<String>,
        val timestampEpoch: Long,
        val integrityHash: String
    )

    fun createRecord(
        userId: String,
        consentVersion: String,
        categories: List<String>
    ): ConsentAuditRecord {
        val timestamp = System.currentTimeMillis()
        val rawPayload = "$userId|$consentVersion|${categories.sorted().joinToString(",")}|$timestamp"
        val hash = sha256(rawPayload)
        return ConsentAuditRecord(userId, consentVersion, categories, timestamp, hash)
    }

    private fun sha256(input: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }
}
