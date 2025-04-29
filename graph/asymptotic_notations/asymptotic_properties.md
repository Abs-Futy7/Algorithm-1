# Properties of Asymptotic Notations

Asymptotic notations help analyze the efficiency of algorithms. The following are the key properties of Big-O (O), Omega (Ω), and Theta (Θ) notations.

---

## 1. **Transitivity Property**

If `f(n) = O(g(n))` and `g(n) = O(h(n))`, then:

```
f(n) = O(h(n))
```

Similarly, the transitivity property applies to Ω and Θ notations:

- If `f(n) = Ω(g(n))` and `g(n) = Ω(h(n))`, then `f(n) = Ω(h(n))`.
- If `f(n) = Θ(g(n))` and `g(n) = Θ(h(n))`, then `f(n) = Θ(h(n))`.

---

## 2. **Reflexivity Property**

For any function `f(n)`, it follows that:

```
f(n) = O(f(n))
```

```
f(n) = Ω(f(n))
```

```
f(n) = Θ(f(n))
```

This means a function is always asymptotically bounded by itself.

---

## 3. **Symmetry Property (For Theta)**

Theta notation is symmetric, meaning:

```
f(n) = Θ(g(n)) ⇔ g(n) = Θ(f(n))
```

This does **not** hold for Big-O and Omega since they define upper and lower bounds, respectively.

---

## 4. **Transposition Property**

If `f(n) = O(g(n))`, then it implies:

```
g(n) = Ω(f(n))
```

Similarly, if `f(n) = Θ(g(n))`, then `g(n) = Θ(f(n))`.

---

## 5. **Addition Property**

If `f(n) = O(h(n))` and `g(n) = O(h(n))`, then:

```
f(n) + g(n) = O(h(n))
```

The same rule applies for Ω and Θ notations.

Example:

```
Let f(n) = O(n²) and g(n) = O(n²), then:
f(n) + g(n) = O(n²)
```

---

## 6. **Multiplication Property**

If `f(n) = O(g(n))` and `h(n) = O(k(n))`, then:

```
f(n) * h(n) = O(g(n) * k(n))
```

Similarly, for Ω and Θ:

```
f(n) * h(n) = Ω(g(n) * k(n))
```

```
f(n) * h(n) = Θ(g(n) * k(n))
```

Example:

```
If f(n) = O(n) and g(n) = O(n log n), then:
f(n) * g(n) = O(n² log n)
```

---

## 7. **Polynomial Property**

For a polynomial function `f(n) = aₖnᵏ + aₖ₋₁nᵏ⁻¹ + ... + a₀`, the asymptotic bound is determined by the highest-degree term:

```
f(n) = Θ(nᵏ)
```

Example:

```
f(n) = 4n³ + 2n² + 7n + 5
Θ(n³)
```

---

## 8. **Logarithm Property**

Logarithms of different bases differ only by a constant factor:

```
logₐ n = O(log_b n)
```

Thus, base differences do not affect asymptotic complexity.

Example:

```
log₂ n = O(log₁₀ n)
```

---

## 9. **Comparability Property**

For two functions `f(n)` and `g(n)`, one of the following must be true:

```
f(n) = O(g(n)), f(n) = Ω(g(n)), or f(n) = Θ(g(n))
```

This ensures every function has a definite asymptotic relationship.

---

## 10. **Non-Negativity Property**

Asymptotic notations are only defined for non-negative functions, meaning:

```
f(n) ≥ 0 for sufficiently large n
```

---

## **Conclusion**

These properties help in simplifying and understanding the behavior of algorithms in terms of asymptotic analysis. Mastering these principles makes it easier to evaluate algorithm efficiency!

Would you like practical examples demonstrating these properties? 🚀

