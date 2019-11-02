
package datastruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//图的邻接链表结构
public class AdjacentGraph {

    public static final int MODE_ARRAY = 1;

    public static final int MODE_LISTNODE = 2;

    private int mode;

    // 每个ListNode的头为顶点u，头后面所有元素表示与顶点u连接的边(u, v(i))
    private List<ListNode> g;

    // adj的每一行，第一个值为顶点u，后面所有值表示顶点u连接的边(u, v(i))
    // adj的行数表示顶点数
    private int[][] adj;

    public AdjacentGraph(List<ListNode> g) {
        this.mode = MODE_LISTNODE;
        this.g = g;
    }

    public AdjacentGraph(int[][] adj) {
        this.mode = MODE_ARRAY;
        this.adj = adj;
    }

    public static AdjacentGraph create(int[][] adj, int mode) {
        if (mode == MODE_ARRAY) {
            return new AdjacentGraph(adj);
        }

        List<ListNode> g = new ArrayList<ListNode>();

        for (int i = 0; i < adj.length; i++) {
            ListNode head = null, next = null, node = null;
            for (int j = 0; j < adj[i].length; j++) {
                node = new ListNode(adj[i][j]);
                if (head == null) {
                    head = node;
                    next = head;
                } else {
                    next.next = node;
                    next = next.next;
                }
            }
            g.add(head);
        }
        return new AdjacentGraph(g);
    }

    // 找出图g中顶点u的“入度”：入度的定义为“所有向顶点u发射的边”
    // 反转的操作就是将顶点u的“入读”转为“出度”
    // 出度的定义为：“所有从顶点u发射出去的边”
    public void transpos2() {
        if (this.mode != MODE_LISTNODE) {
            throw new RuntimeException("NOT IMPLEMENTED");
        }
        List<ListNode> transposG = new ArrayList<ListNode>();

        for (ListNode u : g) {
            // 将顶点u的的入度转为出度
            // u->u.next => [u.next...]=>u
            t(transposG, u, u.next);

            // 在剩余的顶点中找到u的入度，转为出度
            // 存在没有任何出度的顶点，则u == v，顶点u的边就是自己
            boolean aloneVertex = true;
            for (ListNode v : g) {
                if (u.val == v.val) {
                    continue;// 顶点u本身，已经处理过了
                }
                ListNode hv = v;
                while (v != null) {
                    if (v.val == u.val) {
                        // 反转hv->v => v-hv
                        t(transposG, new ListNode(hv.val), new ListNode(v.val));
                        aloneVertex = false;
                        break;
                    }
                    v = v.next;
                }
            }
            if (aloneVertex) {
                transposG.add(new ListNode(u.val));
            }
        }
        this.g.clear();
        this.g.addAll(transposG);
    }

    /**
     * 将u->v转换为v->u
     * @param transposG
     * @param u 边的顶点u
     * @param v 边的顶点v
     * @param edge v 的所有出度顶点
     */
    private void t(List<ListNode> transposG, ListNode u, ListNode v) {
        boolean adjExist = false;
        while (v != null) {
            for (ListNode existV : transposG) {
                // 顶点v在转置图中已经存在
                if (v.val == existV.val) {
                    adjExist = true;
                    // 将u插到队列尾部
                    // u可能已经被处理过了
                    boolean uExist = false;
                    while (existV.next != null) {
                        if (existV.next.val == u.val) {
                            uExist = true;
                            break;
                        }
                        existV = existV.next;
                    }
                    if (!uExist) {
                        existV.next = new ListNode(u.val);
                    }
                }
            }
            // 顶点vv在转置图中不存在
            if (!adjExist) {
                ListNode head = new ListNode(v.val);
                ListNode next = new ListNode(u.val);
                head.next = next;
                transposG.add(head);
            }
            v = v.next;
        }

    }

    // 有向图转置: 将所有有向边方向反转
    public void transpos() {
        if (this.mode != MODE_ARRAY) {
            throw new RuntimeException("NOT IMPLEMENTED");
        }

        int[][] transposG = new int[adj.length][];

        // 找到所有顶点
        int[] vertexs = new int[adj.length];
        for (int i = 0; i < adj.length; i++) {
            // 每个链(行)表第一个元素是顶点
            vertexs[i] = adj[i][0];
        }

        int uNum = 0;
        int v = 0;// 顶点u的出度顶点
        for (int u : vertexs) {
            // 找出图g中顶点u的“入度”：入度的定义为“所有向顶点u发射的边”
            // 反转的操作就是将顶点u的“入读”转为“出度”
            // 出度的定义为：“所有从顶点u发射出去的边”

            int[] out = new int[adj.length];
            int outLen = 0;
            for (int i = 0; i < adj.length; i++) {
                // 顶点u的出度
                outLen = 1;
                out[0] = u; // 第一个元素为顶点
                v = adj[i][0];

                if (u == v) {

                }

                // 从第二个元素开始，第一个元素为顶点
                for (int j = 1; j < adj[i].length; j++) {
                    if (u == adj[i][j]) {
                        // 顶点u在行i中，行i的第一个元素是顶点v
                        out[outLen] = adj[i][0];
                        outLen++;
                        break;
                    }
                }
            }

            transposG[uNum] = Arrays.copyOfRange(out, 0, outLen);
            uNum++;
        }
        this.adj = transposG;
    }

    private String toString1() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < adj.length; i++) {
            sb.append("Edges of Graph\n");
            for (int j = 0; j < adj[i].length; j++) {
                sb.append(adj[i][j]).append("->");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("\n");
        }
        return sb.toString();
    }

    private String toString2() {
        StringBuffer sb = new StringBuffer();
        for (ListNode node : g) {
            sb.append("Edges of Graph\n");
            while (node != null) {
                sb.append(node.val).append("->");
                node = node.next;
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        if (mode == MODE_ARRAY) {
            return toString1();
        } else {
            return toString2();
        }
    }
}
