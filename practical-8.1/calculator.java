import java.util.Scanner;

class DivideByZeroException extends Exception {
    DivideByZeroException(String msg) {
        super(msg);
    }
}

public class calculator
{
    public static void main(String[] args)   
    {
         Scanner sc=new Scanner(System.in);

        System.out.println("enter A:");
         int a= sc.nextInt();

        System.out.println("enter B:");
         int b=sc.nextInt();

        System.out.println("enter Operator:");
        char c = sc.next().charAt
(0);
         int r=0;

         try
         {
            switch(c)
            {
                case '+' :
                    {
                        r=a+b;
                        break;
                    }

            case '-' :
                    {
                        r=a-b;
                        break;
                    }    

            case '*' :
                    {
                        r=a*b;
                        break;
                    }    
                    
            case '/' :
                    {
                         if(b==0)
                        {
                            throw new DivideByZeroException("Cannot divide by zero!");
                        }

                        r=a/b;
                                     
                        System.out.println("done");

                        break;
                    }

            }
           
         }
        catch (DivideByZeroException e)
        {
                System.out.println(e.getMessage());
        }
        finally 
        {
             System.out.println("Attempt logged.");
        }

    }
}