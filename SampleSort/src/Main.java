public class Main {
    public static void main(String[] args){
        int[] num = new int[10];
        num [0] = 10;
        num [1] = 20;
        num [2] = 30;
        num [3] = 60;
        num [4] = 210;
        num [5] = 101;
        num [6] = 37;
        num [7] = 4;
        num [8] = 19;
        num [9] = -1;

        System.out.println("Before sorting:");
        printArray(num);

        System.out.println("After sorting:");
        selectionSort(num);
        printArray(num);
    }

    private static void bubbleSort(int[] nums) {
        // let n = number of elements in nums array
        // outer for loop -> n - 1 iterations
        // inner for loop -> n - 1 iterations (1st pass)
        // inner for loop -> (n - 1) + (n - 2) + (n - 3) .. 1 -> (n * (n - 1)) / 2 -> (n^2 - n) / 2
        // time complexity -> O(n^2)
        for (int lastUnsortedIndex = nums.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (nums[i] < nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] nums) {
        // let n = number of elements in nums array
        // outer for loop -> n - 1 iterations
        // inner for loop -> n - 1
        // inner for loop -> (n - 1) + (n - 2) + (n - 3) .. 1 -> (n * (n - 1)) / 2 -> (n^2 - n) / 2
        // time complexity -> O(n^2)
        for (int lastUnsortedIndex = nums.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int smallest = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (nums[i] < nums[smallest]) {
                    smallest = i;
                }
            }

            if (smallest != lastUnsortedIndex) {
                int temp = nums[smallest];
                nums[smallest] = nums[lastUnsortedIndex];
                nums[lastUnsortedIndex] = temp;
            }
        }
    }

    private static void printArray(int[] num){
        for (int i = 0; i < num.length; i++){
         System.out.println(num[i]);
        }
    }
}

