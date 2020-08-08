public class _836_RectangleOverlap {
    class Solution1 {
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            return !(rec1[2] <= rec2[0] ||   // left
                    rec1[3] <= rec2[1] ||   // bottom
                    rec1[0] >= rec2[2] ||   // right
                    rec1[1] >= rec2[3]);    // top
        }
    }

    class Solution2 {
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) && // width > 0
                    Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));  // height > 0
        }
    }
}
