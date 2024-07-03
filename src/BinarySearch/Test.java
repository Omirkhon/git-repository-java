package BinarySearch;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] nums2 = {5, 4, 3, 2, 1};
        int[] nums3 = {4, 1, 3, 2, 5};
        System.out.println(binarySearch(nums, 4));
        System.out.println(binarySearch(nums2, 5));
        System.out.println(binarySearch(nums3, 3));
    }

    static int binarySearch(int[] nums, int target) {
        int increaseCount = 0;
        int decreaseCount = 0;
        int low = 0;
        int high = nums.length - 1;
        for (int i = 1; i<nums.length; i++) {
            if (nums[i]>nums[i-1])
                increaseCount++;
            else if (nums[i]<nums[i-1])
                decreaseCount++;
        }
        if (increaseCount == nums.length-1) {
            System.out.println("Список отсортирован по возрастанию");
            while (low <= high) {
                System.out.println("Шаг");
                int mid = (low + high)/2;
                if (nums[mid] == target)
                    return mid;
                else if (target > nums[mid])
                    low = mid + 1;
                else
                    high = mid -1;
            }
            return -1;
        } else if (decreaseCount == nums.length-1) {
            System.out.println("Список отсортирован по убыванию");
            while (low <= high) {
                System.out.println("Шаг");
                int mid = (low + high)/2;
                if (nums[mid] == target)
                    return mid;
                else if (target < nums[mid])
                    low = mid + 1;
                else
                    high = mid -1;
            }
            return -1;
        } else {
            System.out.println("Список не отсортирован");
            return -1;
        }
    }
}
