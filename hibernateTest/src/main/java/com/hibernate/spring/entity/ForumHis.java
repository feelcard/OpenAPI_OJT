package com.hibernate.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "FOURM_HIS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ForumHis {
  @Id
  private String forumHisId;
  private String forumId;
  private String forumField;
  private String forumTitle;
  private String forumCreateDate;
  private String forumCreateBy;
  private String forumDeleteDate;
  private String forumDeleteBy;
  private String memberId;
  private String subsiId;
  private String auth_code;// 삭제한 사람의 권한코드
}
