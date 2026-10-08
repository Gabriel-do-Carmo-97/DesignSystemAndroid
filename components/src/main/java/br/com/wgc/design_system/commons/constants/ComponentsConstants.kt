package br.com.wgc.design_system.commons.constants

sealed interface ComponentsConstants {
    object Commons : ComponentsConstants {
        const val PT_BR = "pt-BR"
        const val DEFAULT_DATE_PATTERN = "dd/MM/yyyy"
    }

    object Components : ComponentsConstants {
        const val WGC_DESIGN_SYSTEM = "WGC Design System"
    }

    object Previews : ComponentsConstants {
        const val PREVIEW_WIDTH = 360
        const val PREVIEW_HEIGHT = 640
        const val FONT_SCALE_NORMAL = 1.0f
        const val FONT_SCALE_LARGE = 1.5f
        const val SPEC_PHONE_SMALL = "spec:width=360dp,height=640dp,dpi=320"
        const val SPEC_PHONE_LARGE = "spec:width=411dp,height=891dp,dpi=420"
        const val SPEC_TABLET_7_INCH = "spec:width=600dp,height=1024dp,dpi=240"
        const val SPEC_TABLET_10_INCH = "spec:width=800dp,height=1280dp,dpi=240"
        const val SPEC_PHONE = "spec:width=411dp,height=891dp"
        const val SPEC_TABLET_LANDSCAPE = "spec:width=1280dp,height=800dp,dpi=240"
        const val SPEC_FOLDABLE = "spec:width=673dp,height=841dp"
    }

    object Image : ComponentsConstants {
        const val DEFAULT_MAX_WIDTH = 1920
        const val DEFAULT_MAX_HEIGHT = 1080
        const val DEFAULT_QUALITY = 80
    }

    object Modifiers : ComponentsConstants {
        const val DEFAULT_DEBOUNCE_TIME_MS: Long = 600L
        const val INITIAL_CLICK_TIME_MS: Long = 0L
    }

    object Shimmer : ComponentsConstants {
        const val ALPHA_HIGH = 0.8f
        const val ALPHA_LOW = 0.2f
        const val OFFSET_MULTIPLIER = 2
        const val DURATION_MS = 1000
    }

    object Metrics : ComponentsConstants {
        const val DEFAULT_JANK_THRESHOLD_MS: Long = 16L
        const val FROZEN_THRESHOLD_MS: Long = 700L
        const val NANOS_PER_MILLI: Long = 1_000_000L
    }

    object Clipboard : ComponentsConstants {
        const val DEFAULT_AUTO_CLEAR_MS: Long = 60_000L
        const val NO_AUTO_CLEAR_MS: Long = 0L
    }

    object Haptics : ComponentsConstants {
        const val INITIAL_DELAY_MS: Long = 0L
        const val PAUSE_INTERVAL_MS: Long = 40L
        const val AMPLITUDE_OFF: Int = 0
        const val AMPLITUDE_LIGHT: Int = 100
        const val AMPLITUDE_MEDIUM_LOW: Int = 120
        const val AMPLITUDE_MEDIUM: Int = 140
        const val AMPLITUDE_HIGH: Int = 180
        const val AMPLITUDE_MAX: Int = 255
        const val WAVEFORM_NO_REPEAT: Int = -1
    }

    object Formatters : ComponentsConstants {
        const val CPF_LENGTH = 11
        const val CNPJ_LENGTH = 14
        const val CEP_LENGTH = 8
        const val PHONE_FIXED_LENGTH = 10
        const val PHONE_MOBILE_LENGTH = 11

        const val CPF_PART1_START = 0
        const val CPF_PART1_END = 3
        const val CPF_PART2_START = 3
        const val CPF_PART2_END = 6
        const val CPF_PART3_START = 6
        const val CPF_PART3_END = 9
        const val CPF_PART4_START = 9
        const val CPF_PART4_END = 11

        const val CNPJ_PART1_START = 0
        const val CNPJ_PART1_END = 2
        const val CNPJ_PART2_START = 2
        const val CNPJ_PART2_END = 5
        const val CNPJ_PART3_START = 5
        const val CNPJ_PART3_END = 8
        const val CNPJ_PART4_START = 8
        const val CNPJ_PART4_END = 12
        const val CNPJ_PART5_START = 12
        const val CNPJ_PART5_END = 14

        const val CEP_PART1_START = 0
        const val CEP_PART1_END = 5
        const val CEP_PART2_START = 5
        const val CEP_PART2_END = 8

        const val PHONE_DDD_START = 0
        const val PHONE_DDD_END = 2
        const val PHONE_FIXED_PREFIX_START = 2
        const val PHONE_FIXED_PREFIX_END = 6
        const val PHONE_FIXED_SUFFIX_START = 6
        const val PHONE_FIXED_SUFFIX_END = 10

        const val PHONE_MOBILE_PREFIX_START = 2
        const val PHONE_MOBILE_PREFIX_END = 7
        const val PHONE_MOBILE_SUFFIX_START = 7
        const val PHONE_MOBILE_SUFFIX_END = 11
    }

    object Validators : ComponentsConstants {
        const val MODULO_BASE = 11
        const val DIGIT_TOLERANCE_MIN = 2
        const val CPF_FIRST_DIGIT_FACTORS_COUNT = 9
        const val CPF_FIRST_DIGIT_BASE_WEIGHT = 10
        const val CPF_SECOND_DIGIT_FACTORS_COUNT = 10
        const val CPF_SECOND_DIGIT_BASE_WEIGHT = 11
        const val CPF_FIRST_CHECK_INDEX = 9
        const val CPF_SECOND_CHECK_INDEX = 10
        const val CNPJ_FIRST_DIGIT_FACTORS_COUNT = 12
        const val CNPJ_SECOND_DIGIT_FACTORS_COUNT = 13
        const val CNPJ_FIRST_CHECK_INDEX = 12
        const val CNPJ_SECOND_CHECK_INDEX = 13
        const val PHONE_DDD_VALID_INDEX = 2
        const val PHONE_FIXED_FIRST_DIGIT_MIN = '2'
        const val PHONE_FIXED_FIRST_DIGIT_MAX = '5'
        const val PHONE_MOBILE_FIRST_DIGIT = '9'

        val CNPJ_WEIGHTS_FIRST = intArrayOf(5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
        val CNPJ_WEIGHTS_SECOND = intArrayOf(6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2)
    }
}
