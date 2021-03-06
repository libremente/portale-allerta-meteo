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

package it.eng.bollettino.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.bollettino.model.Bacino;
import it.eng.bollettino.model.BacinoModel;
import it.eng.bollettino.model.BacinoSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Bacino service. Represents a row in the &quot;BOLLETTINO_Bacino&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>BacinoModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BacinoImpl}.
 * </p>
 *
 * @author GFAVINI
 * @see BacinoImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class BacinoModelImpl
	extends BaseModelImpl<Bacino> implements BacinoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a bacino model instance should use the <code>Bacino</code> interface instead.
	 */
	public static final String TABLE_NAME = "BOLLETTINO_Bacino";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"id_", Types.VARCHAR},
		{"nome", Types.VARCHAR}, {"progressivo", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("id_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nome", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("progressivo", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table BOLLETTINO_Bacino (uuid_ VARCHAR(75) null,id_ VARCHAR(75) not null primary key,nome VARCHAR(75) null,progressivo INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table BOLLETTINO_Bacino";

	public static final String ORDER_BY_JPQL =
		" ORDER BY bacino.progressivo ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY BOLLETTINO_Bacino.progressivo ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		allerta.bollettino.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.it.eng.bollettino.model.Bacino"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		allerta.bollettino.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.it.eng.bollettino.model.Bacino"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		allerta.bollettino.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.it.eng.bollettino.model.Bacino"),
		true);

	public static final long UUID_COLUMN_BITMASK = 1L;

	public static final long PROGRESSIVO_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Bacino toModel(BacinoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Bacino model = new BacinoImpl();

		model.setUuid(soapModel.getUuid());
		model.setId(soapModel.getId());
		model.setNome(soapModel.getNome());
		model.setProgressivo(soapModel.getProgressivo());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Bacino> toModels(BacinoSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Bacino> models = new ArrayList<Bacino>(soapModels.length);

		for (BacinoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		allerta.bollettino.service.util.ServiceProps.get(
			"lock.expiration.time.it.eng.bollettino.model.Bacino"));

	public BacinoModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Bacino.class;
	}

	@Override
	public String getModelClassName() {
		return Bacino.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Bacino, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Bacino, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Bacino, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Bacino)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Bacino, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Bacino, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Bacino)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Bacino, Object>> getAttributeGetterFunctions() {
		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Bacino, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Bacino, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Bacino, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Bacino, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Bacino, Object>>();
		Map<String, BiConsumer<Bacino, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Bacino, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<Bacino, Object>() {

				@Override
				public Object apply(Bacino bacino) {
					return bacino.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<Bacino, Object>() {

				@Override
				public void accept(Bacino bacino, Object uuid) {
					bacino.setUuid((String)uuid);
				}

			});
		attributeGetterFunctions.put(
			"id",
			new Function<Bacino, Object>() {

				@Override
				public Object apply(Bacino bacino) {
					return bacino.getId();
				}

			});
		attributeSetterBiConsumers.put(
			"id",
			new BiConsumer<Bacino, Object>() {

				@Override
				public void accept(Bacino bacino, Object id) {
					bacino.setId((String)id);
				}

			});
		attributeGetterFunctions.put(
			"nome",
			new Function<Bacino, Object>() {

				@Override
				public Object apply(Bacino bacino) {
					return bacino.getNome();
				}

			});
		attributeSetterBiConsumers.put(
			"nome",
			new BiConsumer<Bacino, Object>() {

				@Override
				public void accept(Bacino bacino, Object nome) {
					bacino.setNome((String)nome);
				}

			});
		attributeGetterFunctions.put(
			"progressivo",
			new Function<Bacino, Object>() {

				@Override
				public Object apply(Bacino bacino) {
					return bacino.getProgressivo();
				}

			});
		attributeSetterBiConsumers.put(
			"progressivo",
			new BiConsumer<Bacino, Object>() {

				@Override
				public void accept(Bacino bacino, Object progressivo) {
					bacino.setProgressivo((Integer)progressivo);
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
	public String getId() {
		if (_id == null) {
			return "";
		}
		else {
			return _id;
		}
	}

	@Override
	public void setId(String id) {
		_id = id;
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
		_nome = nome;
	}

	@JSON
	@Override
	public int getProgressivo() {
		return _progressivo;
	}

	@Override
	public void setProgressivo(int progressivo) {
		_columnBitmask = -1L;

		_progressivo = progressivo;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Bacino toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Bacino)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BacinoImpl bacinoImpl = new BacinoImpl();

		bacinoImpl.setUuid(getUuid());
		bacinoImpl.setId(getId());
		bacinoImpl.setNome(getNome());
		bacinoImpl.setProgressivo(getProgressivo());

		bacinoImpl.resetOriginalValues();

		return bacinoImpl;
	}

	@Override
	public int compareTo(Bacino bacino) {
		int value = 0;

		if (getProgressivo() < bacino.getProgressivo()) {
			value = -1;
		}
		else if (getProgressivo() > bacino.getProgressivo()) {
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

		if (!(obj instanceof Bacino)) {
			return false;
		}

		Bacino bacino = (Bacino)obj;

		String primaryKey = bacino.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
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
		BacinoModelImpl bacinoModelImpl = this;

		bacinoModelImpl._originalUuid = bacinoModelImpl._uuid;

		bacinoModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Bacino> toCacheModel() {
		BacinoCacheModel bacinoCacheModel = new BacinoCacheModel();

		bacinoCacheModel.uuid = getUuid();

		String uuid = bacinoCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			bacinoCacheModel.uuid = null;
		}

		bacinoCacheModel.id = getId();

		String id = bacinoCacheModel.id;

		if ((id != null) && (id.length() == 0)) {
			bacinoCacheModel.id = null;
		}

		bacinoCacheModel.nome = getNome();

		String nome = bacinoCacheModel.nome;

		if ((nome != null) && (nome.length() == 0)) {
			bacinoCacheModel.nome = null;
		}

		bacinoCacheModel.progressivo = getProgressivo();

		return bacinoCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Bacino, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Bacino, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Bacino, Object> attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Bacino)this));
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
		Map<String, Function<Bacino, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Bacino, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Bacino, Object> attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Bacino)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		Bacino.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		Bacino.class, ModelWrapper.class
	};

	private String _uuid;
	private String _originalUuid;
	private String _id;
	private String _nome;
	private int _progressivo;
	private long _columnBitmask;
	private Bacino _escapedModel;

}