
public class Test2 {
	/*
	 * 4 4 4 4 4 4 4 4 3 3 3 3 3 4 4 3 2 2 2 3 4 4 3 2 1 2 3 4 4 3 2 2 2 3 4 4 3 3 3
	 * 3 3 4 4 4 4 4 4 4 4
	 * 
	 * n = 1 int matrix[] = new int[(n+(n-1))]
	 
	4 4 4 4 4 4 4
	4 3 3 3 3 3 4
	4 3 2 2 2 3 4
	4 3 2 1 2 3 4
	4 3 2 2 2 3 4
	4 3 3 3 3 3 4
	4 4 4 4 4 4 4
	
	*/
	public static void main(String[] args) {
        int n = 7;
        int res[][] = pattern(n);
        for(int i=0;i<res.length;i++)
        {
        	for(int j=0;j<res[0].length;j++)
        	{
        		System.out.print(res[i][j]+" ");
        	}
        	System.out.println();
        }
	}
	private static int [][] pattern(int n)
	{
		int len = n+(n-1);
		int [][] grid = new int[len][len];
		int r = len;
		int c = len;
		int i=0;
		int j=0;
		int val =n;
		while(i<r && j < c)
		{
			//fill first row;
			for(int k=j;k<c;k++)
			{
				grid[i][k] = val;
			}
			i++;
			//fill last coloumn
			for(int k=i;k<r;k++)
			{
				grid[k][c-1]=val;
			}
			c = c-1;
			for(int k=c-1;k>=j;k--)
			{
				grid[r-1][k] = val;
			}
			r = r-1;
			for(int k=r-1;k>=i;k--)
			{
				grid[k][j] = val;
			}
			j=j+1;
			val = val-1;
		}
		return grid;
	}
}
