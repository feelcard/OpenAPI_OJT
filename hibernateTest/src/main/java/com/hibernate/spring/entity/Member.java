package com.hibernate.spring.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "MEMBER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
  @Id
  @Column
  private String memberId;
  @Column
  private String memberName;
  @Column
  private String memberCreateDate;
  @Column
  private String memberUpdateBy;
  @Column
  private String memberUpdateDate;
  @Column
  private String memberDelete;
}
