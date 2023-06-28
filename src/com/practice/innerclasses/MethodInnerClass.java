package com.practice.innerclasses;

public class MethodInnerClass {
	private int count = 100;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
    
	void InnerFunction(int count)
	{
		class InsideInnerFunction {
			int x;
			int y;
			public int getX() {
				return x;
			}
			public void setX(int x) {
				this.x = x;
			}
			public int getY() {
				return y;
			}
			public void setY(int y) {
				this.y = y;
			}
			void setOuter(int count)
			{
				setCount(count);
			}
			void getOuter()
			{
				System.out.println(getCount());
			}
		}
		InsideInnerFunction obj = new InsideInnerFunction();
		obj.setX(count);
		obj.setY(count);
		System.out.println("Area of Squre :"+obj.x*obj.y);
		obj.setOuter(obj.x*obj.y);
		obj.getOuter();
	}
}
