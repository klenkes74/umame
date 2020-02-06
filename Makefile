BASE_NAME=index

PROJECT_DIR=$(shell pwd)/docs
OUTPUT_DIR=$(shell pwd)/target/docs
ASCIIDOCTOR_COMMAND=podman run -it -v $(PROJECT_DIR):/documents:Z -v $(OUTPUT_DIR):/output:Z -w /documents/ quay.io/jaeichle/asciidoctor-redhat-fonts asciidoctor
ASCIIDOCTOR_PDF_COMMAND=podman run -it -v $(PROJECT_DIR):/documents:Z -v $(OUTPUT_DIR):/output:Z -w /documents/ quay.io/jaeichle/asciidoctor-redhat-fonts asciidoctor-pdf
ASCIIDOCTOR_PARAMS=-r asciidoctor-diagram

all: maven $(BASE_NAME).html $(BASE_NAME).pdf $(BASE_NAME).xml

clean:
	rm -rf $(OUTPUT_DIR)

prepare: clean
	mkdir -p $(OUTPUT_DIR)

maven:
	mvn clean install

$(BASE_NAME).html: prepare

# https://github.com/asciidoctor/asciidoctor-pdf
$(BASE_NAME).pdf: prepare
	$(ASCIIDOCTOR_PDF_COMMAND) $(ASCIIDOCTOR_PARAMS) $(BASE_NAME).adoc -o /output/$(BASE_NAME).pdf

$(BASE_NAME).xml: prepare
	$(ASCIIDOCTOR_COMMAND) $(ASCIIDOCTOR_PARAMS) -b docbook5 $(BASE_NAME).adoc -o /output/$(BASE_NAME).xml

$(BASE_NAME).html: prepare
	$(ASCIIDOCTOR_COMMAND) $(ASCIIDOCTOR_PARAMS) -b html $(BASE_NAME).adoc -o /output/$(BASE_NAME).html
