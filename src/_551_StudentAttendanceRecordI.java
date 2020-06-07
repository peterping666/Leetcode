public class _551_StudentAttendanceRecordI {
    /**
     * Time O(n)
     * Space O(1)
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        int count=0;
        for(int i=0;i<s.length() && count<2 ;i++)
            if(s.charAt(i)=='A')
                count++;
        return count<2 && s.indexOf("LLL")<0;
    }
}
