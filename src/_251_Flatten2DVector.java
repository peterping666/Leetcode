public class _251_Flatten2DVector {
    class Vector2D {
        private int[][] vector;
        private int row;
        private int col;
        public Vector2D(int[][] v) {
            vector = v;
            row = 0;
            col = 0;
        }

        public int next() {
            if(hasNext()) {
                return vector[row][col++];
            }
            return -1;
        }

        public boolean hasNext() {
            while(row < vector.length && col == vector[row].length) {
                row++;
                col = 0;
            }
            return row < vector.length;
        }
    }

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
