import java.util.ArrayList;
import java.util.List;

public class _1352_ProductoftheLastKNumbers {
    class ProductOfNumbers {

        List<Integer> list;
        int n;
        int lastZero;

        public ProductOfNumbers() {
            list = new ArrayList<>();
            n = 0;
            lastZero = 0;
            list.add(1);
        }

        public void add(int num) {
            n++;
            if(num == 0) {
                list.add(1);
                lastZero = n;
            } else {
                list.add(num * list.get(n-1));
            }
        }

        public int getProduct(int k) {
            return lastZero <= n - k ? list.get(n) / list.get(n-k) : 0;
        }
    }
}
