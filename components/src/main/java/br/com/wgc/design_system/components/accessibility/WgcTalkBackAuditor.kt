package br.com.wgc.design_system.components.accessibility

/**
 * Utilitário de auditoria para inspeção em tempo de execução das propriedades lidas pelo TalkBack.
 */
object WgcTalkBackAuditor {

    data class TalkBackProfile(
        val roleDescription: String,
        val contentDescription: String?,
        val stateDescription: String?,
        val customActions: List<String>
    )

    fun formatAuditionLog(profile: TalkBackProfile): String {
        return buildString {
            append("TalkBack: [Role: ${profile.roleDescription}]")
            if (profile.contentDescription != null) append(" -> '${profile.contentDescription}'")
            if (profile.stateDescription != null) append(" (${profile.stateDescription})")
            if (profile.customActions.isNotEmpty()) append(" | Ações: ${profile.customActions.joinToString(", ")}")
        }
    }
}
