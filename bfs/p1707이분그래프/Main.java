package bfs.p1707이분그래프;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int color;
	public static int K, V, E;
	public static StringBuffer sb = new StringBuffer();
	public static boolean result = false; // 결과값 true면 YES false면 NO
	public static Queue<Vertax> vertaxQueue; // bfs탐색을 위한 정점 큐

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		List<Vertax> vertaxVector = null; // 정점을 모아놓은 벡터들 Vertax.index-1의 위치에 각각
											// 저장됩니다.

		K = scr.nextInt();

		for (int i = 0; i < K; i++) {
			V = scr.nextInt();
			E = scr.nextInt();
			color = 0;
			result = true; // 1
			vertaxQueue = new LinkedList<Vertax>();

			vertaxVector = new ArrayList<>();

			for (int n = 1; n <= V; n++) {
				Vertax vertax = new Vertax(n);
				vertaxVector.add(vertax);
			}

			for (int n = 1; n <= E; n++) { // 2
				int v1Index = scr.nextInt();
				int v2Index = scr.nextInt();

				Vertax v1 = vertaxVector.get(v1Index - 1);
				Vertax v2 = vertaxVector.get(v2Index - 1);

				v1.getConnectedEdges().add(v2);
				v2.getConnectedEdges().add(v1);
			}

			for (Vertax v : vertaxVector) { // 3
				if (v.getColor() != -1) {
					continue;
				}

				v.setColor(color);
				vertaxQueue.add(v);

				while (!vertaxQueue.isEmpty()) {

					Vertax element = vertaxQueue.poll();
					if (!bfsVertax(element)) {
						result = false;
						break;
					}
				}
			}

			if (result) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}

		System.out.println(sb.toString());
	}

	public static boolean bfsVertax(Vertax vertax) {
		Iterator<Vertax> itr = vertax.getConnectedEdges().iterator();

		while (itr.hasNext()) {
			Vertax v = itr.next();
			if (v.getColor() != -1 && vertax.getColor() == v.getColor()) {
				return false;
			}

			if (v.getColor() == -1) {
//				 v.setColor( color + 1 % 2);
				v.setColor(vertax.getColor() + 1 % 2);
				vertaxQueue.add(v);
			}
		}
		
//		color = color + 1 % 2;
		return true;
	}
}

class Vertax {
	private int index;
	private int color; // -1 색없음, 0 빨 1 파
	private HashSet<Vertax> connectedEdges;

	public Vertax(int index) {
		this.index = index;
		color = -1;
		connectedEdges = new HashSet<>();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public HashSet<Vertax> getConnectedEdges() {
		return connectedEdges;
	}

	public void setConnectedEdges(HashSet<Vertax> connectedEdges) {
		this.connectedEdges = connectedEdges;
	}

}