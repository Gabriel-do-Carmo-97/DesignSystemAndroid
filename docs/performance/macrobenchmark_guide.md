# Guia de Performance & Macrobenchmark (WGC Design System)

Este guia define as práticas recomendadas para garantir que os componentes do **WGC Design System** renderizem com fluidez a **120 FPS** (tempo de frame ≤ 8.3ms).

---

## 🏎️ Métricas Monitoradas

1. **Tempo de Recomposição:** Monitorado via Compose Compiler Metrics (`enableComposeCompilerMetrics`).
2. **Jank Rate:** Aferido via Macrobenchmark em listas com rolagem rápida (`LazyColumn`).
3. **Startup Time (Cold Start):** Otimizado através da geração contínua de **Baseline Profiles**.

---

## 🛠️ Comandos de Benchmark

```bash
# Executar testes de Frame Timing e Startup
./gradlew :benchmark:connectedCheck -Pandroid.testInstrumentationRunnerArguments.class=br.com.wgc.benchmark.ScrollBenchmark
```
