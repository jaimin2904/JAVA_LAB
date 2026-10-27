abstract class Employee
{
    abstract double monthlysalary();
}

class FullTime extends Employee
{
    double monthlysalary()
    {
        return 50000;
    }
}

class PartTime extends Employee
{
    int h, r;

    PartTime(int h, int r)
    {
        this.h = h;
        this.r = r;
    }

    double monthlysalary()
    {
        return h * r;
    }
}

class Intern extends Employee
{
    int s;

    Intern(int s)
    {
        this.s = s;
    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
    double monthlysalary()
    {
        return s;
    }
}

class Main
{
    public static void main(String[] args)
    {
        Employee[] employee =
        {
            new FullTime(),
            new PartTime(2, 5),
            new Intern(10000)
        };
        
        double total = 0;
        double max = 0;

        for(Employee e : employee)
        {
            double a = e.monthlysalary();

            System.out.println("Salary: " + a);

            total += a;

            if(a > max)
            {
                max = a;
            }
        }

        System.out.println("Total = " + total);
        System.out.println("Max = " + max);

        System.out.println("25CE047 - JAIMIN KHAMBHALIYA");

    }
}