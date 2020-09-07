package com.hibernate.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "authority")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Authority {
  @Id
  @Column
  private String authCode;
  @Column
  private String authName;
  @Column
  private String authCreateBy;
  @Column
  private String authCreateDate;
  @Column
  private String authUpdateBy;
  @Column
  private String authUpdateDate;
  @Column
  private String authDelete;
  // @ManyToMany(mappedBy = "auths")
  // private List<Display> displays = new ArrayList<>();

}
