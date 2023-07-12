public class Table {
    public static void main(String[] args) {
        Fork fork1 =new Fork(1);
        Fork fork2 =new Fork(2);
        Fork fork3 =new Fork(3);
        Fork fork4 =new Fork(4);
        Fork fork5 =new Fork(5);
        Philosophy philosophy1 = new Philosophy(1,fork1,fork2);
        Philosophy philosophy2 = new Philosophy(2,fork2,fork3);
        Philosophy philosophy3 = new Philosophy(3,fork3,fork4);
        Philosophy philosophy4 = new Philosophy(4,fork4,fork5);
        Philosophy philosophy5 = new Philosophy(5,fork5,fork1);
        Philosophy.eating=true;

    }
}

