import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] nums = { -50, -12, 5, 16, 91, 42, 55, 81, 108, 105 };

        int findValue = 0;
        int index = 0;

        findValue = 105;
        index = squishSearch(findValue, nums);

        if (index == -1) {
            System.out.println("Value " + findValue + " is not in the array");
        }
        else {
            System.out.println("Value " + findValue + " is found at index " + index);
        }

        findValue = 91;
        index = squishSearch(findValue, nums);

        if (index == -1) {
            System.out.println("Value " + findValue + " is not in the array");
        }
        else {
            System.out.println("Value " + findValue + " is found at index " + index);
        }

        findValue = 2;
        index = squishSearch(findValue, nums);

        if (index == -1) {
            System.out.println("Value " + findValue + " is not in the array");
        }
        else {
            System.out.println("Value " + findValue + " is found at index " + index);
        }

        findValue = 55;
        index = squishSearch(findValue, nums);

        if (index == -1) {
            System.out.println("Value " + findValue + " is not in the array");
        }
        else {
            System.out.println("Value " + findValue + " is found at index " + index);
        }

        findValue = 32789;
        index = squishSearch(findValue, nums);

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

    private static int squishSearch(int value, int[] nums) {
        // Sorted or unsorted? - Unsorted
        // Steps:
        // 1.) Initialize start and end trackers
        // 2.) Check if start = value
        // 3.) If not, check if end = value
        // 4.) If the value is still not found, increment start and decrement end
        // 5.) Repeat steps 2-3
        // Time Complexity - O(n)

        int start = 0;
        int end = nums.length - 1;

        while (start <= end){
            // check start
            if (nums[start] == value) {
                return start;
            }
            // check end
            if (start != end && nums[end] == value) {
                return end;
            }
            start++;
            end--;
        }
        return -1;
    }
}