import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }
        
        int[] newParent = parent.clone();
        int[] last = new int[26];
        Arrays.fill(last, -1);
        
      
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0, -1});
        
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int u = top[0];
            int state = top[1];
            int old = top[2];
            
            int c = s.charAt(u) - 'a';
            
            if (state == 0) { 
                if (last[c] != -1) {
                    newParent[u] = last[c];
                }
                stack.push(new int[]{u, 1, last[c]}); 
                last[c] = u;
               
                for (int i = tree[u].size() - 1; i >= 0; i--) {
                    stack.push(new int[]{tree[u].get(i), 0, -1});
                }
            } else {
                last[c] = old; 
            }
        }
        
        
        List<Integer>[] newTree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            newTree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            newTree[newParent[i]].add(i);
        }
        
        int[] ans = new int[n];
        
      
        Stack<int[]> stack2 = new Stack<>();
        stack2.push(new int[]{0, 0});
        
        while (!stack2.isEmpty()) {
            int[] top = stack2.pop();
            int u = top[0];
            int state = top[1];
            
            if (state == 0) {
                stack2.push(new int[]{u, 1});
                for (int v : newTree[u]) {
                    stack2.push(new int[]{v, 0});
                }
            } else {
                int sz = 1;
                for (int v : newTree[u]) {
                    sz += ans[v];
                }
                ans[u] = sz;
            }
        }
        
        return ans;
    }
}