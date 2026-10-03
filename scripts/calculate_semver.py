#!/usr/bin/env python3
"""
Cálculo SemVer Automatizado baseado em Conventional Commits.
Analisa mensagens git desde a última tag para determinar se deve incrementar PATCH, MINOR ou MAJOR.
"""

import subprocess
import re
import sys

def get_latest_tag():
    try:
        tag = subprocess.check_output(["git", "describe", "--tags", "--abbrev=0"]).decode().strip()
        return tag
    except Exception:
        return "v0.1.0"

def get_commits_since(tag):
    try:
        commits = subprocess.check_output(["git", "log", f"{tag}..HEAD", "--oneline"]).decode().strip().split("\n")
        return [c for c in commits if c]
    except Exception:
        return []

def calculate_next_version(current_tag, commits):
    clean_tag = current_tag.lstrip("v")
    parts = [int(p) for p in clean_tag.split(".")]
    major, minor, patch = parts[0], parts[1], parts[2]

    has_breaking = any("BREAKING CHANGE" in c or re.search(r"^[a-f0-9]+ [a-z]+(\([^\)]+\))?!:", c) for c in commits)
    has_feat = any(re.search(r"^[a-f0-9]+ feat(\([^\)]+\))?:", c) for c in commits)

    if has_breaking:
        major += 1
        minor = 0
        patch = 0
    elif has_feat:
        minor += 1
        patch = 0
    else:
        patch += 1

    next_version = f"v{major}.{minor}.{patch}"
    print(f"Versão Atual: {current_tag}")
    print(f"Total de Commits Analisados: {len(commits)}")
    print(f"Próxima Versão Calculada: {next_version}")
    return next_version

if __name__ == "__main__":
    latest = get_latest_tag()
    commits = get_commits_since(latest)
    calculate_next_version(latest, commits)
