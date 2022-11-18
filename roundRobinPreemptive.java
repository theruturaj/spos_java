import java.util.Scanner;

public class roundRobinPreemptive {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n, tq, timer = 0, maxProcessIndex = 0;
        float avgWaitingTime, avgTurnAroundTime = 0;
        System.out.println("Enter the time quntaum");
        tq = input.nextInt();
        System.out.println("Enter the no of processes : "); 
        n = input.nextInt();
        int at[] = new int[n];
        int bt[] = new int[n];
        int wt[] = new int[n];
        int tat[] = new int[n];
        int queue[] = new int[n];
        int temp_burst[] = new int[n];
        boolean  complete[] = new boolean[n];

        System.out.println("Enter the arival time of the processes : ");
        for (int i=0;i<n;i++) 
            at[i] = input.nextInt();

        System.out.println("Enter the bust time of the processes : ");
        for (int i=0;i<n;i++) {
            bt[i] = input.nextInt();
            temp_burst[i] = bt[i];
        }
        for(int i=0;i<n;i++) {
            complete[i] = false;
            queue[i] = 0;
        }
        while(timer <at[0])
            timer++;
        queue[0] = 1;

        while(true) {
            boolean flag = true;
            for (int i=0;i<n;i++) {
                if(temp_burst[i] != 0) {
                    
                }
            }
        }
    }
}
