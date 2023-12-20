package com.cattle.livestocks.repository.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel implements Serializable {
	private static final long serialVersionUID = -8279622951286080664L;

	@CreatedDate
	private LocalDateTime createdTime;

	@CreatedBy
	private String createdBy;

	@LastModifiedDate
	private LocalDateTime updatedTime;

	@LastModifiedBy
	private String updatedBy;

	@CreatedBy
	private String authoriser;

	@CreatedDate
	private LocalDateTime authorizeTime;

	private String status;

	private Integer version;
}