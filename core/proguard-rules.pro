# Design System WGC - Core Module ProGuard Rules
# Regras de obfuscação e otimização para o módulo core

# Mantém classes públicas do design system
-keep public class br.com.wgc.design_system.core.** {
    public *;
}

# Mantém objetos singleton (object declarations)
-keep public class br.com.wgc.design_system.core.WgcCoreDsSpacing { *; }
-keep public class br.com.wgc.design_system.core.WgcCoreDsBorderRadius { *; }
-keep public class br.com.wgc.design_system.core.WgcCoreDsSize { *; }
-keep public class br.com.wgc.design_system.core.WgcCoreDsTypography { *; }
-keep public class br.com.wgc.design_system.core.WgcCoreDsElevation { *; }
-keep public class br.com.wgc.design_system.core.WgcCoreDsMotion { *; }
-keep public class br.com.wgc.design_system.core.WgcCoreDsOpacity { *; }
-keep public class br.com.wgc.design_system.core.WgcCoreDsBreakpoints { *; }

# Mantém classes de cores
-keep public class br.com.wgc.design_system.core.WgcCoreDsColorsFacade { *; }
-keep public class br.com.wgc.design_system.core.colors.** { *; }
-keep public class br.com.wgc.design_system.core.colors.brands.** { *; }

# Mantém interfaces de tema
-keep public class br.com.wgc.design_system.core.WgcThemeTokens { *; }
-keep public class br.com.wgc.design_system.core.DefaultWgcThemeTokens { *; }

# Mantém constantes de design tokens
-keepclassmembers class br.com.wgc.design_system.core.** {
    public static final **;
}

# Preserva enums de design tokens
-keepclassmembers enum br.com.wgc.design_system.core.** {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Mantém métodos que podem ser chamados via reflexão
-keepclassmembers class br.com.wgc.design_system.core.** {
    @androidx.annotation.Keep *;
}

# Preserva métodos de extensão Kotlin
-keepclassmembers class br.com.wgc.design_system.core.**$** {
    public static **;
}

# Preserva propriedades delegadas Kotlin
-keepclassmembers class br.com.wgc.design_system.core.** {
    public ** getValue(...);
    public ** setValue(...);
}

# Preserva classes de dados Kotlin
-keep @androidx.annotation.Keep class br.com.wgc.design_system.core.** {
    *;
}

# Preserva serialização Kotlin
-keepclassmembers class br.com.wgc.design_system.core.** implements kotlinx.serialization.Serializable {
    public static ** serializer();
}

# Preserva métodos nativos (se houver)
-keepclasseswithmembernames class br.com.wgc.design_system.core.** {
    native <methods>;
}

# Preserva classes aninhadas públicas
-keep public class br.com.wgc.design_system.core.**$** {
    public *;
}

# Preserva setters/getters de propriedades Kotlin
-keepclassmembers class br.com.wgc.design_system.core.** {
    public void set*(***);
    public *** get*();
    public *** is*();
}

# Preserva construtores públicos
-keepclassmembers class br.com.wgc.design_system.core.** {
    public <init>(...);
}

# Preserva métodos com anotações específicas
-keep @androidx.annotation.NonNull class br.com.wgc.design_system.core.** { *; }
-keep @androidx.annotation.Nullable class br.com.wgc.design_system.core.** { *; }

# Preserva métodos usados em reflection por bibliotecas externas
-keepclassmembers class br.com.wgc.design_system.core.** {
    @com.google.gson.annotations.SerializedName <fields>;
    @com.google.gson.annotations.Expose <fields>;
}

# Preserva métodos de callback
-keepclassmembers class br.com.wgc.design_system.core.** {
    public void on*(...);
}

# Preserva classes com nomes específicos (para compatibilidade)
-keep class br.com.wgc.core_ds.** { *; }

# Preserva recursos de strings usados em reflection
-keepclassmembers class br.com.wgc.design_system.core.R$* {
    public static <fields>;
}

# Preserva métodos de teste (não aplicável em release, mas mantém consistência)
-keep class br.com.wgc.design_system.core.** {
    public void test*(...);
}

# Preserva métodos debug (se houver)
-keepclassmembers class br.com.wgc.design_system.core.** {
    public void debug*(...);
}

# Optimizações específicas para design tokens
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose

# Preserva números de linha para debugging
-keepattributes SourceFile,LineNumberTable

# Preserva atributos de assinatura
-keepattributes Signature

# Preserva atributos de anotações
-keepattributes *Annotation*

# Preserva atributos de inner classes
-keepattributes InnerClasses

# Preserva atributos de enclosing method
-keepattributes EnclosingMethod

# Preserva atributos de exceptions
-keepattributes Exceptions

# Regras específicas para Compose (se usado no core no futuro)
-keep class androidx.compose.** { *; }
-keep class kotlin.Metadata { *; }

# Preserva classes geradas pelo Compose
-keep class * extends androidx.compose.** { *; }

# Preserva funções Compose
-keepclassmembers class * {
    @androidx.compose.runtime.Composable *;
}

# Preserva remember functions
-keepclassmembers class * {
    @androidx.compose.runtime.Remember *;
}

# Preserva stable markers
-keepclassmembers class * {
    @androidx.compose.runtime.Stable *;
}

# Regras específicas para AndroidX
-keep class android.support.** { *; }
-keep class androidx.** { *; }

# Preserva implementações de interface AndroidX
-keep class * implements androidx.** { *; }

# Preserva subclasses de classes AndroidX
-keep class * extends androidx.** { *; }

# Regras específicas para Material Design
-keep class com.google.android.material.** { *; }
-keep class androidx.compose.material3.** { *; }

# Preserva métodos de tema Material
-keepclassmembers class * {
    @androidx.compose.material3.MaterialTheme *;
}

# Preserva métodos de ColorScheme
-keepclassmembers class * {
    @androidx.compose.material3.ColorScheme *;
}

# Preserva métodos de Typography
-keepclassmembers class * {
    @androidx.compose.material3.Typography *;
}

# Preserva métodos de Shape
-keepclassmembers class * {
    @androidx.compose.material3.Shapes *;
}

# Regras de otimização agressiva (opcional, habilitar se necessário)
# -optimizationpasses 5
# -allowaccessmodification
# -mergeinterfacesaggressively

# Regras de otimização conservadora (padrão)
-optimizationpasses 3
-allowaccessmodification

# Não otimiza classes específicas
-keep class br.com.wgc.design_system.core.WgcCoreDsSpacing { *; }
-keep class br.com.wgc.design_system.core.WgcCoreDsBorderRadius { *; }
-keep class br.com.wgc.design_system.core.WgcCoreDsColorsFacade { *; }

# Preserva propriedades constantes
-keepclassmembers class br.com.wgc.design_system.core.** {
    public static final ** COLORS = ...;
    public static final ** SPACING = ...;
    public static final ** TYPOGRAPHY = ...;
}

# Regras específicas para reflection
-keepclassmembers class br.com.wgc.design_system.core.** {
    @java.lang.reflect.* *;
}

# Preserva métodos usados por bibliotecas de reflection
-keepclassmembers class br.com.wgc.design_system.core.** {
    public *** class$(java.lang.Class);
    public *** class$(java.lang.Class, int);
}

# Preserva métodos equals e hashCode
-keepclassmembers class br.com.wgc.design_system.core.** {
    public boolean equals(java.lang.Object);
    public int hashCode();
}

# Preserva métodos toString
-keepclassmembers class br.com.wgc.design_system.core.** {
    public java.lang.String toString();
}

# Preserva métodos clone
-keepclassmembers class br.com.wgc.design_system.core.** {
    protected java.lang.Object clone() throws java.lang.CloneNotSupportedException;
}

# Preserva métodos finalize
-keepclassmembers class br.com.wgc.design_system.core.** {
    protected void finalize() throws java.lang.Throwable;
}

# Regras específicas para segurança
-keep class ** implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Preserva classes serializáveis
-keepclassmembers class br.com.wgc.design_system.core.** implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Regras específicas para Gson/JSON
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.google.gson.** { *; }
-keep class * implements com.google.gson.TypeAdapter
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}

# Preserva campos com anotações Gson
-keepclassmembers class br.com.wgc.design_system.core.** {
    @com.google.gson.annotations.SerializedName <fields>;
    @com.google.gson.annotations.Expose <fields>;
}

# Regras específicas para Parceler
-keep class br.com.wgc.design_system.core.** implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

# Preserva classes Parcelable
-keepclassmembers class br.com.wgc.design_system.core.** implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
}

# Regras específicas para Room Database (se usado no futuro)
-keep class br.com.wgc.design_system.core.** { *; }
-keep class * extends androidx.room.RoomDatabase
-keep @androidx.room.Entity class *
-dontwarn androidx.room.**

# Preserva métodos DAO Room
-keepclassmembers class * extends androidx.room.RoomDatabase {
    public abstract * get*(...);
}

# Preserva entidades Room
-keep @androidx.room.Entity class *
-keepclassmembers @androidx.room.Entity class * {
    *;
}

# Regras específicas para Retrofit (se usado no futuro)
-keepattributes Signature
-keepattributes Exceptions
-keepclasseswithmembernames class * {
    @retrofit2.http.* <methods>;
}

# Preserva interfaces Retrofit
-keep interface br.com.wgc.design_system.core.** {
    @retrofit2.http.* <methods>;
}

# Regras específicas para OkHttp (se usado no futuro)
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**

# Regras específicas para Coil (se usado no futuro)
-keep class coil.** { *; }
-dontwarn coil.**

# Preserva classes de imagem Coil
-keep class coil.ImageLoader { *; }
-keep class coil.request.** { *; }
-keep class coil.decode.** { *; }

# Regras específicas para Kotlin Coroutines
-keepclassmembers class kotlinx.coroutines.** {
    public ** *(...);
}

# Preserva classes de coroutines
-keep class kotlinx.coroutines.** { *; }
-dontwarn kotlinx.coroutines.**

# Preserva Continuation
-keepclassmembers class kotlinx.coroutines.internal.** {
    public ** *(...);
}

# Regras específicas para Flow
-keepclassmembers class kotlinx.coroutines.flow.** {
    public ** *(...);
}

# Preserva operadores Flow
-keep class kotlinx.coroutines.flow.** { *; }

# Regras específicas para StateFlow
-keepclassmembers class kotlinx.coroutines.flow.StateFlow {
    public ** *(...);
}

# Preserva SharedFlow
-keepclassmembers class kotlinx.coroutines.flow.SharedFlow {
    public ** *(...);
}

# Regras finais de otimização
-optimizationpasses 3
-allowaccessmodification
-dontpreverify
-verbose

# Preserva classes para debugging
-keep class br.com.wgc.design_system.core.** { *; }

# Preserva métodos de logging
-keepclassmembers class br.com.wgc.design_system.core.** {
    public void log*(...);
    public void d*(...);
    public void i*(...);
    public void w*(...);
    public void e*(...);
}

# Preserva classes de teste em builds de debug
-if:build.is.debug
-keep class br.com.wgc.design_system.core.** { *; }
-keepclassmembers class br.com.wgc.design_system.core.** { *; }
-endif