class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n + 1);
        UnionFind bob = new UnionFind(n + 1);

        int result = 0;

        for (int[] edge : edges) {
            if (edge[0] != 3) continue;

            boolean aliceUnion = alice.union(edge[1], edge[2]);
            boolean bobUnion = bob.union(edge[1], edge[2]);

            if (aliceUnion || bobUnion) result++;
        }

        for (int[] edge : edges) {
            if (edge[0] == 3) continue;

            if (edge[0] == 1) {
                if (alice.union(edge[1], edge[2])) result++;
            } else if (edge[0] == 2) {
                if (bob.union(edge[1], edge[2])) result++;
            }
        }

        return alice.isConnected() && bob.isConnected() ? edges.length - result : -1;
    }

    class UnionFind {
        int[] parents;
        int[] ranks;
        int connectedComponents;

        UnionFind(int n) {
            parents = new int[n];
            ranks = new int[n];
            connectedComponents = n - 1;

            for (int i = 0; i < n; i++) {
                parents[i] = i;
                ranks[i] = 1;
            }
        }

        public int find(int node) {
            int p = parents[node];

            while (parents[p] != p) {
                parents[p] = parents[parents[p]];
                p = parents[p];
            }

            return p;
        }

        public boolean union(int node1, int node2) {
            int parent1 = find(node1), parent2 = find(node2);

            if (parent1 == parent2) return false;

            if (ranks[parent1] > ranks[parent2]) {
                parents[parent2] = parent1;
                ranks[parent1] += ranks[parent2];

            } else {
                parents[parent1] = parent2;
                ranks[parent2] += ranks[parent1];
            }

            connectedComponents--;

            return true;
        }

        public boolean isConnected() {
            return connectedComponents == 1;
        }
    }
}