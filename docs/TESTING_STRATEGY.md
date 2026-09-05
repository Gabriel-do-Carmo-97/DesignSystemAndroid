# 🧪 Estratégia Obrigatória de Testes do Design System WGC

Para garantir 100% de confiabilidade, zero regressões visuais e comportamento impecável, **todo componente** adicionado ao Design System WGC deve possuir obrigatoriamente a seguinte suíte de testes:

1. **Screenshot Tests (Snapshot Testing):**
   - Local: `src/screenshotTest/`
   - Objetivo: Validar a integridade visual (pixels, cores, espaçamentos) contra imagens de referência em múltiplos estados e temas.

2. **Compose UI Instrumented Tests (`androidTest`):**
   - Local: `src/androidTest/`
   - Objetivo: Validar interações do usuário, cliques, estados dinâmicos e acessibilidade (TalkBack, semântica).

3. **Unit Tests (`test`):**
   - Local: `src/test/`
   - Objetivo: Validar funções utilitárias, extensões, formatações e regras de negócio puras (ex: ViewModels, UiStates).
