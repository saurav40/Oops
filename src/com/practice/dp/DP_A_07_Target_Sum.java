package com.practice.dp;

public class DP_A_07_Target_Sum {
	public static void main(String[] args) {
//        int arr[] = {1,1,2,3};
//        int target = 1;
        int arr[] = {0,0,1,0,1};
        int target = 2;
        /*
         *  {1,1,2}{3}=>+1+1+2-3 = 1 =target,count = 1
         *    s1(+ve) {1,1,2) - s2(-ve){3} = target
         *  {1,3},{1,2}=>+1-1-2+3 =1 = target,count = 2
         *   s1(+ve){1,3}- s2(-ve){1,2} = target
         *  {1,3},{1,2}=>-1+1-2+3 = 1 = target,count = 3
         *  ans = 3
         *  so on...
         *  basically we have to find two subset where thier differenc is equql target
         *    s1-s2 = target  ---eq.(1)
         *  and sum of these two sets is equal to sum of all elements of array
         *    s1+s2 = sum(arr) ---eq.(2)
         *    
         *    from eq.1 & 2
         *      2s1 = target + sum(arr)
         *       s1 = (target + sum(arr))/2;
         *     
         *  so if we find count of subset for the target = (target + sum(arr))/2 ;
         *  then this will be the answer
         *  for example  target =(1+7)/2 => 4
         *      we will get subset for the target = 4
         *        {1,1,2}
         *        {1,3}
         *        {1,3}
         *       and if we consider all lefr element as s2 then difference will the target:
         *         {1,1,2} -{3}
         *         {1,3} -{1,2}
         *         {1,3}-{1,2}
         *    hence we just need to find total count of subsets for s1 or target;
         *    & this problem is reduced to subset sum problem.
         * 
         */
        int sum = 0;
        for(int i=0;i<arr.length;i++)
        {
        	sum+=arr[i];
        }
        //edge case when sum == target ans = 2^cntOfZero;
        if(sum == target )
        {
            int cnt = 0;
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i] == 0)
                {
                    cnt ++;
                }
            }
            System.out.println((int)Math.pow(2,cnt));
            return;
        }
           
        int targetSum =0;
        if((target+sum)%2 ==0 ) {
           targetSum = (target+sum)/2;
           System.out.println(countSubset(arr,arr.length,targetSum));
        }
        else
        	System.out.println(0);
        
	}
	private static int countSubset(int arr[],int n,int sum)
	{
		int t[][] = new int[n+1][sum+1];
		for(int i=0;i<=n;i++)
			t[i][0] = 1;
		
		for(int i=1;i<=n;i++)
			for(int j=1;j<=sum;j++)
			{
				if(arr[i-1] <= j)
				{
					t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
				}
				else
					t[i][j] = t[i-1][j];
			}
		return t[n][sum];
	}
}
