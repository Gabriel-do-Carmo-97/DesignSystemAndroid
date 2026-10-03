#!/usr/bin/env python3
"""
Roborazzi Visual Diff PR Comment Bot.
Analisa relatórios de comparação de screenshot e formata comentário de PR em Markdown.
"""

import os
import sys
import glob

def generate_diff_summary(reports_dir="build/outputs/roborazzi"):
    diff_images = glob.glob(f"{reports_dir}/*_diff.png")
    
    if not diff_images:
        print("## 📸 Roborazzi Visual Regression: Nenhum diff detectado! ✅")
        print("Todos os componentes renderizaram 100% idênticos aos baselines de referência.")
        return 0

    print(f"## 📸 Roborazzi Visual Regression: {len(diff_images)} alteração(ões) detectada(s) ⚠️\n")
    print("| Componente | Baseline | Atual | Diff Visual |")
    print("| :--- | :---: | :---: | :---: |")

    for diff_path in diff_images:
        basename = os.path.basename(diff_path).replace("_diff.png", "")
        print(f"| `{basename}` | `[Referência]` | `[Atual]` | `[Diff]` |")

    return 1

if __name__ == "__main__":
    sys.exit(generate_diff_summary())
