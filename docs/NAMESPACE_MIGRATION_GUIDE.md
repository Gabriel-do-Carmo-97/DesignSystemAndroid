# Guia de Migração de Namespace

## 📋 Visão Geral

Este guia fornece instruções detalhadas para migrar código existente para os novos namespaces padronizados do Design System WGC.

## 🔄 Mudanças de Namespace

### Antes (Old Namespaces)
- `:core` → `br.com.wgc.core_ds`
- `:components` → `br.com.wgc.design_system`
- `:templates` → `br.com.wgc.ds_templates`
- `:navigation-flows` → `br.com.wgc.ds_navigation_flows`

### Depois (New Namespaces)
- `:core` → `br.com.wgc.design_system.core`
- `:components` → `br.com.wgc.design_system.components`
- `:templates` → `br.com.wgc.design_system.templates`
- `:navigation-flows` → `br.com.wgc.design_system.navigation`

## 📝 Impacto no Código

### 1. Imports de Kotlin

#### Antes:
```kotlin
import br.com.wgc.core_ds.WgcCoreDsSpacing
import br.com.wgc.core_ds.WgcCoreDsColors
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.ds_templates.screens.WgcHomeScreenTemplate
import br.com.wgc.ds_navigation_flows.WgcAuthNavGraph
```

#### Depois:
```kotlin
import br.com.wgc.design_system.core.WgcCoreDsSpacing
import br.com.wgc.design_system.core.WgcCoreDsColorsFacade
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.templates.screens.WgcHomeScreenTemplate
import br.com.wgc.design_system.navigation.WgcAuthNavGraph
```

### 2. Import de XML (AndroidManifest, layouts)

#### Antes:
```xml
<activity
    android:name="br.com.wgc.design_system.MainActivity"
    android:exported="true">
</activity>
```

#### Depois:
```xml
<activity
    android:name="br.com.wgc.design_system.MainActivity"
    android:exported="true">
</activity>
```

### 3. Dependências Gradle

#### Antes:
```kotlin
dependencies {
    implementation("br.com.wgc:core:1.0.0")
    implementation("br.com.wgc:components:1.0.0")
    implementation("br.com.wgc:templates:1.0.0")
    implementation("br.com.wgc:navigation-flows:1.0.0")
}
```

#### Depois:
```kotlin
dependencies {
    implementation("br.com.wgc:core:1.0.0")
    implementation("br.com.wgc:components:1.0.0")
    implementation("br.com.wgc:templates:1.0.0")
    implementation("br.com.wgc:navigation-flows:1.0.0")
}
```

> **Nota:** As dependências Gradle (artifact IDs) **não** mudaram, apenas os namespaces internos.

## 🛠️ Estratégias de Migração

### Estratégia 1: Migração Gradual

Se você tem uma grande base de código, considere migrar gradualmente:

1. **Módulo por módulo:** Comece com os módulos menos críticos
2. **Feature por feature:** Migre funcionalidades independentes
3. **Sandbox:** Crie um branch de feature para testar a migração

### Estratégia 2: Migração em Massa

Para projetos menores ou quando é possível fazer uma pausa no desenvolvimento:

1. **Backup:** Faça backup completo do projeto
2. **Branch:** Crie um branch específico para migração
3. **Find & Replace:** Use find & replace no nível do projeto
4. **Test:** Execute todos os testes após a migração

### Estratégia 3: Migração Automatizada

Use scripts para automatizar a migração:

#### Script para Kotlin Files:
```bash
# Encontrar e substituir imports no nível do projeto
find . -name "*.kt" -type f -exec sed -i 's/br\.com\.wgc\.core_ds/br.com.wgc.design_system.core/g' {} +
find . -name "*.kt" -type f -exec sed -i 's/br\.com\.wgc\.design_system\./br.com.wgc.design_system.components./g' {} +
find . -name "*.kt" -type f -exec sed -i 's/br\.com\.wgc\.ds_templates/br.com.wgc.design_system.templates/g' {} +
find . -name "*.kt" -type f -exec sed -i 's/br\.com\.wgc\.ds_navigation_flows/br.com.wgc.design_system.navigation/g' {} +
```

#### Script para XML Files:
```bash
# Encontrar e substituir em XML
find . -name "*.xml" -type f -exec sed -i 's/br\.com\.wgc\.core_ds/br.com.wgc.design_system.core/g' {} +
find . -name "*.xml" -type f -exec sed -i 's/br\.com\.wgc\.ds_templates/br.com.wgc.design_system.templates/g' {} +
find . -name "*.xml" -type f -exec sed -i 's/br\.com\.wgc\.ds_navigation_flows/br.com.wgc.design_system.navigation/g' {} +
```

## 🧪 Validação Após Migração

### 1. Compilação
```bash
./gradlew clean build
```

### 2. Testes Unitários
```bash
./gradlew testDebugUnitTest
```

### 3. Testes de Instrumentação
```bash
./gradlew connectedAndroidTest
```

### 4. Lint
```bash
./gradlew lint
```

## ⚠️ Casos Especiais

### Cores do Design System

#### Antes:
```kotlin
import br.com.wgc.core_ds.WgcCoreDsColors

val primaryColor = WgcCoreDsColors.primary
val brandColor = WgcCoreDsColors.foodDeliveryRed
```

#### Depois:
```kotlin
import br.com.wgc.design_system.core.WgcCoreDsColorsFacade
import br.com.wgc.design_system.core.colors.WgcCoreDsColorsPrimitive
import br.com.wgc.design_system.core.colors.brands.WgcBrandFoodDelivery

// Nova estrutura modular
val primaryColor = WgcCoreDsColorsFacade.primary
val brandColor = WgcBrandFoodDelivery.foodDeliveryRed

// Ou use a estrutura legada para compatibilidade
val primaryColor = WgcCoreDsColors.primary // @Deprecated mas funciona
```

### Componentes com Imports Específicos

#### Antes:
```kotlin
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.alert.WgcAlert
```

#### Depois:
```kotlin
import br.com.wgc.design_system.components.buttons.WgcButton
import br.com.wgc.design_system.components.alert.WgcAlert
```

> **Nota:** Os imports de componentes mudaram de `br.com.wgc.design_system` para `br.com.wgc.design_system.components`

## 📞 Suporte

Se você encontrar problemas durante a migração:

1. **Consulte os logs de erro** para identificar arquivos específicos
2. **Verifique dependências transitivas** que podem usar os namespaces antigos
3. **Limpe o cache do Gradle:** `./gradlew clean --no-daemon`
4. **Invalidate Caches** no Android Studio se necessário

## 🔄 Rollback

Se precisar reverter a migração:

1. **Restaure o backup** do projeto
2. **Use git** para reverter para o commit anterior à migração
3. **Publique uma versão** com os namespaces antigos se necessário

## 📅 Timeline de Deprecação

- **Versão atual:** Ambos os namespaces são suportados
- **Versão 2.0.0:** Namespaces antigos serão marcados como `@Deprecated`
- **Versão 3.0.0:** Namespaces antigos serão removidos

## ✅ Checklist de Migração

- [ ] Backup do projeto completo
- [ ] Branch de migração criado
- [ ] Scripts de migração testados em ambiente de sandbox
- [ ] Migração aplicada em ambiente de desenvolvimento
- [ ] Compilação bem-sucedida
- [ ] Todos os testes passando
- [ ] Lint sem erros
- [ ] Testes manuais em dispositivos reais
- [ ] Documentação atualizada
- [ ] Team informado sobre as mudanças

## 🎯 Benefícios da Migração

- **Consistência:** Todos os módulos seguem o mesmo padrão de namespace
- **Clareza:** Namespaces mais descritivos e organizados
- **Escalabilidade:** Melhor suporte para futuros módulos
- **Manutenibilidade:** Código mais fácil de entender e manter

---

Para mais informações, consulte o [README](../README.md) ou entre em contato com a equipe de desenvolvimento.