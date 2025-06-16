# Kth Smallest Element (QuickSelect Algorithm)

## Algorithm Steps

1. **Input:** An array `arr` of size `n`, and an integer `k` (find the kth smallest element).
2. **Partition:**  
   - Use a partition function (like in QuickSort) to place a pivot element in its correct sorted position.
   - All elements less than the pivot go to the left, all greater go to the right.
3. **Check Pivot Position:**  
   - If the pivot's index is `k-1`, return the pivot (it's the kth smallest).
   - If the pivot's index is greater than `k-1`, recursively search the left subarray.
   - If the pivot's index is less than `k-1`, recursively search the right subarray.
4. **Repeat:**  
   - Continue partitioning and narrowing the search range until the kth smallest element is found.
5. **Output:**  
   - Return or print the kth smallest element.

---

## Time Complexity (TC)

**Best Case (Pivot is always perfect):**
- Each partition splits the array into two roughly equal parts.
- Recurrence: `T(n) = T(n/2) + O(n) = O(n)`
- ✔️ **Best/Average Case:** O(n)

**Worst Case (Pivot is always the largest or smallest element):**
- Each partition only reduces the problem by 1 element.
- Recurrence: `T(n) = T(n-1) + O(n) = O(n^2)`
- ❌ **Worst Case:** O(n²)
- ⚠️ This happens when the array is already sorted or all elements are equal and the last element is always picked as pivot.

---

## Space Complexity (SC)

- No extra space is used except the recursive call stack.
- Best case recursion depth: O(log n)
- Worst case recursion depth: O(n)

✔️ **Space Complexity:**
- Best/Average Case: O(log n) (recursive stack)
- Worst Case: O(n)

---

## 🔁 Summary Table

| Case         | Time Complexity | Space Complexity |
|--------------|----------------|-----------------|
| Best Case    | O(n)           | O(log n)        |
| Average Case | O(n)           | O(log n)        |
| Worst Case   | O(n²)          | O(n)            |