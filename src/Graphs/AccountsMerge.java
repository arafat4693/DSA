package Graphs;

import java.util.*;

public class AccountsMerge {
//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//        int[] parent = new int[accounts.size()];
//        HashSet<String>[] mails = new HashSet[accounts.size()];
//
//        for(int i = 0; i < accounts.size(); i++){
//            mails[i] = new HashSet<>();
//            parent[i] = -1;
//        }
//
//        for(int i = 0; i < accounts.size(); i++){
//            List<String> account = accounts.get(i);
//            System.out.println(account);
//            for(int m = 1; m < account.size(); m++) mails[i].add(account.get(m));
//        }
//
//        for(int i = 0; i < accounts.size(); i++){
//            List<String> a1 = accounts.get(i);
//            for(int j = i+1; j < accounts.size(); j++){
//                List<String> a2 = accounts.get(j);
//                if(Objects.equals(a1.get(0), a2.get(0))) union(parent, mails, i, j);
//            }
//        }
//
//        List<List<String>> res = new ArrayList<>();
//        for(int i = 0; i < parent.length; i++){
//            if(parent[i] != -1) continue;
//
//            List<String> subRes = new ArrayList<>();
//            List<String> acc = accounts.get(i);
//
//            subRes.add(acc.get(0));
//            List<String> allMails = new ArrayList<>(mails[i]);
//            Collections.sort(allMails);
//            subRes.addAll(allMails);
//
//            res.add(subRes);
//        }
//
//        return res;
//    }
//
//    private void union(int[] parent, HashSet<String>[] mails, int a1, int a2){
//        int r1 = find(parent, a1), r2 = find(parent, a2);
//
//        if(r1 != r2 && canMerge(mails[r1], mails[r2])){
//            if(mails[r1].size() > mails[r2].size()){
//                parent[r2] = r1;
//                for(String m : mails[r2]) mails[r1].add(m);
//            }else {
//                parent[r1] = r2;
//                for(String m : mails[r1]) mails[r2].add(m);
//            }
//        }
//    }
//
//    private int find(int[] parent, int u){
//        if(parent[u] == -1) return u;
//        return find(parent, parent[u]);
//    }
//
//    private boolean canMerge(HashSet<String> h1, HashSet<String> h2){
//        for(String m : h2){
//            if(h1.contains(m)) return true;
//        }
//        return false;
//    }

    public List<List<String>> accountsMerge(List<List<String>> accounts){
        HashMap<String, Integer> mailToAcc = new HashMap<>();

        int[] parent = new int[accounts.size()];
        Arrays.fill(parent, -1);

        for(int i = 0; i < accounts.size(); i++){
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++){
                if(mailToAcc.containsKey(account.get(j))){
                    union(parent, i, mailToAcc.get(account.get(j)));
                }else mailToAcc.put(account.get(j), i);
            }
        }

        HashMap<Integer, List<String>> mailGroup = new HashMap<>();

        for(String k : mailToAcc.keySet()){
            int rep = find(parent, mailToAcc.get(k));
            mailGroup.putIfAbsent(rep, new ArrayList<>());
            mailGroup.get(rep).add(k);
        }

        List<List<String>> res = new ArrayList<>();

        for(int k : mailGroup.keySet()){
            List<String> account = accounts.get(k);
            List<String> subRes = new ArrayList<>();
            subRes.add(account.get(0));
            Collections.sort(mailGroup.get(k));
            subRes.addAll(mailGroup.get(k));

            res.add(subRes);
        }

        return res;
    }

    private void union(int[] parent, int a1, int a2){
        int r1 = find(parent, a1);
        int r2 = find(parent, a2);

        if(r1 == r2) return;

        if(parent[r1] < parent[r2]){
            parent[r1] += parent[r2];
            parent[r2] = r1;
        }else{
            parent[r2] += parent[r1];
            parent[r1] = r2;
        }
    }

    private int find(int[] parent, int a){
        if(parent[a] < 0) return a;
        return find(parent, parent[a]);
    }
}
