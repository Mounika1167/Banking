import java.io.DataOutputStream;
import java.io.DataInputStream;
//import java.io.DataOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Algorithm {

public static void main(String[] args) throws Exception{
// TODO Auto-generated method stub
Scanner s=new Scanner(System.in);
System.out.println("enyte d");
double q=s.nextDouble();
double pr=find(q);
System.out.println("enyte x");
double xa=s.nextDouble();

double ya=pow(pr,xa,q);
//System.out.println(ya);
Socket ss=new Socket("localhost",6666);
DataOutputStream dos=new DataOutputStream(ss.getOutputStream());
DataInputStream dis=new DataInputStream(ss.getInputStream());
dos.writeUTF(String.valueOf(q));
dos.writeUTF(String.valueOf(pr));
double yb=Double.parseDouble(dis.readUTF());
System.out.println(yb);
dos.writeUTF(String.valueOf(ya));
double ct=pow(yb,xa,q);
System.out.println(ct);
s.close();
}
static double find(double a)
{

for(double i=2;i<a;i++)
{
Map<Double,Double> m=new HashMap<>();
for(double j=0;j<a;j++)
{
m.put((j*i)%a,(double)1);
}
int c=0;
for(double k=0;k<a;k++)
{
if(m.containsKey(k))
c++;
}
System.out.println(c);
if(c==(int)a)
    return i;
}
return 1;
}
static double pow(double m,double n,double k)
{
	double r=1;
	for(double i=0;i<n;i++)
	{
		r*=m;
		r%=k;
	}
	return r%k;
}
}


