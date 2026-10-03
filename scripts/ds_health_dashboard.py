#!/usr/bin/env python3
"""
Design System Health & Adoption Dashboard.
Analisa a adoção de componentes corporativos Wgc* em comparação com componentes nativos do Compose.
"""

import os
import glob
import re

def analyze_adoption():
    wgc_count = 0
    native_count = 0
    
    files = glob.glob("app/src/main/java/**/*.kt", recursive=True) + \
            glob.glob("templates/src/main/java/**/*.kt", recursive=True)

    for file_path in files:
        with open(file_path, "r", encoding="utf-8", errors="ignore") as f:
            content = f.read()
            wgc_matches = len(re.findall(r"\bWgc[A-Z][a-zA-Z0-9_]*\b", content))
            native_matches = len(re.findall(r"\b(Button|TextField|Card|AlertDialog|Scaffold)\b", content))
            
            wgc_count += wgc_matches
            native_count += native_matches

    total = wgc_count + native_count
    ratio = (wgc_count / total * 100) if total > 0 else 100.0

    print("📊 ===========================================")
    print("      WGC DESIGN SYSTEM HEALTH DASHBOARD      ")
    print("==============================================")
    print(f"Total de Usos de Componentes Wgc*:  {wgc_count}")
    print(f"Total de Componentes Nativos:       {native_count}")
    print(f"Taxa de Adoção Corporativa:         {ratio:.1f}%")
    print("==============================================")
    
    return 0

if __name__ == "__main__":
    analyze_adoption()
