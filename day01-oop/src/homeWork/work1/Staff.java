package homeWork.work1;

public class Staff {
    private String name;
    private String jobNumber;
    private double salary;

    public Staff() {
    }

    public Staff(String name, String jobNumber, double salary) {
        this.name = name;
        this.jobNumber = jobNumber;
        this.salary = salary;
    }
    public void work(){
        System.out.println("=====工作====");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob_number() {
        return jobNumber;
    }

    public void setJob_number(String job_number) {
        this.jobNumber = jobNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
