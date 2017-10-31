package com.locationtracker.dao;

import java.util.List;

import com.locationtracker.model.TrackingInfo;

public interface DataDao {

	public boolean addEntity(TrackingInfo info) throws Exception;
	public TrackingInfo getEntityById(long id) throws Exception;
	public List<TrackingInfo> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
