# Guia de Contribuição — DesignSystemAndroid 🎨

Obrigado pelo seu interesse em contribuir com o **DesignSystemAndroid**!
Este repositório reúne os tokens de design, componentes atômicos/moleculares e templates de tela da organização **WGC**, operando sob os mais altos padrões de engenharia em Jetpack Compose, Material 3 e governança de agentes especialistas.

---

## 🏛️ Princípios Arquiteturais Obrigatórios

1. **Separação Estrita de Camadas (Atomic Design):**
   - `:core-ds`: Tokens fundamentais puros (Cores primitivas/semânticas, Spacing, Radius, Size, Elevation, Motion). **Zero dependências de UI/Compose**.
   - `:design-system`: Átomos e moléculas em Jetpack Compose (`WgcClassicButton`, `WgcChip`, `WgcAlert`, etc.). State Hoisting obrigatório (stateless por padrão).
   - `:ds-templates`: Telas e fluxos completos desacoplados (`UiState` + `BaseViewModel` + `FakeViewModel`).
   - `:app`: Storybook catalog interativo para validação visual.

2. **Regra Inviolável de Tokens:**
   - Código novo **NUNCA** utiliza valores hexadecimais soltos, `Color(...)`, `.dp`, `.sp` ou números mágicos hardcoded.
   - Sempre utilize os tokens semânticos do `:core-ds` e `MaterialTheme.colorScheme.*`.

3. **Acessibilidade e Usabilidade Obrigatórias:**
   - Target mínimo de toque de 48dp x 48dp para elementos interativos.
   - Suporte nativo a TalkBack (`contentDescription`, `semantics`).
   - Contraste mínimo de 4.5:1 para texto e 3:1 para componentes visuais.

4. **KDoc e Previews:**
   - 100% de cobertura de KDoc em componentes e tokens públicos.
   - `@Preview` para cada estado/variante (Normal, Hover/Pressed, Disabled, Loading, Error).
   - Screenshot test nativo (`@PreviewTest`) para validação de regressão visual.

---

## 🛠️ Padrão de Commits (Conventional Commits)

Todas as mensagens de commit e títulos de Pull Requests **DEVEM** seguir a especificação [Conventional Commits](https://www.conventionalcommits.org/):

- `feat(<escopo>):` Nova funcionalidade, componente ou template (ex: `feat(buttons): add WgcSegmentedButton`)
- `fix(<escopo>):` Correção de bug ou regressão visual (ex: `fix(textfield): fix clear icon alignment`)
- `refactor(<escopo>):` Refatoração de código sem alteração de comportamento
- `test(<escopo>):` Adição ou atualização de testes unitários ou screenshot tests
- `docs(<escopo>):` Atualizações de documentação, KDocs e Dokka
- `chore(<escopo>):` Tarefas de build, plugins, dependências ou CI/CD

---

## 🧪 Validação Local Obrigatória

Antes de abrir um Pull Request, certifique-se de que todas as validações passam localmente:

```bash
# 1. Análise estática com Detekt
./gradlew detekt

# 2. Executar testes unitários
./gradlew test

# 3. Gerar documentação multi-módulo consolidada do Dokka
./gradlew dokkaHtmlMultiModule

# 4. Compilar AARs de release
./gradlew assembleRelease
```

---

## 🔀 Fluxo de Branches e Pull Requests

1. Crie uma branch a partir de `master`:
   ```bash
   git checkout -b feat/<nome-da-feature>
   # ou
   git checkout -b fix/<nome-do-bug>
   ```
2. Realize commits atômicos e semânticos.
3. Envie a branch para o repositório remoto:
   ```bash
   git push -u origin feat/<nome-da-feature>
   ```
4. Abra um **Pull Request** para `master`.
5. Aguarde a execução da esteira automatizada no GitHub Actions (validação SemVer, Detekt, testes, screenshot tests e Dokka).