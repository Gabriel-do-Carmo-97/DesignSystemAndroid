# WGC Design System Components - Consumer Proguard Rules
-keep class br.com.wgc.design_system.components.** { *; }
-keepclassmembers class br.com.wgc.design_system.components.** { *; }

# Preserve Composable Functions and Parameters
-keepclassmembers class * {
    @androidx.compose.runtime.Composable *;
}

# Preserve Preview Annotations
-dontwarn androidx.compose.ui.tooling.preview.**
-keep @interface androidx.compose.ui.tooling.preview.** { *; }

# Coil 3 Image Loading
-keep class coil3.** { *; }
-dontwarn coil3.**

# Kotlinx Serialization
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.SerializationKt
-keepclassmembers class * {
    *** Companion;
}
-keepclasseswithmembers class * {
    kotlinx.serialization.KSerializer serializer(...);
}
