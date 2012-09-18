

public class TEImpl implements TE1,TE2 {

	@Override
	public int len(String str) {
		return str.length();
	}

	public static void main(String[] args) {
		TE1 te1 = new TEImpl();
		TE2 te2 = (TE2) te1;
		System.out.println(te1.len("anil"));
		System.out.println(te2.len("anil"));
		
	}
	
}
