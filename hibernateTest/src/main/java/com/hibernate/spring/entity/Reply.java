package com.hibernate.spring.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.hibernate.spring.entity.member.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "REPLY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reply {
  @Id
  private String replyId;
  private String replyField;
  private String replyUpdateDate;
  private String replyUpdateBy;
  private String replyCreateDate;
  private String replyCreateBy;

  @ManyToOne
  @JoinColumn(name = "forum_id")
  private Forum forum;

  @ManyToOne
  @JoinColumn(name = "member_id")
  private Member member;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "parent_reply_id")
  private Reply parent;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
  private Set<Reply> childReplys = new HashSet<Reply>();
}
