package com.locationtracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.locationtracker.dao.DataDao;
import com.locationtracker.model.TrackingInfo;

public class DataServicesImpl implements DataServices {

	@Autowired
	DataDao dataDao;
	
	@Override
	public boolean addEntity(TrackingInfo info) throws Exception {
		return dataDao.addEntity(info);
	}

	@Override
	public TrackingInfo getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}

	@Override
	public List<TrackingInfo> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}

}
