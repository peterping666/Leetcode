import java.util.HashMap;
import java.util.Random;

public class _535_EncodeandDecodeTinyURL {
    /**
     *
     */
    public class Codec {
        private String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private HashMap<String, String> map = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            Random rand = new Random();
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < 6; i++) {
                int index = rand.nextInt(alphabet.length());
                sb.append(alphabet.charAt(index));
            }
            String url = "http://tinyurl.com/" + sb.toString();
            map.putIfAbsent(url, longUrl);
            return url;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(shortUrl);
        }
    }
}
