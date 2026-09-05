## feat(foundations): implementação das 5 melhorias cruciais de fundação do Design System

### 📋 O que foi implementado em 5 Commits Atômicos:
1. **Interactive Design System Catalog App (Storybook):**
   - Transformado o módulo `:app` em um catálogo interativo de componentes divididos por abas (Botões, Checkboxes, Templates), permitindo testar estados (Loading, Disabled, Dark Mode) em tempo de execução.
2. **MaterialTheme & Core-DS Token Integration:**
   - Conectado oficialmente o `:core-ds` (`WgcCoreDsColors`) ao `Theme.kt` do app para centralizar cores, superfícies e estados de erro.
3. **Standardized KDoc Documentation:**
   - Adicionada documentação KDoc rigorosa com blocos de exemplo em Markdown no `ClassicButton`.
4. **Compose UI Integration Tests (`:ds-templates`):**
   - Criado teste instrumentado com `ComposeTestRule` (`LoginScreenTemplateTest`) validando a renderização e interatividade de telas complexas.
5. **GitHub Branch Protection Documentation & Guidance:**
   - Adicionado o guia `docs/BRANCH_PROTECTION.md` com as regras recomendadas de proteção de branch para obrigar a aprovação dos checks de CI.

### 🎯 Por quê?
Consolidar a base arquitetural, de testes e de experiência do desenvolvedor (DX) antes de escalar a criação de novas telas e componentes no WGC Design System.
