package com.hibernate.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.hibernate.spring.entity.display.Display;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "DISPLAY_AUTH")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DisplayAuth {
  @Id
  private String displayAuthId;
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "display_id")
  private Display display;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "auth_code")
  private Authority auth;
}
