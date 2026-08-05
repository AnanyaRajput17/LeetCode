import java.util.*;

class Disjoint {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public Disjoint(int n) {
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findulp(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findulp(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionbyrank(int u, int v) {
        int ulpu = findulp(u);
        int ulpv = findulp(v);

        if (ulpu == ulpv) return;

        int ranku = rank.get(ulpu);
        int rankv = rank.get(ulpv);

        if (ranku < rankv) {
            parent.set(ulpu, ulpv);
        } else if (ranku > rankv) {
            parent.set(ulpv, ulpu);
        } else {
            parent.set(ulpv, ulpu);
            rank.set(ulpu, ranku + 1);
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Disjoint ds = new Disjoint(n);
        Map<String, Integer> map = new HashMap<>();

        // Step 1: Map emails to account indices & union overlapping accounts
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!map.containsKey(mail)) {
                    map.put(mail, i);
                } else {
                    ds.unionbyrank(i, map.get(mail));
                }
            }
        }

        // Step 2: Group emails by their ultimate parent account index
        List<List<String>> mergedMail = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mergedMail.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String mail = entry.getKey();
            int parentNode = ds.findulp(entry.getValue());
            mergedMail.get(parentNode).add(mail);
        }

        
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail.get(i).isEmpty()) continue;

            Collections.sort(mergedMail.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // Name
            temp.addAll(mergedMail.get(i));   // Sorted emails
            result.add(temp);
        }

        return result;
    }
}