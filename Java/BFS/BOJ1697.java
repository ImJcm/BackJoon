import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
숨바꼭질 다국어

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	173465	49683	31214	25.185%
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

예제 입력 1
5 17
예제 출력 1
4
 */
public class BOJ1697 {
    static int N,K;
    static boolean[] visited;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);

        map = new int[100001];
        visited = new boolean[100001];
        Arrays.fill(map,0);
        Arrays.fill(visited,false);

        System.out.println(BFS(N,K));
    }

    static int BFS(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        while(!q.isEmpty()) {
            int pos = q.poll();
            visited[pos] = true;
            if(pos == k) return map[k];

            if(2*pos <= 100000 && !visited[2*pos]) {
                q.offer(2*pos);
                map[2*pos] = map[pos] + 1;
                visited[pos*2] = true;
            }
            if(pos - 1 >= 0 && !visited[pos-1]) {
                q.offer(pos - 1);
                map[pos-1] = map[pos] + 1;
                visited[pos-1] = true;
            }
            if(pos + 1 <= 100000 && !visited[pos+1]) {
                q.offer(pos + 1);
                map[pos+1] = map[pos] + 1;
                visited[pos+1] = true;
            }
        }
        return 0;
    }
}
