/*
 * ������� �����.
 * �����: �������� ��������� 09-308.
 * ������������ ����� � ������ 13 ����� 2016 - 23 ������� 2016 ����
 * ��������������� ��� 22 ���� � ������ 23 ������� 2016 ���� - 25 ������ 2016 ����
*/

public class Main1 {
		
		
	public static void main(String[] args){
			double[][] data = new double[254][9];
			double[] y = new double[254];
			double[] result = new double[2];
			double[] average = new double[9];
			double[] update = new double[9];
			double[] k = new double[9];
			double[] a = new double[9];
			boolean daily = false;
			double[] max1 = {0,0};
			double[] max2 = {0,0};
			double[] max3 = {0,0};
			//���� ������
			Model m = new Model();
			data = m.importD();	
			int day = 200;
			int analyz = 200;
			double earning = 0;
			
			
		for (int ac=0;ac<9;ac++){	
			for (int i=0;i<254;i++){
				y[i]=data[i][ac];
				//System.out.println(y[i]);

			}
			//���������� ��������������� ������������� ��������� � ������� ���������� ����� � ���
			Average aver = new Average();
			result = aver.findAver(y, 0);
			average[ac]=result[0];
			update[ac]=result[1];
			k[ac]=result[2];
			a[ac]=result[3];
			
		}
		//System.out.println("==");
/*������� �������� 3 ��������� ����� �� ����*/		
		 	Daily d = new Daily();
			
			for (int l=1;l<23;l++){
			for (int i=0;i<9;i++){
				daily = d.daily(average[i], update[i], k[i]);
	
				if(daily){
					if (a[i]>max1[1]){ //���� ��������������� ����� ������ ����� ������ �����, �� ����������
					 	max1[1] = a[i];
					 	max1[0] = i+1;
					  }
					 
					 if (a[i]>max2[1]&&a[i]<max1[1]){ //���� ����� �������� 2 ����� 
					  		max2[1] = a[i];
						 	max2[0] = i+1;
						  }
						  
					 if (a[i]>max3[1]&&a[i]<max2[1]&&a[i]<max1[1]){ //���� ����� �������� 3 �����
						  		max3[1] = a[i];
							 	max3[0] = i+1;
						}
						  
					  
				}
			}
			
			
			for (int i=0;i<9;i++){
				for (int ii=0;ii<254;ii++){
					y[ii]=data[ii][i];
					//System.out.println(y[i]);

				}
			Average aver = new Average();
			result = aver.findAver(y, l);
			average[i]=result[0];
			update[i]=result[1];
			k[i]=result[2];
			a[i]=result[3];
			
			}
			System.out.println("==");
			System.out.println("���� �"+l);
			System.out.println("������ �����(������):"+max1[0]+", "+max2[0]+", "+max3[0]+"");
/*������ ������� �� ������ ������*/
			double money = 0;
			day++;
			if (max1[0]!=0){
				int ss = (int)max1[0]-1;
				for (int i=0;i<254;i++){
					y[i]=data[i][ss];
					//System.out.println(y[i]);
	
				}
				money = y[day]-y[day-1];
			}
			if (max2[0]!=0){
				int ss = (int)max2[0]-1;
				for (int i=0;i<254;i++){
					y[i]=data[i][ss];
					//System.out.println(y[i]);
	
				}
				money = money + y[day]-y[day-1];
			}
			if (max3[0]!=0){
				int ss = (int)max3[0]-1;
				for (int i=0;i<254;i++){
					y[i]=data[i][ss];
					//System.out.println(y[i]);
	
				}
				money = money+ y[day]-y[day-1];
			}
			System.out.println("�������(%): "+money);
			earning = earning+money;
			max3[1] = 0;
		 	max3[0] = 0;
		 	max2[1] = 0;
		 	max2[0] = 0;
		 	max1[1] = 0;
		 	max1[0] = 0;
		 	money = 0;
			}
			System.out.println(""); 
			System.out.println("����� �������(%): "+earning); 
/*������ ������� �� ������ ������ (�� ��������� �������� ������)*/
			double earningReal=0;
			double[] realMoney = new double[9];
			for( int i=0;i<22;i++){
				analyz++; 
				for (int j=0;j<9;j++){
					
					realMoney[j] = data[analyz][j]-data[analyz-1][j];
					//System.out.println(realMoney[j]);
				}
				double maxi1=0;
				double maxi2=0;
				double maxi3=0;
				for (int j=0;j<9;j++){
					if (realMoney[j]>maxi1){
						maxi1 = realMoney[j];
					}
					if (realMoney[j]>maxi2&&realMoney[j]!=maxi1){
						maxi1 = realMoney[j];
					}
					if (realMoney[j]>maxi3&&realMoney[j]!=maxi2&&realMoney[j]!=maxi1){
						maxi1 = realMoney[j];
					}
				}
				earningReal = earningReal+maxi1+maxi2+maxi3;
			}
			System.out.println(""); 
			System.out.println("�������� �������(%): "+earningReal);
	}
}
