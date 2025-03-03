include a.mak
include b.mak
include c.mak

# Define the output folder
OUTPUT_DIR := output

# Create a list of all files (modify based on your variables)
FILES := $(NNL_FILES) $(C_FILES) $(H_FILES)

# Rule to create directories based on file paths
create_dirs:
	@for file in $(FILES); do \
		dir=$(OUTPUT_DIR)/$$(dirname $$file); \
		mkdir -p $$dir; \
	done

# Rule to copy files to the new directory structure
copy_files: create_dirs
	@for file in $(FILES); do \
		cp $$file $(OUTPUT_DIR)/$$file; \
	done

# Rule to zip the directory
zip_output: copy_files
	@zip -r output.zip $(OUTPUT_DIR)

# Default rule
all: zip_output

# Clean rule
clean:
	rm -rf $(OUTPUT_DIR) output.zip
