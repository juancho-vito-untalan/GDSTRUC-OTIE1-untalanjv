public class Main {
    public static void main(String[] args) {
        int[] nums = { -50, -12, 5, 16, 42, 55, 81, 108 };

        int findValue = 16;
        int index = binarySearch(findValue, nums);

        if (index == -1) {
            System.out.println("Value " + findValue + " is not in the array");
        }
        else {
            System.out.println("Value " + findValue + " is found at index " + index);
        }

        findValue = 100;
        index = binarySearch(findValue, nums);

        if (index == -1) {
            System.out.println("Value " + findValue + " is not in the array");
        }
        else {
            System.out.println("Value " + findValue + " is found at index " + index);
        }
    }

    private static int linearSearch(int value, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == value) {
                return i;
            }
        }

        return -1;
    }

    private static int binarySearch(int value, int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (nums[middle] == value) {
                return  middle;
            }

            if (nums[middle] > value) {
                // left half of the array
                end = middle - 1;
            }
            else {
                // right half of the array
                start = middle + 1;
            }
        }

        return -1;
    }
}