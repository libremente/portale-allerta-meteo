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

package it.eng.radarMeteo.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.radarMeteo.model.Comuni_bacini_ws;
import it.eng.radarMeteo.model.Comuni_bacini_wsModel;
import it.eng.radarMeteo.model.Comuni_bacini_wsSoap;

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
 * The base model implementation for the Comuni_bacini_ws service. Represents a row in the &quot;rt_portlet_comuni_bacini_ws&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>Comuni_bacini_wsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Comuni_bacini_wsImpl}.
 * </p>
 *
 * @author Francesco
 * @see Comuni_bacini_wsImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class Comuni_bacini_wsModelImpl
	extends BaseModelImpl<Comuni_bacini_ws> implements Comuni_bacini_wsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a comuni_bacini_ws model instance should use the <code>Comuni_bacini_ws</code> interface instead.
	 */
	public static final String TABLE_NAME = "rt_portlet_comuni_bacini_ws";

	public static final Object[][] TABLE_COLUMNS = {
		{"idBacini", Types.INTEGER}, {"comune", Types.VARCHAR},
		{"provincia", Types.VARCHAR}, {"bacino", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("idBacini", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("comune", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("provincia", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("bacino", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table rt_portlet_comuni_bacini_ws (idBacini INTEGER not null primary key,comune VARCHAR(75) null,provincia VARCHAR(2) null,bacino VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table rt_portlet_comuni_bacini_ws";

	public static final String ORDER_BY_JPQL =
		" ORDER BY comuni_bacini_ws.idBacini ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY rt_portlet_comuni_bacini_ws.idBacini ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		it.eng.radarMeteo.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.it.eng.radarMeteo.model.Comuni_bacini_ws"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		it.eng.radarMeteo.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.it.eng.radarMeteo.model.Comuni_bacini_ws"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		it.eng.radarMeteo.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.it.eng.radarMeteo.model.Comuni_bacini_ws"),
		true);

	public static final long BACINO_COLUMN_BITMASK = 1L;

	public static final long IDBACINI_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Comuni_bacini_ws toModel(Comuni_bacini_wsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Comuni_bacini_ws model = new Comuni_bacini_wsImpl();

		model.setIdBacini(soapModel.getIdBacini());
		model.setComune(soapModel.getComune());
		model.setProvincia(soapModel.getProvincia());
		model.setBacino(soapModel.getBacino());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Comuni_bacini_ws> toModels(
		Comuni_bacini_wsSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<Comuni_bacini_ws> models = new ArrayList<Comuni_bacini_ws>(
			soapModels.length);

		for (Comuni_bacini_wsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		it.eng.radarMeteo.service.util.ServiceProps.get(
			"lock.expiration.time.it.eng.radarMeteo.model.Comuni_bacini_ws"));

	public Comuni_bacini_wsModelImpl() {
	}

	@Override
	public int getPrimaryKey() {
		return _idBacini;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setIdBacini(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _idBacini;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Comuni_bacini_ws.class;
	}

	@Override
	public String getModelClassName() {
		return Comuni_bacini_ws.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Comuni_bacini_ws, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Comuni_bacini_ws, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Comuni_bacini_ws, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((Comuni_bacini_ws)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Comuni_bacini_ws, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Comuni_bacini_ws, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Comuni_bacini_ws)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Comuni_bacini_ws, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Comuni_bacini_ws, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Comuni_bacini_ws, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Comuni_bacini_ws, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Comuni_bacini_ws, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<Comuni_bacini_ws, Object>>();
		Map<String, BiConsumer<Comuni_bacini_ws, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<Comuni_bacini_ws, ?>>();

		attributeGetterFunctions.put(
			"idBacini",
			new Function<Comuni_bacini_ws, Object>() {

				@Override
				public Object apply(Comuni_bacini_ws comuni_bacini_ws) {
					return comuni_bacini_ws.getIdBacini();
				}

			});
		attributeSetterBiConsumers.put(
			"idBacini",
			new BiConsumer<Comuni_bacini_ws, Object>() {

				@Override
				public void accept(
					Comuni_bacini_ws comuni_bacini_ws, Object idBacini) {

					comuni_bacini_ws.setIdBacini((Integer)idBacini);
				}

			});
		attributeGetterFunctions.put(
			"comune",
			new Function<Comuni_bacini_ws, Object>() {

				@Override
				public Object apply(Comuni_bacini_ws comuni_bacini_ws) {
					return comuni_bacini_ws.getComune();
				}

			});
		attributeSetterBiConsumers.put(
			"comune",
			new BiConsumer<Comuni_bacini_ws, Object>() {

				@Override
				public void accept(
					Comuni_bacini_ws comuni_bacini_ws, Object comune) {

					comuni_bacini_ws.setComune((String)comune);
				}

			});
		attributeGetterFunctions.put(
			"provincia",
			new Function<Comuni_bacini_ws, Object>() {

				@Override
				public Object apply(Comuni_bacini_ws comuni_bacini_ws) {
					return comuni_bacini_ws.getProvincia();
				}

			});
		attributeSetterBiConsumers.put(
			"provincia",
			new BiConsumer<Comuni_bacini_ws, Object>() {

				@Override
				public void accept(
					Comuni_bacini_ws comuni_bacini_ws, Object provincia) {

					comuni_bacini_ws.setProvincia((String)provincia);
				}

			});
		attributeGetterFunctions.put(
			"bacino",
			new Function<Comuni_bacini_ws, Object>() {

				@Override
				public Object apply(Comuni_bacini_ws comuni_bacini_ws) {
					return comuni_bacini_ws.getBacino();
				}

			});
		attributeSetterBiConsumers.put(
			"bacino",
			new BiConsumer<Comuni_bacini_ws, Object>() {

				@Override
				public void accept(
					Comuni_bacini_ws comuni_bacini_ws, Object bacino) {

					comuni_bacini_ws.setBacino((String)bacino);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public int getIdBacini() {
		return _idBacini;
	}

	@Override
	public void setIdBacini(int idBacini) {
		_idBacini = idBacini;
	}

	@JSON
	@Override
	public String getComune() {
		if (_comune == null) {
			return "";
		}
		else {
			return _comune;
		}
	}

	@Override
	public void setComune(String comune) {
		_comune = comune;
	}

	@JSON
	@Override
	public String getProvincia() {
		if (_provincia == null) {
			return "";
		}
		else {
			return _provincia;
		}
	}

	@Override
	public void setProvincia(String provincia) {
		_provincia = provincia;
	}

	@JSON
	@Override
	public String getBacino() {
		if (_bacino == null) {
			return "";
		}
		else {
			return _bacino;
		}
	}

	@Override
	public void setBacino(String bacino) {
		_columnBitmask |= BACINO_COLUMN_BITMASK;

		if (_originalBacino == null) {
			_originalBacino = _bacino;
		}

		_bacino = bacino;
	}

	public String getOriginalBacino() {
		return GetterUtil.getString(_originalBacino);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Comuni_bacini_ws toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Comuni_bacini_ws)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		Comuni_bacini_wsImpl comuni_bacini_wsImpl = new Comuni_bacini_wsImpl();

		comuni_bacini_wsImpl.setIdBacini(getIdBacini());
		comuni_bacini_wsImpl.setComune(getComune());
		comuni_bacini_wsImpl.setProvincia(getProvincia());
		comuni_bacini_wsImpl.setBacino(getBacino());

		comuni_bacini_wsImpl.resetOriginalValues();

		return comuni_bacini_wsImpl;
	}

	@Override
	public int compareTo(Comuni_bacini_ws comuni_bacini_ws) {
		int primaryKey = comuni_bacini_ws.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Comuni_bacini_ws)) {
			return false;
		}

		Comuni_bacini_ws comuni_bacini_ws = (Comuni_bacini_ws)obj;

		int primaryKey = comuni_bacini_ws.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
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
		Comuni_bacini_wsModelImpl comuni_bacini_wsModelImpl = this;

		comuni_bacini_wsModelImpl._originalBacino =
			comuni_bacini_wsModelImpl._bacino;

		comuni_bacini_wsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Comuni_bacini_ws> toCacheModel() {
		Comuni_bacini_wsCacheModel comuni_bacini_wsCacheModel =
			new Comuni_bacini_wsCacheModel();

		comuni_bacini_wsCacheModel.idBacini = getIdBacini();

		comuni_bacini_wsCacheModel.comune = getComune();

		String comune = comuni_bacini_wsCacheModel.comune;

		if ((comune != null) && (comune.length() == 0)) {
			comuni_bacini_wsCacheModel.comune = null;
		}

		comuni_bacini_wsCacheModel.provincia = getProvincia();

		String provincia = comuni_bacini_wsCacheModel.provincia;

		if ((provincia != null) && (provincia.length() == 0)) {
			comuni_bacini_wsCacheModel.provincia = null;
		}

		comuni_bacini_wsCacheModel.bacino = getBacino();

		String bacino = comuni_bacini_wsCacheModel.bacino;

		if ((bacino != null) && (bacino.length() == 0)) {
			comuni_bacini_wsCacheModel.bacino = null;
		}

		return comuni_bacini_wsCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Comuni_bacini_ws, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Comuni_bacini_ws, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Comuni_bacini_ws, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Comuni_bacini_ws)this));
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
		Map<String, Function<Comuni_bacini_ws, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Comuni_bacini_ws, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Comuni_bacini_ws, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Comuni_bacini_ws)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		Comuni_bacini_ws.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		Comuni_bacini_ws.class, ModelWrapper.class
	};

	private int _idBacini;
	private String _comune;
	private String _provincia;
	private String _bacino;
	private String _originalBacino;
	private long _columnBitmask;
	private Comuni_bacini_ws _escapedModel;

}