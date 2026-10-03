#!/usr/bin/env python3
"""
Monitoramento de Tamanho de Binário (AAR Size Impact).
Verifica o tamanho dos artefatos AAR gerados para garantir pegada leve do Design System.
"""

import os
import glob
import sys

# Limites máximos recomendados por módulo (em KB)
MAX_AAR_SIZE_KB = {
    "core": 150,
    "components": 800,
    "templates": 600,
    "navigation-flows": 300
}

def check_sizes():
    print("📦 Analisando tamanho dos artefatos AAR gerados...\n")
    aar_files = glob.glob("*/build/outputs/aar/*-release.aar")
    
    if not aar_files:
        print("⚠️ Nenhum arquivo AAR encontrado. Execute './gradlew assembleRelease' primeiro.")
        return 0

    print("| Módulo | Tamanho Atual (KB) | Limite Máximo (KB) | Status |")
    print("| :--- | :---: | :---: | :---: |")

    has_violation = False
    for aar in sorted(aar_files):
        module_name = aar.split(os.sep)[0]
        size_bytes = os.path.getsize(aar)
        size_kb = size_bytes / 1024.0
        limit_kb = MAX_AAR_SIZE_KB.get(module_name, 500)

        status = "✅ Aprovado" if size_kb <= limit_kb else "❌ Excedeu"
        if size_kb > limit_kb:
            has_violation = True

        print(f"| `:{module_name}` | {size_kb:.2f} KB | {limit_kb} KB | {status} |")

    return 1 if has_violation else 0

if __name__ == "__main__":
    sys.exit(check_sizes())
