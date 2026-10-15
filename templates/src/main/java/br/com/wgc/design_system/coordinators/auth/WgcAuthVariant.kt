package br.com.wgc.design_system.coordinators.auth

import br.com.wgc.design_system.factories.auth.WgcLoginVariant
import br.com.wgc.design_system.factories.auth.WgcOtpVariant
import br.com.wgc.design_system.factories.auth.WgcRegisterVariant
import br.com.wgc.design_system.factories.auth.WgcResetPasswordVariant

/**
 * Variantes de Fluxo de Autenticação suportadas pelo WGC Design System.
 */
enum class WgcAuthVariant {
    STANDARD,
    BIOMETRIC,
    FOOD_DELIVERY,
    RIDE_HAILING,
    MARKETPLACE,
    GYM_FITNESS,
    TELEMEDICINE,
    DENTAL,
    FINTECH_NEOBANK,
    PHARMACY_CHAIN,
    FRESH_GROCERY,
    PET_CARE;

    fun toLoginVariant(): WgcLoginVariant = when (this) {
        STANDARD -> WgcLoginVariant.STANDARD
        BIOMETRIC -> WgcLoginVariant.BIOMETRIC
        FOOD_DELIVERY -> WgcLoginVariant.FOOD_DELIVERY
        RIDE_HAILING -> WgcLoginVariant.RIDE_HAILING
        MARKETPLACE -> WgcLoginVariant.MARKETPLACE
        GYM_FITNESS -> WgcLoginVariant.GYM_FITNESS
        TELEMEDICINE -> WgcLoginVariant.TELEMEDICINE
        DENTAL -> WgcLoginVariant.DENTAL
        FINTECH_NEOBANK -> WgcLoginVariant.FINTECH_NEOBANK
        PHARMACY_CHAIN -> WgcLoginVariant.PHARMACY_CHAIN
        FRESH_GROCERY -> WgcLoginVariant.FRESH_GROCERY
        PET_CARE -> WgcLoginVariant.PET_CARE
    }

    fun toRegisterVariant(): WgcRegisterVariant = when (this) {
        STANDARD, BIOMETRIC -> WgcRegisterVariant.STANDARD
        FOOD_DELIVERY -> WgcRegisterVariant.FOOD_DELIVERY
        RIDE_HAILING -> WgcRegisterVariant.RIDE_HAILING
        MARKETPLACE -> WgcRegisterVariant.MARKETPLACE
        GYM_FITNESS -> WgcRegisterVariant.GYM_FITNESS
        TELEMEDICINE -> WgcRegisterVariant.TELEMEDICINE
        DENTAL -> WgcRegisterVariant.DENTAL
        FINTECH_NEOBANK -> WgcRegisterVariant.FINTECH_NEOBANK
        PHARMACY_CHAIN -> WgcRegisterVariant.PHARMACY_CHAIN
        FRESH_GROCERY -> WgcRegisterVariant.FRESH_GROCERY
        PET_CARE -> WgcRegisterVariant.PET_CARE
    }

    fun toResetPasswordVariant(): WgcResetPasswordVariant = when (this) {
        STANDARD, BIOMETRIC -> WgcResetPasswordVariant.STANDARD
        FOOD_DELIVERY -> WgcResetPasswordVariant.FOOD_DELIVERY
        RIDE_HAILING -> WgcResetPasswordVariant.RIDE_HAILING
        MARKETPLACE -> WgcResetPasswordVariant.MARKETPLACE
        GYM_FITNESS -> WgcResetPasswordVariant.GYM_FITNESS
        TELEMEDICINE -> WgcResetPasswordVariant.TELEMEDICINE
        DENTAL -> WgcResetPasswordVariant.STANDARD
        FINTECH_NEOBANK -> WgcResetPasswordVariant.FINTECH_NEOBANK
        PHARMACY_CHAIN -> WgcResetPasswordVariant.STANDARD
        FRESH_GROCERY -> WgcResetPasswordVariant.STANDARD
        PET_CARE -> WgcResetPasswordVariant.STANDARD
    }

    fun toOtpVariant(): WgcOtpVariant = when (this) {
        STANDARD, BIOMETRIC -> WgcOtpVariant.STANDARD
        FOOD_DELIVERY -> WgcOtpVariant.FOOD_DELIVERY
        RIDE_HAILING -> WgcOtpVariant.RIDE_HAILING
        MARKETPLACE -> WgcOtpVariant.MARKETPLACE
        GYM_FITNESS -> WgcOtpVariant.GYM_FITNESS
        TELEMEDICINE -> WgcOtpVariant.TELEMEDICINE
        DENTAL -> WgcOtpVariant.STANDARD
        FINTECH_NEOBANK -> WgcOtpVariant.FINTECH_NEOBANK
        PHARMACY_CHAIN -> WgcOtpVariant.STANDARD
        FRESH_GROCERY -> WgcOtpVariant.STANDARD
        PET_CARE -> WgcOtpVariant.STANDARD
    }
}
