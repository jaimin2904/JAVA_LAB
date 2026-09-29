import java.util.Scanner;

class OutOfStockException  extends Exception 
{
  int shortfall;

    OutOfStockException(int shortfall)
    {
        this.shortfall = shortfall;
    }
}
class InvalidQuantityException extends Exception
{
     InvalidQuantityException(String msg)
    {
        super(msg);
    }

}

class Warehouse 
{
    int stock = 10;

    void issue(String item , int qty)
    throws OutOfStockException ,InvalidQuantityException
    {
        if(qty<=0)
        {
            throw new InvalidQuantityException("Invalid quantity!");
        }

        if(qty > stock)
        {
            throw new OutOfStockException(qty - stock);
        }

        stock -= qty;
        System.out.println(item + " issued: " + qty);

    }

}
 class StockIssue 
{
    public static void main(String[] args)
    {
        Warehouse w = new Warehouse();


        int[][] requests = {
            {1, 5},
            {2, 8},
            {3, -2},
            {4, 3}
        };

        for(int[] r: requests)
        {
            try
            { 
                    w.issue("Item " + r[0],r[1]);

            }
            catch (OutOfStockException e)
            {
                     System.out.println("Out of stock. Shortfall: "+ e.shortfall);
            }
            catch(InvalidQuantityException e)
            {
                 System.out.println(e.getMessage());
            }
        }

    }

}