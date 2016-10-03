package control;

import java.util.Calendar;

import service.ClientService;

public class Control {
	private static String id;
	
	public static void login(String id, String password) {
		Control.id = id;
		ClientService.getInstance().login(id, password);
	}

	/**@return login id */
	public static String getId() {
		return id;
	}
	
	/** @return present time which type like YYYY.MM.DD/HH:MM:SS */
	public static String now() {
		Calendar cal = Calendar.getInstance();
		String year = Integer.toString(cal.get(Calendar.YEAR));
		String month = Integer.toString(cal.get(Calendar.MONTH));
		String date = Integer.toString(cal.get(Calendar.DATE));
		String hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
		String minute = Integer.toString(cal.get(Calendar.MINUTE));
		String sec = Integer.toString(cal.get(Calendar.SECOND));

		return year + "." + month + "." + date + "/" + hour + ":" + minute + ":" + sec;
	}
	
	public static void main(String[] args) {
		login("id001", "ps001");
		login("id002", "ps002");
		login("ddd", "ps001");
		login("id003", "ddd");
	}
}