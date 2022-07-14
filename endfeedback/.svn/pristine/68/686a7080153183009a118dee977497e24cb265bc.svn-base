package org.vtop.CourseRegistration.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PROGRAM_DETAILS database table.
 * 
 */
@Embeddable
public class ProgramDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private long progid;

	private String progcode;

	public ProgramDetailPK() {
	}
	public long getProgid() {
		return this.progid;
	}
	public void setProgid(long progid) {
		this.progid = progid;
	}
	public String getProgcode() {
		return this.progcode;
	}
	public void setProgcode(String progcode) {
		this.progcode = progcode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProgramDetailPK)) {
			return false;
		}
		ProgramDetailPK castOther = (ProgramDetailPK)other;
		return 
			(this.progid == castOther.progid)
			&& this.progcode.equals(castOther.progcode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.progid ^ (this.progid >>> 32)));
		hash = hash * prime + this.progcode.hashCode();
		
		return hash;
	}
}