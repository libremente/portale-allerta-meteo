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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.eng.animaeteo.model.AnimeteoSmallImg;
import it.eng.animaeteo.service.AnimeteoSmallImgLocalService;
import it.eng.animaeteo.service.persistence.AnimeteoImgPersistence;
import it.eng.animaeteo.service.persistence.AnimeteoSmallImgPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the animeteo small img local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.eng.animaeteo.service.impl.AnimeteoSmallImgLocalServiceImpl}.
 * </p>
 *
 * @author UTENTE
 * @see it.eng.animaeteo.service.impl.AnimeteoSmallImgLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class AnimeteoSmallImgLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AnimeteoSmallImgLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>AnimeteoSmallImgLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.animaeteo.service.AnimeteoSmallImgLocalServiceUtil</code>.
	 */

	/**
	 * Adds the animeteo small img to the database. Also notifies the appropriate model listeners.
	 *
	 * @param animeteoSmallImg the animeteo small img
	 * @return the animeteo small img that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AnimeteoSmallImg addAnimeteoSmallImg(
		AnimeteoSmallImg animeteoSmallImg) {

		animeteoSmallImg.setNew(true);

		return animeteoSmallImgPersistence.update(animeteoSmallImg);
	}

	/**
	 * Creates a new animeteo small img with the primary key. Does not add the animeteo small img to the database.
	 *
	 * @param id the primary key for the new animeteo small img
	 * @return the new animeteo small img
	 */
	@Override
	@Transactional(enabled = false)
	public AnimeteoSmallImg createAnimeteoSmallImg(long id) {
		return animeteoSmallImgPersistence.create(id);
	}

	/**
	 * Deletes the animeteo small img with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img that was removed
	 * @throws PortalException if a animeteo small img with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AnimeteoSmallImg deleteAnimeteoSmallImg(long id)
		throws PortalException {

		return animeteoSmallImgPersistence.remove(id);
	}

	/**
	 * Deletes the animeteo small img from the database. Also notifies the appropriate model listeners.
	 *
	 * @param animeteoSmallImg the animeteo small img
	 * @return the animeteo small img that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AnimeteoSmallImg deleteAnimeteoSmallImg(
		AnimeteoSmallImg animeteoSmallImg) {

		return animeteoSmallImgPersistence.remove(animeteoSmallImg);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			AnimeteoSmallImg.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return animeteoSmallImgPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animaeteo.model.impl.AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return animeteoSmallImgPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animaeteo.model.impl.AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return animeteoSmallImgPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return animeteoSmallImgPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return animeteoSmallImgPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public AnimeteoSmallImg fetchAnimeteoSmallImg(long id) {
		return animeteoSmallImgPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the animeteo small img with the primary key.
	 *
	 * @param id the primary key of the animeteo small img
	 * @return the animeteo small img
	 * @throws PortalException if a animeteo small img with the primary key could not be found
	 */
	@Override
	public AnimeteoSmallImg getAnimeteoSmallImg(long id)
		throws PortalException {

		return animeteoSmallImgPersistence.findByPrimaryKey(id);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			animeteoSmallImgLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AnimeteoSmallImg.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			animeteoSmallImgLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(AnimeteoSmallImg.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("id");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			animeteoSmallImgLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AnimeteoSmallImg.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("id");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return animeteoSmallImgLocalService.deleteAnimeteoSmallImg(
			(AnimeteoSmallImg)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return animeteoSmallImgPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the animeteo small imgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.animaeteo.model.impl.AnimeteoSmallImgModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of animeteo small imgs
	 * @param end the upper bound of the range of animeteo small imgs (not inclusive)
	 * @return the range of animeteo small imgs
	 */
	@Override
	public List<AnimeteoSmallImg> getAnimeteoSmallImgs(int start, int end) {
		return animeteoSmallImgPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of animeteo small imgs.
	 *
	 * @return the number of animeteo small imgs
	 */
	@Override
	public int getAnimeteoSmallImgsCount() {
		return animeteoSmallImgPersistence.countAll();
	}

	/**
	 * Updates the animeteo small img in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param animeteoSmallImg the animeteo small img
	 * @return the animeteo small img that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AnimeteoSmallImg updateAnimeteoSmallImg(
		AnimeteoSmallImg animeteoSmallImg) {

		return animeteoSmallImgPersistence.update(animeteoSmallImg);
	}

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
	public AnimeteoSmallImgLocalService getAnimeteoSmallImgLocalService() {
		return animeteoSmallImgLocalService;
	}

	/**
	 * Sets the animeteo small img local service.
	 *
	 * @param animeteoSmallImgLocalService the animeteo small img local service
	 */
	public void setAnimeteoSmallImgLocalService(
		AnimeteoSmallImgLocalService animeteoSmallImgLocalService) {

		this.animeteoSmallImgLocalService = animeteoSmallImgLocalService;
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
		persistedModelLocalServiceRegistry.register(
			"it.eng.animaeteo.model.AnimeteoSmallImg",
			animeteoSmallImgLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"it.eng.animaeteo.model.AnimeteoSmallImg");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AnimeteoSmallImgLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AnimeteoSmallImg.class;
	}

	protected String getModelClassName() {
		return AnimeteoSmallImg.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = animeteoSmallImgPersistence.getDataSource();

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

	@BeanReference(type = AnimeteoImgPersistence.class)
	protected AnimeteoImgPersistence animeteoImgPersistence;

	@BeanReference(type = AnimeteoSmallImgLocalService.class)
	protected AnimeteoSmallImgLocalService animeteoSmallImgLocalService;

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

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}