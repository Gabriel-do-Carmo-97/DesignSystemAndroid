# 📋 Plano de Remoção do Módulo `:infra:core-ui` e `:bundle:presentation` no Repositório `CoreAndroidNative`

Este documento contém o roteiro técnico e cirúrgico para você ou a IA executar no repositório **`CoreAndroidNative`** (`C:\Users\gcarm\AndroidStudioProjects\CoreAndroidNative`), purgado os componentes de UI e mantendo o Core 100% focado em **Infraestrutura Nativa e Clean Architecture**.

---

## 🎯 Contexto e Motivação

O `CoreAndroidNative` foi concebido para ser uma biblioteca de infraestrutura pura (Storage, Database, Network, Device, Location, Analytics, Coroutines) sem dependências de interface de usuário.
Todos os componentes de UI (`CpfVisualTransformation`, `CepVisualTransformation`, `PhoneVisualTransformation`, `Modifier.debouncedClick`, `MultiPreviews`, `EmptyStateScreen`, `GenericErrorScreen`, `UiEffectChannel`) foram **completamente migrados e integrados ao repositório `DesignSystemAndroid`**, onde residem legitimamente.

---

## 🗑️ Passo 1: Deletar Pastas e Arquivos de UI

Execute os comandos abaixo na raiz do repositório `CoreAndroidNative`:

### PowerShell:
```powershell
# 1. Remover o módulo :infra:core-ui
Remove-Item -Recurse -Force "infra\core-ui"

# 2. Remover o bundle :bundle:presentation
Remove-Item -Recurse -Force "bundle\presentation"

# 3. Remover o agente de UI
Remove-Item -Force "agents\ui-presentation-agent.md"
```

### Bash / Linux:
```bash
rm -rf infra/core-ui
rm -rf bundle/presentation
rm -f agents/ui-presentation-agent.md
```

---

## 📝 Passo 2: Atualizar Configurações de Build

### 1. Arquivo: `settings.gradle.kts`
Remova as linhas que registram `core-ui` e `presentation`:

```kotlin
// REMOVER esta linha (aprox. linha 52):
registerModule("core-ui")

// REMOVER esta linha (aprox. linha 67):
registerBundle("presentation")
```

---

### 2. Arquivo: `infra/core/build.gradle.kts` (Módulo Umbrella)
Remova a dependência `api(project(":infra:core-ui"))`:

```kotlin
dependencies {
    api(project(":infra:core-common"))
    api(project(":infra:core-storage"))
    api(project(":infra:core-device"))
    api(project(":infra:core-network"))
    // REMOVER ESTA LINHA:
    api(project(":infra:core-ui"))
    api(project(":infra:core-database"))
    api(project(":infra:core-location"))
    api(project(":infra:core-camera"))
    api(project(":infra:core-analytics"))
}
```

---

### 3. Arquivo: `sonar-project.properties`
Remova as referências a `infra/core-ui` e `bundle/presentation` nas propriedades:

```properties
# Antes:
sonar.sources=infra/core-common/src/main,...,infra/core-ui/src/main,...,bundle/presentation/src/main,...
sonar.tests=infra/core-common/src/test,...,infra/core-ui/src/test,...,bundle/presentation/src/test,...

# Depois (remover infra/core-ui/src/main, infra/core-ui/src/test, bundle/presentation/src/main e bundle/presentation/src/test)
```

---

## 🤖 Passo 3: Atualizar Governança de Agentes (`agents/`)

### 1. Arquivo: `agents/core-orchestrator.md`
- Remova `core-ui` da lista de módulos em `infra/`.
- Remova a linha `| **ui-presentation** | ui-presentation-agent.md | ... |` da tabela de agentes.

### 2. Arquivo: `agents/README.md`
- Remova a linha correspondente ao especialista `ui-presentation`.

---

## 📚 Passo 4: Atualizar Documentação

### 1. Arquivo: `README.md`
- No diagrama Mermaid, remova o nó `UI[":infra:core-ui"]` e `BundlePres["📦 :bundle:presentation"]`.
- Na tabela de Bundles, remova a linha `bundle-presentation`.
- Na tabela de Módulos Atômicos, remova a linha `core-ui`.

### 2. Arquivo: `INTEGRATION_GUIDE.md`
- Remova a menção a `implementation("br.com.wgc:core-ui:1.0.0")`.

---

## 🧪 Passo 5: Verificação e Build

Execute na raiz do `CoreAndroidNative`:
```bash
./gradlew clean build testDebugUnitTest detekt
```

O build deverá passar com sucesso com **zero referências a Compose** nas camadas de infraestrutura base!
