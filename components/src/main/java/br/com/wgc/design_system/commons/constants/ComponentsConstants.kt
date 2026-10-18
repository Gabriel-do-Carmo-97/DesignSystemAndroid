package br.com.wgc.design_system.commons.constants

/**
 * Central repository of shared constants used by `:components`.
 *
 * Use the nested groups rather than duplicating values for locale/formatting, previews, image
 * processing, interactions, metrics, clipboard, haptics, formatters, and validators.
 */
sealed interface ComponentsConstants {
    /** Locale tags and date-pattern defaults shared by common component utilities. */
    object Commons : ComponentsConstants {
        /** BCP 47 tag used for Brazilian Portuguese conventions. */
        const val PT_BR = "pt-BR"
        /** Default date pattern (`dd/MM/yyyy`) used by [br.com.wgc.design_system.commons.formatters.toFormattedDate]. */
        const val DEFAULT_DATE_PATTERN = "dd/MM/yyyy"
    }

    /** Shared product and brand labels. */
    object Components : ComponentsConstants {
        /** Display name of the design system. */
        const val WGC_DESIGN_SYSTEM = "WGC Design System"
    }

    /** Device specifications and font scales for Android Studio previews. */
    object Previews : ComponentsConstants {
        /** Reference preview width, in dp. */
        const val PREVIEW_WIDTH = 360
        /** Reference preview height, in dp. */
        const val PREVIEW_HEIGHT = 640
        /** Normal preview font scale. */
        const val FONT_SCALE_NORMAL = 1.0f
        /** Enlarged preview font scale for accessibility checks. */
        const val FONT_SCALE_LARGE = 1.5f
        /** Compact phone preview device specification. */
        const val SPEC_PHONE_SMALL = "spec:width=360dp,height=640dp,dpi=320"
        /** Large phone preview device specification. */
        const val SPEC_PHONE_LARGE = "spec:width=411dp,height=891dp,dpi=420"
        /** Seven-inch tablet preview device specification. */
        const val SPEC_TABLET_7_INCH = "spec:width=600dp,height=1024dp,dpi=240"
        /** Ten-inch tablet preview device specification. */
        const val SPEC_TABLET_10_INCH = "spec:width=800dp,height=1280dp,dpi=240"
        /** Standard phone preview device specification. */
        const val SPEC_PHONE = "spec:width=411dp,height=891dp"
        /** Landscape tablet preview device specification. */
        const val SPEC_TABLET_LANDSCAPE = "spec:width=1280dp,height=800dp,dpi=240"
        /** Foldable preview device specification. */
        const val SPEC_FOLDABLE = "spec:width=673dp,height=841dp"
    }

    /** Default image compression limits. Dimensions are in pixels and quality is 0–100. */
    object Image : ComponentsConstants {
        /** Default maximum output image width, in pixels. */
        const val DEFAULT_MAX_WIDTH = 1920
        /** Default maximum output image height, in pixels. */
        const val DEFAULT_MAX_HEIGHT = 1080
        /** Default compression quality passed to bitmap encoders. */
        const val DEFAULT_QUALITY = 80
    }

    /** Timing defaults for debounced modifier interactions. */
    object Modifiers : ComponentsConstants {
        /** Minimum interval between accepted clicks, in milliseconds. */
        const val DEFAULT_DEBOUNCE_TIME_MS: Long = 600L
        /** Initial recorded click time used by the debounce implementation. */
        const val INITIAL_CLICK_TIME_MS: Long = 0L
    }

    /** Appearance and animation defaults for shimmer placeholders. */
    object Shimmer : ComponentsConstants {
        /** Alpha of the brighter shimmer color. */
        const val ALPHA_HIGH = 0.8f
        /** Alpha of the dimmer shimmer color. */
        const val ALPHA_LOW = 0.2f
        /** Multiplier applied to component width to define shimmer travel distance. */
        const val OFFSET_MULTIPLIER = 2
        /** Duration of one shimmer animation cycle, in milliseconds. */
        const val DURATION_MS = 1000
    }

    /** Frame-duration thresholds used by jank monitoring. */
    object Metrics : ComponentsConstants {
        /** Default frame duration threshold for reporting jank, in milliseconds. */
        const val DEFAULT_JANK_THRESHOLD_MS: Long = 16L
        /** Frame duration threshold for classifying a report as frozen, in milliseconds. */
        const val FROZEN_THRESHOLD_MS: Long = 700L
        /** Conversion factor from nanoseconds to milliseconds. */
        const val NANOS_PER_MILLI: Long = 1_000_000L
    }

    /** Clipboard cleanup delays. */
    object Clipboard : ComponentsConstants {
        /** Suggested automatic clipboard cleanup delay, in milliseconds. */
        const val DEFAULT_AUTO_CLEAR_MS: Long = 60_000L
        /** Sentinel delay that disables automatic clipboard cleanup. */
        const val NO_AUTO_CLEAR_MS: Long = 0L
    }

    /** Timing, amplitude, and repetition values for haptic waveforms. */
    object Haptics : ComponentsConstants {
        /** Delay before a haptic waveform begins, in milliseconds. */
        const val INITIAL_DELAY_MS: Long = 0L
        /** Pause between pulses in a haptic waveform, in milliseconds. */
        const val PAUSE_INTERVAL_MS: Long = 40L
        /** Amplitude value representing no vibration in a waveform. */
        const val AMPLITUDE_OFF: Int = 0
        /** Amplitude used for light haptic feedback. */
        const val AMPLITUDE_LIGHT: Int = 100
        /** Amplitude used for a medium-low haptic feedback pulse. */
        const val AMPLITUDE_MEDIUM_LOW: Int = 120
        /** Amplitude used for a medium haptic feedback pulse. */
        const val AMPLITUDE_MEDIUM: Int = 140
        /** Amplitude used for a high haptic feedback pulse. */
        const val AMPLITUDE_HIGH: Int = 180
        /** Maximum supported waveform amplitude. */
        const val AMPLITUDE_MAX: Int = 255
        /** Waveform repeat index that disables repetition. */
        const val WAVEFORM_NO_REPEAT: Int = -1
    }

    /** Digit counts and substring offsets used by Brazilian document/address/phone formatters. */
    object Formatters : ComponentsConstants {
        /** Required digit count for a CPF. */
        const val CPF_LENGTH = 11
        /** Required digit count for a CNPJ. */
        const val CNPJ_LENGTH = 14
        /** Required digit count for a CEP. */
        const val CEP_LENGTH = 8
        /** Digit count for a Brazilian landline number, including DDD. */
        const val PHONE_FIXED_LENGTH = 10
        /** Digit count for a Brazilian mobile number, including DDD. */
        const val PHONE_MOBILE_LENGTH = 11

        /** Start offset of the first CPF group. */
        const val CPF_PART1_START = 0
        /** Exclusive end offset of the first CPF group. */
        const val CPF_PART1_END = 3
        /** Start offset of the second CPF group. */
        const val CPF_PART2_START = 3
        /** Exclusive end offset of the second CPF group. */
        const val CPF_PART2_END = 6
        /** Start offset of the third CPF group. */
        const val CPF_PART3_START = 6
        /** Exclusive end offset of the third CPF group. */
        const val CPF_PART3_END = 9
        /** Start offset of the CPF check digits. */
        const val CPF_PART4_START = 9
        /** Exclusive end offset of the CPF check digits. */
        const val CPF_PART4_END = 11

        /** Start offset of the first CNPJ group. */
        const val CNPJ_PART1_START = 0
        /** Exclusive end offset of the first CNPJ group. */
        const val CNPJ_PART1_END = 2
        /** Start offset of the second CNPJ group. */
        const val CNPJ_PART2_START = 2
        /** Exclusive end offset of the second CNPJ group. */
        const val CNPJ_PART2_END = 5
        /** Start offset of the third CNPJ group. */
        const val CNPJ_PART3_START = 5
        /** Exclusive end offset of the third CNPJ group. */
        const val CNPJ_PART3_END = 8
        /** Start offset of the fourth CNPJ group. */
        const val CNPJ_PART4_START = 8
        /** Exclusive end offset of the fourth CNPJ group. */
        const val CNPJ_PART4_END = 12
        /** Start offset of the CNPJ check digits. */
        const val CNPJ_PART5_START = 12
        /** Exclusive end offset of the CNPJ check digits. */
        const val CNPJ_PART5_END = 14

        /** Start offset of the five-digit CEP prefix. */
        const val CEP_PART1_START = 0
        /** Exclusive end offset of the CEP prefix. */
        const val CEP_PART1_END = 5
        /** Start offset of the three-digit CEP suffix. */
        const val CEP_PART2_START = 5
        /** Exclusive end offset of the CEP suffix. */
        const val CEP_PART2_END = 8

        /** Start offset of the two-digit phone area code (DDD). */
        const val PHONE_DDD_START = 0
        /** Exclusive end offset of the DDD. */
        const val PHONE_DDD_END = 2
        /** Start offset of a landline subscriber prefix. */
        const val PHONE_FIXED_PREFIX_START = 2
        /** Exclusive end offset of a landline subscriber prefix. */
        const val PHONE_FIXED_PREFIX_END = 6
        /** Start offset of a landline subscriber suffix. */
        const val PHONE_FIXED_SUFFIX_START = 6
        /** Exclusive end offset of a landline subscriber suffix. */
        const val PHONE_FIXED_SUFFIX_END = 10

        /** Start offset of a mobile subscriber prefix. */
        const val PHONE_MOBILE_PREFIX_START = 2
        /** Exclusive end offset of a mobile subscriber prefix. */
        const val PHONE_MOBILE_PREFIX_END = 7
        /** Start offset of a mobile subscriber suffix. */
        const val PHONE_MOBILE_SUFFIX_START = 7
        /** Exclusive end offset of a mobile subscriber suffix. */
        const val PHONE_MOBILE_SUFFIX_END = 11
    }

    /** Numeric rules and digit-check parameters used by Brazilian validators. */
    object Validators : ComponentsConstants {
        /** Modulus used to calculate CPF/CNPJ check digits. */
        const val MODULO_BASE = 11
        /** Remainders below this threshold produce a zero check digit. */
        const val DIGIT_TOLERANCE_MIN = 2
        /** Number of CPF digits used to calculate its first check digit. */
        const val CPF_FIRST_DIGIT_FACTORS_COUNT = 9
        /** Initial CPF weight used for its first check digit. */
        const val CPF_FIRST_DIGIT_BASE_WEIGHT = 10
        /** Number of CPF digits used to calculate its second check digit. */
        const val CPF_SECOND_DIGIT_FACTORS_COUNT = 10
        /** Initial CPF weight used for its second check digit. */
        const val CPF_SECOND_DIGIT_BASE_WEIGHT = 11
        /** Index of the first CPF check digit. */
        const val CPF_FIRST_CHECK_INDEX = 9
        /** Index of the second CPF check digit. */
        const val CPF_SECOND_CHECK_INDEX = 10
        /** Number of CNPJ digits used to calculate its first check digit. */
        const val CNPJ_FIRST_DIGIT_FACTORS_COUNT = 12
        /** Number of CNPJ digits used to calculate its second check digit. */
        const val CNPJ_SECOND_DIGIT_FACTORS_COUNT = 13
        /** Index of the first CNPJ check digit. */
        const val CNPJ_FIRST_CHECK_INDEX = 12
        /** Index of the second CNPJ check digit. */
        const val CNPJ_SECOND_CHECK_INDEX = 13
        /** Index of the first phone digit after DDD used for landline/mobile classification. */
        const val PHONE_DDD_VALID_INDEX = 2
        /** Smallest accepted first subscriber digit for a landline. */
        const val PHONE_FIXED_FIRST_DIGIT_MIN = '2'
        /** Largest accepted first subscriber digit for a landline. */
        const val PHONE_FIXED_FIRST_DIGIT_MAX = '5'
        /** Required first subscriber digit for a mobile number. */
        const val PHONE_MOBILE_FIRST_DIGIT = '9'

        /** Pesos usados para calcular o primeiro dígito verificador do CNPJ, na ordem dos dígitos. */
        val CNPJ_WEIGHTS_FIRST = intArrayOf(5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
        /** CNPJ second-check-digit weights, in digit order. */
        val CNPJ_WEIGHTS_SECOND = intArrayOf(6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
    }
}
