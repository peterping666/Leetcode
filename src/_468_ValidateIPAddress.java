public class _468_ValidateIPAddress {
    /**
     * Time O(n)
     * Space O(n)
     * @param IP
     * @return
     */
    public String validIPAddress(String IP) {
        String res = "";
        if(IP.indexOf(".") != -1) {
            if(isIPv4(IP)) {
                return "IPv4";
            }
        } else if(IP.indexOf(":") != -1) {
            if(isIPv6(IP)) {
                return "IPv6";
            }
        }
        return "Neither";
    }

    private boolean isIPv4(String IP) {
        if(IP.charAt(IP.length()-1) == '.') return false;
        String[] strs = IP.split("\\.");
        if(strs.length != 4) return false;
        for(String str : strs) {
            if(str.length() == 0 || str.length() > 4) return false;
            for(int i = 0; i < str.length(); i++) {
                if(!Character.isDigit(str.charAt(i))) return false;
                if(i == 0 && str.charAt(i) == '0' && str.length() > 1) return false;
            }
            int val = Integer.parseInt(str);
            if(val > 255) return false;
        }
        return true;
    }

    private boolean isIPv6(String IP) {
        if(IP.charAt(IP.length()-1) == ':') return false;
        String[] strs = IP.split(":");
        if(strs.length != 8) return false;
        for(String str : strs) {
            if(str.length() == 0 || str.length() > 4) return false;
            for(int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(!Character.isDigit(c)
                        && (c < 'A' || c > 'F')
                        && (c < 'a' || c > 'f')) {
                    return false;
                }
            }
        }
        return true;
    }
}
