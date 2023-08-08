public class Main {


    public static void main(String[] args) {
        Job job1 = new Job("Architect");
        Job job2 = new Job("Doctor");
        Job job3 = new Job("Developer");
        System.out.println(job1.jobID());
        System.out.println(job2.jobID());
        System.out.println(job3.jobID());

    }
}
