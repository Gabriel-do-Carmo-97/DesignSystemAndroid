# WGC Design System Navigation Flows - Consumer Proguard Rules
-keep class br.com.wgc.design_system.navigation.** { *; }
-keepclassmembers class br.com.wgc.design_system.navigation.** { *; }

# Navigation Compose & Routes
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.SerializationKt
-keepclassmembers class * {
    *** Companion;
}
-keepclasseswithmembers class * {
    kotlinx.serialization.KSerializer serializer(...);
}
