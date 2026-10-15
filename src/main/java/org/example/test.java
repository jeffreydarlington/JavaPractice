package org.example;

public class test {
    static int getFirst(int[] arr){
        return arr[0];
    }

    static int  binarySearch(int[] arr,int key){
        int low = 0, high = arr.length - 1;
        while (low <= high){
            int mid = low + (low + high)/2;
            if(arr[mid] == key){
                return mid;
            }
            else if(arr[mid] < key){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }

    static int sum(int[] arr){
        int total = 0;
        for(int i: arr) {
            total += i;
        }
        return total;
    }

    static boolean hasDuplicate(int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    static int[] doubleAll(int[] arr){
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            result[i] = arr[i] * 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9, 3};

        // Test getFirst
        System.out.println("First: " + getFirst(arr));

        // Test binarySearch (array MUST be sorted for this to work)
        int[] sorted = {1, 2, 3, 5, 8, 9};
        System.out.println("Index of 2: " + binarySearch(sorted, 3));
        //System.out.println("Index of 4: " + binarySearch(sorted, 2));
    }
}