package cw8;

public class Main {

    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        try {
            System.out.println(stack.pop() + " " + stack.pop() + " " + stack.pop());
            stack.pop(); //ma rzucic wyjatek
        }
        catch( StackException e)
        {
            System.out.println(e.getReason());
        }

        stack.push(4);
        try {
            System.out.println(stack.pop());
            stack.pop(); //ma rzucic wyjatek
        }
        catch( StackException e)
        {
            System.out.println(e.getReason());
        }

        //***************************************************************

        System.out.println("---------------------------");

        Stack<Character> stack2 = new Stack<Character>();
        stack2.push('A');
        stack2.push( 'B');
        stack2.push('C');

        try {
            System.out.println(stack2.pop() + " " + stack2.pop() + " " + stack2.pop());
            stack2.pop(); //ma rzucic wyjatek
        }
        catch( StackException e)
        {
            System.out.println(e.getReason());
        }

        stack2.push('D');
        try {
            System.out.println(stack2.pop());
            stack2.pop(); //ma rzucic wyjatek
        }
        catch( StackException e)
        {
            System.out.println(e.getReason());
        }
    }
}
