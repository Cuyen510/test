import java.util.Arrays;

public class Main {
    public void linearSearch(int a[], int target){
        int i;
        for(i = 0; i < a.length ; i ++){
            if(a[i] == target)
                break;
        if(i < a.length)
            System.out.println("Tìm thấy tại vị trí : " + i);

        }
    }

    public int binarySearch(int low, int high, int[] a, int target){
        if(low <= high){
            int mid = (low + high)/2;
            if(a[mid]==target)
                return mid;
            else if(target < a[mid])
                return binarySearch(low, mid, a , target);
            else
                return binarySearch(mid+1, high, a ,target);
        }
        else return -1;
    }

    public static void insertSort(int a[]){
        int k, pos, tmp;
        for(k = 1 ; k < a.length ; k ++){
            tmp = a[k];
            pos = k ;
            while(pos > 0 && a[pos-1] > tmp ){
                a[pos] = a[pos-1];
                pos --;

            }
        a[pos] = tmp ;
        }
    }

////////////////////////////////////////////
    static void swap(int a, int b){
        int tmp = a;
        a = b ;
        b = tmp;
    }

    public void selectionSort(int a[]){
        int i, j , index_min;
        for(i = 0; i < a.length-1; i ++){
            index_min = i ;
            for(j = 1; j < a.length; j++){
                if(a[j] < a[index_min] )
                    index_min = j;


            int tmp = a[i];
            a[i] = a[index_min] ;
            a[index_min] = tmp;


            }
        }
    }

    public static void bubbleSort(int a[]){
        boolean sorted = false;
        for (int i = 1; i <= a.length-1; i++)
            if (sorted == false)
            {
                sorted = true;
                for (int j= 0; j <= a.length-i-1; j++)
                    if (a[j] < a[j+1])
                    {
                        int tmp = a[j];
                        a[j] = a[j+1] ;
                        a[j+1] = tmp;
                        sorted = false;
                    }
            }
    }

/////////////////////////////////////////////////////////////////
static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

        static void mergeSort(int arr[], int l, int r)
        {
            if (l < r)
            {
                // Find the middle point
                int m = (l+r)/2;

                // Sort first and second halves
                mergeSort(arr, l, m);
                mergeSort(arr , m+1, r);

                // Merge the sorted halves
                merge(arr, l, m, r);
            }
        }

////////////////////////////////////////////////////////////////
    public static int partition(int A[], int left, int right){
        int i = left;
        int j = right + 1;
        int pivot = A[left];
        while (true){
            i ++;
            while(i <= right && A[i] < pivot )
                i ++;
            j --;
            while(j>= left && pivot < A[j])
                j--;
            if(i >= j) break;
            int tmp = A[i];
            A[i] = A[j] ;
            A[j] = tmp;

        }
        int tmp = A[j];
        A[j] = A[left] ;
        A[left] = tmp;
        return j;
    }

    public static void quickSort(int A[], int left, int right){
        int index_Pivot;
        if(left < right){
            index_Pivot  = partition(A, left, right);
            quickSort(A, left, index_Pivot-1);
            quickSort(A, index_Pivot+1,right );
        }
    }



    public static void main(String[]args){
        int[] a = {1,2,4,5,3,6};
        //insertSort(a);
        mergeSort(a,0, a.length-1);
        //bubbleSort(a);
        //quickSort(a,0 , a.length-1);
        System.out.println(Arrays.toString(a));


    }

}
