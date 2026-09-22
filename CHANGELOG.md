# Changelog

Todas as alterações notáveis neste projeto serão documentadas neste arquivo.

O formato é baseado em [Keep a Changelog](https://keepachangelog.com/pt-BR/1.1.0/),
e este projeto adere ao [Semantic Versioning](https://semver.org/lang/pt-BR/).

---

## [Unreleased]

### Added
- **Novos Templates (`:templates`)**:
  - `WgcNotificationCenterTemplate`: Central de notificações completa com abas de categoria (Todas, Não Lidas, Transações), marcação de leitura, limpeza e slots customizáveis.
  - `WgcUserProfileEditTemplate`: Tela completa de edição de perfil cadastral com avatar, validações em tempo real de e-mail e nome, bio e botões de ação.
- **Novos Componentes e Átomos (`:components`)**:
  - `WgcRatingBar`: Avaliação por estrelas com suporte a modo interativo (toque e clique nas estrelas) e modo somente leitura com notas fracionárias e acessibilidade.
  - `WgcStandardBottomSheet`: Folha inferior modal padronizada com cabeçalho corporativo, botão de fechar, slot de ações e tokens de elevação e raio de borda.
  - `WgcSkeleton` e `WgcSkeletonShape`: Placeholders modulares de carregamento com shimmer effect e composições pré-moldadas (`WgcSkeletonCard`, `WgcSkeletonListItem`, `WgcSkeletonProfile`).
- **Novos Grafos de Navegação Type-Safe (`:navigation-flows`)**:
  - `WgcNotificationsNavGraph` & `WgcNotificationsNavHost`: Fluxo de navegação para listagem e detalhes com rotas type-safe (`NotificationsRoute.List`, `NotificationsRoute.Detail`).
  - `WgcProfileNavGraph` & `WgcProfileNavHost`: Fluxo de navegação para visualização de perfil, edição cadastral e segurança com rotas type-safe (`ProfileRoute.View`, `ProfileRoute.Edit`, `ProfileRoute.Security`).
- **Tokens de Animação e Movimento (`:core`)**:
  - `WgcCoreDsMotion`: Adição de curvas de aceleração e desaceleração cúbica (`easingEmphasized`, `easingEmphasizedDecelerate`, `easingEmphasizedAccelerate`, `easingStandardDecelerate`, `easingStandardAccelerate`) e classe de dados agnóstica `WgcCubicBezier`.
- **Showcase Interativo (`:app`)**:
  - Novas abas e seções demonstrativas para `WgcRatingBar`, `WgcStandardBottomSheet`, `WgcSkeleton`, `WgcNotificationCenterTemplate` e `WgcUserProfileEditTemplate`.
  - Integração dos novos fluxos de notificações e perfil no `NavigationFlowsShowcase`.

## [1.1.0] - 2026-09-20

### Added
- **Novas Fábricas Universais de Templates (`:templates`)**:
  - `WgcSearchFactory`: ponto de entrada unificado para busca e catálogo (`STANDARD`, `VISUAL_SEARCH`, `ECOMMERCE`, `FOOD`) com slots para barra de busca, filtros e resultados.
  - `WgcSettingsHubFactory`: hub unificado de configurações (`STANDARD`, `SECURITY`, `PREFERENCES`) com State Hoisting, alternadores e suporte a slots customizáveis.
  - `WgcCheckoutFactory`: suporte unificado para fluxos de checkout (`STANDARD`, `GADGET_SHOP`, `MEGA_STORE`, `QUICK_SHOP`, `RETAIL`, `TREND_FASHION`).
  - `WgcOnboardingFactory`: suíte unificada para telas de boas-vindas e introdução (`STANDARD`, `GADGET_SHOP`, `PERSONAL_FINANCE`, `QUICK_SHOP`, `TREND_FASHION`).
  - `WgcCartFactory`: catálogo universal para 14 variantes de carrinho de compras de diversos domínios.
- **Novos Grafos de Navegação (`:navigation-flows`)**:
  - `WgcSearchNavGraph` & `WgcSearchNavHost`: fluxo de busca type-safe com transição para detalhe do produto e ação de compra.
  - `WgcSettingsNavGraph` & `WgcSettingsNavHost`: fluxo do hub de configurações com segurança, preferências, termos e diálogo de logout.
- **Novos Componentes e Átomos (`:components`)**:
  - `WgcColorPicker`: seletor de cores cromático interativo 360° com slider de brilho, paleta rápida corporativa e múltiplos formatos de abertura (`DIALOG` e `BOTTOM_SHEET`).
  - `WgcOtpInput`: entrada numérica de 4 e 6 dígitos para códigos de verificação (2FA/PIN) com máscara, feedback de erro e foco automático.
  - `WgcTimeline`: linha do tempo vertical corporativa para acompanhamento e rastreamento de pedidos e processos.
  - `WgcTag`: etiquetas e rótulos de status com variantes semânticas (`Primary`, `Secondary`, `Success`, `Error`, `Warning`, `Info`, `Neutral`), estilos (`Filled`, `Outlined`) e tamanhos (`Small`, `Medium`).
  - `WgcSnackbar`: enriquecido com variantes semânticas (`Default`, `Success`, `Error`, `Warning`, `Info`), ícones contextuais e preservação de retrocompatibilidade total.
  - `WgcBadge`: integração oficial ao catálogo do `:app`.
- **Testes de Regressão Visual (Screenshot Testing)**:
  - `WgcColorPickerScreenshotTest`: validação de regressão visual para roda cromática, triggers (badge e ícone) e diálogos.
  - `WgcOtpInputScreenshotTest` e `WgcTimelineScreenshotTest`: cobertura de estados e nós de linha do tempo.
  - `WgcTagScreenshotTest` e `WgcSnackbarScreenshotTest`: validação visual de variantes semânticas.
  - `WgcFactoriesScreenshotTest`: testes de screenshot para as novas fábricas universais.

### Changed
- **Showcase Interativo (`:app`)**:
  - Adição de seções completas para `WgcColorPicker`, `WgcBadge`, `WgcTag`, `WgcSnackbar`, `WgcSearchFactory` e `WgcSettingsHubFactory`.
- **Tokens Core (`:core`)**:
  - `WgcCoreDsTypography`: hierarquia tipográfica formal (display, headline, title, body, label).
  - `WgcCoreDsOpacity`: constantes semânticas de opacidade para estados interativos.
  - `WgcCoreDsBreakpoints`: limites responsivos e `WgcWindowSizeClass`.
- **Componentes Universais (`:components`)**:
  - `WgcDatePicker` & `WgcDatePickerDialog`: seleção de data Material 3 padronizada.
  - `WgcTimePicker` & `WgcTimePickerDialog`: seleção de hora 24h e 12h.
  - `WgcNavigationDrawer`: drawer modal e itens com badges.
  - `WgcProgressIndicators`: progresso circular e linear (determinado e indeterminado).
  - `WgcBadge` & `WgcBadgedBox`: marcadores visuais e contadores.
  - `WgcSnackbar` & `WgcSnackbarHost`: notificações temporárias estilizadas.
  - `WgcPullToRefreshBox`: contêiner com gesto de atualização.
  - `WgcTabs` & `WgcHorizontalPagerIndicator`: barras de abas e paginação em pontos.
- **Templates Corporativos (`:templates`)**:
  - `WgcHelpCenterSupportTemplate`: central de ajuda, busca, FAQ e tickets.
  - `WgcKycLivenessVerificationTemplate`: validação biométrica facial e instruções de segurança.
  - `WgcTransactionReceiptTemplate`: comprovante detalhado de transação e transferência.
- **Fluxos de Navegação (`:navigation-flows`)**:
  - `WgcAuthNavGraph`: login, cadastro, recuperação de senha e validação OTP type-safe.
  - `WgcCheckoutNavGraph`: carrinho, endereço, pagamento e recibo final.
  - `WgcOnboardingNavGraph`: boas-vindas, permissões e setup de preferências.
- **Governança & Qualidade**:
  - Detekt configurado com `ignoreFailures = false` e baseline explícito.
  - Suporte ao Binary Compatibility Validator para congelamento de API pública.
  - Política de segurança corporativa em `SECURITY.md`.
  - Matriz de donos de código em `.github/CODEOWNERS`.
  - Processo de submissão de novas telas em `docs/RFC_GOVERNANCE.md`.

### Changed
- **Renomeação Conclusiva White-Label**:
  - Neutralização completa de nomes de terceiros remanescentes para identificadores descritivos (`PharmacyChain`, `PopularPharmacy`, `CarePharmacy`, `GuidedTraining`, `PremiumGrocery`, `TrendApparel`, `UrbanMobility`, `Boutique`).
- **Arquitetura de Temas**:
  - `WgcBrand` refatorado para desacoplar cores hardcoded e consumir `ColorScheme` / tokens de `:core`.
- **CI/CD**:
  - Permissões de PR ajustadas para princípio de menor privilégio (`contents: read`).
