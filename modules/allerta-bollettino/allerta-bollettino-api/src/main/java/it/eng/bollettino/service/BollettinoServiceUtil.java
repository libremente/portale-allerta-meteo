/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.eng.bollettino.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Bollettino. This utility wraps
 * <code>it.eng.bollettino.service.impl.BollettinoServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author GFAVINI
 * @see BollettinoService
 * @generated
 */
@ProviderType
public class BollettinoServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>it.eng.bollettino.service.impl.BollettinoServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.ArrayList<java.util.Map<String, String>>
		getAllarmi() {

		return getService().getAllarmi();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static BollettinoService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<BollettinoService, BollettinoService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BollettinoService.class);

		ServiceTracker<BollettinoService, BollettinoService> serviceTracker =
			new ServiceTracker<BollettinoService, BollettinoService>(
				bundle.getBundleContext(), BollettinoService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}