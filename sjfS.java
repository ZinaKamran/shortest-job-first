
import java.util.Scanner;
public class sjfS {
public static void main (String args[]) 
{
		 Scanner sc = new Scanner(System.in);
	     System.out.print("Enter number of processes:");
	     int num = sc.nextInt();
	     int process[]= new int[num];   
	     int arrivalTime[] = new int[num];  
	     int burstTime[] = new int[num];     
	     int FinishTime[] = new int[num];    
	     int turnAroundTime[] = new int[num];     
	     int waitingTime[] = new int[num];     

	     double avgWaitingTime=0,avgTurnATime=0;

	     for(int i = 0; i < num; i++)
	     {
	         System.out.print("p" + (i+1) +"\nArrival time:");
	         arrivalTime[i] = sc.nextInt();
	         System.out.print("Burst Time:");
	         burstTime[i] = sc.nextInt();
	         process[i] = i+1;
	     }
	     
	     //sorting of burst times
	     for(int i=0;i<num;i++)
	     {
	         int pos=i;
	         for(int j=i+1;j<num;j++)
	         {
	             if(burstTime[j]<burstTime[pos])
	                 pos=j;
	         }

	         int tempo=burstTime[i];
	         burstTime[i]=burstTime[pos];
	         burstTime[pos]=tempo;

	         tempo=process[i];
	         process[i]=process[pos];
	         process[pos]=tempo;
	      }
	     

	    int temp;
	     for(int i = 0 ; i <num; i++)
	     {
	         for(int  j=0;  j < num-(i+1) ; j++)
	         {
	             if( arrivalTime[j] > arrivalTime[j+1] )
	             {
	                 temp = arrivalTime[j];
	                 arrivalTime[j] = arrivalTime[j+1];
	                 arrivalTime[j+1] = temp;
	                 temp = burstTime[j];
	                 burstTime[j] = burstTime[j+1];
	                 burstTime[j+1] = temp;
	                 temp = process[j];
	                 process[j] = process[j+1];
	                 process[j+1] = temp;
	             }
	         }
	     }
	    
	  
	//finding finished times
	     for(int  i = 0 ; i < num; i++)
	     {
	         if( i == 0)
	         {
	        	 FinishTime[i] = arrivalTime[i] + burstTime[i];
	         }
	         else
	         {
	             if( arrivalTime[i] > FinishTime[i-1])
	             {
	            	 FinishTime[i] = arrivalTime[i] + burstTime[i];
	             }
	             else
	            	 FinishTime[i] = FinishTime[i-1] + burstTime[i];
	         }
	         turnAroundTime[i] = FinishTime[i] - arrivalTime[i] ;
	         waitingTime[i] = turnAroundTime[i] - burstTime[i] ;
	         avgWaitingTime = avgWaitingTime+waitingTime[i] ;              
	         avgTurnATime= avgTurnATime+turnAroundTime[i] ;               
	     }
	     
	     System.err.println();
	     System.out.println("process \tArrival time \tBurst Time \twaiting time \tTurnaround time");
	     for(int  i = 0 ; i< num;  i++)
	     {
	         System.out.println("P["+process[i] +"]\t  |"
	        		 + " \t "+ arrivalTime[i] 
	        		 + " \t" + "\t "+ burstTime[i] 
	        		 + " \t" + "\t "+ waitingTime[i] 
	        		 + " \t" + "\t "+ turnAroundTime[i] ) ;
	     }
	     System.err.println();
	     System.out.println("average waiting time= "+ (avgWaitingTime/num));    
	     System.out.println("average turnaround time= "+(avgTurnATime/num));    

}
}


