# Plano de Implementação: Suíte Completa de Autenticação Multi-Brand (iFood, Uber, Shopee, Mercado Livre, 99Food e AliExpress)

Este plano descreve a criação dos fluxos completos de autenticação (**Login, Cadastro e Recuperação de Senha**) para as 6 marcas solicitadas, organizando os tokens no `:core-ds`, os componentes no `:design-system`, os templates no `:ds-templates` e a visualização interativa no módulo `:app`.

## User Review Required

> [!IMPORTANT]
> Todos os componentes criados no `:design-system` utilizarão o prefixo obrigatório `Wgc` e serão reutilizados no `:ds-templates` sem acoplamento. Todos os templates contarão com `UiState`, `BaseViewModel`, `FakeViewModel`, Previews, Testes Unitários e Testes Instrumentados.

---

## Proposed Implementation Roadmap

### 1. Módulo `:core-ds` (Tokens de Cores das Marcas)
- Inclusão dos tokens oficiais:
  - **Shopee:** `shopeeOrange` (`#EE4D2D`)
  - **Uber:** `uberBlack` (`#111111`)
  - **AliExpress:** `aliExpressRed` (`#FF4747`)

### 2. Módulo `:design-system` (Componentes de Autenticação Reutilizáveis)
- `WgcBrandAuthHeader`: Cabeçalho com logo/identidade visual da marca.
- `WgcSocialLoginButtons`: Botões de login social (Google, Apple, Facebook).
- `WgcOtpCodeInput`: Campo de entrada de código OTP de 4 a 6 dígitos para verificação.

### 3. Módulo `:ds-templates` (Suítes de Autenticação por Marca)

#### A. iFood Auth Suite (`screens/ifood/auth/`)
- `WgcIFoodLoginScreenTemplate`
- `WgcIFoodRegisterScreenTemplate`
- `WgcIFoodResetPasswordScreenTemplate`

#### B. Uber Auth Suite (`screens/uber/auth/`)
- `WgcUberLoginScreenTemplate`
- `WgcUberRegisterScreenTemplate`
- `WgcUberResetPasswordScreenTemplate`

#### C. Shopee Auth Suite (`screens/shopee/auth/`)
- `WgcShopeeLoginScreenTemplate`
- `WgcShopeeRegisterScreenTemplate`
- `WgcShopeeResetPasswordScreenTemplate`

#### D. Mercado Livre Auth Suite (`screens/mercadolivre/auth/`)
- `WgcMercadoLivreLoginScreenTemplate`
- `WgcMercadoLivreRegisterScreenTemplate`
- `WgcMercadoLivreResetPasswordScreenTemplate`

#### E. 99Food Auth Suite (`screens/nineninefood/auth/`)
- `WgcNineNineLoginScreenTemplate`
- `WgcNineNineRegisterScreenTemplate`
- `WgcNineNineResetPasswordScreenTemplate`

#### F. AliExpress Auth Suite (`screens/aliexpress/auth/`)
- `WgcAliExpressLoginScreenTemplate`
- `WgcAliExpressRegisterScreenTemplate`
- `WgcAliExpressResetPasswordScreenTemplate`

### 4. Módulo `:app` (`MainActivity.kt`)
- Adição da seção **"Fluxos de Autenticação Multi-Brand"** com seletor interativo para alternar entre as 6 marcas (iFood, Uber, Shopee, Mercado Livre, 99Food, AliExpress) e visualizar os fluxos de Login, Cadastro e Recuperação em tempo real.

---

## Verification Plan

### Automated Tests
- Executar `./gradlew assembleDebug`
- Executar `./gradlew check` para validar unit tests e instrumented UI tests de todos os novos templates.
