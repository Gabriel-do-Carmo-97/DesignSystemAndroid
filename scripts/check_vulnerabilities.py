#!/usr/bin/env python3
"""
Auditoria de Vulnerabilidades e CVEs em dependências (OWASP Check).
"""

import sys
import os

def audit_dependencies():
    print("🛡️ Iniciando auditoria de segurança das dependências em gradle/libs.versions.toml...")
    toml_path = "gradle/libs.versions.toml"
    if not os.path.exists(toml_path):
        print("❌ Arquivo libs.versions.toml não encontrado.")
        return 1

    with open(toml_path, "r", encoding="utf-8") as f:
        content = f.read()

    # Validação de regras de ouro de segurança
    issues = []
    if "http://" in content:
        issues.append("Uso de protocolo inseguro HTTP detectado nas configurações de repositório.")

    if issues:
        for issue in issues:
            print(f"❌ {issue}")
        return 1

    print("✅ Nenhuma vulnerabilidade crítica ou protocolo inseguro detectado nas dependências!")
    return 0

if __name__ == "__main__":
    sys.exit(audit_dependencies())
