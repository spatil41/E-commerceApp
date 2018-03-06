package model;

public class Shopping 
{
	private String pc1;
	public String getPc1() {
		return pc1;
	}
	public void setPc1(String pc1) {
		this.pc1 = pc1;
	}
	public String getPc2() {
		return pc2;
	}
	public void setPc2(String pc2) {
		this.pc2 = pc2;
	}
	public String getPc3() {
		return pc3;
	}
	public void setPc3(String pc3) {
		this.pc3 = pc3;
	}
	private String pc2;
	private String pc3;
	
	public Shopping()
	{
		
	}
	public Shopping(String pc1, String pc2, String pc3)
	{
		this.pc1=pc1;
		this.pc2= pc2;
		this.pc3= pc3;
	}

}
