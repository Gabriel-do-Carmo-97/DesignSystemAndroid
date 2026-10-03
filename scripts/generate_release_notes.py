#!/usr/bin/env python3
"""
WGC Design System - Release Notes Generator (Passo 91)
Parses git log commits according to Conventional Commits and outputs Markdown release notes.
"""

import subprocess
import re

def generate_release_notes():
    try:
        cmd = ["git", "log", "-n", "30", "--pretty=format:%s"]
        output = subprocess.check_output(cmd, encoding="utf-8")
        commits = output.strip().split("\n")

        features = []
        fixes = []
        others = []

        for msg in commits:
            if msg.startswith("feat"):
                features.append(msg)
            elif msg.startswith("fix"):
                fixes.append(msg)
            else:
                others.append(msg)

        notes = "# 🚀 Notas da Versão (Release Notes)\n\n"
        if features:
            notes += "### 🌟 Novas Funcionalidades (Features)\n"
            for f in features:
                notes += f"- {f}\n"
            notes += "\n"

        if fixes:
            notes += "### 🐛 Correções de Bugs (Bug Fixes)\n"
            for fx in fixes:
                notes += f"- {fx}\n"
            notes += "\n"

        if others:
            notes += "### 🔧 Tarefas de Manutenção & Tooling\n"
            for o in others[:5]:
                notes += f"- {o}\n"

        print(notes)
        with open("RELEASE_NOTES_LATEST.md", "w", encoding="utf-8") as f:
            f.write(notes)
        print("[OK] RELEASE_NOTES_LATEST.md gerado com sucesso!")
    except Exception as e:
        print(f"Erro ao gerar notas de release: {e}")

if __name__ == "__main__":
    generate_release_notes()
