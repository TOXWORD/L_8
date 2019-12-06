import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the collection size: ");
            int size = sc.nextInt();

            System.out.println("Enter the sorting order(1-4): ");
            int order = sc.nextInt();
            if (!(order >= 1 && order <= 4)) {
                throw new Exception();
            }

            Integer[] coll = new Integer[size];
            Random r = new Random();

            System.out.print("Collection: ");
            for (int i = 0; i < size; i++) {
                coll[i] = r.nextInt(100);
                System.out.print(coll[i] + " ");
            }

            Runnable runnable = ()->{

                switch(order){
                    case 1:
                        Arrays.sort(coll, (integer, t1) -> integer - t1);
                        break;
                    case 2:
                        Arrays.sort(coll, (integer, t1) -> t1 - integer);
                        break;
                    case 3:
                        Arrays.sort(coll, (integer, t1) -> integer.toString().length() - t1.toString().length());
                        break;
                    case 4:
                        Arrays.sort(coll, (integer, t1) -> t1.toString().length() - integer.toString().length());
                        break;
                }

            };

            Thread sorter = new Thread(runnable);
            sorter.run();

            System.out.println();
            for(int i : coll)
                System.out.print(i + " ");

        }
        catch (Exception e) {
            System.out.print("Incorrect input!");
        }
    }
}
