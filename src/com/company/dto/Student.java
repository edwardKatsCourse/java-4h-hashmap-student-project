package com.company.dto;

public class Student {
    private Integer id;
    private String fullName;
    private String major;
    private String group;
    private Integer yearOfEducation;

    //constructors (default and with all arguments)
    //getters/setters
    //equals() and hashCode()
    //toString()


    @Override
    public String toString() {
        return String.format("(%s) Name: %s | Major: %s | Group: %s | Year: %s\n",
                this.id,
                this.fullName,
                this.major,
                this.group,
                this.yearOfEducation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getYearOfEducation() {
        return yearOfEducation;
    }

    public void setYearOfEducation(Integer yearOfEducation) {
        this.yearOfEducation = yearOfEducation;
    }

    public Student(Integer id, String fullName, String major, String group, Integer yearOfEducation) {
        this.id = id;
        this.fullName = fullName;
        this.major = major;
        this.group = group;
        this.yearOfEducation = yearOfEducation;
    }
}
