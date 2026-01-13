package assignment1;


	import java.util.Scanner;

	public class assignment13 {

	    static Scanner sc = new Scanner(System.in);

	    // Input matrix
	    static void inputMatrix(int a[][], int r, int c) {
	        for (int i = 0; i < r; i++)
	            for (int j = 0; j < c; j++)
	                a[i][j] = sc.nextInt();
	    }

	    // Display matrix
	    static void displayMatrix(int a[][], int r, int c) {
	        for (int i = 0; i < r; i++) {
	            for (int j = 0; j < c; j++)
	                System.out.print(a[i][j] + " ");
	            System.out.println();
	        }
	    }

	    // Addition
	    static void addition(int a[][], int b[][], int r, int c) {
	        int sum[][] = new int[r][c];
	        for (int i = 0; i < r; i++)
	            for (int j = 0; j < c; j++)
	                sum[i][j] = a[i][j] + b[i][j];

	        System.out.println("Addition Result:");
	        displayMatrix(sum, r, c);
	    }

	    // Subtraction
	    static void subtraction(int a[][], int b[][], int r, int c) {
	        int sub[][] = new int[r][c];
	        for (int i = 0; i < r; i++)
	            for (int j = 0; j < c; j++)
	                sub[i][j] = a[i][j] - b[i][j];

	        System.out.println("Subtraction Result:");
	        displayMatrix(sub, r, c);
	    }

	    // Multiplication
	    static void multiplication(int a[][], int b[][], int r1, int c1, int c2) {
	        int mul[][] = new int[r1][c2];

	        for (int i = 0; i < r1; i++)
	            for (int j = 0; j < c2; j++)
	                for (int k = 0; k < c1; k++)
	                    mul[i][j] += a[i][k] * b[k][j];

	        System.out.println("Multiplication Result:");
	        displayMatrix(mul, r1, c2);
	    }

	    // Transpose
	    static void transpose(int a[][], int r, int c) {
	        int t[][] = new int[c][r];
	        for (int i = 0; i < r; i++)
	            for (int j = 0; j < c; j++)
	                t[j][i] = a[i][j];

	        System.out.println("Transpose Matrix:");
	        displayMatrix(t, c, r);
	    }

	    // Check square matrix
	    static void checkSquare(int r, int c) {
	        if (r == c)
	            System.out.println("Matrix is a Square Matrix");
	        else
	            System.out.println("Matrix is NOT a Square Matrix");
	    }

	    // Check diagonal matrix
	    static void checkDiagonal(int a[][], int r, int c) {
	        if (r != c) {
	            System.out.println("Matrix is NOT a Diagonal Matrix");
	            return;
	        }

	        for (int i = 0; i < r; i++)
	            for (int j = 0; j < c; j++)
	                if (i != j && a[i][j] != 0) {
	                    System.out.println("Matrix is NOT a Diagonal Matrix");
	                    return;
	                }

	        System.out.println("Matrix is a Diagonal Matrix");
	    }

	    // Check identity matrix
	    static void checkIdentity(int a[][], int r, int c) {
	        if (r != c) {
	            System.out.println("Matrix is NOT an Identity Matrix");
	            return;
	        }

	        for (int i = 0; i < r; i++)
	            for (int j = 0; j < c; j++) {
	                if ((i == j && a[i][j] != 1) || (i != j && a[i][j] != 0)) {
	                    System.out.println("Matrix is NOT an Identity Matrix");
	                    return;
	                }
	            }

	        System.out.println("Matrix is an Identity Matrix");
	    }

	    public static void main(String[] args) {

	        System.out.print("Enter number of rows and columns: ");
	        int r = sc.nextInt();
	        int c = sc.nextInt();

	        int a[][] = new int[r][c];
	        int b[][] = new int[r][c];

	        System.out.println("Enter elements of Matrix A:");
	        inputMatrix(a, r, c);

	        System.out.println("Enter elements of Matrix B:");
	        inputMatrix(b, r, c);

	        System.out.println("\nMatrix A:");
	        displayMatrix(a, r, c);

	        System.out.println("\nMatrix B:");
	        displayMatrix(b, r, c);

	        addition(a, b, r, c);
	        subtraction(a, b, r, c);

	        if (r == c)
	            multiplication(a, b, r, c, c);

	        transpose(a, r, c);
	        checkSquare(r, c);
	        checkDiagonal(a, r, c);
	        checkIdentity(a, r, c);
	    }
	}


