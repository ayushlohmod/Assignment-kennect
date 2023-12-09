import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int [] arr = { 90, 6, 56, 82, 33, 16, 34, 41, 80, 10, 24, 74, 67, 27, 54, 49, 19,1};

        //Randomize array
        randomizeArray(arr);
        System.out.println("Randomized Array" + Arrays.toString(arr)); 

        //insertion sort
        insertionSort(arr);
        System.out.println("Insertion Sort"+Arrays.toString(arr));

        //selection sort
        selectionSort(arr);
        System.out.println("Selection sort" +Arrays.toString(arr));

        //bubble sort
        bubbleSort(arr);
        System.out.println("BubbleSort" + Arrays.toString(arr));

        //merge sort
        mergeSort(arr);
        System.out.println("Merge Sort"+Arrays.toString(arr));

        //shell sort
        shellSort(arr);
        System.out.println("shell Sort" +Arrays.toString(arr));

        
    }

    static void randomizeArray(int [] nums){
        for(int i = 0; i < nums.length; i++){
            int randomIndex = (int) (Math.random() * nums.length);
            int temp = nums[i];
            nums[i] = nums[randomIndex];
            nums[randomIndex] = temp;
        }
    }

    static void insertionSort(int [] nums){
        for(int i = 0; i < nums.length -1; i++){
            for(int j = i+1; j > 0; j--){
                if(nums[j] < nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }else{
                    break;
                }
            }
        }
          
    }
    static void selectionSort(int [] nums){
        for(int i = 0; i < nums.length; i++){
            int minIndex = i;
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] < nums[minIndex]){
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }
    static void bubbleSort(int [] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j < nums.length - i; j++){
                if(nums[j] < nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }         
        }
    }

    private static int [] merge(int[] first, int[] second){
        int [] mix = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < first.length && j < second.length){
            if(first[i] < second[j]){
                mix[k] = first[i];
                i++;
            }else{
                mix[k] = second[j];
                j++;
            }
            k++;
        }

        while(i < first.length){
            mix[k] = first[i];
            i++;
            k++;
        }
        while(j < second.length){
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }

    static int[] mergeSort(int [] nums ){
        if (nums.length == 1) {
            return nums;
            
        }
        int mid = nums.length / 2;

        int [] left = mergeSort(Arrays.copyOfRange(nums, 0, mid));
        int [] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length));

        return merge(left, right);
        
        
    }
    static void shellSort(int [] nums){
        int gap = nums.length / 2;
        while(gap > 0){
            for(int i = gap; i < nums.length; i++){
                int j = i;
                while(j >= gap && nums[j] < nums[j-gap]){
                    int temp = nums[j];
                    nums[j] = nums[j-gap];
                    nums[j-gap] = temp;
                    j -= gap;
                }
            }
            gap /= 2;
        }
    }
    static void quicksort(int [] nums, int low, int high){
        if(low >= high){
            return;
        }
        int s = low;
        int e = high;
        int m = s + (e-s) / 2;
        int pivot = nums[m];
        while(s <= e){
            while(nums[s] < pivot){
                s++;
            }
            while(nums[e] > pivot){
                e--;
            }
            if(s <= e){
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        quicksort(nums, low, e);
        quicksort(nums, s, high);
    }

}
