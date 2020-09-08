package com.hibernate.spring.entity.display;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.hibernate.spring.entity.DisplayAuth;
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
  private String displayId;
  private String displayName;
  private String displayStatus;
  private String displayUrl;
  private String displayCreateBy;
  private String displayCreateDate;
  private String displayUpdateBy;
  private String displayUpdateDate;
  private String displayDelete;

  @OneToMany(mappedBy = "display", cascade = CascadeType.ALL)
  private Set<DisplayAuth> displayAuths = new HashSet<>();


}
