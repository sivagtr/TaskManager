package com.sivagtr.taskmanager.data;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskManagerData {

	@Id
	private String id;

	private String title;

	private Date createdDate;

	private Date expireDate;

	private String details;

	private String status;
}
