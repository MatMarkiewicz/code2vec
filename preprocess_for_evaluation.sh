#!/usr/bin/env bash
###########################################################
# Change the following values to preprocess a new dataset.
# DATA_DIR should be paths to      
#   directory containing sub-directories with .java files
#   data will be extracted from .java files found in those sub-dirs.
# DATASET_NAME is just a name for the currently extracted 
#   dataset.                                              
# MAX_CONTEXTS is the number of contexts to keep for each 
#   method (by default 200).                              
# WORD_VOCAB_SIZE, PATH_VOCAB_SIZE, TARGET_VOCAB_SIZE -   
#   - the number of words, paths and target words to keep 
#   in the vocabulary (the top occurring words and paths will be kept). 
#   The default values are reasonable for a Tesla K80 GPU 
#   and newer (12 GB of board memory).
# NUM_THREADS - the number of parallel threads to use. It is 
#   recommended to use a multi-core machine for the preprocessing 
#   step and set this value to the number of cores.
# PYTHON - python3 interpreter alias.
DATA_DIR=data/raw_java_small_test
DATASET_NAME=java_small_test
MAX_CONTEXTS=200
WORD_VOCAB_SIZE=1301136
PATH_VOCAB_SIZE=911417
TARGET_VOCAB_SIZE=261245
NUM_THREADS=1
PYTHON=python3
###########################################################

DATA_FILE=${DATASET_NAME}.data.raw.txt
EXTRACTOR_JAR=JavaExtractor/JPredict/target/JavaExtractor-0.0.1-SNAPSHOT.jar

mkdir -p data
mkdir -p data/${DATASET_NAME}

echo "Extracting paths from the data..."
${PYTHON} JavaExtractor/extract.py --dir ${DATA_DIR} --max_path_length 8 --max_path_width 2 --num_threads ${NUM_THREADS} --jar ${EXTRACTOR_JAR} > ${DATA_FILE}
echo "Finished extracting paths the data."

${PYTHON} preprocess_for_evaluation.py --test_data ${DATA_FILE} --max_contexts ${MAX_CONTEXTS} --word_vocab_size ${WORD_VOCAB_SIZE} \
  --path_vocab_size ${PATH_VOCAB_SIZE} --target_vocab_size ${TARGET_VOCAB_SIZE} --output_name data/${DATASET_NAME}/${DATASET_NAME}  

# If all went well, the raw data files can be deleted, because preprocess.py creates new files 
# with truncated and padded number of paths for each example.
rm ${DATA_FILE}
