package com.sivagtr.taskmanager;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseData {
	private String error;
	private String comments;

	public ResponseData setError(String error){
		this.error = error;
		return this;
	}

	public ResponseData setComments(String comments){
		this.comments = comments;
		return this;
	}
}
