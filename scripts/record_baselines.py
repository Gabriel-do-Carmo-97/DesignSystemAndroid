#!/usr/bin/env python3
"""
CLI helper para gravação e atualização dos baselines do Roborazzi em todos os módulos.
Executa ./gradlew recordRoborazziDebug.
"""

import subprocess
import sys

def main():
    print("📸 Iniciando gravação de baselines do Roborazzi em todos os módulos...")
    cmd = ["./gradlew", "recordRoborazziDebug", "--no-daemon"]
    result = subprocess.run(cmd)
    if result.returncode == 0:
        print("✅ Baselines atualizados com sucesso! Não esqueça de verificar o git status antes de commitar.")
    else:
        print("❌ Erro ao atualizar baselines.")
    sys.exit(result.returncode)

if __name__ == "__main__":
    main()
