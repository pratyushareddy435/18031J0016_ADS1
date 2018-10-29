package pc3ads;

public class Student {
	String total;
	String s3;
	String s2;
	String s1;
	String dob;
	String name;
	Student()
	{
		
	}
	Student(String total,String s3,String s2,String s1,String dob,String name)
	{
		this.total=total;
		this.s3=s3;
		this.s2=s2;
		this.s1=s1;
		this.dob=dob;
		this.name=name;
	}
	@Override
	public String toString() {
		return "Student [total=" + total + ", s3=" + s3 + ", s2=" + s2 + ", s1=" + s1 + ", dob=" + dob + ", name="
				+ name + "]";
	}
}
