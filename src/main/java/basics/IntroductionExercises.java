package basics;

public class IntroductionExercises {

    public static int variable = 0;

    public static int[] squares;

    /*
     * Function that bound variable to value
     */
    public static void attribute(int value){
        variable = value;
    }

    /*
     * Function that return the addition of the two parameters
     */
    public static int add(int a, int b){
         return a+b;
    }

    /*
     * return true is a and b are equal
     */
    public static boolean equalsIntegers(int a, int b){
         return a==b;
    }

    /*
     * Function that return the max between a and b in one line
     * You must use a ternary operation
     */
    public static int max(int a, int b){
         return a > b ? a : b;
    }

    /*
     * Function that return the middle value.
     * If a > b > c, the function must return b.
     * If two value are equals, return -1.
     */
    public static int middleValue(int a, int b, int c){

        if ((a > b && b > c) || (c > b && b > a)) return b;
        else if ((b > c && c > a) || (a > c && c > b)) return c;
        else if ((c > a && a > b) || (b > a && a > c)) return a;
        else return -1;
    }
    /*
     * This function must return :
     * "Good morning, sir!" if str is "Morning"
     * "Good evening, sir!" if str is "Evening"
     * "Hello, sir!" otherwise
     * Use a switch case statement
     * Your implementation must be case-sensitive
     * And you should not use if/else!
     */
    public static String greetings(String str){

        switch (str) {
            case "Morning":
                return "Good morning, sir!";
            case "Evening":
                return "Good evening, sir!";
            default:
                return "Hello, sir!";
        }
    }

    /*
     * This function must return a new array of length 3
     * The first element of this new array is the last element of a
     * The second element is the first element of a
     * The last element is the middle element of a
     */
    public static int[] lastFirstMiddle(int[] a){

        int n = a.length;
        return new int[] {a[n-1], a[0], a[n/2]};
    }

    /*
     * This function must return the sum of the elements of array using a for loop
     */
    public static int sum(int[] array){
         int sum = 0;

         for (int x : array) {
             sum += x;
         }

         return sum;
    }

    /*
     * return the maximum element of array using a while loop
     */
    public static int maxArray(int[] array){
         int max = array[0];
         int i = 1;
         while (i < array.length) {
             if (array[i] > max) max = array[i];
             i++;
         }
         return max;
    }


    /**
     * Assign to the variable square, the square of the
     * parameters.
     *
     * Let assume that the program is invoked with the following
     * line:
     *  java IntroductionExercises 0 3 4 5
     *
     * The arguments of the program are 0, 3, 4 and 5.
     * After the execution of the main, the variable squares
     * should be:
     *  squares = [0, 9, 16, 25]
     *
     * If an exception occurs when converting an argument to
     * an integer, put 0 at the corresponding index. For example
     *
     *  java IntroductionExercise 0 3.1 4 5
     *
     * would yield
     *
     *  squares = [0, 0, 16, 25]
     *
     * because 3.1 can not be converted to an integer
     * */
    public static void main(String... args){
        squares = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            try {
                int val = Integer.parseInt(args[i]);
                squares[i] = val * val;
            } catch (Exception e) {
                squares[i] = 0;
            }
        }
    }
}