public class KthSmallest {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3; 

        int result = getKthSmallest(arr, k, 0, arr.length-1);
        System.out.println("The " + k + "rd smallest element is: " + result);
    }


    private static int getKthSmallest(int[] arr, int k, int low, int high){
        // Partition the array and get the position of the pivot
        int pivotPoint = getPivot(arr, low, high);

        // If pivotPoint is the (k-1)th index, we've found the kth smallest element
        if(pivotPoint == k-1) return arr[pivotPoint];

        // If pivotPoint is greater than (k-1), search in the left subarray
        else if(pivotPoint > k-1) return getKthSmallest(arr, k, low, pivotPoint-1);

        // If pivotPoint is less than (k-1), search in the right subarray
        else return getKthSmallest(arr, k, pivotPoint+1, high);
    }

    
    private static int getPivot(int[] arr, int low, int high){
        int pivotElement = arr[high]; // Choose the last element as pivot
        int pivotPoint = low; // Index for smaller element

        // Rearrange elements: elements less than pivot to the left
        for(int i = pivotPoint; i < high ; i++){
            if(arr[i] < pivotElement){
                int temp = arr[pivotPoint];
                arr[pivotPoint] = arr[i];
                arr[i] = temp;
                pivotPoint++;
            }
        }

        // Place the pivot element in its correct position
        int temp = arr[pivotPoint];
        arr[pivotPoint] = arr[high];
        arr[high] = temp;
        
        return pivotPoint;
    }
}
