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
	 * @param rowssize depicts the size of the row
	 * @param localarr depicts the array which is to be worked upon
	 * @return the sorted array
	 */
	int[][] sortarr(int rowssize,int localarr[][])
	{
		for(int i=0;i<rowssize;i++)
		{
			for(int j=i+1;j<rowssize;j++)
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
	    int totalwaitingtime=waitingarr[0];
	    double averagewaitingtime=0.0;
	    for(int i=1;i<waitingarr.length;i++)
	    {
	        totalwaitingtime+=waitingarr[i];
	    }
	    averagewaitingtime=(double)totalwaitingtime/(waitingarr.length);
	    return averagewaitingtime ;
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
        int rowsize;
        boolean flag=true;
        do
        {   
            rowsize=s.nextInt();
            try
            {
                
                if(rowsize<0)
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
        int btime,atime;
        int[][] arr=new int[rowsize][2];
        for(int i=0;i<rowsize;i++)
        {
            for(int j=0;j<obj1.colsize;j++)
            {
                System.out.println("Enter the arrival time:");
                atime=s.nextInt();
                arr[i][j]=atime;
                j++;
                System.out.println("Enter the burst time:");
                btime=s.nextInt();
                arr[i][j]=btime;
            }
        
        }
         s.close();
		 arr=obj1.sortarr(rowsize,arr);
		 int completiontimearr[]=new int[rowsize];
		 completiontimearr=obj1.calculateCompletionTime(arr, completiontimearr);
		 int turnaroundtimearr[]=new int[rowsize];
		 turnaroundtimearr=obj1.calculateTurnAroundTime(arr, turnaroundtimearr, completiontimearr);
		 int waitingtimearr[]=new int[rowsize];
		 waitingtimearr=obj1.calculateWaitingTime(arr, waitingtimearr, turnaroundtimearr);
		 System.out.println("Following are the processes:\n");
		 System.out.println("Arrival Time\t  Burst Time\n");
		 for(int i=0;i<rowsize;i++)
		 {
		     for(int j=0;j<=obj1.colsize;j++)
		     {
		         System.out.print(arr[i][j]+"\t\t  ");
		     }
		     System.out.println("\n");
		 }
		 for(int i=0;i<rowsize;i++)
		 {
		     System.out.println("\nCompletion time for Process "+(i+1)+"= "+completiontimearr[i]);
		 }
		 for(int i=0;i<rowsize;i++)
         {
             System.out.println("\nWaiting time for Process "+(i+1)+"= "+waitingtimearr[i]);
         }
		 for(int i=0;i<rowsize;i++)
         {
             System.out.println("\nTurnaround time for Process "+(i+1)+"= "+turnaroundtimearr[i]);
         }
		 System.out.println("\nAverage Waiting time: "+obj1.averageWaitingTime(waitingtimearr));
		 System.out.println("\nMaximum Waiting time: "+obj1.maxWaitingTime(waitingtimearr));
	}

}
