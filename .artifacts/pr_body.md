## feat(ds): suíte completa do Design System WGC (Componentes M3, Templates, Core Tokens e Build-Logic)

### 📋 Resumo das Entregas:
1. **Componentes Material 3 (`:design-system`):**
   - Catálogo completo M3 das Categorias 1 a 5 (`WgcIconButton`, `WgcSegmentedButton`, `WgcListItem`, `WgcSnackbar`, `WgcDialog`, `WgcSwitch`, `WgcSlider`, `WgcTopAppBar`, `WgcBottomNavBar`, `WgcBottomSheet`, `WgcAvatar`, `WgcRadioButton`, `WgcTooltip`).
   - Galeria Centralizada de Previews (`DesignSystemGallery.kt`) com suporte a Multipreviews (Light, Dark, Scaled Font).
2. **Suíte de Templates de Telas (`:ds-templates`):**
   - `FintechHomeScreenTemplate` (Home Fintech com saldo e atalhos).
   - `EcommerceHomeScreenTemplate` (Home E-commerce com carrinho e banners).
   - `RealtimeLocationMapScreenTemplate` (Mapa e acompanhamento em tempo real).
   - `StandardCartScreenTemplate` (Carrinho de compras e checkout).
   - `SettingsHubScreenTemplate` (Perfil e central de configurações).
   - `SearchAndFilterScreenTemplate` (Busca e filtros).
3. **Evolução do Módulo Core (`:core-ds`):**
   - Inclusão de Motion Tokens (`WgcCoreDsMotion`), Elevation Tokens (`WgcCoreDsElevation`) e interface Multi-Brand / White-Label (`WgcThemeTokens`).
4. **Infraestrutura de Build (`build-logic`):**
   - Módulo `build-logic` de Convention Plugins (`wgc.android.library`) centralizando a configuração do Gradle para todos os módulos.
5. **Cobertura Completa de Testes:**
   - Tríade de testes em 3 camadas (*Unit Tests*, *Compose UI Instrumented Tests* e *Screenshot Tests*) em `:design-system` e `:ds-templates`.

### 🧪 Verificação:
- `./gradlew assembleDebug` 100% verde.
- `./gradlew check` 100% aprovado em todas as camadas de teste.
