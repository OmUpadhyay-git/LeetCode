class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] arr = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            arr[i] = -1;

            // Find nums1[i] in nums2
            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {

                    // Search for next greater element
                    for (int k = j + 1; k < nums2.length; k++) {

                        if (nums2[k] > nums1[i]) {
                            arr[i] = nums2[k];
                            break;
                        }
                    }

                    break;
                }
            }
        }

        return arr;
    }
}