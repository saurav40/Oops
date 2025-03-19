package com.practice.nykaa;

public class Test2 {
	private static void recur(int idx, String s, int cnt[]) {
		//base
		if(idx == s.length()) {
			cnt[0]++;
			return;
		}
		
		for(int i=idx;i<s.length();i++) {
			int num = Integer.parseInt(s.substring(idx,i+1));
			
			if(num >= 1 && num <= 26) {
				recur(i+1,s,cnt);
			}
		}
	}
	public static void main(String[] args) {
       String s = "11106";//"226";
       int cnt[] = {0};
       recur(0, s, cnt);
       System.out.println(cnt[0]);
	}
}
