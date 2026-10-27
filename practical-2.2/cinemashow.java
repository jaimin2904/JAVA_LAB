import java.util.Scanner;

class cinemashow
{
    private String title;
    private int seatavailable=100;
    private int capacity;
    private static int totalbooked=0;


    cinemashow(String t,int number)
    {
        title = t;
        capacity = number;

    }

    cinemashow(String t)
    {
        this(t,100);
    }

    void book(int n)
    {   
        if(n<=seatavailable)
        {
        seatavailable = capacity - n;
        totalbooked = totalbooked + n;
        }
        else{
            System.out.println("invalid seat");
        }
    }

    void cancel(int x)
    {
        if(x<=totalbooked)
        {
         seatavailable = capacity + x;
        totalbooked = totalbooked - x;
        }
        else{
            System.out.println("not possiable....");
        }

    }

    int result()
    {
        if(totalbooked <0)
        {
            System.out.print("Error....");
            return 0 ;
        }
        else
        {
          System.out.println("totalbook seat : " + totalbooked);
         return 0 ;
        }

    }


    public static void main(String[] args)
    {
        cinemashow c = new cinemashow("abc");

        Scanner sc = new Scanner(System.in);

       
         for(int i=0;i<5;i++)
        {
            System.out.print("enter number of seat for booking :");
             int binput = sc.nextInt();
             c.book(binput);
        }

         for(int i=0;i<5;i++)
        {
            System.out.print("enter number of seat for cancel :");
             int cinput = sc.nextInt();
             c.cancel(cinput);
        }

        // c.book(50);
        // c.cancel(10);

         c.result();

    }

}