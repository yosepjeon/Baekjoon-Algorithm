package 시뮬레이션.p17143낚시왕;

public class Practice {
	public static void main(String[] args ) {
		Element e1 = new Element(1,1);
		Element e2 = new Element(1,1);
		
		if(e1.equals(e2)) {
			System.out.println("e1과 e2는 같은 객체이다.");
		}else {
			System.out.println("!");
		}
		
		if(e1.hashCode() == e2.hashCode()) {
			System.out.println("e1과 e2는 같은 해시코드이다.");
		}
	}
}

class Element {
	int r,c;
	static final int HASH_PRIME = 31;
	
	public Element(int r, int c) {
		this.r = r;
		this.c = c;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Element element = (Element)obj;
		if(this.r == element.r && this.c == element.c) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int hashCode = HASH_PRIME * Integer.hashCode(this.r);
		hashCode = HASH_PRIME * Integer.hashCode(this.c);
		
		return hashCode;
	}
}
