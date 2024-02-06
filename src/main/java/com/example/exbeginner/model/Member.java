package com.example.exbeginner.model;

public class Member {
  private String name;
  private Integer age;
  private Integer dep_id;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Integer getAge() {
    return age;
  }
  public void setAge(Integer age) {
    this.age = age;
  }
  public Integer getDep_id() {
    return dep_id;
  }
  public void setDep_id(Integer dep_id) {
    this.dep_id = dep_id;
  }
  @Override
  public String toString() {
    return "Member [name=" + name + ", age=" + age + ", dep_id=" + dep_id + "]";
  }

  
}
