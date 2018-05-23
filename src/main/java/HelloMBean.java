/**
 * Author: 余家奎
 * Email: yjk@haochedai.com
 * Date: 2018-05-23
 * Time: 11:42
 * <p>
 * Description:
 */
public interface HelloMBean {
	public String getName();
	public void setName(String name);
	public void printHello();
	public void printHello(String whoName);
	public int getCacheSize();
	public void setCacheSize(int cacheSize);
}
