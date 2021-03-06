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

package it.eng.allerter.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
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

import it.eng.allerter.model.TipoEvento;
import it.eng.allerter.service.TipoEventoLocalService;
import it.eng.allerter.service.persistence.AllertaFinder;
import it.eng.allerter.service.persistence.AllertaParametroPersistence;
import it.eng.allerter.service.persistence.AllertaPersistence;
import it.eng.allerter.service.persistence.AllertaStatoPersistence;
import it.eng.allerter.service.persistence.AreaPersistence;
import it.eng.allerter.service.persistence.EmailPersistence;
import it.eng.allerter.service.persistence.FeedPersistence;
import it.eng.allerter.service.persistence.GeografiaPersistence;
import it.eng.allerter.service.persistence.LogInternoPersistence;
import it.eng.allerter.service.persistence.SMSFinder;
import it.eng.allerter.service.persistence.SMSPersistence;
import it.eng.allerter.service.persistence.StatoAllertamentoPersistence;
import it.eng.allerter.service.persistence.TipoEventoPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the tipo evento local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link it.eng.allerter.service.impl.TipoEventoLocalServiceImpl}.
 * </p>
 *
 * @author GFAVINI
 * @see it.eng.allerter.service.impl.TipoEventoLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class TipoEventoLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements TipoEventoLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>TipoEventoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.eng.allerter.service.TipoEventoLocalServiceUtil</code>.
	 */

	/**
	 * Adds the tipo evento to the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipoEvento the tipo evento
	 * @return the tipo evento that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TipoEvento addTipoEvento(TipoEvento tipoEvento) {
		tipoEvento.setNew(true);

		return tipoEventoPersistence.update(tipoEvento);
	}

	/**
	 * Creates a new tipo evento with the primary key. Does not add the tipo evento to the database.
	 *
	 * @param eventoId the primary key for the new tipo evento
	 * @return the new tipo evento
	 */
	@Override
	@Transactional(enabled = false)
	public TipoEvento createTipoEvento(long eventoId) {
		return tipoEventoPersistence.create(eventoId);
	}

	/**
	 * Deletes the tipo evento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventoId the primary key of the tipo evento
	 * @return the tipo evento that was removed
	 * @throws PortalException if a tipo evento with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TipoEvento deleteTipoEvento(long eventoId) throws PortalException {
		return tipoEventoPersistence.remove(eventoId);
	}

	/**
	 * Deletes the tipo evento from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tipoEvento the tipo evento
	 * @return the tipo evento that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public TipoEvento deleteTipoEvento(TipoEvento tipoEvento) {
		return tipoEventoPersistence.remove(tipoEvento);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			TipoEvento.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return tipoEventoPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return tipoEventoPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return tipoEventoPersistence.findWithDynamicQuery(
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
		return tipoEventoPersistence.countWithDynamicQuery(dynamicQuery);
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

		return tipoEventoPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public TipoEvento fetchTipoEvento(long eventoId) {
		return tipoEventoPersistence.fetchByPrimaryKey(eventoId);
	}

	/**
	 * Returns the tipo evento matching the UUID and group.
	 *
	 * @param uuid the tipo evento's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tipo evento, or <code>null</code> if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento fetchTipoEventoByUuidAndGroupId(
		String uuid, long groupId) {

		return tipoEventoPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the tipo evento with the primary key.
	 *
	 * @param eventoId the primary key of the tipo evento
	 * @return the tipo evento
	 * @throws PortalException if a tipo evento with the primary key could not be found
	 */
	@Override
	public TipoEvento getTipoEvento(long eventoId) throws PortalException {
		return tipoEventoPersistence.findByPrimaryKey(eventoId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(tipoEventoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TipoEvento.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("eventoId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			tipoEventoLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(TipoEvento.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("eventoId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(tipoEventoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(TipoEvento.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("eventoId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<TipoEvento>() {

				@Override
				public void performAction(TipoEvento tipoEvento)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, tipoEvento);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(TipoEvento.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return tipoEventoLocalService.deleteTipoEvento(
			(TipoEvento)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return tipoEventoPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the tipo eventos matching the UUID and company.
	 *
	 * @param uuid the UUID of the tipo eventos
	 * @param companyId the primary key of the company
	 * @return the matching tipo eventos, or an empty list if no matches were found
	 */
	@Override
	public List<TipoEvento> getTipoEventosByUuidAndCompanyId(
		String uuid, long companyId) {

		return tipoEventoPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of tipo eventos matching the UUID and company.
	 *
	 * @param uuid the UUID of the tipo eventos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching tipo eventos, or an empty list if no matches were found
	 */
	@Override
	public List<TipoEvento> getTipoEventosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TipoEvento> orderByComparator) {

		return tipoEventoPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the tipo evento matching the UUID and group.
	 *
	 * @param uuid the tipo evento's UUID
	 * @param groupId the primary key of the group
	 * @return the matching tipo evento
	 * @throws PortalException if a matching tipo evento could not be found
	 */
	@Override
	public TipoEvento getTipoEventoByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return tipoEventoPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the tipo eventos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>it.eng.allerter.model.impl.TipoEventoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo eventos
	 * @param end the upper bound of the range of tipo eventos (not inclusive)
	 * @return the range of tipo eventos
	 */
	@Override
	public List<TipoEvento> getTipoEventos(int start, int end) {
		return tipoEventoPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of tipo eventos.
	 *
	 * @return the number of tipo eventos
	 */
	@Override
	public int getTipoEventosCount() {
		return tipoEventoPersistence.countAll();
	}

	/**
	 * Updates the tipo evento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param tipoEvento the tipo evento
	 * @return the tipo evento that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public TipoEvento updateTipoEvento(TipoEvento tipoEvento) {
		return tipoEventoPersistence.update(tipoEvento);
	}

	/**
	 * Returns the allerta local service.
	 *
	 * @return the allerta local service
	 */
	public it.eng.allerter.service.AllertaLocalService
		getAllertaLocalService() {

		return allertaLocalService;
	}

	/**
	 * Sets the allerta local service.
	 *
	 * @param allertaLocalService the allerta local service
	 */
	public void setAllertaLocalService(
		it.eng.allerter.service.AllertaLocalService allertaLocalService) {

		this.allertaLocalService = allertaLocalService;
	}

	/**
	 * Returns the allerta persistence.
	 *
	 * @return the allerta persistence
	 */
	public AllertaPersistence getAllertaPersistence() {
		return allertaPersistence;
	}

	/**
	 * Sets the allerta persistence.
	 *
	 * @param allertaPersistence the allerta persistence
	 */
	public void setAllertaPersistence(AllertaPersistence allertaPersistence) {
		this.allertaPersistence = allertaPersistence;
	}

	/**
	 * Returns the allerta finder.
	 *
	 * @return the allerta finder
	 */
	public AllertaFinder getAllertaFinder() {
		return allertaFinder;
	}

	/**
	 * Sets the allerta finder.
	 *
	 * @param allertaFinder the allerta finder
	 */
	public void setAllertaFinder(AllertaFinder allertaFinder) {
		this.allertaFinder = allertaFinder;
	}

	/**
	 * Returns the allerta parametro local service.
	 *
	 * @return the allerta parametro local service
	 */
	public it.eng.allerter.service.AllertaParametroLocalService
		getAllertaParametroLocalService() {

		return allertaParametroLocalService;
	}

	/**
	 * Sets the allerta parametro local service.
	 *
	 * @param allertaParametroLocalService the allerta parametro local service
	 */
	public void setAllertaParametroLocalService(
		it.eng.allerter.service.AllertaParametroLocalService
			allertaParametroLocalService) {

		this.allertaParametroLocalService = allertaParametroLocalService;
	}

	/**
	 * Returns the allerta parametro persistence.
	 *
	 * @return the allerta parametro persistence
	 */
	public AllertaParametroPersistence getAllertaParametroPersistence() {
		return allertaParametroPersistence;
	}

	/**
	 * Sets the allerta parametro persistence.
	 *
	 * @param allertaParametroPersistence the allerta parametro persistence
	 */
	public void setAllertaParametroPersistence(
		AllertaParametroPersistence allertaParametroPersistence) {

		this.allertaParametroPersistence = allertaParametroPersistence;
	}

	/**
	 * Returns the allerta stato local service.
	 *
	 * @return the allerta stato local service
	 */
	public it.eng.allerter.service.AllertaStatoLocalService
		getAllertaStatoLocalService() {

		return allertaStatoLocalService;
	}

	/**
	 * Sets the allerta stato local service.
	 *
	 * @param allertaStatoLocalService the allerta stato local service
	 */
	public void setAllertaStatoLocalService(
		it.eng.allerter.service.AllertaStatoLocalService
			allertaStatoLocalService) {

		this.allertaStatoLocalService = allertaStatoLocalService;
	}

	/**
	 * Returns the allerta stato persistence.
	 *
	 * @return the allerta stato persistence
	 */
	public AllertaStatoPersistence getAllertaStatoPersistence() {
		return allertaStatoPersistence;
	}

	/**
	 * Sets the allerta stato persistence.
	 *
	 * @param allertaStatoPersistence the allerta stato persistence
	 */
	public void setAllertaStatoPersistence(
		AllertaStatoPersistence allertaStatoPersistence) {

		this.allertaStatoPersistence = allertaStatoPersistence;
	}

	/**
	 * Returns the area local service.
	 *
	 * @return the area local service
	 */
	public it.eng.allerter.service.AreaLocalService getAreaLocalService() {
		return areaLocalService;
	}

	/**
	 * Sets the area local service.
	 *
	 * @param areaLocalService the area local service
	 */
	public void setAreaLocalService(
		it.eng.allerter.service.AreaLocalService areaLocalService) {

		this.areaLocalService = areaLocalService;
	}

	/**
	 * Returns the area persistence.
	 *
	 * @return the area persistence
	 */
	public AreaPersistence getAreaPersistence() {
		return areaPersistence;
	}

	/**
	 * Sets the area persistence.
	 *
	 * @param areaPersistence the area persistence
	 */
	public void setAreaPersistence(AreaPersistence areaPersistence) {
		this.areaPersistence = areaPersistence;
	}

	/**
	 * Returns the email local service.
	 *
	 * @return the email local service
	 */
	public it.eng.allerter.service.EmailLocalService getEmailLocalService() {
		return emailLocalService;
	}

	/**
	 * Sets the email local service.
	 *
	 * @param emailLocalService the email local service
	 */
	public void setEmailLocalService(
		it.eng.allerter.service.EmailLocalService emailLocalService) {

		this.emailLocalService = emailLocalService;
	}

	/**
	 * Returns the email persistence.
	 *
	 * @return the email persistence
	 */
	public EmailPersistence getEmailPersistence() {
		return emailPersistence;
	}

	/**
	 * Sets the email persistence.
	 *
	 * @param emailPersistence the email persistence
	 */
	public void setEmailPersistence(EmailPersistence emailPersistence) {
		this.emailPersistence = emailPersistence;
	}

	/**
	 * Returns the feed local service.
	 *
	 * @return the feed local service
	 */
	public it.eng.allerter.service.FeedLocalService getFeedLocalService() {
		return feedLocalService;
	}

	/**
	 * Sets the feed local service.
	 *
	 * @param feedLocalService the feed local service
	 */
	public void setFeedLocalService(
		it.eng.allerter.service.FeedLocalService feedLocalService) {

		this.feedLocalService = feedLocalService;
	}

	/**
	 * Returns the feed persistence.
	 *
	 * @return the feed persistence
	 */
	public FeedPersistence getFeedPersistence() {
		return feedPersistence;
	}

	/**
	 * Sets the feed persistence.
	 *
	 * @param feedPersistence the feed persistence
	 */
	public void setFeedPersistence(FeedPersistence feedPersistence) {
		this.feedPersistence = feedPersistence;
	}

	/**
	 * Returns the geografia local service.
	 *
	 * @return the geografia local service
	 */
	public it.eng.allerter.service.GeografiaLocalService
		getGeografiaLocalService() {

		return geografiaLocalService;
	}

	/**
	 * Sets the geografia local service.
	 *
	 * @param geografiaLocalService the geografia local service
	 */
	public void setGeografiaLocalService(
		it.eng.allerter.service.GeografiaLocalService geografiaLocalService) {

		this.geografiaLocalService = geografiaLocalService;
	}

	/**
	 * Returns the geografia persistence.
	 *
	 * @return the geografia persistence
	 */
	public GeografiaPersistence getGeografiaPersistence() {
		return geografiaPersistence;
	}

	/**
	 * Sets the geografia persistence.
	 *
	 * @param geografiaPersistence the geografia persistence
	 */
	public void setGeografiaPersistence(
		GeografiaPersistence geografiaPersistence) {

		this.geografiaPersistence = geografiaPersistence;
	}

	/**
	 * Returns the log interno local service.
	 *
	 * @return the log interno local service
	 */
	public it.eng.allerter.service.LogInternoLocalService
		getLogInternoLocalService() {

		return logInternoLocalService;
	}

	/**
	 * Sets the log interno local service.
	 *
	 * @param logInternoLocalService the log interno local service
	 */
	public void setLogInternoLocalService(
		it.eng.allerter.service.LogInternoLocalService logInternoLocalService) {

		this.logInternoLocalService = logInternoLocalService;
	}

	/**
	 * Returns the log interno persistence.
	 *
	 * @return the log interno persistence
	 */
	public LogInternoPersistence getLogInternoPersistence() {
		return logInternoPersistence;
	}

	/**
	 * Sets the log interno persistence.
	 *
	 * @param logInternoPersistence the log interno persistence
	 */
	public void setLogInternoPersistence(
		LogInternoPersistence logInternoPersistence) {

		this.logInternoPersistence = logInternoPersistence;
	}

	/**
	 * Returns the sms local service.
	 *
	 * @return the sms local service
	 */
	public it.eng.allerter.service.SMSLocalService getSMSLocalService() {
		return smsLocalService;
	}

	/**
	 * Sets the sms local service.
	 *
	 * @param smsLocalService the sms local service
	 */
	public void setSMSLocalService(
		it.eng.allerter.service.SMSLocalService smsLocalService) {

		this.smsLocalService = smsLocalService;
	}

	/**
	 * Returns the sms persistence.
	 *
	 * @return the sms persistence
	 */
	public SMSPersistence getSMSPersistence() {
		return smsPersistence;
	}

	/**
	 * Sets the sms persistence.
	 *
	 * @param smsPersistence the sms persistence
	 */
	public void setSMSPersistence(SMSPersistence smsPersistence) {
		this.smsPersistence = smsPersistence;
	}

	/**
	 * Returns the sms finder.
	 *
	 * @return the sms finder
	 */
	public SMSFinder getSMSFinder() {
		return smsFinder;
	}

	/**
	 * Sets the sms finder.
	 *
	 * @param smsFinder the sms finder
	 */
	public void setSMSFinder(SMSFinder smsFinder) {
		this.smsFinder = smsFinder;
	}

	/**
	 * Returns the stato allertamento local service.
	 *
	 * @return the stato allertamento local service
	 */
	public it.eng.allerter.service.StatoAllertamentoLocalService
		getStatoAllertamentoLocalService() {

		return statoAllertamentoLocalService;
	}

	/**
	 * Sets the stato allertamento local service.
	 *
	 * @param statoAllertamentoLocalService the stato allertamento local service
	 */
	public void setStatoAllertamentoLocalService(
		it.eng.allerter.service.StatoAllertamentoLocalService
			statoAllertamentoLocalService) {

		this.statoAllertamentoLocalService = statoAllertamentoLocalService;
	}

	/**
	 * Returns the stato allertamento persistence.
	 *
	 * @return the stato allertamento persistence
	 */
	public StatoAllertamentoPersistence getStatoAllertamentoPersistence() {
		return statoAllertamentoPersistence;
	}

	/**
	 * Sets the stato allertamento persistence.
	 *
	 * @param statoAllertamentoPersistence the stato allertamento persistence
	 */
	public void setStatoAllertamentoPersistence(
		StatoAllertamentoPersistence statoAllertamentoPersistence) {

		this.statoAllertamentoPersistence = statoAllertamentoPersistence;
	}

	/**
	 * Returns the tipo evento local service.
	 *
	 * @return the tipo evento local service
	 */
	public TipoEventoLocalService getTipoEventoLocalService() {
		return tipoEventoLocalService;
	}

	/**
	 * Sets the tipo evento local service.
	 *
	 * @param tipoEventoLocalService the tipo evento local service
	 */
	public void setTipoEventoLocalService(
		TipoEventoLocalService tipoEventoLocalService) {

		this.tipoEventoLocalService = tipoEventoLocalService;
	}

	/**
	 * Returns the tipo evento persistence.
	 *
	 * @return the tipo evento persistence
	 */
	public TipoEventoPersistence getTipoEventoPersistence() {
		return tipoEventoPersistence;
	}

	/**
	 * Sets the tipo evento persistence.
	 *
	 * @param tipoEventoPersistence the tipo evento persistence
	 */
	public void setTipoEventoPersistence(
		TipoEventoPersistence tipoEventoPersistence) {

		this.tipoEventoPersistence = tipoEventoPersistence;
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
			"it.eng.allerter.model.TipoEvento", tipoEventoLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"it.eng.allerter.model.TipoEvento");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TipoEventoLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return TipoEvento.class;
	}

	protected String getModelClassName() {
		return TipoEvento.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = tipoEventoPersistence.getDataSource();

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

	@BeanReference(type = it.eng.allerter.service.AllertaLocalService.class)
	protected it.eng.allerter.service.AllertaLocalService allertaLocalService;

	@BeanReference(type = AllertaPersistence.class)
	protected AllertaPersistence allertaPersistence;

	@BeanReference(type = AllertaFinder.class)
	protected AllertaFinder allertaFinder;

	@BeanReference(
		type = it.eng.allerter.service.AllertaParametroLocalService.class
	)
	protected it.eng.allerter.service.AllertaParametroLocalService
		allertaParametroLocalService;

	@BeanReference(type = AllertaParametroPersistence.class)
	protected AllertaParametroPersistence allertaParametroPersistence;

	@BeanReference(
		type = it.eng.allerter.service.AllertaStatoLocalService.class
	)
	protected it.eng.allerter.service.AllertaStatoLocalService
		allertaStatoLocalService;

	@BeanReference(type = AllertaStatoPersistence.class)
	protected AllertaStatoPersistence allertaStatoPersistence;

	@BeanReference(type = it.eng.allerter.service.AreaLocalService.class)
	protected it.eng.allerter.service.AreaLocalService areaLocalService;

	@BeanReference(type = AreaPersistence.class)
	protected AreaPersistence areaPersistence;

	@BeanReference(type = it.eng.allerter.service.EmailLocalService.class)
	protected it.eng.allerter.service.EmailLocalService emailLocalService;

	@BeanReference(type = EmailPersistence.class)
	protected EmailPersistence emailPersistence;

	@BeanReference(type = it.eng.allerter.service.FeedLocalService.class)
	protected it.eng.allerter.service.FeedLocalService feedLocalService;

	@BeanReference(type = FeedPersistence.class)
	protected FeedPersistence feedPersistence;

	@BeanReference(type = it.eng.allerter.service.GeografiaLocalService.class)
	protected it.eng.allerter.service.GeografiaLocalService
		geografiaLocalService;

	@BeanReference(type = GeografiaPersistence.class)
	protected GeografiaPersistence geografiaPersistence;

	@BeanReference(type = it.eng.allerter.service.LogInternoLocalService.class)
	protected it.eng.allerter.service.LogInternoLocalService
		logInternoLocalService;

	@BeanReference(type = LogInternoPersistence.class)
	protected LogInternoPersistence logInternoPersistence;

	@BeanReference(type = it.eng.allerter.service.SMSLocalService.class)
	protected it.eng.allerter.service.SMSLocalService smsLocalService;

	@BeanReference(type = SMSPersistence.class)
	protected SMSPersistence smsPersistence;

	@BeanReference(type = SMSFinder.class)
	protected SMSFinder smsFinder;

	@BeanReference(
		type = it.eng.allerter.service.StatoAllertamentoLocalService.class
	)
	protected it.eng.allerter.service.StatoAllertamentoLocalService
		statoAllertamentoLocalService;

	@BeanReference(type = StatoAllertamentoPersistence.class)
	protected StatoAllertamentoPersistence statoAllertamentoPersistence;

	@BeanReference(type = TipoEventoLocalService.class)
	protected TipoEventoLocalService tipoEventoLocalService;

	@BeanReference(type = TipoEventoPersistence.class)
	protected TipoEventoPersistence tipoEventoPersistence;

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