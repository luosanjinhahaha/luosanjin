package com.smxy.healthmedical.bean;

public class Patient {
    private Integer patientId;

    private String patientUsername;

    private String patientPassword;

    private String patientRepassword;

    private String patientGender;

    private String patientPhone;

    private Integer pId;
    
    private Department department;
    
    public Patient(Integer patientId, String patientUsername,
			String patientPassword, String patientRepassword,
			String patientGender, String patientPhone, Integer pId) {
		super();
		this.patientId = patientId;
		this.patientUsername = patientUsername;
		this.patientPassword = patientPassword;
		this.patientRepassword = patientRepassword;
		this.patientGender = patientGender;
		this.patientPhone = patientPhone;
		this.pId = pId;
	}

	public Patient() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientUsername() {
        return patientUsername;
    }

    public void setPatientUsername(String patientUsername) {
        this.patientUsername = patientUsername == null ? null : patientUsername.trim();
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword == null ? null : patientPassword.trim();
    }

    public String getPatientRepassword() {
        return patientRepassword;
    }

    public void setPatientRepassword(String patientRepassword) {
        this.patientRepassword = patientRepassword == null ? null : patientRepassword.trim();
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender == null ? null : patientGender.trim();
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone == null ? null : patientPhone.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
}