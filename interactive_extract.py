from common import common
from extractor import Extractor
import numpy as np

SHOW_TOP_SIMILARITIES = 10
MAX_PATH_LENGTH = 8
MAX_PATH_WIDTH = 2
JAR_PATH = 'JavaExtractor/JPredict/target/JavaExtractor-0.0.1-SNAPSHOT.jar'


class InteractiveExtractor:
    exit_keywords = ['exit', 'quit', 'q']

    def __init__(self, config, model):
        model.predict([])
        self.model = model
        self.config = config
        self.path_extractor = Extractor(config,
                                        jar_path=JAR_PATH,
                                        max_path_length=MAX_PATH_LENGTH,
                                        max_path_width=MAX_PATH_WIDTH)
        self.config.EXPORT_CODE_VECTORS = True
        self._read_vectors_and_names()
        

    def read_file(self, input_filename):
        with open(input_filename, 'r') as file:
            return file.readlines()

    def _read_vectors_and_names(self, 
                                vectors_file_path='extracted.vectors', 
                                names_file_path='extracted_names.txt'):
        with open(vectors_file_path) as vectors_file:
            self.normalized_vectors = np.loadtxt(vectors_file.readlines())
        with open(names_file_path) as names_file:
            self.names = np.array(list(map(lambda e: e[:-1], names_file.readlines())))

    def extract(self):
        input_filename = 'Input.java'
        print('Starting interactive extraction...')
        while True:
            print(
                'Modify the file: "%s" and press any key when ready, or "q" / "quit" / "exit" to exit' % input_filename)
            user_input = input()
            if user_input.lower() in self.exit_keywords:
                print('Exiting...')
                return
            try:
                predict_lines, hash_to_string_dict = self.path_extractor.extract_paths(input_filename)
            except ValueError as e:
                print(e)
                continue
            raw_prediction_results = self.model.predict(predict_lines)
            method_prediction_results = common.parse_prediction_results(
                raw_prediction_results, hash_to_string_dict,
                self.model.vocabs.target_vocab.special_words, topk=1)
            
            for raw_prediction, method_prediction in zip(raw_prediction_results, method_prediction_results):
                print('Original name:\t' + method_prediction.original_name)
                for name_prob_pair in method_prediction.predictions[:3]:
                    print('\t(%f) predicted: %s' % (name_prob_pair['probability'], name_prob_pair['name']))
                
                code_vector = raw_prediction.code_vector
                code_vector /= np.linalg.norm(code_vector)
                cosine_sim = np.sum(self.normalized_vectors * code_vector, axis=1)
                cosine_dist = 1 - cosine_sim
                argsorted_dists = np.argsort(cosine_dist)[:SHOW_TOP_SIMILARITIES]
                similar_names = self.names[argsorted_dists]
                print('Most similar functions:')
                for name, idx in zip(similar_names, argsorted_dists):
                    print(name, ' dist: ', cosine_dist[idx])