# Finding code similarities based on Code2Vec model

This extension to the Code2Vec model enables finding the most similar code snippets in the given code database.

README of the original Code2Vec code can be found at `CODE2VEC_README.md`.

# Requirements

* python (3.6)
* TensorFlow - version 2.0.0
* If you are using a GPU, you will need CUDA 10.0 and cuDNN (>=7.5)
* Java JDK

# Usage

## Training a model

You can either download an already-trained model, or train a new model using a preprocessed dataset.

Information about the training process can be found in the Code2Vec README. To download the trained model we can use:

```
wget https://s3.amazonaws.com/code2vec/model/java14m_model.tar.gz
tar -xvzf java14m_model.tar.gz
```

## Preprocessing the dataset

In order to create and preprocess a new dataset (some raw datasets are provided by the authors of the original code):
* Edit the file `preprocess_for_extracting.sh` using the instructions there, pointing it to the data directory.
* Run the `preprocess_for_extracting.sh` file
```
./preprocess_for_extracting.sh
```

## Extracting code vectors

To extract names and code vectors of the preprocessed data we need to run:
```
python code2vec.py --load *path_to_model* --ev *path_to_data*
```

for example:
```
python code2vec.py --load models/java14_model/saved_model_iter8.release -ev data/smallest/smallest.data.c2v
```

## Manually extraction
To manually get closes code functions based on a trained model, run:
```
python code2vec.py --load *path_to_model* --interactive_extract
```
After the model loads, follow the instructions and edit the file Input.java and enter a Java method or code snippet.

Example result:
```
Original name:  f
    (0.921215) predicted: ['test', 'swap']
    (0.032008) predicted: ['bubble', 'sort']
    (0.009010) predicted: ['visit', 'binary', 'spatial', 'operator']
Most similar functions:
    sort                dist:  0.5792298538826088
    sort|writable       dist:  0.626716160262489
    distance|to         dist:  0.639008344707509
    down|heap           dist:  0.6416091544528166
    swap                dist:  0.6422565405152388
    generate|rows       dist:  0.6526368586445036
    swap                dist:  0.6582794146808126
    to|json|array       dist:  0.6597630007702668
    main                dist:  0.6661443300050862
    move|to|next|queue  dist:  0.6737719875144312
```
