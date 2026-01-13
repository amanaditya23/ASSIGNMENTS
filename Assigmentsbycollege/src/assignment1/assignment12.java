package assignment1;
import java.util.Scanner;

public class assignment12 {

    static Scanner sc = new Scanner(System.in);

    // Insert element
    static int insert(int arr[], int n) {
        System.out.print("Enter position: ");
        int pos = sc.nextInt();
        System.out.print("Enter element: ");
        int val = sc.nextInt();

        if (pos < 0 || pos > n) {
            System.out.println("Invalid position");
            return n;
        }

        for (int i = n; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = val;

        System.out.println("Element inserted successfully");
        display(arr, n + 1);
        return n + 1;
    }

    // Delete element
    static int delete(int arr[], int n) {
        System.out.print("Enter position to delete: ");
        int pos = sc.nextInt();

        if (pos < 0 || pos >= n) {
            System.out.println("Invalid position");
            return n;
        }

        System.out.println("Deleted element: " + arr[pos]);

        for (int i = pos; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }

        display(arr, n - 1);
        return n - 1;
    }

    // Linear search
    static void linearSearch(int arr[], int n) {
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at index " + i);
                return;
            }
        }
        System.out.println("Element not found");
    }

    // Binary search (array must be sorted)
    static void binarySearch(int arr[], int n) {
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                System.out.println("Element found at index " + mid);
                return;
            } else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        System.out.println("Element not found");
    }

    // Find maximum
    static void findMax(int arr[], int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("Maximum value: " + max);
    }

    // Count even and odd
    static void countEvenOdd(int arr[], int n) {
        int even = 0, odd = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0)
                even++;
            else
                odd++;
        }
        System.out.println("Even count: " + even);
        System.out.println("Odd count: " + odd);
    }

    // Insertion sort
    static void insertionSort(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.println("Array sorted using Insertion Sort");
        display(arr, n);
    }

    // Display array
    static void display(int arr[], int n) {
        System.out.print("Array: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int arr[] = new int[100];
        int n;

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        display(arr, n);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Linear Search");
            System.out.println("4. Binary Search");
            System.out.println("5. Find Maximum");
            System.out.println("6. Count Even/Odd");
            System.out.println("7. Insertion Sort");
            System.out.println("8. Display");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    n = insert(arr, n);
                    break;
                case 2:
                    n = delete(arr, n);
                    break;
                case 3:
                    linearSearch(arr, n);
                    break;
                case 4:
                    binarySearch(arr, n);
                    break;
                case 5:
                    findMax(arr, n);
                    break;
                case 6:
                    countEvenOdd(arr, n);
                    break;
                case 7:
                    insertionSort(arr, n);
                    break;
                case 8:
                    display(arr, n);
                    break;
                case 9:
                    System.out.println("Program terminated");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
