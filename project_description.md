# Project description
The goal of this project was to check how much information we can get from code vectors gets from the code2vec model. I was using a pre-trained model that is available ![here](https://s3.amazonaws.com/code2vec/model/java14m_model.tar.gz).


## Part 1

**All the details can be found at `README.md`.**

The first part was about adding new functionality to the code2vec model that able to find closes code functions to the given one. 
The main idea is about extracting and saving code vectors from big code repositories. Then each time we have a new function we can check if have some similar functions yet created.
This can be done by 3 stage process.

### Preprocessing the dataset

Firstly we have to extract paths from code snippets. This can be done by using `preprocess_for_extracting.sh` scripts.

### Extracting code vectors

Having extracted paths we can use code2vec pre-trained model to get code vectors.

### Manually extraction

Finally, we can compare the code vector of a new function to all saved code vectors extracted from a given repository. This can be done in interactive mode.

### Results

The results were not fully satisfying. There were some difficulties in separating functions that are built similarly, and sometimes small changes in code (like renaming variables) can quite radically change the code vector. We'll revisit this issue in the next parts.

## Part 2

**All the details can be found at `KMeans.ipynb`**

This part was to explore if vectors of functions that have the same functionality are close to each other (in a cosine distance).

### Vector space

I decide to extract code functionality from names. Names can be tokenized, for example from `classToString` we can extract tokens `code`, `to` and `string`.
I decide to use multidimensional scaling based on the cosine distance matrix to explore where specific functions are located in the vector space. 

### Results

I found that code snippets with the same functionality are often far apart from each other in the vector space. This might be caused by the fact that functions with the same functionality can be implemented in many ways.

## Part 3

**All the details can be found at `Model_sensitivity.ipynb`**

In this part, I focused on measuring how specific code modifications influent changes in the code vector.

Methods and results are described in the notebook, but the general conclusion is that some technical modifications, like using a while loop instead of for loop or reordering instructions aren't affected the code vector. On the other hand, if we implement the same function differently, the code vectors can be far apart from each other. An important note is that the names of variables have a significant influence on the code vector. Even using the synonymous can radically change code representation in the vector space.
