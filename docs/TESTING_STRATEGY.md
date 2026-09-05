# 🧪 Estratégia Obrigatória de Testes do Design System WGC (`:design-system` & `:ds-templates`)

Para garantir 100% de confiabilidade, zero regressões visuais e comportamento impecável, **todo componente no `:design-system` e todo template no `:ds-templates`** adicionado ao projeto deve possuir obrigatoriamente a seguinte suíte de testes:

1. **Screenshot Tests (Snapshot Testing):**
   - Local: `src/screenshotTest/`
   - Objetivo: Validar a integridade visual (pixels, cores, espaçamentos, layout das telas) contra imagens de referência em múltiplos estados (Default, Loading, Error, Dark Mode).

2. **Compose UI Instrumented Tests (`androidTest`):**
   - Local: `src/androidTest/`
   - Objetivo: Validar interações do usuário, cliques em botões, preenchimento de formulários, transições de estado e acessibilidade (TalkBack, semântica).

3. **Unit Tests (`test`):**
   - Local: `src/test/`
   - Objetivo: Validar regras de negócio puras, ViewModels (`Base...ViewModel`), reduções de estado (`UiState`) e validações de formulário sem subir o Android Runtime.
