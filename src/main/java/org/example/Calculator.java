package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

public class Calculator {
    public static void main(String[] args)
    {
        double num1;
        double num2;
        char sym;
        double result;
        boolean bool = true;

        Scanner inp = new Scanner(System.in);
        Logger l = Logger.getLogger("kawin");
        l.info("Enter number: ");
        num1 =inp.nextDouble();
        Opertions obj;
        result=num1;
        l.info("Choose the symbol:\n Addition-> +\n Substraction-> -\n Multiplication->*\n Division->/\n Exit the calculator-> =");
        sym =inp.next().charAt(0);
        do
        {
            l.info("Enter number: ");
            num2 =inp.nextDouble();
            switch (sym)
            {
                case '+':
                    obj = new Add(result,num2);
                    obj.Oper();
                    result = obj.res;
                    break;

                case '-':
                    obj = new Sub(result,num2);
                    obj.Oper();
                    result = obj.res;
                    break;

                case '*':
                    obj = new Mul(result,num2);
                    obj.Oper();
                    result = obj.res;
                    break;

                case '/':
                    obj = new Div(result,num2);
                    obj.Oper();
                    result = obj.res;
                    break;


            }

            String res = String.valueOf(result);
            l.info(res);
            l.info("Choose the symbol:\n Addition-> +\n Substraction-> -\n Multiplication->*\n Division->/\n Exit the calculator-> =");
            sym =inp.next().charAt(0);
            if(sym=='=')
            {
                bool = false;
                String res1 = String.valueOf(result);
                l.info(res1);
            }

        }while(bool);
    }

}

abstract class Opertions
{
    double num1;
    double num2;
    double res;

    Opertions (double a,double b)
    {
        this.num1=a;
        this.num2=b;
    }
    public abstract void Oper();
}


class Add extends Opertions {
    Add(double a, double b) {
        super(a, b);
    }


    public void Oper() {
        super.res = super.num1 + super.num2;
    }
}

    class Sub extends Opertions
    {
        Sub(double a , double b)
        {
            super(a,b);
        }

        public void Oper() {
            super.res = super.num1 - super.num2;
        }
}

class Mul extends Opertions {
    Mul(double a, double b) {
        super(a, b);
    }


    public void Oper() {
        super.res = super.num1 * super.num2;
    }
}

class Div extends Opertions {
    Div(double a, double b) {
        super(a, b);
    }

    public void Oper() {
        super.res = super.num1 / super.num2;
    }
}