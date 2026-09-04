# Plano de Implementação: Integração de Tokens do Core-DS e Refatoração dos Módulos

Este plano descreve os passos para criar uma branch dedicada, integrar o módulo `:core-ds` como dependência nos módulos `:design-system` e `:ds-templates`, e substituir valores mágicos (espaçamentos, raios de borda, cores hardcoded) pelos tokens padronizados do `:core-ds`.

## User Review Required

> [!IMPORTANT]
> A integração do `:core-ds` fará com que `:design-system` e `:ds-templates` passem a consumir os tokens semânticos e primitivos centralizados (`WgcCoreDsSpacing`, `WgcCoreDsBorderRadius`, `WgcCoreDsColors`, etc.), garantindo consistência visual em todo o design system.

## Open Questions

- Nenhuma dúvida pendente. O mapeamento dos tokens disponíveis em `core-ds` já foi validado pelos agentes especialistas.

## Proposed Changes

### Git Branch
- Criar e mudar para a branch `feature/token-integration`.

### Build & Gradle (`:design-system` e `:ds-templates`)
#### [MODIFY] [build.gradle.kts](file:///C:/Users/gcarm/Documents/GitHub/DesignSystemAndroid/design-system/build.gradle.kts)
- Adicionar dependência `implementation(project(":core-ds"))`.

#### [MODIFY] [build.gradle.kts](file:///C:/Users/gcarm/Documents/GitHub/DesignSystemAndroid/ds-templates/build.gradle.kts)
- Adicionar dependência `implementation(project(":core-ds"))`.

### Componentes e Telas (`:design-system` e `:ds-templates`)
#### [MODIFY] Componentes visuais em `:design-system/components/`
- Substituir espaçamentos fixos (`8.dp`, `16.dp`, etc.) e raios de borda por constantes/tokens correspondentes do `core-ds` (`WgcCoreDsSpacing`, `WgcCoreDsBorderRadius`).
- Substituir cores hardcoded (`Color(0xFF...)`) por referências de cores do `core-ds` ou `MaterialTheme`.

#### [MODIFY] Templates e Telas em `:ds-templates/screens/`
- Substituir paddings e espaçamentos avulsos por tokens do `core-ds`.

## Verification Plan

### Automated Tests
- Executar `./gradlew assembleDebug` para verificar se todas as dependências e referências compilam sem erros.
- Executar `./gradlew check` para garantir que todos os testes unitários continuam passando.

### Manual Verification
- Validar via Android Studio Previews que os componentes continuam renderizando corretamente.
