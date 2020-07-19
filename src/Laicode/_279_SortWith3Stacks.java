package Laicode;

import java.util.LinkedList;

public class _279_SortWith3Stacks {
    public class Solution {
        public void sort(LinkedList<Integer> s1) {
            LinkedList<Integer> s2 = new LinkedList<Integer>();
            LinkedList<Integer> s3 = new LinkedList<Integer>();
            sort(s1, s2, s3, s1.size());
        }

        private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int size) {
            if(size <= 1) {
                return;
            }
            int mid1 = size / 2;
            int mid2 = size - size / 2;
            for (int i = 0; i < mid1; i++) {
                s2.offerFirst(s1.pollFirst());
            }
            sort(s2, s3, s1, mid1);
            sort(s1, s3, s2, mid2);
            int i = 0;
            int j = 0;
            while (i < mid1 && j < mid2) {
                if(s2.peekFirst() < s1.peekFirst()) {
                    s3.offerFirst(s2.pollFirst());
                    i++;
                } else {
                    s3.offerFirst(s1.pollFirst());
                    j++;
                }
            }
            while(i++ < mid1) {
                s3.offerFirst(s2.pollFirst());
            }
            while(j++ < mid2) {
                s3.offerFirst(s1.pollFirst());
            }
            for (int idx = 0; idx < size; idx++) {
                s1.offerFirst(s3.pollFirst());
            }
        }
    }

}
