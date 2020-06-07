/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

public class _702_SearchInSortedArrayUnknownSize<ArrayReader> {

    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        while(reader.get(right) != Integer.MAX_VALUE && reader.get(right) < target) {
            left = right;
            right *= 2;
        }

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(reader.get(mid) == target) {
                return mid;
            }
            if(reader.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
