# Inversion Count

**Inversion Count** in an array is the number of pairs `(i, j)` such that `i < j` and `arr[i] > arr[j]`. It measures how far the array is from being sorted.

## Divide and Conquer Algorithm

The inversion count can be efficiently calculated using a modified Merge Sort algorithm.

### Algorithm
```
1. **Divide** the array into two halves.
2. **Recursively** count inversions in the left half.
3. **Recursively** count inversions in the right half.
4. **Merge** the two halves:
    - While merging, for each element in the left half that is greater than an element in the right half, count the number of such inversions.
5. **Sum** the inversion counts from the left half, right half, and the merge step to get the total inversion count.
```
### Time Complexity

- **Divide and Conquer (Merge Sort based):** `O(n log n)`

### Space Complexity

- **Divide and Conquer:** `O(n)` (due to temporary arrays during merge)

## Brute Force Approach

- Check all pairs `(i, j)` with `i < j` and count if `arr[i] > arr[j]`.

### Time Complexity

- **Brute Force:** `O(n^2)`

### Space Complexity

- **Brute Force:** `O(1)`

## Comparison

| Approach         | Time Complexity | Space Complexity |
|------------------|----------------|------------------|
| Brute Force      | O(n²)          | O(1)             |
| Divide & Conquer | O(n log n)     | O(n)             |

**Divide and Conquer** is much more efficient for large arrays compared to the brute force method.