package q11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map, edge;
	static int[] visited;
	
	public static void DFS(int n) {
		int i;
		
		for(i=0; i<N; i++) {
			if(map[n][i] == 1 && visited[i] == 0) {
				visited[i] = 1;
				DFS(i);
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		int i, j, temp;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		edge = new int[N][N];

		for (i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (j = 0; j < N; j++) {
				temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
			}
		}

		for (i = 0; i < N; i++) {
			visited = new int[N];
			DFS(i);
			for (j = 0; j < N; j++) {
				edge[i][j] = visited[j];
			}
		}

		for (i = 0; i < N; i++) {
			for (j = 0; j < N; j++)
				System.out.print(edge[i][j] + " ");
			System.out.println();
		}

		in.close();
	}
}
