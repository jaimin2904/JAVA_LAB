import java.util.Scanner;

class Thermostat
{
    private String location;
    private int tem;

    private static final int min=16,max=30;
    private static int count=0;

    Thermostat(String lo, int te)
    {
        location=lo;

        if(te>=16 && te<=30)
        {
            tem=te;
        }
        else
        {
            tem=22;
        }
        
        count++;   
    }

    Thermostat(String lo)
    {
        this(lo,22);
    }

    void raise()
    {
        if(max>tem)
        {
            tem++;
        }
        else
        {
            System.out.println("Already at maximum (30)");
            return;
        }
    }

    void lower()
    {
        if(tem>min)
        {
            tem--;
        }
        else
        {
            System.out.println("Already at minimum (16)");
            return;
        }
    }

    int getTemperature()
    {
        return tem;
    }

    static int getactiveCount()
    {
        return count;
    }

    public static void main(String[] args)
    {
      //  Scanner sc=new Scanner(System.in);


        Thermostat t1=new Thermostat("Room");

        for(int i=0;i<10;i++)
        {
            t1.raise();
            System.out.println(t1.getTemperature());

            if(t1.getTemperature()==30)
            {
            System.out.println("Already at maximum (30)");
                break;
            }
        }

        for(int i=0;i<20;i++)
        {
            t1.lower();
            System.out.println(t1.getTemperature());
            
            if(t1.getTemperature()==16)
            {
            System.out.println("Already at minimum (16)");
                break;
            }


        }

        System.out.println("count : " + Thermostat.getactiveCount());
    }
}


