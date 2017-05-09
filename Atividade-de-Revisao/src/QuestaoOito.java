
public class QuestaoOito {
	public int func(int n, int m) {
		int ans = 0;
		for (int i = 1; i <= n; i++)
			ans += java.lang.Math.pow(i, 2);
		
		for (int i = 1; i <= m / 2; i++)
			ans += i;
		
		return ans;
	}
}
