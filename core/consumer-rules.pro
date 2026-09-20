# WGC Design System Core - Consumer Proguard Rules
-keep class br.com.wgc.design_system.core.** { *; }
-keepclassmembers class br.com.wgc.design_system.core.** { *; }

# Legacy Facade Compatibility
-keep class br.com.wgc.core_ds.** { *; }
-keepclassmembers class br.com.wgc.core_ds.** { *; }
