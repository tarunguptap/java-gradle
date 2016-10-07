package com.example.core.comparable;


//companycategory
public class EmployeeIdentity {
    private Long id = new Long(-1);
    private Identity identity;
    private Employee employee;

    public EmployeeIdentity() {

    }

    public EmployeeIdentity(Identity identity, Employee employee) {
        this.identity = identity;
        this.employee = employee;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the identity
     */
    public Identity getIdentity() {
        return identity;
    }

    /**
     * @param identity
     *            the identity to set
     */
    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee
     *            the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


}
