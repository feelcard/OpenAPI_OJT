package com.hibernate.spring.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Display")
public class Display {

	@Id
//	@GeneratedValue(generator = "UUID")
//	@GenericGenerator(	name = "UUID",
//			strategy = "org.hibernate.id.UUIDGenerator")
	@Column(columnDefinition = "VARCHAR(100)")
	private String id;
	@Column(columnDefinition = "VARCHAR(30)")
	private String name;
	@Column(columnDefinition = "VARCHAR(30)")
	private String status;
	@Column(columnDefinition = "VARCHAR(200)")
	private String url;
	@Column(columnDefinition = "VARCHAR(30)")
	private String createBy;
	@Column(columnDefinition = "VARCHAR(30)")
	private String createDate;
	@Column(columnDefinition = "VARCHAR(30)")
	private String updateBy;
	@Column(columnDefinition = "VARCHAR(30)")
	private String updateDate;
	
	public Display() {
		super();
	}

	public Display(String id, String name, String status, String url, String createBy, String createDate, String updateBy,
			String updateDate) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.url = url;
		this.createBy = createBy;
		this.createDate = createDate;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Display [id=" + id + ", name=" + name + ", status=" + status + ", url=" + url + ", createBy=" + createBy
				+ ", createDate=" + createDate + ", updateBy=" + updateBy + ", updateDate=" + updateDate + "]";
	}
	
	
}
