import java.util.Date;

public class QuestaoSete {
	
	public static void main(String[] args) {
		I1 x = new E();
		System.out.println(x instanceof B);
		System.out.println(x instanceof C);
		System.out.println(x instanceof A);
		System.out.println(x instanceof I1);
		System.out.println(x instanceof I2);
		
		Date d1 = new Date();
		Date d2 = d1;
		d2.setDate(5);
		
		System.out.println(d2.getDate());
		System.out.println(d1.getDate());
		d1 = null;
		System.out.println(d2.getDate());
		System.out.println(d1.getDate());
	}
}
