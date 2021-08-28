class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int N = startTime.length;
        Job[] jobs = new Job[N];
        int[] maxProfits = new int[N];
        
        for(int i = 0; i < N; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        
        Arrays.sort(jobs, (Job a, Job b) -> a.end - b.end);
        
        maxProfits[0] = jobs[0].profit;
        
        for(int i = 1; i < N; i++) {
            int j = i-1;
            while (j >= 0 && jobs[j].end > jobs[i].start) j--;
            int currMax = jobs[i].profit;
            if (j >= 0) currMax += maxProfits[j];
            
            maxProfits[i] = Math.max(currMax, maxProfits[i-1]);
            
        }
        return maxProfits[N-1];
    }
}

class Job {
    int start;
    int end;
    int profit;
    
    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}