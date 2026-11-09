
import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> a = new TreeSet<>();
        PriorityQueue<int[]> b = new PriorityQueue<>(
            (x, y) -> Integer.compare(x[0], y[0])
        );

        int[] c = new int[k];

        for (int i = 0; i < k; i++) {
            a.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {

            while (!b.isEmpty() && b.peek()[0] <= arrival[i]) {
                a.add(b.poll()[1]);
            }

            if (a.isEmpty()) {
                continue;
            }

            int d = i % k;
            Integer e = a.ceiling(d);

            if (e == null) {
                e = a.first();
            }

            a.remove(e);
            c[e]++;

            b.offer(new int[]{arrival[i] + load[i], e});
        }

        int f = 0;
        List<Integer> g = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (c[i] > f) {
                f = c[i];
                g.clear();
                g.add(i);
            } else if (c[i] == f) {
                g.add(i);
            }
        }

        return g;
    }
}
