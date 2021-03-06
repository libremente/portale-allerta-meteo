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

package it.eng.animaeteo.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.animaeteo.model.AnimeteoImg;
import it.eng.animaeteo.service.AnimeteoImgService;
import it.eng.animaeteo.service.persistence.AnimeteoImgPersistence;
import it.eng.animaeteo.service.persistence.AnimeteoSmallImgPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the animeteo img remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.eng.animaeteo.service.impl.AnimeteoImgServiceImpl}.
 * </p>
 *
 * @author UTENTE
 * @see it.eng.animaeteo.service.impl.AnimeteoImgServiceImpl
 * @generated
 */
public abstract class AnimeteoImgServiceBaseImpl
	extends BaseServiceImpl
	implements AnimeteoImgService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>AnimeteoImgService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.animaeteo.service.AnimeteoImgServiceUtil</code>.
	 */

	/**
	 * Returns the animeteo img local service.
	 *
	 * @return the animeteo img local service
	 */
	public it.eng.animaeteo.service.AnimeteoImgLocalService
		getAnimeteoImgLocalService() {

		return animeteoImgLocalService;
	}

	/**
	 * Sets the animeteo img local service.
	 *
	 * @param animeteoImgLocalService the animeteo img local service
	 */
	public void setAnimeteoImgLocalService(
		it.eng.animaeteo.service.AnimeteoImgLocalService
			animeteoImgLocalService) {

		this.animeteoImgLocalService = animeteoImgLocalService;
	}

	/**
	 * Returns the animeteo img remote service.
	 *
	 * @return the animeteo img remote service
	 */
	public AnimeteoImgService getAnimeteoImgService() {
		return animeteoImgService;
	}

	/**
	 * Sets the animeteo img remote service.
	 *
	 * @param animeteoImgService the animeteo img remote service
	 */
	public void setAnimeteoImgService(AnimeteoImgService animeteoImgService) {
		this.animeteoImgService = animeteoImgService;
	}

	/**
	 * Returns the animeteo img persistence.
	 *
	 * @return the animeteo img persistence
	 */
	public AnimeteoImgPersistence getAnimeteoImgPersistence() {
		return animeteoImgPersistence;
	}

	/**
	 * Sets the animeteo img persistence.
	 *
	 * @param animeteoImgPersistence the animeteo img persistence
	 */
	public void setAnimeteoImgPersistence(
		AnimeteoImgPersistence animeteoImgPersistence) {

		this.animeteoImgPersistence = animeteoImgPersistence;
	}

	/**
	 * Returns the animeteo small img local service.
	 *
	 * @return the animeteo small img local service
	 */
	public it.eng.animaeteo.service.AnimeteoSmallImgLocalService
		getAnimeteoSmallImgLocalService() {

		return animeteoSmallImgLocalService;
	}

	/**
	 * Sets the animeteo small img local service.
	 *
	 * @param animeteoSmallImgLocalService the animeteo small img local service
	 */
	public void setAnimeteoSmallImgLocalService(
		it.eng.animaeteo.service.AnimeteoSmallImgLocalService
			animeteoSmallImgLocalService) {

		this.animeteoSmallImgLocalService = animeteoSmallImgLocalService;
	}

	/**
	 * Returns the animeteo small img remote service.
	 *
	 * @return the animeteo small img remote service
	 */
	public it.eng.animaeteo.service.AnimeteoSmallImgService
		getAnimeteoSmallImgService() {

		return animeteoSmallImgService;
	}

	/**
	 * Sets the animeteo small img remote service.
	 *
	 * @param animeteoSmallImgService the animeteo small img remote service
	 */
	public void setAnimeteoSmallImgService(
		it.eng.animaeteo.service.AnimeteoSmallImgService
			animeteoSmallImgService) {

		this.animeteoSmallImgService = animeteoSmallImgService;
	}

	/**
	 * Returns the animeteo small img persistence.
	 *
	 * @return the animeteo small img persistence
	 */
	public AnimeteoSmallImgPersistence getAnimeteoSmallImgPersistence() {
		return animeteoSmallImgPersistence;
	}

	/**
	 * Sets the animeteo small img persistence.
	 *
	 * @param animeteoSmallImgPersistence the animeteo small img persistence
	 */
	public void setAnimeteoSmallImgPersistence(
		AnimeteoSmallImgPersistence animeteoSmallImgPersistence) {

		this.animeteoSmallImgPersistence = animeteoSmallImgPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService
		getClassNameService() {

		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {

		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {

		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AnimeteoImgService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AnimeteoImg.class;
	}

	protected String getModelClassName() {
		return AnimeteoImg.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = animeteoImgPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(
		type = it.eng.animaeteo.service.AnimeteoImgLocalService.class
	)
	protected it.eng.animaeteo.service.AnimeteoImgLocalService
		animeteoImgLocalService;

	@BeanReference(type = AnimeteoImgService.class)
	protected AnimeteoImgService animeteoImgService;

	@BeanReference(type = AnimeteoImgPersistence.class)
	protected AnimeteoImgPersistence animeteoImgPersistence;

	@BeanReference(
		type = it.eng.animaeteo.service.AnimeteoSmallImgLocalService.class
	)
	protected it.eng.animaeteo.service.AnimeteoSmallImgLocalService
		animeteoSmallImgLocalService;

	@BeanReference(
		type = it.eng.animaeteo.service.AnimeteoSmallImgService.class
	)
	protected it.eng.animaeteo.service.AnimeteoSmallImgService
		animeteoSmallImgService;

	@BeanReference(type = AnimeteoSmallImgPersistence.class)
	protected AnimeteoSmallImgPersistence animeteoSmallImgPersistence;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserService.class
	)
	protected com.liferay.portal.kernel.service.UserService userService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

}