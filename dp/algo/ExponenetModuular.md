# Algorithm for Modular Exponentiation (Recursive Binary Exponentiation)

## Algorithm Steps

1. **Input:** Three numbers: base `A`, exponent `k`, and modulus `M`.
2. **Base Case:**  
   - If `k` is 0, return `1 % M` (since any number to the power 0 is 1).
3. **Recursive Step:**  
   - Recursively compute `half = powerMod(A, k / 2, M)`.
   - Compute `result = (half * half) % M`.
   - If `k` is odd, update `result = (result * A) % M`.
4. **Return:**  
   - Return `result`.
5. **Output:**  
   - Print the result of `powerMod(A, k, M)`.

---

## Time Complexity

- The `powerMod` function uses recursion and divides the exponent `k` by 2 at each step.
- This results in a recursion depth of **O(log k)**.
- Each step does **O(1)** work (just a few multiplications and modulus operations).
- **Total Time Complexity:** `O(log k)`

---

## Space Complexity

- The space used is mainly due to the recursion stack.
- The maximum depth of recursion is **O(log k)**.
- No extra space is used apart from recursion.
- **Total Space Complexity:** `O(log k)`