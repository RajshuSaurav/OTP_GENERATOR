import java.util.Scanner;
public class otp
{
    public static void main(String[] args)
    {
        String name="",otp="",rev="",p="";
        int i,l,pl=0,j,ps=0;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your full name : ");
        name=(sc.nextLine()).trim();
        l=name.length();
        System.out.print("Enter your phone number : ");
        p=sc.nextLine();
        for(i=0;i<10;i++)
        {
            if(p.charAt(i)!='0')
                pl++;
        }        int ph[]=new int[pl];
        int a=0;
        for (i=0;i<10;i++)
        {
            char ch=p.charAt(i);
            if(ch!='0')
            {
                ph[a]=Integer.parseInt(String.valueOf(ch));
                a++;
            }
        }
        for(i=0;i<pl-1;i++)
        {
            for (j=0;j<pl-i-1;j++)
            {
                if (ph[j]>ph[j+1])
                {
                    int temp=ph[j];
                    ph[j]=ph[j+1];
                    ph[j+1]=temp;
                }
            }
        }
        ps=(pl==10)?ph[0]*100+ph[1]*10+ph[2]:(pl==9)?ph[0]*100+ph[1]:ph[0]*100;
        otp=(otp+name.charAt(0)+name.charAt(1)+name.charAt(2)+name.charAt(3)).toUpperCase();
        for(i=l-1;i>=0;i--)
        {
            if(name.charAt(i)!=' ')
                rev=rev+name.charAt(i);
            else
            {
                rev=rev.toLowerCase();
                break;
            }
        }
        otp=otp+String.valueOf(ps);
        otp=otp+rev.charAt(rev.length()-1);
        System.out.println(otp);
    }
}