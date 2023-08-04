package com.practice.cloneable;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;

public class Student implements Cloneable, Serializable {
	int s_roll_no;
	String name;
	int course_id;
	String course_name;
	String course_description;

	public Student(int s_roll_no, String name, int course_id, String course_name, String course_description) {
		super();
		this.s_roll_no = s_roll_no;
		this.name = name;
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_description = course_description;
	}

	public int getS_roll_no() {
		return s_roll_no;
	}

	public void setS_roll_no(int s_roll_no) {
		this.s_roll_no = s_roll_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_description() {
		return course_description;
	}

	public void setCourse_description(String course_description) {
		this.course_description = course_description;
	}
}
