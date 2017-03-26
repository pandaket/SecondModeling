/*
 * Проходит по всем предыдущим дням, находит возрастающие тренды, высчитывает
 * среднее количество дней в тренде, фиксирует последний день(возрастает ли)
*/


public class Average {
	double update = 0;
	double aver = 0;
	int n = 0;
	int k = 0;
	int s = 0;
	int count = 1;
	int chan = 0;
	double[][] chanals = new double[100][4];
	double[] ab = new double[2];
	double[] result = new double[4];
	
	public double[] findAver(double[] y, int ii){
		line l= new line();
		ab = l.koeff(y, n, 2);
		k = 2;
	
		for (int i=0;s<200+ii;i++)
		{

			if (l.check(y, s) == false)
			{
				//System.out.println("Тренд #"+count+" : y = "+ab[0]+"x + "+ab[1]);
				count = count+1;
				if (ab[0]>0.2){
					chanals[chan][0] = ab[0];
					chanals[chan][1] = ab[1];
					chanals[chan][2] = k;
					chanals[chan][3] = count-1;
					chan++;
				}
				//System.out.println(chan);
				n = s;
				ab = l.koeff(y, n, 2);
				k = 2;
				s = s+2;
				if(ab[0]>0.2){
				update = 1;
				}
				else {
				update = 0;
				}
				
				
			}
			else
			{
				//System.out.println("Обновление тренда");
				
				ab = l.koeff(y, n, k);
				k = k+1;
				s = s+1;
				if(ab[0]>0.2){
				update = 1;
				}
				else
				{update = 0;}
			}
			
		}
		
		for (int i=0;i<chan;i++){
			//System.out.println("Удовлетворяющий тренд#"+i+": y = "+chanals[i][0]+"x + "+chanals[i][1]);
			aver = aver+chanals[i][2];
			//System.out.println(chanals[i][2]);
		}
		aver = Math.round(aver/chan);
		//aver = aver/chan;
		//System.out.println("Average = "+aver);
		result[0] = aver;
		result[1] = update;
		result[2] = k;
		result[3] = ab[0];
		//Math.round(n)
		return result;
	}
}
