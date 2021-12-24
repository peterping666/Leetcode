import java.util.*;

public class _721_AccountsMerge {

    // Union Find
    class Solution1 {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            if (accounts.size() == 0) {
                return new ArrayList<>();
            }

            int n = accounts.size();
            UnionFind uf = new UnionFind(n);

            // Step 1: traverse all emails except names, if we have not seen an email before, put it with its index into map.
            // Otherwise, union the email to its parent index.
            Map<String, Integer> mailToIndex = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < accounts.get(i).size(); j++) {
                    String curMail = accounts.get(i).get(j);
                    if (mailToIndex.containsKey(curMail)) {
                        int preIndex = mailToIndex.get(curMail);
                        uf.union(preIndex, i);
                    }
                    else {
                        mailToIndex.put(curMail, i);
                    }
                }
            }

            // Step 2: traverse every email list, find the parent of current list index and put all emails into the set list
            // that belongs to key of its parent index
            Map<Integer, Set<String>> disjointSet = new HashMap<>();
            for (int i = 0; i < n; i++) {
                // find parent index of current list index in parent array
                int parentIndex = uf.find(i);
                disjointSet.putIfAbsent(parentIndex, new HashSet<>());

                Set<String> curSet = disjointSet.get(parentIndex);
                for (int j = 1; j < accounts.get(i).size(); j++) {
                    curSet.add(accounts.get(i).get(j));
                }
                disjointSet.put(parentIndex, curSet);
            }

            // step 3: traverse ket set of disjoint set group, retrieve all emails from each parent index, and then SORT
            // them, as well as adding the name at index 0 of every sublist
            List<List<String>> result = new ArrayList<>();
            for (int index : disjointSet.keySet()) {
                List<String> curList = new ArrayList<>();
                if (disjointSet.containsKey(index)) {
                    curList.addAll(disjointSet.get(index));
                }
                Collections.sort(curList);
                curList.add(0, accounts.get(index).get(0));
                result.add(curList);
            }
            return result;
        }

        class UnionFind {
            int size;
            int[] parent;
            public UnionFind(int size) {
                this.size = size;
                this.parent = new int[size];

                for (int i = 0; i < size; i++) {
                    parent[i] = i;
                }
            }

            public void union(int a, int b) {
                parent[find(a)] = parent[find(b)];
            }

            public int find(int x) {
                if (x != parent[x]) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }
        }
    }

    // Graph + DFS
    class Solution2 {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, String> emailToName = new HashMap<>();
            Map<String, List<String>> emailGraph = new HashMap<>();
            for(List<String> account : accounts) {
                String name = account.get(0);
                for(int i = 1; i < account.size(); i++) {
                    emailGraph.putIfAbsent(account.get(i), new ArrayList<>());
                    emailToName.put(account.get(i), name);
                    if(i == 1) {
                        continue;
                    }
                    emailGraph.get(account.get(i)).add(account.get(i-1));
                    emailGraph.get(account.get(i-1)).add(account.get(i));
                }
            }

            List<List<String>> res = new ArrayList<>();
            Set<String> seen = new HashSet<>();

            for(String email : emailGraph.keySet()) {
                if(!seen.add(email)) {
                    continue;
                }
                List<String> list = new LinkedList<>();
                dfs(emailGraph, email, seen, list);
                Collections.sort(list);
                list.add(0, emailToName.get(email));
                res.add(list);
            }
            return res;
        }

        private void dfs(Map<String, List<String>> emailGraph, String email, Set<String> seen,
                         List<String> list) {
            list.add(email);
            for(String next : emailGraph.get(email)) {
                if(!seen.add(next)) {
                    continue;
                }
                dfs(emailGraph, next, seen, list);;
            }
        }
    }
}
