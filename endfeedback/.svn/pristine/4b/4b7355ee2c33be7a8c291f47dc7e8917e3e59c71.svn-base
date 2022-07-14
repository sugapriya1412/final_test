package org.vtop.CourseRegistration.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
	
@Entity
@Table(name="COMPU_COURSE_COND_DETAIL", schema="ACADEMICS")
public class CompulsoryCourseConditionDetailModel implements Serializable {
				
			private static final long serialVersionUID = 1L;
				
			@EmbeddedId
			private CompulsoryCourseConditionDetailModelPK cccdmPkId;
			
			@Column(name="STATUS")
			private Integer status;
					
			@Column(name="LOG_USERID")
			private String logUserId;
					
			@Column(name="LOG_TIMESTAMP")
			@Temporal(TemporalType.TIMESTAMP)
			private Date logTimestamp;
					
			@Column(name="LOG_IPADDRESS")
			private String logIpaddress;

			public CompulsoryCourseConditionDetailModelPK getCccdmPkId() {
				return cccdmPkId;
			}

			public void setCccdmPkId(CompulsoryCourseConditionDetailModelPK cccdmPkId) {
				this.cccdmPkId = cccdmPkId;
			}

			public Integer getStatus() {
				return status;
			}

			public void setStatus(Integer status) {
				this.status = status;
			}

			public String getLogUserId() {
				return logUserId;
			}

			public void setLogUserId(String logUserId) {
				this.logUserId = logUserId;
			}

			public String getLogTimestamp() throws ParseException {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
			    if(this.logTimestamp==null) {
			    	return "";
			    } else {
			      return dateFormat.format(logTimestamp); 
			    }
			}

			public void setLogTimestamp(Date logTimestamp) {
				this.logTimestamp = logTimestamp;
			}

			public String getLogIpaddress() {
				return logIpaddress;
			}

			public void setLogIpaddress(String logIpaddress) {
				this.logIpaddress = logIpaddress;
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((cccdmPkId == null) ? 0 : cccdmPkId.hashCode());
				result = prime * result + ((logIpaddress == null) ? 0 : logIpaddress.hashCode());
				result = prime * result + ((logTimestamp == null) ? 0 : logTimestamp.hashCode());
				result = prime * result + ((logUserId == null) ? 0 : logUserId.hashCode());
				result = prime * result + ((status == null) ? 0 : status.hashCode());
				return result;
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				CompulsoryCourseConditionDetailModel other = (CompulsoryCourseConditionDetailModel) obj;
				if (cccdmPkId == null) {
					if (other.cccdmPkId != null)
						return false;
				} else if (!cccdmPkId.equals(other.cccdmPkId))
					return false;
				if (logIpaddress == null) {
					if (other.logIpaddress != null)
						return false;
				} else if (!logIpaddress.equals(other.logIpaddress))
					return false;
				if (logTimestamp == null) {
					if (other.logTimestamp != null)
						return false;
				} else if (!logTimestamp.equals(other.logTimestamp))
					return false;
				if (logUserId == null) {
					if (other.logUserId != null)
						return false;
				} else if (!logUserId.equals(other.logUserId))
					return false;
				if (status == null) {
					if (other.status != null)
						return false;
				} else if (!status.equals(other.status))
					return false;
				return true;
			}

			@Override
			public String toString() {
				return "CompulsoryCourseConditionDetailModel [cccdmPkId=" + cccdmPkId + ", status=" + status
						+ ", logUserId=" + logUserId + ", logTimestamp=" + logTimestamp + ", logIpaddress="
						+ logIpaddress + "]";
			}		
}
