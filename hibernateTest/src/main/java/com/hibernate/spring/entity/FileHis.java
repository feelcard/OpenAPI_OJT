package com.hibernate.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "FILE_HIS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileHis {
  @Id
  private String fileHisId;
  private String fileId;
  private String forumId;
  private String filePath;
  private String fileSize;
  private String fileCreateBy;
  private String fileCreateDate;
  private String fileType;
  private String fileDeleteBy;
  private String fileDeleteDate;
}
