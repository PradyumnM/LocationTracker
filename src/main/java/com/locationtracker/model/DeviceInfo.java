package com.locationtracker.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "devices")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DeviceInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "device_type")
	private String deviceType;
	@Id
	@Column(name = "device_id")
	private String deviceId;

	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "assoc_contact_no")
	private String assocContactNo;

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getAssocContactNo() {
		return assocContactNo;
	}

	public void setAssocContactNo(String assocContactNo) {
		this.assocContactNo = assocContactNo;
	}

	@Column(name = "other_info")
	private String otherInfo;



	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}


	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

}
