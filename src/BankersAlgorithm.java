import java.util.Arrays;
import java.util.Scanner;

public class BankersAlgorithm {
    private int[][] max;          // Maximum resource need of each process
    private int[][] allocation;   // Currently allocated resources for each process
    private int[] available;      // Available resources
    private int[] request;        // Resource request for a process

    public BankersAlgorithm(int[][] max, int[][] allocation, int[] available) {
        this.max = max;
        this.allocation = allocation;
        this.available = available;
        this.request = new int[available.length];
    }

    public boolean isSafe(int process) {
        // Check if the request is less than or equal to the available resources
        for (int i = 0; i < available.length; i++) {
            if (request[i] > available[i]) {
                return false;
            }
        }

        // Try to allocate the resources temporarily
        int[] tempAvailable = Arrays.copyOf(available, available.length);
        int[][] tempAllocation = new int[allocation.length][];
        for (int i = 0; i < allocation.length; i++) {
            tempAllocation[i] = Arrays.copyOf(allocation[i], allocation[i].length);
        }

        for (int i = 0; i < available.length; i++) {
            tempAvailable[i] -= request[i];
            tempAllocation[process][i] += request[i];
        }

        // Check if the system is still in a safe state after the allocation
        boolean[] finish = new boolean[max.length];
        Arrays.fill(finish, false);

        for (int i = 0; i < max.length; i++) {
            if (!finish[i]) {
                boolean canFinish = true;
                for (int j = 0; j < available.length; j++) {
                    if (max[i][j] - tempAllocation[i][j] > tempAvailable[j]) {
                        canFinish = false;
                        break;
                    }
                }
                if (canFinish) {
                    finish[i] = true;
                    for (int k = 0; k < available.length; k++) {
                        tempAvailable[k] += tempAllocation[i][k];
                    }
                    i = -1; // Start from the beginning to check again
                }
            }
        }

        // Check if all processes can finish
        for (boolean b : finish) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    public void requestResources(int process, int[] request) {
        this.request = request;
        if (isSafe(process)) {
            // Allocate the requested resources
            for (int i = 0; i < available.length; i++) {
                available[i] -= request[i];
                allocation[process][i] += request[i];
            }
            System.out.println("Request granted.");
        } else {
            System.out.println("Request denied. Granting this request would lead to an unsafe state.");
        }
    }

    public void releaseResources(int process, int[] release) {
        // Release the allocated resources
        for (int i = 0; i < available.length; i++) {
            available[i] += release[i];
            allocation[process][i] -= release[i];
        }
        System.out.println("Resources released.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int numProcesses = scanner.nextInt();

        System.out.print("Enter the number of resource types: ");
        int numResourceTypes = scanner.nextInt();

        int[][] max = new int[numProcesses][numResourceTypes];
        int[][] allocation = new int[numProcesses][numResourceTypes];
        int[] available = new int[numResourceTypes];

        System.out.println("Enter the maximum resource needs for each process:");
        for (int i = 0; i < numProcesses; i++) {
            for (int j = 0; j < numResourceTypes; j++) {
                max[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the current resource allocation for each process:");
        for (int i = 0; i < numProcesses; i++) {
            for (int j = 0; j < numResourceTypes; j++) {
                allocation[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the available resources:");
        for (int i = 0; i < numResourceTypes; i++) {
            available[i] = scanner.nextInt();
        }

        BankersAlgorithm banker = new BankersAlgorithm(max, allocation, available);

        // Example: Request resources for a process
        System.out.print("Enter the process number to request resources: ");
        int processToRequest = scanner.nextInt();
        int[] requestResources = new int[numResourceTypes];
        System.out.println("Enter the resource request for the process:");
        for (int i = 0; i < numResourceTypes; i++) {
            requestResources[i] = scanner.nextInt();
        }
        banker.requestResources(processToRequest, requestResources);

        // Example: Release resources for a process
        System.out.print("Enter the process number to release resources: ");
        int processToRelease = scanner.nextInt();
        int[] releaseResources = new int[numResourceTypes];
        System.out.println("Enter the resource release for the process:");
        for (int i = 0; i < numResourceTypes; i++) {
            releaseResources[i] = scanner.nextInt();
        }
        banker.releaseResources(processToRelease, releaseResources);

        scanner.close();
    }
}
