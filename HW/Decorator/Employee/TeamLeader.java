package Decorator.Employee;

public class TeamLeader extends EmployeeDecorator{
    protected TeamLeader(EmployeeComponent employee) {
        super(employee);
    }

    public void planning(){
        System.out.println(this.employee.getName() + " is planning.");
    }
    public void motivate(){
        System.out.println(this.employee.getName() + " is motivating his members");
    }
    public void monitor(){
        System.out.println(this.employee.getName() + " is monitoring his members");
    }
    @Override
    public void doTask(){
        employee.doTask();
        planning();
        motivate();
        monitor();
    }
}
