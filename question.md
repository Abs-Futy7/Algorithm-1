# Algorithm Viva Preparation Guide

## 1. ASYMPTOTIC NOTATIONS

### Key Concepts:
- **Big-O (O)**: Upper bound (worst case)
- **Omega (Ω)**: Lower bound (best case)  
- **Theta (Θ)**: Tight bound (average case)

### Possible Questions:
1. **Q: What is the difference between Big-O, Omega, and Theta notations?**
   - **A:** Big-O gives upper bound (worst case), Omega gives lower bound (best case), Theta gives tight bound (exact growth rate)

2. **Q: What is the time complexity of Binary Search?**
   - **A:** O(log n) - divides search space in half each time

3. **Q: Compare time complexities: O(n), O(n²), O(log n), O(n log n)**
   - **A:** O(log n) < O(n) < O(n log n) < O(n²)

4. **Q: What does O(1) mean?**
   - **A:** Constant time - execution time doesn't change with input size

---

## 2. DYNAMIC PROGRAMMING

### Key Concepts:
- **Overlapping Subproblems**: Same subproblems solved multiple times
- **Optimal Substructure**: Optimal solution contains optimal solutions to subproblems
- **Memoization**: Top-down approach with caching
- **Tabulation**: Bottom-up approach

### Possible Questions:
1. **Q: What are the two main properties required for Dynamic Programming?**
   - **A:** Overlapping subproblems and optimal substructure

2. **Q: Difference between Memoization and Tabulation?**
   - **A:** 
     - Memoization: Top-down, recursive, stores results on demand
     - Tabulation: Bottom-up, iterative, fills table systematically

3. **Q: Explain 0/1 Knapsack problem approach**
   - **A:** 
     - State: dp[i][w] = maximum value using first i items with weight limit w
     - Recurrence: dp[i][w] = max(dp[i-1][w], dp[i-1][w-weight[i]] + value[i])

4. **Q: What is the time complexity of Fibonacci using DP?**
   - **A:** O(n) with DP vs O(2ⁿ) with naive recursion

### Common DP Problems in Your Code:
- **Fibonacci**: O(n) time, O(1) space (optimized)
- **Longest Common Subsequence**: O(mn) time and space
- **Knapsack 0/1**: O(nW) time, O(nW) space
- **Edit Distance**: O(mn) time and space
- **Maximum Subarray**: O(n) time, O(1) space

---

## 3. GREEDY ALGORITHMS

### Key Concepts:
- **Greedy Choice Property**: Locally optimal choice leads to global optimum
- **No backtracking**: Once choice is made, it's never reconsidered

### Possible Questions:
1. **Q: When does Greedy algorithm work?**
   - **A:** When problem has greedy choice property and optimal substructure

2. **Q: Explain Activity Selection problem**
   - **A:** 
     - Sort activities by finish time
     - Select activity with earliest finish time that doesn't conflict
     - Time complexity: O(n log n)

3. **Q: Difference between Greedy and Dynamic Programming?**
   - **A:**
     - Greedy: Makes local optimal choice, no backtracking
     - DP: Considers all possibilities, builds optimal solution

4. **Q: Explain Fractional Knapsack approach**
   - **A:**
     - Sort items by value/weight ratio
     - Take items greedily until knapsack is full
     - Can take fractions of items

### Greedy Algorithms in Your Code:
- **Activity Selection**: O(n log n)
- **Fractional Knapsack**: O(n log n)
- **Job Sequencing**: O(n log n)
- **Minimum Spanning Tree (Kruskal/Prim)**: O(E log V)

---

## 4. GRAPH ALGORITHMS

### Key Concepts:
- **Traversal**: DFS, BFS
- **Shortest Path**: Dijkstra, Bellman-Ford, Floyd-Warshall
- **Minimum Spanning Tree**: Kruskal, Prim
- **Topological Sort**: Kahn's algorithm, DFS-based

### Possible Questions:

#### Graph Traversal:
1. **Q: Difference between DFS and BFS?**
   - **A:**
     - DFS: Uses stack/recursion, goes deep first, O(V+E)
     - BFS: Uses queue, explores level by level, O(V+E)

2. **Q: Applications of DFS?**
   - **A:** Topological sort, cycle detection, strongly connected components

3. **Q: Applications of BFS?**
   - **A:** Shortest path in unweighted graphs, level-order traversal

#### Shortest Path:
4. **Q: When to use Dijkstra vs Bellman-Ford?**
   - **A:**
     - Dijkstra: Non-negative weights, O(V²) or O(E log V)
     - Bellman-Ford: Can handle negative weights, O(VE)

5. **Q: Explain Floyd-Warshall algorithm**
   - **A:**
     - All-pairs shortest path
     - Dynamic programming approach
     - Time complexity: O(V³)

#### Minimum Spanning Tree:
6. **Q: Difference between Kruskal and Prim's algorithm?**
   - **A:**
     - Kruskal: Edge-based, uses Union-Find, O(E log E)
     - Prim: Vertex-based, uses priority queue, O(E log V)

#### Topological Sort:
7. **Q: What is topological sorting?**
   - **A:** Linear ordering of vertices in DAG where u comes before v if there's edge u→v

8. **Q: Kahn's algorithm vs DFS-based topological sort?**
   - **A:**
     - Kahn's: Uses in-degree, BFS-like approach
     - DFS-based: Uses finishing time, reverse post-order

### Graph Algorithms in Your Code:
- **DFS/BFS Traversal**: O(V+E)
- **Dijkstra**: O(E log V)
- **Bellman-Ford**: O(VE)
- **Floyd-Warshall**: O(V³)
- **Kruskal MST**: O(E log E)
- **Prim MST**: O(E log V)
- **Topological Sort**: O(V+E)

---

## 5. DIVIDE AND CONQUER

### Key Concepts:
- **Divide**: Break problem into smaller subproblems
- **Conquer**: Solve subproblems recursively
- **Combine**: Merge solutions

### Possible Questions:
1. **Q: Explain Merge Sort algorithm**
   - **A:**
     - Divide array into two halves
     - Recursively sort both halves
     - Merge sorted halves
     - Time complexity: O(n log n)

2. **Q: What is Inversion Count problem?**
   - **A:** Count pairs (i,j) where i < j but arr[i] > arr[j]
   - Can be solved using modified merge sort in O(n log n)

---

## 6. NETWORK PROGRAMMING & ERROR DETECTION

### Key Concepts:
- **CRC (Cyclic Redundancy Check)**: Error detection
- **Socket Programming**: Client-server communication

### Possible Questions:
1. **Q: How does CRC work?**
   - **A:**
     - Append zeros to data
     - Divide by generator polynomial
     - Remainder becomes CRC bits
     - Append CRC to data for transmission

2. **Q: Single-bit vs Multi-bit error correction?**
   - **A:**
     - Single-bit: Flip each bit and check CRC
     - Multi-bit: More complex, may need advanced techniques

---

## 7. COMPREHENSIVE ALGORITHM COMPLEXITY TABLE

| Algorithm | Time Complexity | Space Complexity | Best Case | Worst Case | Average Case |
|-----------|----------------|------------------|-----------|------------|--------------|
| **SORTING ALGORITHMS** |
| Bubble Sort | O(n²) | O(1) | O(n) | O(n²) | O(n²) |
| Selection Sort | O(n²) | O(1) | O(n²) | O(n²) | O(n²) |
| Insertion Sort | O(n²) | O(1) | O(n) | O(n²) | O(n²) |
| Merge Sort | O(n log n) | O(n) | O(n log n) | O(n log n) | O(n log n) |
| Quick Sort | O(n log n) | O(log n) | O(n log n) | O(n²) | O(n log n) |
| Heap Sort | O(n log n) | O(1) | O(n log n) | O(n log n) | O(n log n) |
| **SEARCHING ALGORITHMS** |
| Linear Search | O(n) | O(1) | O(1) | O(n) | O(n) |
| Binary Search | O(log n) | O(1) | O(1) | O(log n) | O(log n) |
| **GRAPH ALGORITHMS** |
| DFS Traversal | O(V+E) | O(V) | O(V+E) | O(V+E) | O(V+E) |
| BFS Traversal | O(V+E) | O(V) | O(V+E) | O(V+E) | O(V+E) |
| Dijkstra | O(E log V) | O(V) | O(E log V) | O(E log V) | O(E log V) |
| Bellman-Ford | O(VE) | O(V) | O(VE) | O(VE) | O(VE) |
| Floyd-Warshall | O(V³) | O(V²) | O(V³) | O(V³) | O(V³) |
| Kruskal MST | O(E log E) | O(V) | O(E log E) | O(E log E) | O(E log E) |
| Prim MST | O(E log V) | O(V) | O(E log V) | O(E log V) | O(E log V) |
| Topological Sort | O(V+E) | O(V) | O(V+E) | O(V+E) | O(V+E) |
| Kosaraju SCC | O(V+E) | O(V) | O(V+E) | O(V+E) | O(V+E) |
| **DYNAMIC PROGRAMMING** |
| Fibonacci (DP) | O(n) | O(1) | O(n) | O(n) | O(n) |
| Fibonacci (Recursive) | O(2ⁿ) | O(n) | O(2ⁿ) | O(2ⁿ) | O(2ⁿ) |
| 0/1 Knapsack | O(nW) | O(nW) | O(nW) | O(nW) | O(nW) |
| LCS | O(mn) | O(mn) | O(mn) | O(mn) | O(mn) |
| Edit Distance | O(mn) | O(mn) | O(mn) | O(mn) | O(mn) |
| LIS | O(n log n) | O(n) | O(n log n) | O(n log n) | O(n log n) |
| Maximum Subarray | O(n) | O(1) | O(n) | O(n) | O(n) |
| Rod Cutting | O(n²) | O(n) | O(n²) | O(n²) | O(n²) |
| Coin Change | O(nW) | O(nW) | O(nW) | O(nW) | O(nW) |
| **GREEDY ALGORITHMS** |
| Activity Selection | O(n log n) | O(1) | O(n log n) | O(n log n) | O(n log n) |
| Fractional Knapsack | O(n log n) | O(1) | O(n log n) | O(n log n) | O(n log n) |
| Job Sequencing | O(n log n) | O(n) | O(n log n) | O(n log n) | O(n log n) |
| Huffman Coding | O(n log n) | O(n) | O(n log n) | O(n log n) | O(n log n) |
| **DIVIDE AND CONQUER** |
| Merge Sort | O(n log n) | O(n) | O(n log n) | O(n log n) | O(n log n) |
| Quick Sort | O(n log n) | O(log n) | O(n log n) | O(n²) | O(n log n) |
| Binary Search | O(log n) | O(1) | O(1) | O(log n) | O(log n) |
| Inversion Count | O(n log n) | O(n) | O(n log n) | O(n log n) | O(n log n) |

---

## 8. SHORTEST ALGORITHM CODES

### DYNAMIC PROGRAMMING CODES:

#### 1. Fibonacci (Space Optimized)
```java
public static int fibonacci(int n) {
    if (n <= 1) return n;
    int a = 0, b = 1;
    for (int i = 2; i <= n; i++) {
        int temp = a + b;
        a = b;
        b = temp;
    }
    return b;
}
// TC: O(n), SC: O(1)
```

#### 2. 0/1 Knapsack
```java
public static int knapsack(int[] wt, int[] val, int W) {
    int n = wt.length;
    int[][] dp = new int[n+1][W+1];
    
    for (int i = 1; i <= n; i++) {
        for (int w = 1; w <= W; w++) {
            if (wt[i-1] <= w) {
                dp[i][w] = Math.max(dp[i-1][w], 
                                   dp[i-1][w-wt[i-1]] + val[i-1]);
            } else {
                dp[i][w] = dp[i-1][w];
            }
        }
    }
    return dp[n][W];
}
// TC: O(nW), SC: O(nW)
```

#### 3. Longest Common Subsequence
```java
public static int lcs(String s1, String s2) {
    int m = s1.length(), n = s2.length();
    int[][] dp = new int[m+1][n+1];
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                dp[i][j] = dp[i-1][j-1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }
    return dp[m][n];
}
// TC: O(mn), SC: O(mn)
```

#### 4. Maximum Subarray (Kadane's Algorithm)
```java
public static int maxSubArray(int[] arr) {
    int maxSoFar = arr[0];
    int maxEndingHere = arr[0];
    
    for (int i = 1; i < arr.length; i++) {
        maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
        maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
}
// TC: O(n), SC: O(1)
```

#### 5. Coin Change (Minimum Coins)
```java
public static int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    
    for (int i = 1; i <= amount; i++) {
        for (int coin : coins) {
            if (coin <= i) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
    }
    return dp[amount] > amount ? -1 : dp[amount];
}
// TC: O(n*amount), SC: O(amount)
```

### GREEDY ALGORITHM CODES:

#### 1. Activity Selection
```java
public static int activitySelection(int[] start, int[] finish) {
    int n = start.length;
    // Sort by finish time
    Integer[] indices = new Integer[n];
    for (int i = 0; i < n; i++) indices[i] = i;
    Arrays.sort(indices, (a, b) -> finish[a] - finish[b]);
    
    int count = 1;
    int lastFinish = finish[indices[0]];
    
    for (int i = 1; i < n; i++) {
        if (start[indices[i]] >= lastFinish) {
            count++;
            lastFinish = finish[indices[i]];
        }
    }
    return count;
}
// TC: O(n log n), SC: O(1)
```

#### 2. Fractional Knapsack
```java
static class Item {
    int value, weight;
    double ratio;
    Item(int v, int w) { value = v; weight = w; ratio = (double)v/w; }
}

public static double fractionalKnapsack(int[] values, int[] weights, int W) {
    int n = values.length;
    Item[] items = new Item[n];
    for (int i = 0; i < n; i++) {
        items[i] = new Item(values[i], weights[i]);
    }
    
    Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
    
    double totalValue = 0;
    for (Item item : items) {
        if (W >= item.weight) {
            totalValue += item.value;
            W -= item.weight;
        } else {
            totalValue += item.value * ((double)W / item.weight);
            break;
        }
    }
    return totalValue;
}
// TC: O(n log n), SC: O(n)
```

#### 3. Job Sequencing
```java
static class Job {
    int id, profit, deadline;
    Job(int i, int p, int d) { id = i; profit = p; deadline = d; }
}

public static int jobSequencing(Job[] jobs) {
    Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
    
    int maxDeadline = Arrays.stream(jobs)
                           .mapToInt(job -> job.deadline)
                           .max().orElse(0);
    
    boolean[] slot = new boolean[maxDeadline + 1];
    int totalProfit = 0;
    
    for (Job job : jobs) {
        for (int j = job.deadline; j > 0; j--) {
            if (!slot[j]) {
                slot[j] = true;
                totalProfit += job.profit;
                break;
            }
        }
    }
    return totalProfit;
}
// TC: O(n²), SC: O(n)
```

#### 4. Minimum Coins (Greedy - only works for canonical coin systems)
```java
public static int minCoins(int[] coins, int amount) {
    Arrays.sort(coins);
    int count = 0;
    
    for (int i = coins.length - 1; i >= 0; i--) {
        while (amount >= coins[i]) {
            amount -= coins[i];
            count++;
        }
    }
    return amount == 0 ? count : -1;
}
// TC: O(n log n), SC: O(1)
```

#### 5. Huffman Coding (Simplified)
```java
static class Node {
    int freq;
    char ch;
    Node left, right;
    
    Node(char c, int f) { ch = c; freq = f; }
    Node(int f) { freq = f; }
}

public static Node huffmanCoding(char[] chars, int[] freqs) {
    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);
    
    for (int i = 0; i < chars.length; i++) {
        pq.offer(new Node(chars[i], freqs[i]));
    }
    
    while (pq.size() > 1) {
        Node left = pq.poll();
        Node right = pq.poll();
        Node merged = new Node(left.freq + right.freq);
        merged.left = left;
        merged.right = right;
        pq.offer(merged);
    }
    
    return pq.poll();
}
// TC: O(n log n), SC: O(n)
```

---

## 9. ALGORITHM COMPARISON TABLE

| Algorithm Type | Time Complexity | Space Complexity | When to Use |
|---------------|----------------|------------------|-------------|
| **Sorting** |
| Merge Sort | O(n log n) | O(n) | Stable, worst-case guarantee |
| Quick Sort | O(n log n) avg, O(n²) worst | O(log n) | In-place, average case |
| **Searching** |
| Binary Search | O(log n) | O(1) | Sorted array |
| Linear Search | O(n) | O(1) | Unsorted array |
| **Graph** |
| DFS | O(V+E) | O(V) | Topological sort, cycle detection |
| BFS | O(V+E) | O(V) | Shortest path (unweighted) |
| Dijkstra | O(E log V) | O(V) | Non-negative weights |
| **DP** |
| Fibonacci | O(n) | O(1) | Overlapping subproblems |
| LCS | O(mn) | O(mn) | String matching |
| **Greedy** |
| Activity Selection | O(n log n) | O(1) | Scheduling problems |
| Kruskal MST | O(E log E) | O(V) | Sparse graphs |

---

## 10. IMPORTANT CODING QUESTIONS

### Be ready to trace through these algorithms:
1. **Fibonacci with memoization**
2. **0/1 Knapsack recurrence relation**
3. **Dijkstra's algorithm step by step**
4. **DFS and BFS traversal**
5. **Activity selection greedy choice**
6. **Merge sort divide and conquer**
7. **CRC calculation and error detection**

### Common Viva Tricks:
- **Draw diagrams** for graph algorithms
- **Trace through small examples** step by step
- **Compare time/space complexities**
- **Explain why certain approaches work**
- **Discuss trade-offs** between different methods

---

## 11. LAST-MINUTE TIPS

### Must Remember:
- **Big-O hierarchy**: O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(2ⁿ)
- **DP conditions**: Overlapping subproblems + Optimal substructure
- **Greedy works when**: Greedy choice property holds
- **Graph representations**: Adjacency matrix vs adjacency list
- **MST algorithms**: Kruskal (edge-based) vs Prim (vertex-based)

### Practice Questions:
1. Trace Dijkstra on a small graph
2. Calculate Big-O for nested loops
3. Explain why greedy works for Activity Selection
4. Show DP table for small Knapsack instance
5. Compare DFS vs BFS for finding cycles

---

## 12. ALGORITHM SELECTION SCENARIOS

### **WHEN TO USE WHICH ALGORITHM?**

#### **SORTING ALGORITHMS:**

| Scenario | Best Algorithm | Why? |
|----------|---------------|------|
| **Small dataset (n < 50)** | Insertion Sort | Simple, low overhead, O(n) best case |
| **Nearly sorted data** | Insertion Sort | O(n) time for already sorted data |
| **Memory constrained** | Heap Sort | O(1) space, guaranteed O(n log n) |
| **Stability required** | Merge Sort | Stable, guaranteed O(n log n) |
| **Average case performance** | Quick Sort | O(n log n) average, in-place |
| **Worst case guarantee** | Merge Sort | Always O(n log n), no worst case |
| **External sorting** | Merge Sort | Good for disk-based sorting |

#### **SEARCHING ALGORITHMS:**

| Scenario | Best Algorithm | Why? |
|----------|---------------|------|
| **Sorted array** | Binary Search | O(log n) vs O(n) |
| **Unsorted array** | Linear Search | No choice, must check all |
| **Single search** | Linear Search | No preprocessing needed |
| **Multiple searches** | Binary Search | Sort once, search many times |
| **Memory constrained** | Binary Search | O(1) space |

#### **GRAPH ALGORITHMS:**

| Scenario | Best Algorithm | Why? |
|----------|---------------|------|
| **Unweighted shortest path** | BFS | O(V+E), finds shortest path |
| **Weighted shortest path (non-negative)** | Dijkstra | O(E log V), handles weights |
| **Negative weight edges** | Bellman-Ford | O(VE), detects negative cycles |
| **All-pairs shortest path** | Floyd-Warshall | O(V³), finds all pairs |
| **Sparse graph MST** | Kruskal | O(E log E), edge-based |
| **Dense graph MST** | Prim | O(V²), vertex-based |
| **Cycle detection** | DFS | O(V+E), uses recursion stack |
| **Topological ordering** | DFS or Kahn's | O(V+E), depends on preference |
| **Strongly connected components** | Kosaraju | O(V+E), two DFS passes |

#### **DYNAMIC PROGRAMMING vs GREEDY:**

| Problem Type | Use DP When | Use Greedy When |
|-------------|-------------|-----------------|
| **Optimization** | Multiple optimal solutions exist | Single greedy choice leads to optimum |
| **Subproblems** | Overlapping subproblems | Independent subproblems |
| **Complexity** | Can handle complex constraints | Simple, intuitive solution |
| **Examples** | 0/1 Knapsack, LCS | Activity Selection, Fractional Knapsack |

#### **DIVIDE AND CONQUER SCENARIOS:**

| Scenario | Best Algorithm | Why? |
|----------|---------------|------|
| **Large dataset sorting** | Merge Sort | O(n log n), stable |
| **Average case sorting** | Quick Sort | O(n log n) average, in-place |
| **Finding element** | Binary Search | O(log n), sorted array |
| **Counting inversions** | Modified Merge Sort | O(n log n) vs O(n²) |

---

## 13. PROBLEM-SPECIFIC ALGORITHM CHOICES

### **COMMON VIVA SCENARIOS:**

#### **1. "I have a large dataset to sort, which algorithm?"**
**Answer:** 
- **If memory is limited**: Heap Sort (O(1) space)
- **If stability needed**: Merge Sort (stable)
- **For best average performance**: Quick Sort
- **For guaranteed performance**: Merge Sort

#### **2. "I need to find shortest path in a graph, which algorithm?"**
**Answer:**
- **Unweighted graph**: BFS (O(V+E))
- **Weighted, non-negative**: Dijkstra (O(E log V))
- **Negative weights**: Bellman-Ford (O(VE))
- **All pairs**: Floyd-Warshall (O(V³))

#### **3. "Should I use DP or Greedy for optimization?"**
**Answer:**
- **Use DP if**: Problem has overlapping subproblems AND optimal substructure
- **Use Greedy if**: Greedy choice property holds AND optimal substructure exists
- **Test**: If greedy doesn't work on small examples, use DP

#### **4. "Which MST algorithm to choose?"**
**Answer:**
- **Sparse graph (E << V²)**: Kruskal (O(E log E))
- **Dense graph (E ≈ V²)**: Prim (O(V²) with array, O(E log V) with heap)
- **Need edge-based approach**: Kruskal
- **Need vertex-based approach**: Prim

#### **5. "DFS or BFS for graph traversal?"**
**Answer:**
- **DFS for**: Topological sort, cycle detection, path finding
- **BFS for**: Shortest path (unweighted), level-order traversal
- **Memory**: DFS uses less memory for sparse graphs

### **TRADE-OFF ANALYSIS:**

#### **Time vs Space Trade-offs:**
| Algorithm | Time | Space | Trade-off |
|-----------|------|-------|-----------|
| **Merge Sort** | O(n log n) | O(n) | Guaranteed time, uses extra space |
| **Quick Sort** | O(n log n) avg | O(log n) | In-place, but O(n²) worst case |
| **Heap Sort** | O(n log n) | O(1) | In-place, guaranteed, but not stable |
| **Dijkstra** | O(E log V) | O(V) | Fast for sparse graphs |
| **Floyd-Warshall** | O(V³) | O(V²) | All-pairs solution |

#### **Greedy vs DP Trade-offs:**
| Aspect | Greedy | DP |
|--------|--------|-----|
| **Time Complexity** | Usually faster | Usually slower |
| **Implementation** | Simpler | More complex |
| **Memory Usage** | Less memory | More memory |
| **Correctness** | Works only for specific problems | Works for broader class |
| **Debugging** | Easier | Harder |

### **REAL-WORLD SCENARIOS:**

#### **1. Web Search Engine:**
- **Crawling**: BFS (breadth-first web crawling)
- **Ranking**: Topological sort (dependency ordering)
- **Caching**: LRU (can use DP for optimal caching)

#### **2. Operating System:**
- **Process Scheduling**: Greedy (shortest job first)
- **Memory Management**: DP (optimal page replacement)
- **File System**: DFS (directory traversal)

#### **3. Network Routing:**
- **Internet routing**: Dijkstra (OSPF protocol)
- **Social networks**: BFS (finding connections)
- **Load balancing**: Greedy algorithms

#### **4. Database Systems:**
- **Query optimization**: DP (finding optimal join order)
- **Index structures**: Binary search trees
- **Sorting**: External merge sort for large datasets

---

## 14. ALGORITHM SELECTION FLOWCHART

```
PROBLEM TYPE?
│
├── SORTING
│   ├── Small data (n<50) → Insertion Sort
│   ├── Nearly sorted → Insertion Sort  
│   ├── Memory limited → Heap Sort
│   ├── Stability needed → Merge Sort
│   └── General purpose → Quick Sort
│
├── SEARCHING
│   ├── Sorted array → Binary Search
│   └── Unsorted array → Linear Search
│
├── GRAPH PROBLEMS
│   ├── Shortest Path
│   │   ├── Unweighted → BFS
│   │   ├── Non-negative weights → Dijkstra
│   │   ├── Negative weights → Bellman-Ford
│   │   └── All pairs → Floyd-Warshall
│   │
│   ├── Minimum Spanning Tree
│   │   ├── Sparse graph → Kruskal
│   │   └── Dense graph → Prim
│   │
│   └── Traversal
│       ├── Need shortest path → BFS
│       └── Need deep exploration → DFS
│
└── OPTIMIZATION
    ├── Has overlapping subproblems → DP
    ├── Greedy choice works → Greedy
    └── Can divide problem → Divide & Conquer
```

---

## 15. LAST-MINUTE TIPS
