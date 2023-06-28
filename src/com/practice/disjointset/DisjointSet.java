package com.practice.disjointset;

public class DisjointSet {
   public static int  v;
   int rank[] = new int[v+1];
   int parent[] = new int[v+1];
   int size[]  = new int[v+1];
   //Initial Configuration
   public DisjointSet()
   {
	   
	   for(int i = 0; i <=this.v ; i++)
	   {
		   this.parent[i] = i;
		   this.rank[i]=0;
		   this.size[i] = 1;
	   }  
   }
   int findUParent(int v)
   {
	    if(this.parent[v] == v)
	    	return v;
	    return this.parent[v] = findUParent(this.parent[v]);
   }
   
   void unionByRank(int u,int v)
   {
	   int up_u = findUParent(u);
	   int up_v = findUParent(v);
	   if(up_u == up_v)
		   return;
	   if(this.rank[up_u] < this.rank[up_v])
	   {
		   this.parent[up_u] = up_v;
	   }
	   else if(this.rank[up_u] > this.rank[up_v])
	   {
		   this.parent[up_v] = up_u;
	   }
	   else
	   {
		   this.parent[up_v] = up_u;
		   this.rank[up_u]++;
	   }
   }
   
   void unionBySize(int u,int v)
   {
	   int up_u = findUParent(u);
	   int up_v = findUParent(v);
	   if(up_u == up_v)
		    return ;
	   if(size[up_u] < size[up_v])
	   {
		   parent[up_u] = up_v;
		   size[up_v] += size[up_u];
	   }
	   else
	   {
		   parent[up_v] = up_u;
		   size[up_u] += size[up_v];
	   }
   }
}
