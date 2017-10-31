package com.locationtracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.locationtracker.model.TrackingInfo;

public class DataDaoImpl implements DataDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(TrackingInfo info) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(info);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public TrackingInfo getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		TrackingInfo info = (TrackingInfo) session.load(TrackingInfo.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return info;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrackingInfo> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<TrackingInfo> infoList = session.createCriteria(TrackingInfo.class)
				.list();
		tx.commit();
		session.close();
		return infoList;
	}
	
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(TrackingInfo.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		return false;
	}

}
