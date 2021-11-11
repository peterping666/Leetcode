import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class _1268_SearchSuggestionsSystem {
    class Solution1 {
        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            List<String> suggestion = new ArrayList<>();
        }
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Arrays.sort(products);
            TrieNode root = new TrieNode();
            for (String product : products) {
                insert(product, root);
            }
            return search(searchWord, root);
        }
        private void insert(String product, TrieNode node) {
            TrieNode t = node;
            for (char c : product.toCharArray()) {
                if (t.children[c - 'a'] == null) {
                    t.children[c - 'a'] = new TrieNode();
                }
                t = t.children[c - 'a'];
                if(t.suggestion.size() < 3) {
                    t.suggestion.add(product);
                }
            }
        }
        private List<List<String>> search(String searchWord, TrieNode node) {
            List<List<String>> res = new ArrayList<>();
            for (char c : searchWord.toCharArray()) {
                if (node != null) {
                    node = node.children[c - 'a'];
                }
                res.add(node == null ? Arrays.asList() : node.suggestion);
            }
            return res;
        }
    }

    class Solution2 {
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            List<List<String>> res = new ArrayList<>();
            TreeMap<String, Integer> map = new TreeMap<>();
            Arrays.sort(products);
            List<String> productsList = Arrays.asList(products);

            for (int i = 0; i < products.length; i++) {
                map.put(products[i], i);
            }

            String key = "";
            for (char c : searchWord.toCharArray()) {
                key += c;
                String ceiling = map.ceilingKey(key);
                String floor = map.floorKey(key + "~");
                if (ceiling == null || floor == null) {
                    break;
                }
                res.add(productsList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
            }

            while (res.size() < searchWord.length()) {
                res.add(new ArrayList<>());
            }
            return res;
        }
    }
}
