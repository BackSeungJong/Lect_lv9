package etc;

public class Item {
	public int kind;// (0.무기)(1.방어)(2.장신구)
	public String name;
	public int hp;
	public int mp;
	public int att;
	public int def;

	public Item(int k, String n, int h, int m, int a, int d) {
		kind = k;
		name = n;
		hp = h;
		mp = m;
		att = a;
		def = d;
	}

	public void getiteminfo() {
		if (kind == 0) {
			System.out.print("[무기] ");
		} else if (kind == 1) {
			System.out.print("[방어구] ");
		} else if (kind == 2) {
			System.out.print("[장신구] ");
		}
		System.out.printf("%s ");
		
	}
}
