#!/usr/bin/env python3
"""
Gera o arquivo oficial de avisos de licença de terceiros (Third-Party Notices).
"""

def generate_notices():
    output_path = "THIRD_PARTY_NOTICES.md"
    content = """# Avisos de Licenças de Terceiros — WGC Design System

Este projeto utiliza componentes e bibliotecas de código aberto sob as seguintes licenças permissivas:

## 1. Jetpack Compose & AndroidX
- **Licença:** Apache License 2.0
- **Copyright:** (c) The Android Open Source Project

## 2. Kotlin & Kotlinx Serialization
- **Licença:** Apache License 2.0
- **Copyright:** (c) JetBrains s.r.o.

## 3. Detekt
- **Licença:** Apache License 2.0
- **Copyright:** (c) Artur Bosch and contributors

---
Todos os direitos reservados à WGC Design System Architecture Team.
"""
    with open(output_path, "w", encoding="utf-8") as f:
        f.write(content)
    print(f"Arquivo de avisos de terceiros gerado em: {output_path}")

if __name__ == "__main__":
    generate_notices()
