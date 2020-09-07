package com.hibernate.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "display")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Display {

  @Id
  // @GeneratedValue(generator = "UUID")
  // @GenericGenerator( name = "UUID",
  @Column(name = "display_id")
  private String displayId;
  @Column(name = "display_name")
  private String name;
  @Column(name = "display_status")
  private String status;
  @Column(name = "display_url")
  private String url;
  @Column(name = "display_create_by")
  private String createBy;
  @Column(name = "display_create_date")
  private String createDate;
  @Column(name = "display_update_by")
  private String updateBy;
  @Column // (name = "display_update_date")
  private String displayUpdateDate;
  @Column(name = "display_delete")
  private String delete;
  // @ManyToMany
  // @JoinTable(name = "display_auth", joinColumns = @JoinColumn(name = "display_id"),
  // inverseJoinColumns = @JoinColumn(name = "auth_code"))
  // private List<Authority> auths = new ArrayList<Authority>();


}
