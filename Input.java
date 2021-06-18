void bubbleSort(int[] array) {
    boolean swapped = true;
    for (int i = 0; i < array.length && swapped; i++) {
        swapped = false;
        for (int j = 0; j < array.length - 1 - i; j++) {
           if (array[j] > array[j+1]) {
               int temp = array[j];
               array[j] = array[j+1];
               array[j+1]= temp;
               swapped = true;
           }
        }
    }
}


void bubbleSortRenamedvars(int[] array) {
    boolean changed = true;
    for (int i = 0; i < array.length && changed; i++) {
        changed = false;
        for (int j = 0; j < array.length - 1 - i; j++) {
           if (array[j] > array[j+1]) {
               int temp = array[j];
               array[j] = array[j+1];
               array[j+1]= temp;
               changed = true;
           }
        }
    }
}


void bubbleSortRenamedloopvars(int[] array) {
    boolean swapped = true;
    for (int a = 0; a < array.length && swapped; a++) {
        swapped = false;
        for (int b = 0; b < array.length - 1 - a; b++) {
           if (array[b] > array[b+1]) {
               int temp = array[b];
               array[b] = array[b+1];
               array[b+1]= temp;
               swapped = true;
           }
        }
    }
}


void bubbleSortRenamedargs(int[] list) {
    boolean swapped = true;
    for (int i = 0; i < list.length && swapped; i++) {
        swapped = false;
        for (int j = 0; j < list.length - 1 - i; j++) {
           if (list[j] > list[j+1]) {
               int temp = list[j];
               list[j] = list[j+1];
               list[j+1]= temp;
               swapped = true;
           }
        }
    }
}


void bubbleSortReordered(int[] array) {
    boolean swapped = true;
    for (int i = 0; i < array.length && swapped; i++) {
        swapped = false;
        for (int j = 0; j < array.length - 1 - i; j++) {
           if (array[j] > array[j+1]) {
               swapped = true;
               int temp = array[j];
               array[j] = array[j+1];
               array[j+1]= temp;
           }
        }
    }
}


void bubbleSortDifferenttype(float[] array) {
    boolean swapped = true;
    for (int i = 0; i < array.length && swapped; i++) {
        swapped = false;
        for (int j = 0; j < array.length - 1 - i; j++) {
           if (array[j] > array[j+1]) {
               float temp = array[j];
               array[j] = array[j+1];
               array[j+1]= temp;
               swapped = true;
           }
        }
    }
}


void bubbleSortReimplemented(int[] array) {
    boolean swapped = true;
    int i = 0;
    while (i < array.length && swapped){
        swapped = false;
        int j = 0;
        while (j < array.length - 1 - i){
           if (array[j] > array[j+1]) {
               int temp = array[j];
               array[j] = array[j+1];
               array[j+1]= temp;
               swapped = true;
           }
           j++;
        }
        i++;
    }
}


void bubbleSortReimplemented2(int[] array){
    int n = array.length;
    for (int i = 0; i < n-1; i++)
        for (int j = 0; j < n-i-1; j++)
            if (array[j] > array[j+1]){
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
}


void bubbleSortReimplemented3(int[] array) {
    boolean swapped = true;
    for (int i = 0; i < array.length; i++) {
        swapped = false;
        for (int j = 0; j < array.length - 1 - i; j++) {
           if (array[j] > array[j+1]) {
               int temp = array[j];
               array[j] = array[j+1];
               array[j+1]= temp;
               swapped = true;
           }
        }
        if (swapped){
            break;
        }
    }
}


void reverseArray(int[] array) {
    for (int left = 0, right = array.length - 1; left < right; left++, right--) {
        int temp = array[left];
        array[left]  = array[right];
        array[right] = temp;
    }
}


void InsertionSort(int[] array) {
    int n = array.length;
    for (int i = 1; i < n; ++i) {
        int key = array[i];
        int j = i - 1;
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j];
            j = j - 1;
        }
        array[j + 1] = key;
    }
}


boolean hasDuplicates(int[] array) {
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array.length; j++) {
           if (array[i] == array[j] && i!=j) {
               return true;
           }
        }
    }
    return false;
}


boolean isPrime(int n) {
    if (n <= 1) {
        return false;
    }
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}


boolean isPrimeRenameloopvar(int n) {
    if (n <= 1) {
        return false;
    }
    for (int a = 2; a * a <= n; a++) {
        if (n % a == 0) {
            return false;
        }
    }
    return true;
}


boolean isPrimeRenameargs(int a) {
    if (a <= 1) {
        return false;
    }
    for (int i = 2; i * i <= a; i++) {
        if (a % i == 0) {
            return false;
        }
    }
    return true;
}


boolean isPrimeReimplemented(int n) {
    if (n <= 1) {
        return false;
    }
    for (int i = 2; i <= n; i++) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}


boolean isPrimeReimplemente2(int n) {
    if (n <= 1) {
        return false;
    }
    int i = 2;
    while (i * i <= n) {
        if (n % i == 0) {
            return false;
        }
        i++;
    }
    return true;
}


boolean isPrimeReimplemented3(int n) {
    if (n <= 1)
        return false;
    if (n <= 3)
        return true;
    if (n % 2 == 0 || n % 3 == 0)
        return false;
    for (int i = 5; i * i <= n; i = i + 6)
        if (n % i == 0 || n % (i + 2) == 0)
            return false;
    return true;
}


int smallestDivisor(int n) {
    if (n <= 1) {
        return 1;
    }
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) {
            return i;
        }
    }
    return 1;
}


int gcdByBruteForce(int n1, int n2) {
    int gcd = 1;
    for (int i = 1; i <= n1 && i <= n2; i++) {
        if (n1 % i == 0 && n2 % i == 0) {
            gcd = i;
        }
    }
    return gcd;
}


int binarySearch(int arr[], int x) {
    int l = 0, r = arr.length - 1;
    while (l <= r) {
        int m = l + (r - l) / 2;
        if (arr[m] == x)
            return m;
        if (arr[m] < x)
            l = m + 1;
        else
            r = m - 1;
    }
    return -1;
}


int binarySearchRenamedvars(int arr[], int x) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int middle = left + (right - left) / 2;
        if (arr[middle] == x)
            return m;
        if (arr[middle] < x)
            left = middle + 1;
        else
            right = middle - 1;
    }
    return -1;
}


int binarySearchRenamedargs(int list[], int a) {
    int l = 0, r = list.length - 1;
    while (l <= r) {
        int m = l + (r - l) / 2;
        if (list[m] == a)
            return m;
        if (list[m] < a)
            l = m + 1;
        else
            r = m - 1;
    }
    return -1;
}


int binarySearchReordered(int arr[], int x) {
    int l = 0, r = arr.length - 1;
    while (l <= r) {
        int m = l + (r - l) / 2;
        if (arr[m] == x)
            return m;
        if (arr[m] > x)
            r = m - 1;
        else
            l = m + 1;
    }
    return -1;
}


int binarySearchReordered2(int arr[], int x) {
    int l = 0, r = arr.length - 1;
    while (l <= r) {
        int m = l + (r - l) / 2;
        if (arr[m] > x)
            r = m - 1;
        if (arr[m] < x)
            l = m + 1;
        else
            return m;
    }
    return -1;
}


int binarySearchReordered3(int arr[], int x) {
    int l = 0, r = arr.length - 1;
    while (l <= r) {
        int m = l + (r - l) / 2;
        if (arr[m] < x)
            l = m + 1;
        if (arr[m] > x)
            r = m - 1;
        else
            return m;
    }
    return -1;
}



int binarySearchDifferenttype(float arr[], float x) {
    int l = 0, r = arr.length - 1;
    while (l <= r) {
        int m = l + (r - l) / 2;
        if (arr[m] == x)
            return m;
        if (arr[m] < x)
            l = m + 1;
        else
            r = m - 1;
    }
    return -1;
}


 int binarySearchReimplemented(int arr[], int l, int r, int x){  
    if (r>=l) {  
        int m = l + (r - l)/2;  
        if (arr[m] == x) {  
            return m;  
        }  
        if (arr[m] > x) {  
            return binarySearch(arr, l, m-1, x);
        } else {  
            return binarySearch(arr, m+1, r, x); 
        }  
    }  
    return -1;  
}  


void BFS(int s){
    boolean visited[] = new boolean[V];
    LinkedList<Integer> queue = new LinkedList<Integer>();
    visited[s]=true;
    queue.add(s);
    while (queue.size() != 0) {
        s = queue.poll();
        System.out.print(s + " ");
        Iterator<Integer> i = adj[s].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
            {
                visited[n] = true;
                queue.add(n);
            }
        }
    }
}


void BFSRenamedvars(int s){
    boolean alreadySearched[] = new boolean[V];
    LinkedList<Integer> differentNameForQueue = new LinkedList<Integer>();
    alreadySearched[s]=true;
    differentNameForQueue.add(s);
    while (differentNameForQueue.size() != 0) {
        s = differentNameForQueue.poll();
        System.out.print(s + " ");
        Iterator<Integer> i = adj[s].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!alreadySearched[n])
            {
                alreadySearched[n] = true;
                differentNameForQueue.add(n);
            }
        }
    }
}


void BFSRenamedargs(int n){
    boolean visited[] = new boolean[V];
    LinkedList<Integer> queue = new LinkedList<Integer>();
    visited[n]=true;
    queue.add(n);
    while (queue.size() != 0) {
        n = queue.poll();
        System.out.print(n + " ");
        Iterator<Integer> i = adj[n].listIterator();
        while (i.hasNext())
        {
            int c = i.next();
            if (!visited[c])
            {
                visited[c] = true;
                queue.add(c);
            }
        }
    }
}


void BFSReordered(int s){
    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.add(s);
    boolean visited[] = new boolean[V];
    visited[s]=true;
    while (queue.size() != 0) {
        s = queue.poll();
        Iterator<Integer> i = adj[s].listIterator();
        System.out.print(s + " ");
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
            {
                queue.add(n);
                visited[n] = true;
            }
        }
    }
}


void BFSReimplemented() {
    Queue q = new LinkedList();
    for (i = 0; i < visited.length; i++)
        visited[i] = false;
    q.add(0);
    while(! q.isEmpty()) {
        int nextNode;
        int i;
        nextNode = q.remove();
        if (!visited[nextNode]) {
        visited[nextNode] = true;
        System.out.println("nextNode = " + nextNode);
        for ( i = 0; i < NNodes; i++ )
            if ( adjMatrix[nextNode][i] > 0 && ! visited[i] )
                q.add(i);
        }
    }
}


int editDistance(String word1, String word2) {
	int len1 = word1.length();
	int len2 = word2.length();
	int[][] dp = new int[len1 + 1][len2 + 1];
	for (int i = 0; i <= len1; i++) {
		dp[i][0] = i;
	}
	for (int j = 0; j <= len2; j++) {
		dp[0][j] = j;
	}
	for (int i = 0; i < len1; i++) {
		char c1 = word1.charAt(i);
		for (int j = 0; j < len2; j++) {
			char c2 = word2.charAt(j);
			if (c1 == c2) {
				dp[i + 1][j + 1] = dp[i][j];
			} else {
				int replace = dp[i][j] + 1;
				int insert = dp[i][j + 1] + 1;
				int delete = dp[i + 1][j] + 1;
				int min = replace > insert ? insert : replace;
				min = delete > min ? min : delete;
				dp[i + 1][j + 1] = min;
			}
		}
	}
	return dp[len1][len2];
}


int editDistanceRenamedvars(String word1, String word2) {
	int numberOfLetters1 = word1.length();
	int numberOfLetters2 = word2.length();
	int[][] array = new int[numberOfLetters1 + 1][numberOfLetters2 + 1];
	for (int i = 0; i <= numberOfLetters1; i++) {
		array[i][0] = i;
	}
	for (int j = 0; j <= numberOfLetters2; j++) {
		array[0][j] = j;
	}
	for (int i = 0; i < numberOfLetters1; i++) {
		char c1 = word1.charAt(i);
		for (int j = 0; j < numberOfLetters2; j++) {
			char c2 = word2.charAt(j);
			if (c1 == c2) {
				array[i + 1][j + 1] = array[i][j];
			} else {
				int r = array[i][j] + 1;
				int i = array[i][j + 1] + 1;
				int d = array[i + 1][j] + 1;
				int res = r > i ? i : r;
				res = d > res ? res : d;
				array[i + 1][j + 1] = res;
			}
		}
	}
	return array[numberOfLetters1][numberOfLetters2];
}


int editDistanceRenamedloopvars(String word1, String word2) {
	int len1 = word1.length();
	int len2 = word2.length();
	int[][] dp = new int[len1 + 1][len2 + 1];
	for (int a = 0; a <= len1; a++) {
		dp[a][0] = a;
	}
	for (int b = 0; b <= len2; b++) {
		dp[0][b] = b;
	}
	for (int z = 0; z < len1; z++) {
		char c1 = word1.charAt(z);
		for (int t = 0; t < len2; t++) {
			char c2 = word2.charAt(t);
			if (c1 == c2) {
				dp[z + 1][t + 1] = dp[z][t];
			} else {
				int replace = dp[z][t] + 1;
				int insert = dp[z][t + 1] + 1;
				int delete = dp[z + 1][t] + 1;
				int min = replace > insert ? insert : replace;
				min = delete > min ? min : delete;
				dp[z + 1][t + 1] = min;
			}
		}
	}
	return dp[len1][len2];
}


int editDistanceRenemedargs(String string1, String string2) {
	int len1 = string1.length();
	int len2 = string2.length();
	int[][] dp = new int[len1 + 1][len2 + 1];
	for (int i = 0; i <= len1; i++) {
		dp[i][0] = i;
	}
	for (int j = 0; j <= len2; j++) {
		dp[0][j] = j;
	}
	for (int i = 0; i < len1; i++) {
		char c1 = string1.charAt(i);
		for (int j = 0; j < len2; j++) {
			char c2 = string2.charAt(j);
			if (c1 == c2) {
				dp[i + 1][j + 1] = dp[i][j];
			} else {
				int replace = dp[i][j] + 1;
				int insert = dp[i][j + 1] + 1;
				int delete = dp[i + 1][j] + 1;
				int min = replace > insert ? insert : replace;
				min = delete > min ? min : delete;
				dp[i + 1][j + 1] = min;
			}
		}
	}
	return dp[len1][len2];
}


int editDistanceReordered(String word1, String word2) {
    int len2 = word2.length();
	int len1 = word1.length();
	int[][] dp = new int[len1 + 1][len2 + 1];
	for (int j = 0; j <= len2; j++) {
		dp[0][j] = j;
	}
    for (int i = 0; i <= len1; i++) {
		dp[i][0] = i;
	}
	for (int i = 0; i < len1; i++) {
		char c1 = word1.charAt(i);
		for (int j = 0; j < len2; j++) {
			char c2 = word2.charAt(j);
			if (c1 == c2) {
				dp[i + 1][j + 1] = dp[i][j];
			} else {
                int delete = dp[i + 1][j] + 1;
                int insert = dp[i][j + 1] + 1;
				int replace = dp[i][j] + 1;
				int min = replace > insert ? insert : replace;
				min = delete > min ? min : delete;
				dp[i + 1][j + 1] = min;
			}
		}
	}
	return dp[len1][len2];
}


int editDistanceReimplemented(String word1, String word2) {
	int len1 = word1.length();
	int len2 = word2.length();
	int[][] dp = new int[len1 + 1][len2 + 1];
    int i = 0;
	while (i <= len1) {
		dp[i][0] = i;
        i++;
	}
    int j = 0;
	while (j <= len2) {
		dp[0][j] = j;
        j++;
	}
    int i = 0;
	while (i < len1) {
		char c1 = word1.charAt(i);
        int j = 0;
		while (j < len2) {
			char c2 = word2.charAt(j);
			if (c1 == c2) {
				dp[i + 1][j + 1] = dp[i][j];
			} else {
				int replace = dp[i][j] + 1;
				int insert = dp[i][j + 1] + 1;
				int delete = dp[i + 1][j] + 1;
				int min = replace > insert ? insert : replace;
				min = delete > min ? min : delete;
				dp[i + 1][j + 1] = min;
			}
            j++;
		}
        i++;
	}
	return dp[len1][len2];
}


int editDistanceReimplemented(String word1, String word2) {
	int len1 = word1.length();
	int len2 = word2.length();
	int[][] dp = new int[len1 + 1][len2 + 1];
	for (int i = 0; i <= len1; i++) {
		dp[i][0] = i;
	}
	for (int j = 0; j <= len2; j++) {
		dp[0][j] = j;
	}
	for (int i = 0; i < len1; i++) {
		char c1 = word1.charAt(i);
		for (int j = 0; j < len2; j++) {
			char c2 = word2.charAt(j);
			if (c1 == c2) {
				dp[i + 1][j + 1] = dp[i][j];
			} else {
				int replace = dp[i][j] + 1;
				int insert = dp[i][j + 1] + 1;
				int delete = dp[i + 1][j] + 1;
				int min = delete > insert ? insert : delete;
				min = replace > min ? min : replace;
				dp[i + 1][j + 1] = min;
			}
		}
	}
	return dp[len1][len2];
}


int editDistReimplemented(String s1, String s2) {
    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    for (int row = s2.length(); row >= 0; row--) {
        dp[row][s1.length()] = s2.length() - row;
    }
    for (int col = s1.length(); col >= 0; col--) {
        dp[s2.length()][col] = s1.length() - col;
    }
    for (int col = s1.length() - 1; col >= 0; col--) {
        for (int row = s2.length() - 1; row >= 0; row--) {
            if (s1.charAt(col) == s2.charAt(row)) {
                dp[row][col] = dp[row + 1][col + 1];
            } else {
            dp[row][col] = 1 + Math.min(dp[row + 1][col + 1], Math.min(dp[row][col + 1], dp[row + 1][col]));
            }
        }
    }
    return dp[0][0];
}
