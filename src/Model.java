import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Импорт данных из таблицы Excel
 * 
*/
public class Model {

	double[][] data = new double[254][9];	
	
	public double[][] importD(){
		int counter = 0;
        int j = 0;
        int n = 0;
		try {
    	
    	//из какого файла импортировать
        File excel = new File("actions.xlsx");
        FileInputStream fis = new FileInputStream(excel);
        XSSFWorkbook book = new XSSFWorkbook(fis);
        
        //из какого листа импортировать
        XSSFSheet sheet = book.getSheetAt(0);
        
        //Построчное изъятие данных
        Iterator<Row> i = sheet.iterator();

        
        double value;
        while (i.hasNext()&&counter!=254) {
            Row row = i.next();   
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()){
	            //в 1 столбце - 1 фактор
	            Cell key = cellIterator.next();
	            value = key.getNumericCellValue();
	            data[counter][j] = value;
	            j++;
            }
            n = j;
            counter++;
            j = 0;
            
        }
        
        //закрыть книгу
        book.close();
        //остановить считывание из файла
        fis.close();

    } catch (FileNotFoundException fe) { //если файл не найден
        fe.printStackTrace();
    } catch (IOException ie) { //при ошибке кода
        ie.printStackTrace();
    }
		//Оторбражение данных
		/*for (int i=0;i<counter;i++){
		for (int jj=0;jj<n;jj++){
			
				System.out.print(data[i][jj]+" ");
			}
			System.out.println("");
		}*/
		return data;
	}
}
