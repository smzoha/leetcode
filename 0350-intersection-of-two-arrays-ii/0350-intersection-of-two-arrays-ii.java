class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> intersect = new ArrayList<>();

        for (int n : nums1.length > nums2.length ? nums1 : nums2) {
            freqMap.compute(n, (k, v) -> v == null ? 1 : v + 1);
        }

        for (int n : nums1.length > nums2.length ? nums2 : nums1) {
            if (freqMap.containsKey(n)) {
                freqMap.put(n, freqMap.get(n) - 1);
                if (freqMap.get(n) >= 0) intersect.add(n);
            }
        }

        int[] result = new int[intersect.size()];
        for (int i = 0; i < intersect.size(); i++) result[i] = intersect.get(i);

        return result;
    }
}