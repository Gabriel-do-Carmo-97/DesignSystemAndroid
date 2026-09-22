# 🧪 Estratégia Obrigatória de Testes do Design System WGC (`:core`, `:components`, `:templates`, `:navigation-flows`)

Para garantir 100% de confiabilidade, zero regressões visuais e comportamento impecável em todos os módulos, cada camada possui diretrizes estritas de testes:

1. **Screenshot Tests (Snapshot Testing - `:components`, `:templates`, `:app`):**
   - Local: `src/screenshotTest/`
   - Objetivo: Validar a integridade visual (pixels, cores, espaçamentos, layout das telas) contra imagens de referência em múltiplos estados (Default, Loading, Error, Dark Mode).

2. **Compose UI Instrumented Tests (`androidTest` - `:components`, `:templates`, `:navigation-flows`):**
   - Local: `src/androidTest/`
   - Objetivo: Validar interações do usuário, cliques em botões, preenchimento de formulários, transições de estado, grafos de navegação (`TestNavHostController`) e acessibilidade (TalkBack, semântica).

3. **Unit Tests (`test` - `:core`, `:components`, `:templates`, `:navigation-flows`):**
   - Local: `src/test/`
   - Objetivo: Validar tokens, transformações visuais (CPF, CEP, Telefone), canais de efeitos (`UiEffectChannel`), regras de negócio em ViewModels (`Base...ViewModel`) e reduções de estado (`UiState`) com execução ultrarrápida na JVM sem subir o Android Runtime.
