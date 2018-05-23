import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationListener;

/**
 * Author: 余家奎
 * Email: yjk@haochedai.com
 * Date: 2018-05-23
 * Time: 16:42
 * <p>
 * Description:
 */
public class HelloListener implements NotificationListener {

	public void handleNotification(Notification n, Object handback) {

		System.out.println("type=" + n.getType());
		System.out.println("source=" + n.getSource());
		System.out.println("seq=" + n.getSequenceNumber());
		System.out.println("send time=" + n.getTimeStamp());
		System.out.println("message=" + n.getMessage());
		if (n instanceof AttributeChangeNotification){
			AttributeChangeNotification attributeChangeNotification = (AttributeChangeNotification)n;
			System.out.println("old value="+attributeChangeNotification.getOldValue());
			System.out.println("new value="+attributeChangeNotification.getNewValue());
		}

		if (handback != null) {
			if (handback instanceof Hello) {
				Hello hello = (Hello) handback;
				hello.printHello(n.getMessage());
			}
		}
	}
}
