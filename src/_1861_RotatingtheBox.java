public class _1861_RotatingtheBox {
    class Solution1 {
        public char[][] rotateTheBox(char[][] box) {
            int r = box.length, c = box[0].length;
            char[][] res = new char[c][r];

            for(int i = 0; i < r; ++i){
                int empty = c - 1;
                for(int j = c - 1; j >= 0; --j){
                    if(box[i][j] == '*'){
                        empty = j - 1;
                    }
                    if(box[i][j] == '#'){
                        box[i][j] = '.';
                        box[i][empty] = '#';
                        --empty;
                    }
                }
            }

            for(int i = 0; i < r; i++){
                for(int j = c - 1; j >= 0; j--)
                    res[j][r-i-1] = box[i][j];
            }

            return res;
        }
    }

    class Solution2 {
        public char[][] rotateTheBox(char[][] box) {
            int r = box.length, c = box[0].length;
            char[][] res = new char[c][r];

            for(int i = 0; i<r; ++i){
                int empty = c-1;
                for(int j = c-1; j>=0; --j){
                    if(box[i][j] == '.') {
                        res[j][r-i-1] = box[i][j];
                    } else if(box[i][j] == '*'){
                        res[j][r-i-1] = box[i][j];
                        empty = j - 1;
                    } else {
                        res[j][r-i-1] = '.';
                        res[empty][r-i-1] = box[i][j];
                        --empty;
                    }

                }
            }

            return res;
        }
    }
}
