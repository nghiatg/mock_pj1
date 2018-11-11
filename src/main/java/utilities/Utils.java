package utilities;

import java.util.Date;

public class Utils {
	@SuppressWarnings("deprecation")
	public static String changeDateToString(Date d) {
		StringBuilder sb = new StringBuilder();
		sb.append(d.getDate()).append("-").append(d.getMonth()+1).append("-").append(d.getYear() + 1900);
		return sb.toString();
	}

}
