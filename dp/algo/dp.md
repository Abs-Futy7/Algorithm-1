# Dynamic Programming

## Basic Idea

Dynamic Programming (DP) is a method for solving complex problems by breaking them down into simpler subproblems. It is applicable when the problem has **overlapping subproblems** and **optimal substructure** properties.

- **Overlapping Subproblems:** The problem can be broken down into subproblems which are reused several times.
- **Optimal Substructure:** The optimal solution to the problem can be constructed from optimal solutions of its subproblems.

DP stores the results of subproblems to avoid redundant computations, typically using a table (array, matrix, or hash map).

## Comparison with Divide & Conquer and Greedy Algorithms

| Approach             | Overlapping Subproblems | Optimal Substructure | Solution Construction | Example Problems         |
|----------------------|------------------------|----------------------|----------------------|-------------------------|
| Divide & Conquer     | No                     | Yes                  | Combine sub-solutions| Merge Sort, Quick Sort  |
| Greedy Algorithms    | No                     | Yes                  | Make local optimal   | Activity Selection, Huffman Coding |
| Dynamic Programming  | Yes                    | Yes                  | Build from subproblems| Fibonacci, Knapsack     |

- **Divide & Conquer:** Solves subproblems independently and combines their results. No overlapping subproblems.
- **Greedy:** Makes the locally optimal choice at each step, hoping for a global optimum. Does not always guarantee the best solution.
- **Dynamic Programming:** Solves each subproblem only once and stores the result for future use.

## Types of Dynamic Programming Approaches

Dynamic Programming can be implemented mainly in two ways:

### 1. Top-Down Approach (Memoization)

- **What is Memoization?**  
    Memoization is a technique where you solve a problem using recursion and store the results of already solved subproblems (usually in a dictionary or array). When the same subproblem occurs again, you simply return the stored result instead of recomputing it.
- **When to use?**  
    Use memoization when the problem is naturally recursive and you want to avoid redundant calculations.

**Example: Fibonacci Numbers (Top-Down with Memoization)**
```python
def fib(n, memo={}):
        if n in memo:
                return memo[n]
        if n <= 1:
                return n
        memo[n] = fib(n-1, memo) + fib(n-2, memo)
        return memo[n]
```
- **Explanation:** This approach uses recursion and stores already computed values in a dictionary (`memo`). This avoids redundant calculations.
- **Time Complexity:** O(n)  
    - **Why?** Each unique value of `n` from 0 to `n` is computed only once and stored. All subsequent calls reuse the stored result, so the total number of computations is linear in `n`.

### 2. Bottom-Up Approach (Tabulation)

- **What is Tabulation?**  
    Tabulation is a technique where you solve the problem iteratively, starting from the smallest subproblems and building up solutions to larger subproblems. The results are stored in a table (usually an array or matrix).
- **When to use?**  
    Use tabulation when you can define the order in which subproblems are solved and want to avoid recursion stack overhead.

**Example: Fibonacci Numbers (Bottom-Up with Tabulation)**
```python
def fib(n):
        if n <= 1:
                return n
        dp = [0, 1]
        for i in range(2, n+1):
                dp.append(dp[i-1] + dp[i-2])
        return dp[n]
```
- **Explanation:** This approach builds up the solution from the base cases, filling up a table (`dp`) iteratively.
- **Time Complexity:** O(n)  
    - **Why?** The loop runs from 2 to `n`, performing a constant amount of work for each value, so the total work is proportional to `n`.

### 3. Space Optimization Approach

- **What is Space Optimization?**  
    Many DP problems only require information from a fixed number of previous states. Space optimization reduces memory usage by storing only the necessary previous results instead of the entire table.
- **When to use?**  
    Use space optimization when the current state depends only on a few previous states, such as in Fibonacci or certain knapsack problems.

**Example: Fibonacci Numbers (Space Optimized)**
```python
def fib(n):
        if n <= 1:
                return n
        a, b = 0, 1
        for _ in range(2, n+1):
                a, b = b, a + b
        return b
```
- **Explanation:** Instead of storing all previous Fibonacci numbers, only the last two are kept, reducing space complexity.
- **Space Complexity:** O(1)  
    - **Why?** Only two variables are used, regardless of `n`.

### Comparison of Approaches

- **Top-Down (Memoization):** Easier to implement, especially for problems naturally defined recursively. May use more stack space.
- **Bottom-Up (Tabulation):** Often more space-efficient and avoids recursion stack overflow.
- **Space Optimization:** Minimizes memory usage when only a few previous results are needed.

## Summary

Dynamic Programming is a powerful technique for optimization problems with overlapping subproblems and optimal substructure.  
- **Memoization** is the top-down approach using recursion and caching.
- **Tabulation** is the bottom-up approach using iteration and tables.
- **Space Optimization** further reduces memory usage when possible by storing only essential previous results.
It is more efficient than naive recursion and often outperforms greedy and divide & conquer approaches for suitable problems.
- **Time Complexity:** For both approaches, the time complexity is typically O(n) for problems like Fibonacci, because each subproblem is solved only once and results are reused, eliminating redundant calculations.