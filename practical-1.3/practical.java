import java.util.Scanner;

enum game
{
     ROCK,
     PAPER,
     SCISSORS, 
     LIZARD,
     SPOCK
}

record result(game ymove ,game cmove){};

class practical
{
    public static void main(String[] args)
    {
        int j,k=0,c=0,m=0;
        Scanner sc= new Scanner(System.in);

        System.out.print("enter your move:");
        String ymove=sc.next().toUpperCase();

        System.out.print("enter computer move:");
        String cmove=sc.next().toUpperCase();

        game ymove1= game.valueOf(ymove);
        game cmove1= game.valueOf(cmove);

        result r= new result(ymove1,cmove1);

        while(k!=5)
        {
                k++;

        j=switch(r.ymove())
        {
             case ROCK ->
               (r.cmove()== game.SCISSORS || r.cmove() == game.LIZARD) ? 1 : -1;

            case PAPER ->
              (r.cmove() == game.ROCK || r.cmove() == game.SPOCK) ? 1 : -1;

            case SCISSORS ->
               (r.cmove() == game.PAPER || r.cmove() == game.LIZARD) ? 1 : -1;

            case LIZARD ->
             (r.cmove() == game.PAPER || r.cmove() == game.SPOCK) ? 1 : -1;

            case SPOCK ->
               (r.cmove() == game.ROCK || r.cmove() == game.SCISSORS) ? 1 : -1;
        };
        

        if(j==-1)
        {
            c++;
         System.out.println("me move:" + c);
        System.out.println("computer move:" + m);
        System.out.println("me win");
        
        }
        if(j==1)
        {
            m++;
        System.out.println("me move:" + c);
        System.out.println("computer move:" + m);
        System.out.println("computer win");

        }

        if(m==c)
        {
            System.out.print("tie");
        }

        System.out.print("enter your move:");
        ymove=sc.next().toUpperCase();

        System.out.print("enter computer move:");
        cmove=sc.next().toUpperCase();

         ymove1= game.valueOf(ymove);
         cmove1= game.valueOf(cmove);

        r= new result(ymove1,cmove1);

        
        }

        if(c>m)
        {
            System.out.print("you win "+c+" - "+m);
        }
        if(m>c)
        {
            System.out.print("computer win "+m+" - "+c);

        }
      
     

    }
}