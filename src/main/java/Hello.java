import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 * Author: 余家奎
 * Email: yjk@haochedai.com
 * Date: 2018-05-23
 * Time: 11:44
 * <p>
 * Description:
 */
public class Hello extends NotificationBroadcasterSupport implements HelloMBean {
	private String name;

	private int cacheSize = DEFAULT_CACHE_SIZE;
	private static final int DEFAULT_CACHE_SIZE = 200;
	private long sequenceNumber = 1;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printHello() {
		System.out.println("Hello world, "+ name);
	}

	public void printHello(String whoName) {
		System.out.println("Hello, "+whoName);
	}

	public int getCacheSize() {
		return this.cacheSize;
	}

	public synchronized void setCacheSize(int size) {
		int oldSize = this.cacheSize;
		this.cacheSize = size;

		System.out.println("Cache size now " + this.cacheSize);

		Notification n = new AttributeChangeNotification(this,
				sequenceNumber++, System.currentTimeMillis(),
				"CacheSize changed", "CacheSize", "int",
				oldSize, this.cacheSize);

		sendNotification(n);
	}

	@Override
	public MBeanNotificationInfo[] getNotificationInfo() {
		String[] types = new String[]{
				AttributeChangeNotification.ATTRIBUTE_CHANGE
		};

		System.out.println("=========================");

		String name = AttributeChangeNotification.class.getName();
		String description = "An attribute of this MBean has changed";
		MBeanNotificationInfo info =
				new MBeanNotificationInfo(types, name, description);
		return new MBeanNotificationInfo[]{info};
	}
}
