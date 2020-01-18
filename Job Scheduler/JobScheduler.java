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
	 * sortArr method is used to sort array in ascending order according to their arrival time
	 * @param rowsSize depicts the size of the row
	 * @param localArr depicts the array which is to be worked upon
	 * @return the sorted array
	 */
	int[][] sortArr(int rowsSize,int localArr[][])
	{
		for(int i=0;i<rowsSize;i++)
		{
			for(int j=i+1;j<rowsSize;j++)
			{
				if(localArr[i][0]>localArr[j][0])
				{
					int temp=localArr[i][0];
					localArr[i][0]=localArr[j][0];
					localArr[j][0]=temp;
				}
			}
		}
		return localArr;
	}
	
	/**
	 * calculateCompletionTime is used to calculate completion time of the processes
	 * @param localArr localarr depicts the sorted array which is to be worked upon
	 * @param rowsSize depicts the size of the rows 
	 * @return an array with the complete time of the processes
	 */
	
	int[] calculateCompletionTime(int localArr[][],int rowsSize)
	{
	    int completionArr[]=new int[rowsSize];
	    completionArr[0]=localArr[0][0]+localArr[0][1];
	    for(int i=1;i<localArr.length;i++)
	    {
	        if(completionArr[i-1]>localArr[i][0])
	            completionArr[i]=completionArr[i-1]+localArr[i][1];
	        else
	            completionArr[i]=localArr[i][0]+localArr[i][1];
	    }
	    return completionArr;
	}
	
	/**
	 * 
	 * @param localArr depicts the sorted array which is to be worked upon
	 * @param turnAroundArr depicts an array of Time taken to complete after arrival
	 * @param completionArr depicts the array with the completion time of processes
	 * @return an array with the turnaround time for processes
	 */
	int[] calculateTurnAroundTime(int [][]localArr,int turnAroundArr[],int completionArr[])
	{
	    for(int i=0;i<localArr.length;i++)
	    {
	        turnAroundArr[i]=completionArr[i]-localArr[i][0];
	    }
	    return turnAroundArr;
	}
	
	/**
	 * 
	 * @param localArr depicts the sorted array which is to be worked upon
	 * @param waitingArr depicts an array of Total time the process has to wait before it's execution begins
	 * @param turnAroundArr depicts an array of Time taken to complete after arrival
	 * @return the array with waiting time of the processes
	 */
	int[] calculateWaitingTime(int localArr[][],int waitingArr[],int turnAroundArr[])
	{
	    for(int i=0;i<localArr.length;i++)
	    {
	        waitingArr[i]=turnAroundArr[i]-localArr[i][1];
	    }
	    return waitingArr;
	}
	
	/**
	 * Calculates the average waiting time of the processes
	 * @param waitingArr depicts an array of Total time the process has to wait before it's execution begins
	 * @return the average waiting time of the processes
	 */
	double averageWaitingTime(int waitingArr[])
	{
	    int totalWaitingtime=waitingArr[0];
	    double averageWaitingtime=0.0;
	    for(int i=1;i<waitingArr.length;i++)
	    {
	        totalWaitingtime+=waitingArr[i];
	    }
	    averageWaitingtime=(double)totalWaitingtime/(waitingArr.length);
	    return averageWaitingtime ;
	}
	
	/**
	 * Calculates the maximum waiting time among the waiting time of all the processes
	 * @param waitingArr depicts an array of Total time the process has to wait before it's execution begins
	 * @return the maximum waiting time of the processes
	 */
	int maxWaitingTime(int waitingArr[])
	{
	    int maximumWaitingTime=waitingArr[0];
	    for(int i=1;i<waitingArr.length;i++)
	    {
	        if(maximumWaitingTime<waitingArr[i])
	            maximumWaitingTime=waitingArr[i];
	    }
	    return maximumWaitingTime;
	}
	
	public static void main(String[] args) 
	{
        JobScheduler jobSchedulerInstance=new JobScheduler();
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
        int[][] inputArr=new int[rowSize][2];
        for(int i=0;i<rowSize;i++)
        {
            for(int j=0;j<jobSchedulerInstance.colsize;j++)
            {
                System.out.println("Enter the arrival time:");
                inputArr[i][j]=s.nextInt();
                j++;
                System.out.println("Enter the burst time:");
                inputArr[i][j]=s.nextInt();
            }
        }
         s.close();
		 inputArr=jobSchedulerInstance.sortArr(rowSize,inputArr);
		 int completionTimeArr[]=new int[rowSize];
		 completionTimeArr=jobSchedulerInstance.calculateCompletionTime(inputArr,rowSize);
		 int turnaroundTimearr[]=new int[rowSize];
		 turnAroundTimeArr=jobSchedulerInstance.calculateTurnAroundTime(inputArr, turnAroundTimeArr, completionTimeArr);
		 int waitingTimeArr[]=new int[rowSize];
		 waitingTimeArr=jobSchedulerInstance.calculateWaitingTime(inputArr, waitingTimeArr, TurnAroundTimearr);
		 System.out.println("Following are the processes:\n");
		 System.out.println("Arrival Time\t  Burst Time\n");
		 for(int i=0;i<rowSize;i++)
		 {
		     for(int j=0;j<=jobSchedulerInstance.colsize;j++)
		     {
		         System.out.print(inputArr[i][j]+"\t\t  ");
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
		 System.out.println("\nAverage Waiting time: "+jobSchedulerInstance.averageWaitingTime(waitingTimeArr));
		 System.out.println("\nMaximum Waiting time: "+jobSchedulerInstance.maxWaitingTime(waitingTimeArr));
	}
}
