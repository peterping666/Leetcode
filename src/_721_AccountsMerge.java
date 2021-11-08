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

    // Graph + BFS
    class Solution2 {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, Set<String>> graph = new HashMap<>();
            Map<String, String> emailToName = new HashMap<>();

            // step 1: build graph that connects all emails have relationships
            for (List<String> account : accounts) {
                String name = account.get(0);
                for (int i = 1; i < account.size(); i++) {
                    graph.putIfAbsent(account.get(i), new HashSet<>());
                    emailToName.put(account.get(i), name);
                    if (i != 1) {
                        graph.get(account.get(i)).add(account.get(i - 1));
                        graph.get(account.get(i - 1)).add(account.get(i));
                    }
                }
            }

            // step 2: BFS traversal to traverse all nodes in every single component and generate each result list individually
            List<List<String>> result = new ArrayList<>();
            Set<String> visited = new HashSet<>();
            for (String email : graph.keySet()) {
                if (!visited.contains(email)) {
                    visited.add(email);
                    List<String> newList = bfs(graph, visited, email);
                    Collections.sort(newList);
                    newList.add(0, emailToName.get(newList.get(0)));
                    result.add(newList);
                }
            }
            return result;
        }

        public List<String> bfs(Map<String, Set<String>> graph, Set<String> visited, String startPoint) {
            List<String> newList = new ArrayList<>();
            Queue<String> queue = new LinkedList<>();
            queue.offer(startPoint);

            while(!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String curEmail = queue.poll();
                    newList.add(curEmail);
                    Set<String> neighbors = graph.get(curEmail);
                    for (String neighbor : neighbors) {
                        // WARING: DO NOT FORGET to check whether current email has been visited before
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            return newList;
        }
    }

    // Graph + DFS
    class Solution3 {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, Set<String>> graph = new HashMap<>();
            Map<String, String> name = new HashMap<>();
            // build graph
            for(List<String> account : accounts) {
                String username = account.get(0);
                for(int i = 1; i < account.size(); i++) {
                    graph.putIfAbsent(account.get(i), new HashSet<>());
                    name.put(account.get(i), username);
                    if(i == 1) continue;
                    graph.get(account.get(i)).add(account.get(i-1));
                    graph.get(account.get(i-1)).add(account.get(i));
                }
            }

            List<List<String>> res = new ArrayList<>();
            Set<String> visited = new HashSet<>();

            for(String email : name.keySet()) {
                List<String> emails = new LinkedList<>();
                if(visited.add(email)) {
                    dfs(graph, email, emails, visited);
                    Collections.sort(emails);
                    emails.add(0, name.get(email));
                    res.add(emails);
                }
            }
            return res;
        }

        private void dfs(Map<String, Set<String>> graph, String email, List<String> emails, Set<String> visited) {
            emails.add(email);
            for(String neighbor : graph.get(email)) {
                if(visited.add(neighbor)) {
                    dfs(graph, neighbor, emails, visited);
                }
            }
        }
    }
}
