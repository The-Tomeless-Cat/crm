package com.model.system;

public class Kbm {
    private Integer id;

    private String technicalName;

    private String parts;

    private String kbmDesc;

    public Kbm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Kbm(Integer id, String technicalName, String parts, String kbmDesc) {
		super();
		this.id = id;
		this.technicalName = technicalName;
		this.parts = parts;
		this.kbmDesc = kbmDesc;
	}

	@Override
	public String toString() {
		return "Kbm [id=" + id + ", technicalName=" + technicalName + ", parts=" + parts + ", kbmDesc=" + kbmDesc + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTechnicalName() {
        return technicalName;
    }

    public void setTechnicalName(String technicalName) {
        this.technicalName = technicalName;
    }

    public String getParts() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;
    }

    public String getKbmDesc() {
        return kbmDesc;
    }

    public void setKbmDesc(String kbmDesc) {
        this.kbmDesc = kbmDesc;
    }
}