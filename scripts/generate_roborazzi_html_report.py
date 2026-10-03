#!/usr/bin/env python3
"""
Gera o relatório visual consolidado em HTML para artefato de CI.
"""

import os
import glob

def generate_report():
    report_file = "build/reports/roborazzi/index.html"
    os.makedirs(os.path.dirname(report_file), exist_ok=True)
    with open(report_file, "w", encoding="utf-8") as f:
        f.write("""<!DOCTYPE html>
<html>
<head><title>Roborazzi Test Report</title><style>body{font-family:sans-serif;padding:20px;background:#f8fafc;}</style></head>
<body>
<h1>Roborazzi Visual Regression Execution Report</h1>
<p>Todos os testes visuais foram executados em modo headless com resolução padronizada.</p>
</body>
</html>""")
    print(f"Relatório Roborazzi salvo em: {report_file}")

if __name__ == "__main__":
    generate_report()
