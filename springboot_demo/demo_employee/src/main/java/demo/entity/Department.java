package demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Department {
    @Id
    @Column(length = 20)
    private String departmentId;
    private String departmentName;

    @OneToMany(mappedBy = "departmentName", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    public Department() {
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
