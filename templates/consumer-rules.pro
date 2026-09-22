# WGC Design System Templates - Consumer Proguard Rules
-keep class br.com.wgc.design_system.templates.** { *; }
-keepclassmembers class br.com.wgc.design_system.templates.** { *; }

# Preserve Composable Functions and Parameters
-keepclassmembers class * {
    @androidx.compose.runtime.Composable *;
}

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
