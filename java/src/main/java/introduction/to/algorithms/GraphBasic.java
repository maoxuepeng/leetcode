
package introduction.to.algorithms;

import datastruct.AdjacentGraph;

public class GraphBasic {
    public static void main(String[] args) {
        int[][] adj = new int[][] {new int[] {1, 2, 4}, new int[] {2, 5}, new int[] {3, 5, 6}, new int[] {4, 2},
            new int[] {5, 4}, new int[] {6, 6}};
        AdjacentGraph g = AdjacentGraph.create(adj, AdjacentGraph.MODE_LISTNODE);
        String originG = g.toString();
        g.transpos2();
        String transposG = g.toString();
        System.out.println("Origin Graph:");
        System.out.println(originG);
        System.out.println("-------");
        System.out.println("Transposed Graph:");
        System.out.println(transposG);
    }
}
