package com.hibernate.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "REPLY_HIS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReplyHis {
  @Id
  private String replyHisId;
  private String replyId;
  private String forum_id;
  private String member_id;
  private String replyField;
  private String parentReplyId;
  private String replyUpdateDate;
  private String replyUpdateBy;
  private String replyDeleteDate;
  private String replyDeleteBy;

}
