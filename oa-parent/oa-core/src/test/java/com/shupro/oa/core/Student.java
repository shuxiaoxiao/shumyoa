package com.shupro.oa.core;

public class Student {
	private String name;
	private String grade;
	private String writeScore;
	private String machineScore;

	public Student(String name, String grade, String writeScore, String machineScore) {
		super();
		this.name = name;
		this.grade = grade;
		this.writeScore = writeScore;
		this.machineScore = machineScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getWriteScore() {
		return writeScore;
	}

	public void setWriteScore(String writeScore) {
		this.writeScore = writeScore;
	}

	public String getMachineScore() {
		return machineScore;
	}

	public void setMachineScore(String machineScore) {
		this.machineScore = machineScore;
	}

}
