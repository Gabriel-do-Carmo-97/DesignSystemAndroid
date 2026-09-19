# Design System WGC - Components Module ProGuard Rules
# Regras de obfuscação e otimização para o módulo components

# Mantém classes públicas do design system
-keep public class br.com.wgc.design_system.components.** {
    public *;
}

# Mantém componentes Compose públicos
-keep public class br.com.wgc.design_system.components.buttons.** { *; }
-keep public class br.com.wgc.design_system.components.alert.** { *; }
-keep public class br.com.wgc.design_system.components.avatar.** { *; }
-keep public class br.com.wgc.design_system.components.badge.** { *; }
-keep public class br.com.wgc.design_system.components.bottomsheet.** { *; }
-keep public class br.com.wgc.design_system.components.cards.** { *; }
-keep public class br.com.wgc.design_system.components.input.** { *; }
-keep public class br.com.wgc.design_system.components.navigation.** { *; }
-keep public class br.com.wgc.design_system.components.sections.** { *; }
-keep public class br.com.wgc.design_system.components.story.** { *; }
-keep public class br.com.wgc.design_system.components.common.** { *; }
-keep public class br.com.wgc.design_system.components.commons.** { *; }

# Mantém funções @Composable públicas
-keepclassmembers class br.com.wgc.design_system.components.** {
    @androidx.compose.runtime.Composable public *;
}

# Mantém Preview functions (não usadas em produção, mas úteis para debug)
-if:build.is.debug
-keepclassmembers class br.com.wgc.design_system.components.** {
    @androidx.compose.ui.tooling.preview.Preview public *;
    @androidx.compose.ui.tooling.preview.PreviewTest public *;
}
-endif

# Mantém classes de Factory
-keep public class br.com.wgc.design_system.components.**Factory { *; }
-keep public class br.com.wgc.design_system.components.**Factory$** { *; }

# Mantém enums de componentes
-keepclassmembers enum br.com.wgc.design_system.components.** {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Mantém métodos com anotações específicas
-keepclassmembers class br.com.wgc.design_system.components.** {
    @androidx.annotation.Keep *;
}

# Preserva propriedades constantes de componentes
-keepclassmembers class br.com.wgc.design_system.components.** {
    public static final **;
}

# Preserva métodos de extensão Kotlin
-keepclassmembers class br.com.wgc.design_system.components.**$** {
    public static **;
}

# Preserva propriedades delegadas Kotlin
-keepclassmembers class br.com.wgc.design_system.components.** {
    public ** getValue(...);
    public ** setValue(...);
}

# Preserva classes de dados Kotlin
-keep @androidx.annotation.Keep class br.com.wgc.design_system.components.** {
    *;
}

# Preserva serialização Kotlin
-keepclassmembers class br.com.wgc.design_system.components.** implements kotlinx.serialization.Serializable {
    public static ** serializer();
}

# Preserva classes aninhadas públicas
-keep public class br.com.wgc.design_system.components.**$** {
    public *;
}

# Preserva setters/getters de propriedades Kotlin
-keepclassmembers class br.com.wgc.design_system.components.** {
    public void set*(***);
    public *** get*();
    public *** is*();
}

# Preserva construtores públicos
-keepclassmembers class br.com.wgc.design_system.components.** {
    public <init>(...);
}

# Preserva métodos com anotações específicas
-keep @androidx.annotation.NonNull class br.com.wgc.design_system.components.** { *; }
-keep @androidx.annotation.Nullable class br.com.wgc.design_system.components.** { *; }

# Preserva métodos usados em reflection por bibliotecas externas
-keepclassmembers class br.com.wgc.design_system.components.** {
    @com.google.gson.annotations.SerializedName <fields>;
    @com.google.gson.annotations.Expose <fields>;
}

# Preserva métodos de callback
-keepclassmembers class br.com.wgc.design_system.components.** {
    public void on*(...);
}

# Preserva classes com nomes específicos (para compatibilidade)
-keep class br.com.wgc.design_system.** { *; }

# Preserva recursos de strings usados em reflection
-keepclassmembers class br.com.wgc.design_system.components.R$* {
    public static <fields>;
}

# Preserva métodos de teste
-keepclassmembers class br.com.wgc.design_system.components.** {
    public void test*(...);
}

# Preserva métodos debug
-keepclassmembers class br.com.wgc.design_system.components.** {
    public void debug*(...);
}

# Optimizações específicas para componentes Compose
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

# Regras específicas para Compose
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

# Preserva derivedStateOf
-keepclassmembers class * {
    @androidx.compose.runtime.derivedStateOf *;
}

# Preserva LaunchedEffect
-keepclassmembers class * {
    @androidx.compose.runtime.LaunchedEffect *;
}

# Preserva DisposableEffect
-keepclassmembers class * {
    @androidx.compose.runtime.DisposableEffect *;
}

# Preserva SideEffect
-keepclassmembers class * {
    @androidx.compose.runtime.SideEffect *;
}

# Preserva rememberCoroutineScope
-keepclassmembers class * {
    @androidx.compose.runtime.rememberCoroutineScope *;
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

# Preserva componentes Material3
-keep class androidx.compose.material3.** { *; }

# Preserva Button
-keep class androidx.compose.material3.Button { *; }
-keep class androidx.compose.material3.OutlinedButton { *; }
-keep class androidx.compose.material3.TextButton { *; }
-keep class androidx.compose.material3.ElevatedButton { *; }
-keep class androidx.compose.material3.FilledTonalButton { *; }

# Preserva TextField
-keep class androidx.compose.material3.TextField { *; }
-keep class androidx.compose.material3.OutlinedTextField { *; }

# Preserva Card
-keep class androidx.compose.material3.Card { *; }
-keep class androidx.compose.material3.ElevatedCard { *; }
-keep class androidx.compose.material3.OutlinedCard { *; }

# Preserva AlertDialog
-keep class androidx.compose.material3.AlertDialog { *; }

# Preserva Snackbar
-keep class androidx.compose.material3.Snackbar { *; }

# Preserva Navigation
-keep class androidx.navigation.** { *; }
-keep class androidx.navigation.compose.** { *; }

# Preserva NavController
-keep class androidx.navigation.NavController { *; }

# Preserva NavHost
-keep class androidx.navigation.compose.NavHost { *; }

# Preserva NavGraph
-keep class androidx.navigation.NavGraph { *; }

# Regras específicas para Coil
-keep class coil.** { *; }
-dontwarn coil.**

# Preserva classes de imagem Coil
-keep class coil.ImageLoader { *; }
-keep class coil.request.** { *; }
-keep class coil.decode.** { *; }

# Preserva ImageRequest
-keep class coil.request.ImageRequest { *; }

# Preserva ImageResult
-keep class coil.request.ImageResult { *; }

# Regras específicas para Foundation
-keep class androidx.compose.foundation.** { *; }

# Preserva Modifier
-keep class androidx.compose.ui.Modifier { *; }

# Preserva Layout
-keep class androidx.compose.foundation.layout.** { *; }

# Preserva Clickable
-keep class androidx.compose.foundation.clickable.** { *; }

# Preserva Scroll
-keep class androidx.compose.foundation.gestures.** { *; }

# Regras específicas para Animation
-keep class androidx.compose.animation.** { *; }

# Preserva AnimatedVisibility
-keep class androidx.compose.animation.AnimatedVisibility { *; }

# Preserva animateAsState
-keepclassmembers class * {
    @androidx.compose.animation.animateAsState *;
}

# Preserva Crossfade
-keep class androidx.compose.animation.Crossfade { *; }

# Preserva AnimatedContent
-keep class androidx.compose.animation.AnimatedContent { *; }

# Regras específicas para Icons
-keep class androidx.compose.material.icons.** { *; }
-keep class androidx.compose.material.icons.Icons { *; }

# Preserva Icon
-keep class androidx.compose.material3.Icon { *; }

# Preserva ImageIcon
-keep class androidx.compose.material.icons.Icons.Default { *; }

# Preserva Filled Icons
-keep class androidx.compose.material.icons.filled.** { *; }

# Preserva Outlined Icons
-keep class androidx.compose.material.icons.outlined.** { *; }

# Preserva Rounded Icons
-keep class androidx.compose.material.icons.rounded.** { *; }

# Preserva Sharp Icons
-keep class androidx.compose.material.icons.sharp.** { *; }

# Preserva TwoTone Icons
-keep class androidx.compose.material.icons.twotone.** { *; }

# Regras específicas para UI Toolkit
-keep class androidx.compose.ui.** { *; }

# Preserva Platform-specific classes
-keep class androidx.compose.ui.platform.** { *; }

# Preserva Text
-keep class androidx.compose.ui.text.** { *; }

# Preserva TextRange
-keep class androidx.compose.ui.text.TextRange { *; }

# Preserva AnnotatedString
-keep class androidx.compose.ui.text.AnnotatedString { *; }

# Preserva TextStyle
-keep class androidx.compose.ui.text.TextStyle { *; }

# Preserva ParagraphStyle
-keep class androidx.compose.ui.text.ParagraphStyle { *; }

# Regras específicas para Geometry
-keep class androidx.compose.ui.geometry.** { *; }

# Preserva Size
-keep class androidx.compose.ui.geometry.Size { *; }

# Preserva Offset
-keep class androidx.compose.ui.geometry.Offset { *; }

# Preserva Rect
-keep class androidx.compose.ui.geometry.Rect { *; }

# Preserva RoundRect
-keep class androidx.compose.ui.geometry.RoundRect { *; }

# Regras específicas para Graphics
-keep class androidx.compose.ui.graphics.** { *; }

# Preserva Color
-keep class androidx.compose.ui.graphics.Color { *; }

# Preserva ColorFilter
-keep class androidx.compose.ui.graphics.ColorFilter { *; }

# Preserva Shader
-keep class androidx.compose.ui.graphics.Shader { *; }

# Preserva Path
-keep class androidx.compose.ui.graphics.Path { *; }

# Preserva PathEffect
-keep class androidx.compose.ui.graphics.PathEffect { *; }

# Regras específicas para Unit
-keep class androidx.compose.ui.unit.** { *; }

# Preserva Dp
-keep class androidx.compose.ui.unit.Dp { *; }

# Preserva Sp
-keep class androidx.compose.ui.unit.Sp { *; }

# Preserva TextUnit
-keep class androidx.compose.ui.unit.TextUnit { *; }

# Preserva Density
-keep class androidx.compose.ui.unit.Density { *; }

# Regras específicas para Input
-keep class androidx.compose.ui.input.** { *; }

# Preserva KeyEvent
-keep class androidx.compose.ui.input.KeyEvent { *; }

# Preserva PointerEvent
-keep class androidx.compose.ui.input.PointerEvent { *; }

# Preserva DragEvent
-keep class androidx.compose.ui.input.DragEvent { *; }

# Regras específicas para Test
-keep class androidx.compose.ui.test.** { *; }

# Preserva SemanticsNode
-keep class androidx.compose.ui.semantics.SemanticsNode { *; }

# Preserva SemanticsConfiguration
-keep class androidx.compose.ui.semantics.SemanticsConfiguration { *; }

# Regras específicas para Accessibility
-keep class androidx.compose.ui.semantics.** { *; }

# Preserva Role
-keep class androidx.compose.ui.semantics.Role { *; }

# Preserva SemanticsProperties
-keep class androidx.compose.ui.semantics.SemanticsProperties { *; }

# Regras específicas para Util
-keep class androidx.compose.ui.util.** { *; }

# Preserva DensityUtils
-keep class androidx.compose.ui.utilDensityUtils { *; }

# Regras específicas para Reflection
-keepclassmembers class br.com.wgc.design_system.components.** {
    @java.lang.reflect.* *;
}

# Preserva métodos usados por bibliotecas de reflection
-keepclassmembers class br.com.wgc.design_system.components.** {
    public *** class$(java.lang.Class);
    public *** class$(java.lang.Class, int);
}

# Preserva métodos equals e hashCode
-keepclassmembers class br.com.wgc.design_system.components.** {
    public boolean equals(java.lang.Object);
    public int hashCode();
}

# Preserva métodos toString
-keepclassmembers class br.com.wgc.design_system.components.** {
    public java.lang.String toString();
}

# Preserva métodos clone
-keepclassmembers class br.com.wgc.design_system.components.** {
    protected java.lang.Object clone() throws java.lang.CloneNotSupportedException;
}

# Preserva métodos finalize
-keepclassmembers class br.com.wgc.design_system.components.** {
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
-keepclassmembers class br.com.wgc.design_system.components.** implements java.io.Serializable {
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
-keepclassmembers class br.com.wgc.design_system.components.** {
    @com.google.gson.annotations.SerializedName <fields>;
    @com.google.gson.annotations.Expose <fields>;
}

# Regras específicas para Parceler
-keep class br.com.wgc.design_system.components.** implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

# Preserva classes Parcelable
-keepclassmembers class br.com.wgc.design_system.components.** implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator CREATOR;
}

# Regras específicas para Room Database
-keep class br.com.wgc.design_system.components.** { *; }
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

# Regras específicas para Retrofit
-keepattributes Signature
-keepattributes Exceptions
-keepclasseswithmembernames class * {
    @retrofit2.http.* <methods>;
}

# Preserva interfaces Retrofit
-keep interface br.com.wgc.design_system.components.** {
    @retrofit2.http.* <methods>;
}

# Regras específicas para OkHttp
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**

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

# Regras específicas para ViewModel
-keep class androidx.lifecycle.ViewModel { *; }
-keep class androidx.lifecycle.AndroidViewModel { *; }

# Preserva ViewModel implementations
-keep class * extends androidx.lifecycle.ViewModel { *; }
-keep class * extends androidx.lifecycle.AndroidViewModel { *; }

# Preserva ViewModel factories
-keep class * implements androidx.lifecycle.ViewModelProvider.Factory { *; }

# Regras específicas para LiveData
-keep class androidx.lifecycle.LiveData { *; }
-keep class androidx.lifecycle.MutableLiveData { *; }

# Preserva LiveData implementations
-keep class * extends androidx.lifecycle.LiveData { *; }

# Preserva LiveData builders
-keepclassmembers class * {
    @androidx.lifecycle.LiveData *;
}

# Regras específicas para State
-keep class androidx.compose.runtime.** { *; }

# Preserva State
-keep class androidx.compose.runtime.State { *; }

# Preserva MutableState
-keep class androidx.compose.runtime.MutableState { *; }

# Preserva remember functions
-keepclassmembers class * {
    @androidx.compose.runtime.remember *;
}

# Preserva rememberSaveable
-keepclassmembers class * {
    @androidx.compose.runtime.saveable.rememberSaveable *;
}

# Regras específicas para Saver
-keep class androidx.compose.runtime.saveable.** { *; }

# Preserva Saver implementations
-keep class * implements androidx.compose.runtime.saveable.Saver { *; }

# Regras específicas para Snapshot
-keep class androidx.compose.runtime.snapshots.** { *; }

# Preserva SnapshotState
-keep class androidx.compose.runtime.snapshots.SnapshotState { *; }

# Regras finais de otimização
-optimizationpasses 3
-allowaccessmodification
-dontpreverify
-verbose

# Preserva classes para debugging
-keep class br.com.wgc.design_system.components.** { *; }

# Preserva métodos de logging
-keepclassmembers class br.com.wgc.design_system.components.** {
    public void log*(...);
    public void d*(...);
    public void i*(...);
    public void w*(...);
    public void e*(...);
}

# Preserva classes de teste em builds de debug
-if:build.is.debug
-keep class br.com.wgc.design_system.components.** { *; }
-keepclassmembers class br.com.wgc.design_system.components.** { *; }
-endif