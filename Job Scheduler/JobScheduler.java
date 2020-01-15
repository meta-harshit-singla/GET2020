package main;

import java.util.Scanner;

/**
 * @author Harshit
 *JobScheduler class is used to perform different operations according to FCFS(First Come First Serve) algorithm
 */
public class JobScheduler 
{
	final int colsize=1;
	
	/**
	 * sortarr method is used to sort array in ascending order according to their arrival time
	 * @param rowsSize depicts the size of the row
	 * @param localarr depicts the array which is to be worked upon
	 * @return the sorted array
	 */
	int[][] sortarr(int rowsSize,int localarr[][])
	{
		for(int i=0;i<rowsSize;i++)
		{
			for(int j=i+1;j<rowsSize;j++)
			{
				if(localarr[i][0]>localarr[j][0])
				{
					int temp=localarr[i][0];
					localarr[i][0]=localarr[j][0];
					localarr[j][0]=temp;
				}
			}
		}
		return localarr;
	}
	
	/**
	 * calculateCompletionTime is used to calculate completion time of the processes
	 * @param localarr localarr depicts the sorted array which is to be worked upon
	 * @param completionarr depicts the array with the completion time of processes 
	 * @return an array with the complete time of the processes
	 */
	
	int[] calculateCompletionTime(int localarr[][],int completionarr[])
	{
	    completionarr[0]=localarr[0][0]+localarr[0][1];
	    for(int i=1;i<localarr.length;i++)
	    {
	        if(completionarr[i-1]>localarr[i][0])
	            completionarr[i]=completionarr[i-1]+localarr[i][1];
	        else
	            completionarr[i]=localarr[i][0]+localarr[i][1];
	    }
	    return completionarr;
	}
	
	/**
	 * 
	 * @param localarr depicts the sorted array which is to be worked upon
	 * @param turnaroundarr depicts an array of Time taken to complete after arrival
	 * @param completionarr depicts the array with the completion time of processes
	 * @return an array with the turnaround time for processes
	 */
	int[] calculateTurnAroundTime(int [][]localarr,int turnaroundarr[],int completionarr[])
	{
	    for(int i=0;i<localarr.length;i++)
	    {
	        turnaroundarr[i]=completionarr[i]-localarr[i][0];
	    }
	    return turnaroundarr;
	}
	
	/**
	 * 
	 * @param localarr  depicts the sorted array which is to be worked upon
	 * @param waitingarr depicts an array of Total time the process has to wait before it's execution begins
	 * @param turnaroundarr depicts an array of Time taken to complete after arrival
	 * @return the array with waiting time of the processes
	 */
	int[] calculateWaitingTime(int localarr[][],int waitingarr[],int turnaroundarr[])
	{
	    for(int i=0;i<localarr.length;i++)
	    {
	        waitingarr[i]=turnaroundarr[i]-localarr[i][1];
	    }
	    return waitingarr;
	}
	
	/**
	 * Calculates the average waiting time of the processes
	 * @param waitingarr depicts an array of Total time the process has to wait before it's execution begins
	 * @return the average waiting time of the processes
	 */
	double averageWaitingTime(int waitingarr[])
	{
	    int totalWaitingtime=waitingarr[0];
	    double averageWaitingtime=0.0;
	    for(int i=1;i<waitingarr.length;i++)
	    {
	        totalWaitingtime+=waitingarr[i];
	    }
	    averageWaitingtime=(double)totalWaitingtime/(waitingarr.length);
	    return averageWaitingtime ;
	}
	
	/**
	 * Calculates the maximum waiting time among the waiting time of all the processes
	 * @param waitingarr depicts an array of Total time the process has to wait before it's execution begins
	 * @return the maximum waiting time of the processes
	 */
	int maxWaitingTime(int waitingarr[])
	{
	    int maxwaitingtime=waitingarr[0];
	    for(int i=1;i<waitingarr.length;i++)
	    {
	        if(maxwaitingtime<waitingarr[i])
	            maxwaitingtime=waitingarr[i];
	    }
	    return maxwaitingtime;
	}
	
	public static void main(String[] args) 
	{
		JobScheduler obj1=new JobScheduler();
		System.out.println("Enter the total number of processes:");
        Scanner s=new Scanner(System.in);
        int rowSize;
        boolean flag=true;
        do
        {   
            rowSize=s.nextInt();
            try
            {
                
                if(rowSize<0)
                    throw new ArithmeticException("Enter positive number");
            }
            catch(ArithmeticException e)
            {
                flag=false;
                e.getMessage();
            }
            catch(Exception e)
            {
                flag=false;
                System.out.println("Wrong input");
            }
        }while(!flag);
        int burstTime,arrivalTime;
        int[][] arr=new int[rowSize][2];
        for(int i=0;i<rowSize;i++)
        {
            for(int j=0;j<obj1.colsize;j++)
            {
                System.out.println("Enter the arrival time:");
                arrivalTime=s.nextInt();
                arr[i][j]=arrivalTime;
                j++;
                System.out.println("Enter the burst time:");
                burstTime=s.nextInt();
                arr[i][j]=burstTime;
            }
        
        }
         s.close();
		 arr=obj1.sortarr(rowSize,arr);
		 int completionTimeArr[]=new int[rowSize];
		 completionTimeArr=obj1.calculateCompletionTime(arr, completionTimeArr);
		 int turnaroundtimearr[]=new int[rowSize];
		 turnAroundTimeArr=obj1.calculateTurnAroundTime(arr, turnAroundTimeArr, completionTimeArr);
		 int waitingTimeArr[]=new int[rowSize];
		 waitingTimeArr=obj1.calculateWaitingTime(arr, waitingTimeArr, TurnAroundTimearr);
		 System.out.println("Following are the processes:\n");
		 System.out.println("Arrival Time\t  Burst Time\n");
		 for(int i=0;i<rowSize;i++)
		 {
		     for(int j=0;j<=obj1.colsize;j++)
		     {
		         System.out.print(arr[i][j]+"\t\t  ");
		     }
		     System.out.println("\n");
		 }
		 for(int i=0;i<rowSize;i++)
		 {
		     System.out.println("\nCompletion time for Process "+(i+1)+"= "+completionTimeArr[i]);
		 }
		 for(int i=0;i<rowSize;i++)
         {
             System.out.println("\nWaiting time for Process "+(i+1)+"= "+waitingTimeArr[i]);
         }
		 for(int i=0;i<rowSize;i++)
         {
             System.out.println("\nTurnaround time for Process "+(i+1)+"= "+turnAroundTimeArr[i]);
         }
		 System.out.println("\nAverage Waiting time: "+obj1.averageWaitingTime(waitingTimeArr));
		 System.out.println("\nMaximum Waiting time: "+obj1.maxWaitingTime(waitingTimeArr));
	}

}
