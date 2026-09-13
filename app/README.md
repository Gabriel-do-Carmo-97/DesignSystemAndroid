# 📱 Módulo `:app` (Catálogo Interativo & Sandbox Storybook)

[![Build Passing](https://img.shields.io/badge/Build-Passing-brightgreen.svg)]()
![Min SDK](https://img.shields.io/badge/minSdk-29-green.svg)
![Target SDK](https://img.shields.io/badge/targetSdk-37-blue.svg)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-blue.svg)

O módulo **`:app`** é o aplicativo de vitrine (*Catalog App* / *Storybook*) do ecossistema WGC. Ele funciona como ambiente interativo em tempo de execução para inspecionar, testar e validar todos os componentes de `:design-system` e telas de `:ds-templates`.

---

## 🎨 Organização da Navegação no Catálogo (`MainActivity`)

O app é estruturado em 4 abas mestras no topo para garantir acesso rápido a todas as camadas:

```
┌─────────────────────────────────────────────────────────────────────────────┐
│ 🎨 Figma (3 Templates) │ 🧩 Componentes │ 📱 Templates (Gerais) │ 🏭 Fábricas │
└─────────────────────────────────────────────────────────────────────────────┘
```

1. **🎨 Figma (3 Templates):**  
   Destaque principal exibindo os 3 layouts recém-extraídos do Figma Community:
   - **Wave Login:** Curva orgânica inferior e biometria por digital.
   - **Split Card Login:** Card superior elevado e login com biometria lateral.
   - **Klok Brand Login:** Seletor pill duplo (Login/Register) e biometria dourada.

2. **🧩 Componentes:**  
   Catálogo atômico exibindo cada componente isoladamente em todos os seus estados (`Habilitado`, `Loading`, `Desabilitado` e variações). Inclui: `WgcClassicButton`, `WgcBiometricButton`, `WgcSocialLoginPillButton`, `WgcPillTabSwitch`, `WgcSimpleTextField`, etc.

3. **📱 Templates (Gerais):**  
   Fluxos de telas completos do ecossistema (E-commerce, Fintech/Banking, iFood Home, Carrinho de Compras, Central de Configurações, Busca e Filtros).

4. **🏭 Fábricas & Slots:**  
   Laboratório interativo da arquitetura de **Factories & Injeção de Slots**. Permite alternar dinamicamente marcas (`WgcBrand`) e injetar componentes personalizados nos slots abertos.

---

## 🛠️ Como Executar o Catálogo

### 1. No Android Studio:
- Selecione a configuração de execução **`app`** na barra superior.
- Escolha um emulador (API 29+) ou conecte um dispositivo físico via USB/Wi-Fi com depuração ativa.
- Clique em **Run ▶** (Shift + F10).

### 2. Pela Linha de Comando (Gradle CLI):
Gerar e instalar diretamente no dispositivo conectado:
```bash
./gradlew :app:installDebug
```

Para gerar apenas o APK para testes:
```bash
./gradlew :app:assembleDebug
```
O arquivo gerado estará disponível em:
`app/build/outputs/apk/debug/app-debug.apk`

---

## 📸 Testes de Regressão Visual (Screenshot Tests)

O módulo `:app` contém o runner de screenshot tests configurado via Android Gradle Plugin (`enableScreenshotTest=true`):

- **Validar regressão visual contra as imagens de referência:**
  ```bash
  ./gradlew validateDebugScreenshotTest
  ```
- **Atualizar / Gravar novas imagens de referência:**
  ```bash
  ./gradlew updateDebugScreenshotTest
  ```

---

## 🚀 Integração Contínua (CI/CD)

Na esteira hipergranular (`.github/workflows/android.yml`), o módulo `:app` é validado em paralelo nos seguintes jobs:
- `🧹 Detekt [:app]`
- `🧪 Tests [:app]`
- `📸 Screenshot Tests [:app]`
- `📱 Assemble Catalog App` (com upload do `app-debug.apk` para download direto nos artefatos da ação).
