package rabinkarp;

public class RK {
	
		char[] circBuffer;
		int startIndex = -1;
		int endIndex = -1;
		int entryNum = -1;
		
		int m = 0;
		int hashValue = 0;
		int hashM = 31;
		
	/**
	 * Rabin-Karp string matching for a window of the specified size
	 * @param m size of the window
	 */
	public RK(int m) {
		
		circBuffer = new char[m];
		this.m = m;
		for (int i = 1; i < m; i++)
		{
			hashM = hashM*31;
			hashM = hashM%511;
		}
		
		if (hashM < 0)
		{
			hashM = hashM + 511;
		}
	}
	
	/**
	 * Compute the rolling hash for the previous m-1 characters with d appended.
	 * @param d the next character in the target string
	 * @return
	 */
	public int nextCh(char d) {
		
		entryNum++;
		
		startIndex = (entryNum/m)%m;
		endIndex = (endIndex+1)%m;
		
		char leave = circBuffer[endIndex];
		circBuffer[endIndex] = d;
		
		int a = (hashValue%511 * (31%511))%511;
		int b = ((hashM%511)*(leave%511))%511;
		int c = (b - (d%511))%511;
		hashValue = (a-c)%511;
		
		if (hashValue < 0)
		{
			hashValue = hashValue + 511;
		}
		
		return hashValue;
	}
}
