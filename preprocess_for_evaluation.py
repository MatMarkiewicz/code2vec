import random
from argparse import ArgumentParser

'''
This script preprocesses the data from MethodPaths. It truncates methods with too many contexts,
and pads methods with less paths with spaces.
'''

def process_file(file_path, data_file_role, dataset_name, max_contexts):
    sum_total = 0
    sum_sampled = 0
    total = 0
    empty = 0
    max_unfiltered = 0
    output_path = '{}.{}.c2v'.format(dataset_name, data_file_role)
    with open(output_path, 'w') as outfile:
        with open(file_path, 'r') as file:
            for line in file:
                parts = line.rstrip('\n').split(' ')
                target_name = parts[0]
                contexts = parts[1:]

                if len(contexts) > max_unfiltered:
                    max_unfiltered = len(contexts)
                sum_total += len(contexts)

                if len(contexts) > max_contexts:
                    contexts = random.sample(contexts, max_contexts)

                if len(contexts) == 0:
                    empty += 1
                    continue

                sum_sampled += len(contexts)

                csv_padding = " " * (max_contexts - len(contexts))
                outfile.write(target_name + ' ' + " ".join(contexts) + csv_padding + '\n')
                total += 1

    print('File: ' + file_path)
    print('Average total contexts: ' + str(float(sum_total) / total))
    print('Average final (after sampling) contexts: ' + str(float(sum_sampled) / total))
    print('Total examples: ' + str(total))
    print('Empty examples: ' + str(empty))
    print('Max number of contexts per word: ' + str(max_unfiltered))
    return total

if __name__ == '__main__':
    parser = ArgumentParser()
    parser.add_argument("-ted", "--test_data", dest="test_data_path",
                        help="path to test data file", required=True)
    parser.add_argument("-mc", "--max_contexts", dest="max_contexts", default=200,
                        help="number of max contexts to keep", required=False)
    parser.add_argument("-wvs", "--word_vocab_size", dest="word_vocab_size", default=1301136,
                        help="Max number of origin word in to keep in the vocabulary", required=False)
    parser.add_argument("-pvs", "--path_vocab_size", dest="path_vocab_size", default=911417,
                        help="Max number of paths to keep in the vocabulary", required=False)
    parser.add_argument("-tvs", "--target_vocab_size", dest="target_vocab_size", default=261245,
                        help="Max number of target words to keep in the vocabulary", required=False)
    parser.add_argument("-o", "--output_name", dest="output_name",
                        help="output name - the base name for the created dataset", metavar="FILE", required=True,
                        default='data')
    args = parser.parse_args()

    test_data_path = args.test_data_path

    num_examples = process_file(file_path=test_data_path, data_file_role='data', dataset_name=args.output_name,
                                max_contexts=int(args.max_contexts))
