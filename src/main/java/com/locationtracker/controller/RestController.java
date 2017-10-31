package com.locationtracker.controller;

import java.util.List;

import org.apache.log4j.Logger;
import com.locationtracker.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.locationtracker.model.TrackingInfo;
import com.locationtracker.services.DataServices;

/**
 * @author Pradyumnm
 * This controller handles the request to get/update information for a particular location id.
 */
@Controller
@RequestMapping("/trackinginfo")
public class RestController {

	@Autowired
	DataServices dataServices;

	static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addInfo(@RequestBody TrackingInfo info) {
		try {
			dataServices.addEntity(info);
			return new Status(1, "location info updated !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	TrackingInfo getInf(@PathVariable("id") long id) {
		TrackingInfo info = null;
		try {
			info = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}





}
