public class Employee {
    private static int nextId = 0;

    int id;
    public String name;
    public String skills[];
    public boolean isAvailable = true;

    public Employee (String name, String skills[]){
        this.id = Employee.nextId++;
        this.name = name;
        this.skills = skills;
        this.isAvailable = isAvailable;
    }
}
