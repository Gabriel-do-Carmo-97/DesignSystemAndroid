package br.com.wgc.design_system.components.security

import java.util.Arrays

/**
 * Contêiner de memória segura para senhas e chaves criptográficas com limpeza explícita de memória (zero-allocation).
 */
class WgcSecureString(charArray: CharArray) {

    private val internalChars = charArray.clone()
    private var isWiped = false

    fun getChars(): CharArray {
        check(!isWiped) { "WgcSecureString já foi limpa da memória." }
        return internalChars.clone()
    }

    /**
     * Sobrescreve imediatamente o array de caracteres com zeros na memória.
     */
    fun wipe() {
        if (!isWiped) {
            Arrays.fill(internalChars, '\u0000')
            isWiped = true
        }
    }

    override fun toString(): String {
        return if (isWiped) "[WIPED]" else "[PROTECTED_SECURE_STRING]"
    }
}
