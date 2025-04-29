# Asymptotic Notations: Big-O, Omega, and Theta

Asymptotic notations are used to describe the efficiency of algorithms in terms of time and space complexity as the input size grows. The three most commonly used notations are:

- **Big-O Notation (O)** – Upper Bound (Worst-case complexity)
- **Omega Notation (Ω)** – Lower Bound (Best-case complexity)
- **Theta Notation (Θ)** – Tight Bound (Average-case complexity)

---

## 1. Big-O Notation (O) – Upper Bound
Big-O notation represents the upper bound on the running time of an algorithm, meaning it gives the worst-case complexity.

### **Mathematical Definition:**
A function `f(n)` is **O(g(n))** if there exist positive constants `c` and `n₀` such that:

```
f(n) ≤ c * g(n), ∀ n ≥ n₀
```

This means that beyond a certain point `n₀`, `f(n)` does not grow faster than `g(n)` multiplied by a constant.

### **Example:**
```
f(n) = 3n² + 5n + 7
```
For large `n`, the term `3n²` dominates, so:
```
f(n) = O(n²)
```

### **Common Big-O Complexities:**
| Notation  | Complexity Type | Example |
|-----------|----------------|---------|
| O(1)      | Constant Time   | Accessing an array element |
| O(log n)  | Logarithmic Time | Binary Search |
| O(n)      | Linear Time     | Traversing an array |
| O(n log n)| Linearithmic Time | Merge Sort |
| O(n²)     | Quadratic Time  | Bubble Sort |
| O(2ⁿ)     | Exponential Time | Recursive Fibonacci |
| O(n!)     | Factorial Time  | Traveling Salesman Problem |

---

## 2. Omega Notation (Ω) – Lower Bound
Omega notation provides a lower bound on an algorithm’s running time, meaning it describes the best-case scenario.

### **Mathematical Definition:**
A function `f(n)` is **Ω(g(n))** if there exist positive constants `c` and `n₀` such that:

```
f(n) ≥ c * g(n), ∀ n ≥ n₀
```

This ensures that for sufficiently large `n`, `f(n)` is at least proportional to `g(n)`.

### **Example:**
```
f(n) = 3n² + 5n + 7
```
For large `n`, the quadratic term dominates, so:
```
f(n) = Ω(n²)
```

### **Common Omega Complexities:**
| Notation  | Complexity Type | Example |
|-----------|----------------|---------|
| Ω(1)      | Constant Time   | Best case of hash table lookup |
| Ω(log n)  | Logarithmic Time | Best case of binary search |
| Ω(n)      | Linear Time     | Best case of linear search |
| Ω(n log n)| Linearithmic Time | Best case of quicksort |
| Ω(n²)     | Quadratic Time  | Best case of matrix multiplication |

---

## 3. Theta Notation (Θ) – Tight Bound
Theta notation provides both an upper and lower bound, meaning it gives a tight bound for the running time of an algorithm.

### **Mathematical Definition:**
A function `f(n)` is **Θ(g(n))** if there exist positive constants `c₁`, `c₂`, and `n₀` such that:

```
c₁ * g(n) ≤ f(n) ≤ c₂ * g(n), ∀ n ≥ n₀
```

This means that `f(n)` grows at the same rate as `g(n)`, up to constant factors.

### **Example:**
```
f(n) = 3n² + 5n + 7
```
Since the quadratic term dominates for large `n`, we say:
```
f(n) = Θ(n²)
```

### **Common Theta Complexities:**
| Notation  | Complexity Type | Example |
|-----------|----------------|---------|
| Θ(1)      | Constant Time   | Accessing an array element |
| Θ(log n)  | Logarithmic Time | Balanced BST operations |
| Θ(n)      | Linear Time     | Traversing an array |
| Θ(n log n)| Linearithmic Time | Merge Sort |
| Θ(n²)     | Quadratic Time  | Bubble Sort |

---

## 4. Comparison of Asymptotic Notations
To summarize:
- **Big-O (O)** gives the worst-case complexity.
- **Omega (Ω)** gives the best-case complexity.
- **Theta (Θ)** gives the exact bound when both O and Ω are the same.

For example, if an algorithm runs in:
- **O(n²)** – It won’t take more than quadratic time.
- **Ω(n log n)** – It will take at least `n log n` time.
- **Θ(n²)** – It always takes quadratic time.

---

## 5. Conclusion
Understanding asymptotic notations helps in evaluating algorithm efficiency independent of hardware and implementation details. Knowing **Big-O, Omega, and Theta** allows programmers to analyze and compare different algorithms based on performance in various scenarios.


