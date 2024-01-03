import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        int[] ans = mergeSort(arr);
        inPlaceMergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(ans));

    }

    public static int[] mergeSort(int[] arr) {
        // Base Condition
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);

    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] newArr = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                newArr[k] = arr1[i];
                i++;
            } else {
                newArr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length) {
            newArr[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length) {
            newArr[k] = arr2[j];
            j++;
            k++;
        }
        return newArr;
    }

    // in-place mergeSort
    public static void inPlaceMergeSort(int[] arr, int s, int e) {
        // base condition
        if (e - s == 1) {
            return;
        }
        int mid = (s + e) / 2;
        inPlaceMergeSort(arr, s, mid);
        inPlaceMergeSort(arr, mid, e);
        mergeInPlace(arr, s, mid, e);
    }

    public static void mergeInPlace(int[] arr, int s, int mid, int e) {
        int newArr[] = new int[e - s];
        int i = s;
        int j = mid;
        int k = 0;
        while (i < mid && j < e) {
            if (arr[i] < arr[j]) {
                newArr[k] = arr[i];
                i++;
                k++;
            } else {
                newArr[k] = arr[j];
                j++;
                k++;
            }
        }
        while (i < mid) {
            newArr[k] = arr[i];
            i++;
            k++;
        }
        while (j < e) {
            newArr[k] = arr[j];
            j++;
            k++;
        }
        System.arraycopy(newArr, 0, arr, s + 0, newArr.length);
    }
}