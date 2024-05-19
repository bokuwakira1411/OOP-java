package Decorator.Employee;

import java.util.Date;

abstract class EmployeeDecorator implements EmployeeComponent{
    protected EmployeeComponent employee;
    protected EmployeeDecorator(EmployeeComponent employee){
        this.employee = employee;
    }
    @Override
    public String getName(){
        return employee.getName();
    }
    @Override
    public void doTask() {

    }

    @Override
    public void join(Date joinDate) {
        employee.join(joinDate);
    }

    @Override
    public void terminate(Date terminateDate) {
        employee.terminate(terminateDate);
    }
}
