# Fibonacci Algorithms

## 1. Top-Down Approach with Memoization (Recursive)

**Algorithm:**
```
1. Create an array `memo` of size `n+1` and initialize all elements to -1.
2. Define a recursive function `fib(n)`:
    - If `n <= 1`, return `n`.
    - If `memo[n]` is not -1, return `memo[n]`.
    - Otherwise, compute `fib(n-1) + fib(n-2)`, store the result in `memo[n]`, and return it.
3. Call `fib(n)` to get the nth Fibonacci number.
```

---

## 2. Bottom-Up Approach with Tabulation (Iterative)

**Algorithm:**
```
1. If `n <= 1`, return `n`.
2. Create an array `dp` of size `n+1`.
3. Set `dp[0] = 0` and `dp[1] = 1`.
4. For `i` from 2 to `n`:
    - Set `dp[i] = dp[i-1] + dp[i-2]`.
5. Return `dp[n]`.
```
---

## 3. Space Optimized Approach

**Algorithm:**
```
1. If `n <= 1`, return `n`.
2. Initialize two variables: `prev1 = 1`, `prev2 = 0`.
3. For `i` from 2 to `n`:
    - Compute `curr = prev1 + prev2`.
    - Update `prev2 = prev1`.
    - Update `prev1 = curr`.
4. Return `prev1`.
```