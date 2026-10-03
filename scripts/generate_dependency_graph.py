#!/usr/bin/env python3
"""
WGC Design System - Module Dependency Graph Generator (Passo 97)
Generates Mermaid diagram showing inter-module architecture dependencies.
"""

def generate_graph():
    mermaid = """```mermaid
flowchart TD
    app[":app (Showcase / Catálogo)"]
    nav[":navigation-flows (Grafos & Guards)"]
    tpl[":templates (Telas & Fluxos Completos)"]
    cmp[":components (Átomos & Moléculas)"]
    core[":core (Tokens, Cores, Tipografia, WCAG)"]

    app --> nav
    app --> tpl
    app --> cmp
    app --> core

    nav --> tpl
    nav --> cmp
    nav --> core

    tpl --> cmp
    tpl --> core

    cmp --> core
```"""
    print(mermaid)
    with open("MODULE_DEPENDENCIES.md", "w", encoding="utf-8") as f:
        f.write("# Grafo de Dependências dos Módulos\n\n" + mermaid + "\n")
    print("[OK] MODULE_DEPENDENCIES.md gerado com sucesso!")

if __name__ == "__main__":
    generate_graph()
