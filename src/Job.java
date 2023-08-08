public class Job
{
    private int count = 0;
    private int jobID;
    private String name;

    public Job(String title){
        name = title;
        jobID = ++count;
    }

    public int count() {
        return count;
    }

    public int jobID() {
        return jobID;
    }
}