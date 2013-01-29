package utils;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import fr.cpe.ha.jbbflight.models.User;

public class Utils {

	/**
	 * Get a Date from a string.
	 * @return
	 */
	public static Date getDateFromString(String date, String format) {
		
		if(format.isEmpty())
			format = "dd/MM/yyyy";
		
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date dateTemp = null;
		try {
			dateTemp = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dateTemp;
	}
	
	/**
	 * Send a message with the specified params.
	 * @param to
	 * @param from
	 * @param subj
	 * @param body
	 */
	public static void SendMessage(String to, String from, String subj, String body) {
		
		Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        
		try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from, from));
            msg.addRecipient(Message.RecipientType.TO,
                             new InternetAddress(to, to));
            msg.setSubject(subj);
            msg.setText(body);
            Transport.send(msg);

        } catch (AddressException e) {
            // ...
        } catch (MessagingException e) {
            // ...
        } catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
