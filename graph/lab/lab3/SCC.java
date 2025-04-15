
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;



public class SCC{
    private List<Integer>[] g;
    private List<Integer>[] rg;
    private boolean[] visited;
    private Stack<Integer> st;
    private List<List<Integer>> sccList;
    private int count;

    public SCC(int nodeCnt){
        g = new ArrayList[nodeCnt + 1];
        rg = new ArrayList[nodeCnt + 1];
        visited = new boolean[nodeCnt + 1];
        st = new Stack<>();
        sccList = new ArrayList<>();
        count = 0;

        for(int i = 1 ; i <= nodeCnt ; i++){
            g[i] = new ArrayList<>();
            rg[i] = new ArrayList<>();
        }
    }


    public void addEdge(int x, int y){
        g[x].add(y);
        rg[y].add(x);
    }

    public void dfs1(int node){
        visited[node] = true;
        for(int child : g[node]){
            if(!visited[child]){
                dfs1(child);
            }
        }
        st.push(node);
    }

    public void dfs2(int node, List<Integer> component){
        visited[node] = true;
        component.add(node);
        
        for(int child : rg[node]){
            if(!visited[child]){
                dfs2(child, component);
            }
        }
    }

    public void findSCC(int nodeCnt){
        Arrays.fill(visited, false);
        
        for(int i = 1 ; i <= nodeCnt ; i++){
            if(!visited[i]){
                dfs1(i);
            }
        }

        Arrays.fill(visited, false);

        while(!st.isEmpty()){
            int node = st.pop();
            if(!visited[node]){
                List<Integer> component = new ArrayList<>();
                count++;
                dfs2(node, component);
                sccList.add(component);
            }
        }
    }


    public void printSCC(){
        System.out.println("# strongly Connected Components:" + count);
        for(int i = 0 ; i < sccList.size() ; i++){
            System.out.print("SCC " + (i + 1) + ": ");
            for(int node : sccList.get(i)){
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int node = sc.nextInt();
        int edge = sc.nextInt();

        SCC graph = new SCC(node);

        for(int i = 0 ; i < edge ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.addEdge(x, y);
        }

        graph.findSCC(node);
        graph.printSCC();
        sc.close();

    }
}