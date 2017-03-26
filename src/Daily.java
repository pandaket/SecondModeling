/*
 * ѕроверка дн€
 * ¬ последний день шел ли прирост и не достиг ли среднего значени€
*/

public class Daily {
		public boolean daily(double a, double u, double k){
		//	System.out.println(a);
		//	System.out.println(u);
		//	System.out.println(k);
			boolean check = false;
			if (k<a && u==1){
				check = true;
			}
			return check;
		}
}
