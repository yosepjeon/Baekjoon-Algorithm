package 시뮬레이션.p17143낚시왕;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int R, C, M;
	static int score = 0;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		R = scr.nextInt();
		C = scr.nextInt();
		M = scr.nextInt();

		List<Shark> sharks = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			int r = scr.nextInt();
			int c = scr.nextInt();
			int s = scr.nextInt();
			int d = scr.nextInt();
			int z = scr.nextInt();

			sharks.add(new Shark(r, c, s, d, z));
		}

		sortSharks(sharks);

//		for (Shark shark : sharks) {
//			System.out.println(shark.r + ", " + shark.c + ", " + shark.s + ", " + shark.d + ", " + shark.z);
//		}

		for (int i = 1; i <= C; i++) {
			huntShark(i, sharks);
//			System.out.println(score);
			moveSharks(sharks);
			eatEachOther(sharks);
			
			sortSharks(sharks);
			
//			for (Shark shark : sharks) {
//				System.out.println(shark.r + ", " + shark.c + ", " + shark.s + ", " + shark.d + ", " + shark.z);
//			}
		}

//		for (Shark shark : sharks) {
//			System.out.println(shark.r + ", " + shark.c + ", " + shark.s + ", " + shark.d + ", " + shark.z);
//		}
//		System.out.println("남은 상어수: " + sharks.size() + "마리");
//		System.out.println("점수: " + score);
		System.out.println(score);
	}
	
	public static void sortSharks(List<Shark> sharks) {
		sharks.sort((Shark s1, Shark s2) -> {
			if (s1.c > s2.c) {
				return 1;
			} else if (s1.c < s2.c) {
				return -1;
			} else {
				if (s1.r > s2.r) {
					return 1;
				} else if (s1.r < s2.r) {
					return -1;
				} else {
					if(s1.z < s2.z) {
						return 1;
					}else if(s1.z > s2.z) {
						return -1;
					}else {
						return 0;
					}
				}
			}
		});
	}

	public static void huntShark(int c, List<Shark> sharks) {
		Iterator<Shark> itr = sharks.iterator();

		while (itr.hasNext()) {
			Shark shark = itr.next();
			if (c == shark.c) {
				itr.remove();
				score += shark.z;
				return;
			}
		}
	}

	public static void moveSharks(List<Shark> sharks) {
		Iterator<Shark> itr = sharks.iterator();

		while (itr.hasNext()) {
			Shark shark = itr.next();
			int s = shark.s;

			while (s != 0) {
//				if(shark.z == 9) {
//					System.out.println("크기 9: " + s + " 방향: " + shark.d);
//				}
				
				if (shark.d == 1) { // 북, 남 
					if(s > Math.abs(shark.r - 1)) {
						s -= Math.abs(shark.r - 1);
						shark.r = 1;
						shark.d = 2;
						continue;
					}else if(s <= Math.abs(shark.r - 1)){
						shark.r = shark.r - s;
						s = 0;
						continue;
					}
				}else if(shark.d == 2) {
					if(s > Math.abs(shark.r - R)) {
						s -= Math.abs(shark.r - R);
						shark.r = R;
						shark.d = 1;
						continue;
					}else if(s <= Math.abs(shark.r - R)){
						shark.r = shark.r + s;
						s = 0;
						continue;
					}
				}else if (shark.d == 3) { // 동, 서
					if(s > Math.abs(shark.c - C)) {
						s -= Math.abs(shark.c - C);
						shark.c = C;
						shark.d = 4;
						continue;
					}else if (s <= Math.abs(shark.c - C)){
						shark.c = shark.c + s;
						s = 0;
						continue;
					}
				}else if(shark.d == 4) {
					if(s > Math.abs(shark.c - 1)) {
						s -= Math.abs(shark.c - 1);
						shark.c = 1;
						shark.d = 3;
						continue;
					}else if (s <= Math.abs(shark.c - 1)){
						shark.c = shark.c - s;
						s = 0;
						continue;
					}
				}
			}

			// int count = 0;
			// if (shark.d == 1 || shark.d == 2) {
			// count = shark.s / R;
			//
			// if (count % 2 == 0) {
			//
			// } else {
			//
			// }
			// } else if (shark.d == 3 || shark.d == 4) {
			// count = shark.s / C;
			//
			// if (count % 2 == 0) {
			//
			// } else {
			//
			// }
			// }
		}
	}
	
	public static void eatEachOther(List<Shark> sharks) {
		Iterator<Shark> itr = sharks.iterator();
		Shark[][] map = new Shark[R+1][C+1];
		
		while(itr.hasNext()) {
			Shark shark = itr.next();
			
			if(map[shark.r][shark.c] == null) {
				map[shark.r][shark.c] = shark;
				continue;
			}else if(map[shark.r][shark.c] != null && map[shark.r][shark.c].z > shark.z) {
				itr.remove();
				continue;
			}
		}
	}
	
//	public static void eatEachOther(List<Shark> sharks) {
//		Iterator<Shark> itr1 = sharks.iterator();
//		
//		boolean flag = false;
//		boolean[] check = new boolean[sharks.size()];
//		int size = sharks.size();
//		
//		for(int i=0;i<size;i++) {
//			if(check[i])
//				continue;
//			
//			for(int j=i+1;j<size;j++) {
//				if(check[j])
//					continue;
//				
//				if(sharks.get(i).r == sharks.get(j).r && sharks.get(i).c == sharks.get(j).c && sharks.get(i).z > sharks.get(j).z) {
//					check[j] = true;
//					continue;
////					break;
//				}else if(sharks.get(i).r == sharks.get(j).r && sharks.get(i).c == sharks.get(j).c && sharks.get(i).z < sharks.get(j).z) {
//					check[i] = true;
//					break;
//				}
//			}
//		}
//		
//		Iterator<Shark> itr = sharks.iterator();
//		int i = 0;
//		while(itr.hasNext()) {
//			itr.next();
//			if(check[i]) {
//				itr.remove();
//			}
//			
//			i++;
//		}
//	}
	
//	public static void eatEachOther(List<Shark> sharks) {
//		Iterator<Shark> itr1 = sharks.iterator();
//		
//		boolean flag = false;
//		while(itr1.hasNext()) {
//			if(flag) {
//				itr1 = sharks.iterator();
//				flag = false;
//			}
//			Shark shark1 = itr1.next();
//			
//			Iterator<Shark> itr2 = sharks.iterator();
//			while(itr2.hasNext()) {
//				Shark shark2 = itr2.next();
////				System.out.println("shark1 " + shark1.r + ", " + shark1.c);
////				System.out.println("shark2 " + shark2.r + ", " + shark2.c);
//				
//				if(shark1 == shark2) {
//					continue;
//				}
//				
//				if(shark1.r == shark2.r && shark1.c == shark2.c && shark1.z > shark2.z) {
//					itr2.remove();
//					flag = true;
//					continue;
////					break;
//				}else if(shark1.r == shark2.r && shark1.c == shark2.c && shark1.z < shark2.z) {
//
//					break;
//				}
//			}
//		}
//	}
}

class Shark {
	int r, c, s, d, z;

	public Shark(int r, int c, int s, int d, int z) {
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}
}