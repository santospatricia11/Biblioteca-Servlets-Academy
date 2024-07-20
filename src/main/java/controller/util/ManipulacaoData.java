package controller.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ManipulacaoData {
	
	public Date converterStringData(String dataString) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = null;
		try {
			data = format.parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return data;
	}

}
