package com.hibernate.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "FILE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class File {
  @Id
  private String fileId;
  private String filePath;
  private String fileSize;
  private String fileCreateDate;
  private String fileType;

  @ManyToOne
  @JoinColumn(name = "forum_id")
  private Forum forum;
}
