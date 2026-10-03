# Guia de Configuração de Testes Visuais com Roborazzi

O **WGC Design System** utiliza o **Roborazzi** para testes de regressão visual automatizados diretamente na JVM, sem a necessidade de emuladores pesados.

---

## 🚀 Execução Local

```bash
# Gravar novas capturas de tela douradas (Golden Images)
./gradlew recordRoborazziDebug

# Comparar renderizações atuais contra as imagens de referência
./gradlew verifyRoborazziDebug

# Gerar relatório HTML comparativo de diffs
./gradlew compareRoborazziDebug
```

---

## 📋 Diretrizes para Novos Componentes

1. Todo componente público deve conter uma função `@PreviewTest` correspondente.
2. Certifique-se de testar os modos:
   - Modo Claro (Light Theme)
   - Modo Escuro (Dark Theme)
   - Escala de Fonte 150% (Acessibilidade)
