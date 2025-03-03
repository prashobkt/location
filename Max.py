import os
import re
import zipfile
from pathlib import Path

def parse_makefile_vars(makfile_path):
    """
    Parses cmm.mak to extract variable definitions.
    Returns a dictionary of variables and their values.
    """
    variables = {}
    var_pattern = re.compile(r'^(\w+)\s*=\s*(.*)')

    with open(makfile_path, "r") as f:
        lines = f.readlines()

    for line in lines:
        match = var_pattern.match(line)
        if match:
            var_name, var_value = match.groups()
            variables[var_name] = var_value.strip()

    return variables

def expand_variables(line, variables):
    """
    Replaces variables (macros) in a Makefile line with their values from cmm.mak.
    """
    var_usage_pattern = re.compile(r'\$\((\w+)\)')

    def replacer(match):
        var_name = match.group(1)
        return variables.get(var_name, match.group(0))  # Keep original if not found

    return var_usage_pattern.sub(replacer, line)

def parse_makefile(makefile_path, variables):
    """
    Parses the Makefile, expands variables, and extracts file paths.
    """
    file_paths = set()
    
    file_pattern = re.compile(r'([a-zA-Z0-9_/.-]+\.(c|h|axl))')

    with open(makefile_path, "r") as f:
        lines = f.readlines()

    for line in lines:
        expanded_line = expand_variables(line, variables)
        matches = file_pattern.findall(expanded_line)
        for match in matches:
            file_paths.add(match[0].strip())

    return file_paths

def create_zip(makefile_path, cmm_mak_path, output_zip):
    """
    Reads Makefile and cmm.mak, resolves variables, collects relevant files, 
    and zips them while preserving folder structure.
    """
    variables = parse_makefile_vars(cmm_mak_path)
    file_paths = parse_makefile(makefile_path, variables)

    with zipfile.ZipFile(output_zip, 'w', zipfile.ZIP_DEFLATED) as zipf:
        for file_path in file_paths:
            if os.path.exists(file_path):  # Ensure the file actually exists
                zipf.write(file_path, arcname=file_path)
    
    print(f"Created zip archive: {output_zip}")

if __name__ == "__main__":
    makefile_path = "Makefile"  # Change this if needed
    cmm_mak_path = "cmm.mak"    # Change this if needed
    output_zip = "filtered_files.zip"

    create_zip(makefile_path, cmm_mak_path, output_zip)
