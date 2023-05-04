package demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "nhanVien")
public class Employee {
    @Id
    @Column(name = "employee_id", columnDefinition = "varchar(10)")
    private String id;
    private String name;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
    private Department departmentName;

    private String email;

    private String gender;

    private String phoneNumber;

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public Employee() {
    }

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(String id, String name, Department departmentName, String email, String gender, String phoneNumber, Date birthday) {
        this.id = id;
        this.name = name;
        this.departmentName = departmentName;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(Department departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
