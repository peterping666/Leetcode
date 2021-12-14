public class _223_RectangleArea {
    class Solution {
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            int leftx = Math.max(ax1, bx1);
            int lefty = Math.max(ay1, by1);
            int rightx = Math.min(ax2, bx2);
            int righty = Math.min(ay2, by2);
            int overlap = 0;
            if(rightx >= leftx && righty >= lefty) {
                overlap = (rightx - leftx) * (righty - lefty);
            }
            return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - overlap;
        }
    }
}
