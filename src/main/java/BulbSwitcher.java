/**
 * Bulb Switcher
 * LeetCode 319
 *
 * @author RakhmedovRS
 * @created 29-Feb-20
 */
public class BulbSwitcher
{
	public int bulbSwitch(int n)
	{
		return (int) Math.sqrt(n);
	}

	public static void main(String[] args)
	{
		System.out.println(new BulbSwitcher().bulbSwitch(4));
	}
}
