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

package it.eng.allerter.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.allerter.model.TipoEvento;
import it.eng.allerter.model.TipoEventoModel;
import it.eng.allerter.model.TipoEventoSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the TipoEvento service. Represents a row in the &quot;ALLERTER_TipoEvento&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>TipoEventoModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TipoEventoImpl}.
 * </p>
 *
 * @author GFAVINI
 * @see TipoEventoImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TipoEventoModelImpl
	extends BaseModelImpl<TipoEvento> implements TipoEventoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tipo evento model instance should use the <code>TipoEvento</code> interface instead.
	 */
	public static final String TABLE_NAME = "ALLERTER_TipoEvento";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"eventoId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"nome", Types.VARCHAR}, {"indice", Types.INTEGER},
		{"tabella", Types.INTEGER}, {"split", Types.BOOLEAN},
		{"costiero", Types.BOOLEAN}, {"dataInizio", Types.TIMESTAMP},
		{"dataFine", Types.TIMESTAMP}, {"parentId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("eventoId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("nome", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("indice", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("tabella", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("split", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("costiero", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("dataInizio", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("dataFine", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("parentId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ALLERTER_TipoEvento (uuid_ VARCHAR(75) null,eventoId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,nome VARCHAR(75) null,indice INTEGER,tabella INTEGER,split BOOLEAN,costiero BOOLEAN,dataInizio DATE null,dataFine DATE null,parentId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table ALLERTER_TipoEvento";

	public static final String ORDER_BY_JPQL =
		" ORDER BY tipoEvento.indice ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ALLERTER_TipoEvento.indice ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		it.eng.allertaer.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.it.eng.allerter.model.TipoEvento"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		it.eng.allertaer.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.it.eng.allerter.model.TipoEvento"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		it.eng.allertaer.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.it.eng.allerter.model.TipoEvento"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long NOME_COLUMN_BITMASK = 4L;

	public static final long TABELLA_COLUMN_BITMASK = 8L;

	public static final long UUID_COLUMN_BITMASK = 16L;

	public static final long INDICE_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static TipoEvento toModel(TipoEventoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TipoEvento model = new TipoEventoImpl();

		model.setUuid(soapModel.getUuid());
		model.setEventoId(soapModel.getEventoId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setNome(soapModel.getNome());
		model.setIndice(soapModel.getIndice());
		model.setTabella(soapModel.getTabella());
		model.setSplit(soapModel.isSplit());
		model.setCostiero(soapModel.isCostiero());
		model.setDataInizio(soapModel.getDataInizio());
		model.setDataFine(soapModel.getDataFine());
		model.setParentId(soapModel.getParentId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TipoEvento> toModels(TipoEventoSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TipoEvento> models = new ArrayList<TipoEvento>(soapModels.length);

		for (TipoEventoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		it.eng.allertaer.service.util.ServiceProps.get(
			"lock.expiration.time.it.eng.allerter.model.TipoEvento"));

	public TipoEventoModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _eventoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEventoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TipoEvento.class;
	}

	@Override
	public String getModelClassName() {
		return TipoEvento.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TipoEvento, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TipoEvento, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TipoEvento, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((TipoEvento)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TipoEvento, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TipoEvento, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TipoEvento)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TipoEvento, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TipoEvento, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<TipoEvento, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TipoEvento, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TipoEvento, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<TipoEvento, Object>>();
		Map<String, BiConsumer<TipoEvento, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<TipoEvento, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<TipoEvento, Object>() {

				@Override
				public Object apply(TipoEvento tipoEvento) {
					return tipoEvento.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<TipoEvento, Object>() {

				@Override
				public void accept(TipoEvento tipoEvento, Object uuid) {
					tipoEvento.setUuid((String)uuid);
				}

			});
		attributeGetterFunctions.put(
			"eventoId",
			new Function<TipoEvento, Object>() {

				@Override
				public Object apply(TipoEvento tipoEvento) {
					return tipoEvento.getEventoId();
				}

			});
		attributeSetterBiConsumers.put(
			"eventoId",
			new BiConsumer<TipoEvento, Object>() {

				@Override
				public void accept(TipoEvento tipoEvento, Object eventoId) {
					tipoEvento.setEventoId((Long)eventoId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<TipoEvento, Object>() {

				@Override
				public Object apply(TipoEvento tipoEvento) {
					return tipoEvento.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<TipoEvento, Object>() {

				@Override
				public void accept(TipoEvento tipoEvento, Object groupId) {
					tipoEvento.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<TipoEvento, Object>() {

				@Override
				public Object apply(TipoEvento tipoEvento) {
					return tipoEvento.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<TipoEvento, Object>() {

				@Override
				public void accept(TipoEvento tipoEvento, Object companyId) {
					tipoEvento.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<TipoEvento, Object>() {

				@Override
				public Object apply(TipoEvento tipoEvento) {
					return tipoEvento.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<TipoEvento, Object>() {

				@Override
				public void accept(TipoEvento tipoEvento, Object userId) {
					tipoEvento.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<TipoEvento, Object>() {

				@Override
				public Object apply(TipoEvento tipoEvento) {
					return tipoEvento.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<TipoEvento, Object>() {

				@Override
				public void accept(TipoEvento tipoEvento, Object userName) {
					tipoEvento.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<TipoEvento, Object>() {

				@Override
				public Object apply(TipoEvento tipoEvento) {
					return tipoEvento.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<TipoEvento, Object>() {

				@Override
				public void accept(TipoEvento tipoEvento, Object createDate) {
					tipoEvento.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<TipoEvento, Object>() {

				@Override
				public Object apply(TipoEvento tipoEvento) {
					return tipoEvento.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<TipoEvento, Object>() {

				@Override
				public void accept(TipoEvento tipoEvento, Object modifiedDate) {
					tipoEvento.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"nome",
			new Function<TipoEvento, Object>() {

				@Override
				public Object apply(TipoEvento tipoEvento) {
					return tipoEvento.getNome();
				}

			});
		attributeSetterBiConsumers.put(
			"nome",
			new BiConsumer<TipoEvento, Object>() {

				@Override
				public void accept(TipoEvento tipoEvento, Object nome) {
					tipoEvento.setNome((String)nome);
				}

			});
		attributeGetterFunctions.put(
			"indice",
			new Function<TipoEvento, Object>() {

				@Override
				public Object apply(TipoEvento tipoEvento) {
					return tipoEvento.getIndice();
				}

			});
		attributeSetterBiConsumers.put(
			"indice",
			new BiConsumer<TipoEvento, Object>() {

				@Override
				public void accept(TipoEvento tipoEvento, Object indice) {
					tipoEvento.setIndice((Integer)indice);
				}

			});
		attributeGetterFunctions.put(
			"tabella",
			new Function<TipoEvento, Object>() {

				@Override
				public Object apply(TipoEvento tipoEvento) {
					return tipoEvento.getTabella();
				}

			});
		attributeSetterBiConsumers.put(
			"tabella",
			new BiConsumer<TipoEvento, Object>() {

				@Override
				public void accept(TipoEvento tipoEvento, Object tabella) {
					tipoEvento.setTabella((Integer)tabella);
				}

			});
		attributeGetterFunctions.put(
			"split",
			new Function<TipoEvento, Object>() {

				@Override
				public Object apply(TipoEvento tipoEvento) {
					return tipoEvento.getSplit();
				}

			});
		attributeSetterBiConsumers.put(
			"split",
			new BiConsumer<TipoEvento, Object>() {

				@Override
				public void accept(TipoEvento tipoEvento, Object split) {
					tipoEvento.setSplit((Boolean)split);
				}

			});
		attributeGetterFunctions.put(
			"costiero",
			new Function<TipoEvento, Object>() {

				@Override
				public Object apply(TipoEvento tipoEvento) {
					return tipoEvento.getCostiero();
				}

			});
		attributeSetterBiConsumers.put(
			"costiero",
			new BiConsumer<TipoEvento, Object>() {

				@Override
				public void accept(TipoEvento tipoEvento, Object costiero) {
					tipoEvento.setCostiero((Boolean)costiero);
				}

			});
		attributeGetterFunctions.put(
			"dataInizio",
			new Function<TipoEvento, Object>() {

				@Override
				public Object apply(TipoEvento tipoEvento) {
					return tipoEvento.getDataInizio();
				}

			});
		attributeSetterBiConsumers.put(
			"dataInizio",
			new BiConsumer<TipoEvento, Object>() {

				@Override
				public void accept(TipoEvento tipoEvento, Object dataInizio) {
					tipoEvento.setDataInizio((Date)dataInizio);
				}

			});
		attributeGetterFunctions.put(
			"dataFine",
			new Function<TipoEvento, Object>() {

				@Override
				public Object apply(TipoEvento tipoEvento) {
					return tipoEvento.getDataFine();
				}

			});
		attributeSetterBiConsumers.put(
			"dataFine",
			new BiConsumer<TipoEvento, Object>() {

				@Override
				public void accept(TipoEvento tipoEvento, Object dataFine) {
					tipoEvento.setDataFine((Date)dataFine);
				}

			});
		attributeGetterFunctions.put(
			"parentId",
			new Function<TipoEvento, Object>() {

				@Override
				public Object apply(TipoEvento tipoEvento) {
					return tipoEvento.getParentId();
				}

			});
		attributeSetterBiConsumers.put(
			"parentId",
			new BiConsumer<TipoEvento, Object>() {

				@Override
				public void accept(TipoEvento tipoEvento, Object parentId) {
					tipoEvento.setParentId((Long)parentId);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getEventoId() {
		return _eventoId;
	}

	@Override
	public void setEventoId(long eventoId) {
		_eventoId = eventoId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getNome() {
		if (_nome == null) {
			return "";
		}
		else {
			return _nome;
		}
	}

	@Override
	public void setNome(String nome) {
		_columnBitmask |= NOME_COLUMN_BITMASK;

		if (_originalNome == null) {
			_originalNome = _nome;
		}

		_nome = nome;
	}

	public String getOriginalNome() {
		return GetterUtil.getString(_originalNome);
	}

	@JSON
	@Override
	public int getIndice() {
		return _indice;
	}

	@Override
	public void setIndice(int indice) {
		_columnBitmask = -1L;

		_indice = indice;
	}

	@JSON
	@Override
	public int getTabella() {
		return _tabella;
	}

	@Override
	public void setTabella(int tabella) {
		_columnBitmask |= TABELLA_COLUMN_BITMASK;

		if (!_setOriginalTabella) {
			_setOriginalTabella = true;

			_originalTabella = _tabella;
		}

		_tabella = tabella;
	}

	public int getOriginalTabella() {
		return _originalTabella;
	}

	@JSON
	@Override
	public boolean getSplit() {
		return _split;
	}

	@JSON
	@Override
	public boolean isSplit() {
		return _split;
	}

	@Override
	public void setSplit(boolean split) {
		_split = split;
	}

	@JSON
	@Override
	public boolean getCostiero() {
		return _costiero;
	}

	@JSON
	@Override
	public boolean isCostiero() {
		return _costiero;
	}

	@Override
	public void setCostiero(boolean costiero) {
		_costiero = costiero;
	}

	@JSON
	@Override
	public Date getDataInizio() {
		return _dataInizio;
	}

	@Override
	public void setDataInizio(Date dataInizio) {
		_dataInizio = dataInizio;
	}

	@JSON
	@Override
	public Date getDataFine() {
		return _dataFine;
	}

	@Override
	public void setDataFine(Date dataFine) {
		_dataFine = dataFine;
	}

	@JSON
	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(TipoEvento.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), TipoEvento.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TipoEvento toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TipoEvento)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TipoEventoImpl tipoEventoImpl = new TipoEventoImpl();

		tipoEventoImpl.setUuid(getUuid());
		tipoEventoImpl.setEventoId(getEventoId());
		tipoEventoImpl.setGroupId(getGroupId());
		tipoEventoImpl.setCompanyId(getCompanyId());
		tipoEventoImpl.setUserId(getUserId());
		tipoEventoImpl.setUserName(getUserName());
		tipoEventoImpl.setCreateDate(getCreateDate());
		tipoEventoImpl.setModifiedDate(getModifiedDate());
		tipoEventoImpl.setNome(getNome());
		tipoEventoImpl.setIndice(getIndice());
		tipoEventoImpl.setTabella(getTabella());
		tipoEventoImpl.setSplit(isSplit());
		tipoEventoImpl.setCostiero(isCostiero());
		tipoEventoImpl.setDataInizio(getDataInizio());
		tipoEventoImpl.setDataFine(getDataFine());
		tipoEventoImpl.setParentId(getParentId());

		tipoEventoImpl.resetOriginalValues();

		return tipoEventoImpl;
	}

	@Override
	public int compareTo(TipoEvento tipoEvento) {
		int value = 0;

		if (getIndice() < tipoEvento.getIndice()) {
			value = -1;
		}
		else if (getIndice() > tipoEvento.getIndice()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TipoEvento)) {
			return false;
		}

		TipoEvento tipoEvento = (TipoEvento)obj;

		long primaryKey = tipoEvento.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		TipoEventoModelImpl tipoEventoModelImpl = this;

		tipoEventoModelImpl._originalUuid = tipoEventoModelImpl._uuid;

		tipoEventoModelImpl._originalGroupId = tipoEventoModelImpl._groupId;

		tipoEventoModelImpl._setOriginalGroupId = false;

		tipoEventoModelImpl._originalCompanyId = tipoEventoModelImpl._companyId;

		tipoEventoModelImpl._setOriginalCompanyId = false;

		tipoEventoModelImpl._setModifiedDate = false;

		tipoEventoModelImpl._originalNome = tipoEventoModelImpl._nome;

		tipoEventoModelImpl._originalTabella = tipoEventoModelImpl._tabella;

		tipoEventoModelImpl._setOriginalTabella = false;

		tipoEventoModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TipoEvento> toCacheModel() {
		TipoEventoCacheModel tipoEventoCacheModel = new TipoEventoCacheModel();

		tipoEventoCacheModel.uuid = getUuid();

		String uuid = tipoEventoCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			tipoEventoCacheModel.uuid = null;
		}

		tipoEventoCacheModel.eventoId = getEventoId();

		tipoEventoCacheModel.groupId = getGroupId();

		tipoEventoCacheModel.companyId = getCompanyId();

		tipoEventoCacheModel.userId = getUserId();

		tipoEventoCacheModel.userName = getUserName();

		String userName = tipoEventoCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			tipoEventoCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			tipoEventoCacheModel.createDate = createDate.getTime();
		}
		else {
			tipoEventoCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			tipoEventoCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			tipoEventoCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		tipoEventoCacheModel.nome = getNome();

		String nome = tipoEventoCacheModel.nome;

		if ((nome != null) && (nome.length() == 0)) {
			tipoEventoCacheModel.nome = null;
		}

		tipoEventoCacheModel.indice = getIndice();

		tipoEventoCacheModel.tabella = getTabella();

		tipoEventoCacheModel.split = isSplit();

		tipoEventoCacheModel.costiero = isCostiero();

		Date dataInizio = getDataInizio();

		if (dataInizio != null) {
			tipoEventoCacheModel.dataInizio = dataInizio.getTime();
		}
		else {
			tipoEventoCacheModel.dataInizio = Long.MIN_VALUE;
		}

		Date dataFine = getDataFine();

		if (dataFine != null) {
			tipoEventoCacheModel.dataFine = dataFine.getTime();
		}
		else {
			tipoEventoCacheModel.dataFine = Long.MIN_VALUE;
		}

		tipoEventoCacheModel.parentId = getParentId();

		return tipoEventoCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TipoEvento, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TipoEvento, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TipoEvento, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((TipoEvento)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<TipoEvento, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TipoEvento, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TipoEvento, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TipoEvento)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		TipoEvento.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		TipoEvento.class, ModelWrapper.class
	};

	private String _uuid;
	private String _originalUuid;
	private long _eventoId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _nome;
	private String _originalNome;
	private int _indice;
	private int _tabella;
	private int _originalTabella;
	private boolean _setOriginalTabella;
	private boolean _split;
	private boolean _costiero;
	private Date _dataInizio;
	private Date _dataFine;
	private long _parentId;
	private long _columnBitmask;
	private TipoEvento _escapedModel;

}