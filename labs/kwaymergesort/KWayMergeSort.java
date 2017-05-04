package kwaymergesort;

import timing.Ticker;

public class KWayMergeSort {
	
	/**
	 * 
	 * @param K some positive power of 2.
	 * @param input an array of unsorted integers.  Its size is either 1, or some other power of 2 that is at least K
	 * @param ticker call .tick() on this to account for the work you do
	 * @return
	 */
	public static Integer[] kwaymergesort(int K, Integer[] input, Ticker ticker) {
		
		int n = input.length;
		
		if (n <= 1)
		{
			return input;
		}
		
		int size = n/K;
		Integer[][] set = new Integer[K][];
		
		ticker.tick(K);
	
		// perform a K-way merge sort, placing the result in ans
		
		for (int i = 0; i < K; i++)
		{
			Integer[] newArr = new Integer[size];
			ticker.tick(size);
			System.arraycopy( input, i*(size), newArr, 0, size);
			ticker.tick(size);
			set[i] = kwaymergesort(K, newArr, ticker);
		}
		
		Integer[] ans = merge(set, ticker);
		return ans;
		
	}
		
	private static Integer[] merge(Integer[][] set, Ticker ticker)
	{
		int k = set.length;
		int size = set[0].length;
		
		if (k == 1)
		{
			return set[0];
		}
		
		Integer[][] merged = new Integer[(k/2)][size*2];
		ticker.tick((k/2)*(size*2));
		
		for (int i = 0; i < k; i=i+2)
		{
			merged[i/2] = doMerge(set[i], set[i+1], ticker);
		}
		
		return merge(merged, ticker);	
	}
	
	private static Integer[] doMerge(Integer[] merge1, Integer[] merge2, Ticker ticker)
	{
		int i = 0;
		int j = 0;
		int k = 0;
		 
		Integer[] merged = new Integer[merge1.length+merge2.length];
		ticker.tick(merged.length);
		
		while (i < merge1.length && j < merge2.length)
		{
			if (merge1[i] < merge2[j])
			{
				merged[k] = merge1[i];
				i++;
			}
			else
			{
				merged[k] = merge2[j];
				j++;
			}
			
			k++;
			ticker.tick();
		}     
		    
		if (i < merge1.length)
		{
			while(i < merge1.length)
			{
				merged[k] = merge1[i];
				k++;
				i++;
				ticker.tick();
			}
		}
		
		if (j < merge2.length)
		{
			while(j < merge2.length)
			{
				merged[k] = merge2[j];
				k++;
				j++;
				ticker.tick();
			}
		}
		
		return merged;
	}
}
