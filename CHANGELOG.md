# Changelog

Todas as alterações notáveis neste projeto serão documentadas neste arquivo.

O formato é baseado em [Keep a Changelog](https://keepachangelog.com/pt-BR/1.1.0/),
e este projeto adere ao [Semantic Versioning](https://semver.org/lang/pt-BR/).

---

## [Unreleased]

### Added
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
