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

import it.eng.radarMeteo.model.Comuni_ws;
import it.eng.radarMeteo.model.Comuni_wsModel;
import it.eng.radarMeteo.model.Comuni_wsSoap;

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
 * The base model implementation for the Comuni_ws service. Represents a row in the &quot;rt_portlet_comuni_ws&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>Comuni_wsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Comuni_wsImpl}.
 * </p>
 *
 * @author Francesco
 * @see Comuni_wsImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class Comuni_wsModelImpl
	extends BaseModelImpl<Comuni_ws> implements Comuni_wsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a comuni_ws model instance should use the <code>Comuni_ws</code> interface instead.
	 */
	public static final String TABLE_NAME = "rt_portlet_comuni_ws";

	public static final Object[][] TABLE_COLUMNS = {
		{"idIstat", Types.VARCHAR}, {"comune", Types.VARCHAR},
		{"provincia", Types.VARCHAR}, {"sottozona", Types.VARCHAR},
		{"zonaallerta", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("idIstat", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("comune", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("provincia", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sottozona", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("zonaallerta", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table rt_portlet_comuni_ws (idIstat VARCHAR(10) not null primary key,comune VARCHAR(50) null,provincia VARCHAR(2) null,sottozona VARCHAR(2) null,zonaallerta VARCHAR(1) null)";

	public static final String TABLE_SQL_DROP =
		"drop table rt_portlet_comuni_ws";

	public static final String ORDER_BY_JPQL =
		" ORDER BY comuni_ws.idIstat ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY rt_portlet_comuni_ws.idIstat ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		it.eng.radarMeteo.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.it.eng.radarMeteo.model.Comuni_ws"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		it.eng.radarMeteo.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.it.eng.radarMeteo.model.Comuni_ws"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		it.eng.radarMeteo.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.it.eng.radarMeteo.model.Comuni_ws"),
		true);

	public static final long SOTTOZONA_COLUMN_BITMASK = 1L;

	public static final long ZONAALLERTA_COLUMN_BITMASK = 2L;

	public static final long IDISTAT_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Comuni_ws toModel(Comuni_wsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Comuni_ws model = new Comuni_wsImpl();

		model.setIdIstat(soapModel.getIdIstat());
		model.setComune(soapModel.getComune());
		model.setProvincia(soapModel.getProvincia());
		model.setSottozona(soapModel.getSottozona());
		model.setZonaallerta(soapModel.getZonaallerta());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Comuni_ws> toModels(Comuni_wsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Comuni_ws> models = new ArrayList<Comuni_ws>(soapModels.length);

		for (Comuni_wsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		it.eng.radarMeteo.service.util.ServiceProps.get(
			"lock.expiration.time.it.eng.radarMeteo.model.Comuni_ws"));

	public Comuni_wsModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _idIstat;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setIdIstat(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _idIstat;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Comuni_ws.class;
	}

	@Override
	public String getModelClassName() {
		return Comuni_ws.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Comuni_ws, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Comuni_ws, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Comuni_ws, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Comuni_ws)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Comuni_ws, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Comuni_ws, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Comuni_ws)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Comuni_ws, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Comuni_ws, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Comuni_ws, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Comuni_ws, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Comuni_ws, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Comuni_ws, Object>>();
		Map<String, BiConsumer<Comuni_ws, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Comuni_ws, ?>>();

		attributeGetterFunctions.put(
			"idIstat",
			new Function<Comuni_ws, Object>() {

				@Override
				public Object apply(Comuni_ws comuni_ws) {
					return comuni_ws.getIdIstat();
				}

			});
		attributeSetterBiConsumers.put(
			"idIstat",
			new BiConsumer<Comuni_ws, Object>() {

				@Override
				public void accept(Comuni_ws comuni_ws, Object idIstat) {
					comuni_ws.setIdIstat((String)idIstat);
				}

			});
		attributeGetterFunctions.put(
			"comune",
			new Function<Comuni_ws, Object>() {

				@Override
				public Object apply(Comuni_ws comuni_ws) {
					return comuni_ws.getComune();
				}

			});
		attributeSetterBiConsumers.put(
			"comune",
			new BiConsumer<Comuni_ws, Object>() {

				@Override
				public void accept(Comuni_ws comuni_ws, Object comune) {
					comuni_ws.setComune((String)comune);
				}

			});
		attributeGetterFunctions.put(
			"provincia",
			new Function<Comuni_ws, Object>() {

				@Override
				public Object apply(Comuni_ws comuni_ws) {
					return comuni_ws.getProvincia();
				}

			});
		attributeSetterBiConsumers.put(
			"provincia",
			new BiConsumer<Comuni_ws, Object>() {

				@Override
				public void accept(Comuni_ws comuni_ws, Object provincia) {
					comuni_ws.setProvincia((String)provincia);
				}

			});
		attributeGetterFunctions.put(
			"sottozona",
			new Function<Comuni_ws, Object>() {

				@Override
				public Object apply(Comuni_ws comuni_ws) {
					return comuni_ws.getSottozona();
				}

			});
		attributeSetterBiConsumers.put(
			"sottozona",
			new BiConsumer<Comuni_ws, Object>() {

				@Override
				public void accept(Comuni_ws comuni_ws, Object sottozona) {
					comuni_ws.setSottozona((String)sottozona);
				}

			});
		attributeGetterFunctions.put(
			"zonaallerta",
			new Function<Comuni_ws, Object>() {

				@Override
				public Object apply(Comuni_ws comuni_ws) {
					return comuni_ws.getZonaallerta();
				}

			});
		attributeSetterBiConsumers.put(
			"zonaallerta",
			new BiConsumer<Comuni_ws, Object>() {

				@Override
				public void accept(Comuni_ws comuni_ws, Object zonaallerta) {
					comuni_ws.setZonaallerta((String)zonaallerta);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getIdIstat() {
		if (_idIstat == null) {
			return "";
		}
		else {
			return _idIstat;
		}
	}

	@Override
	public void setIdIstat(String idIstat) {
		_idIstat = idIstat;
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
	public String getSottozona() {
		if (_sottozona == null) {
			return "";
		}
		else {
			return _sottozona;
		}
	}

	@Override
	public void setSottozona(String sottozona) {
		_columnBitmask |= SOTTOZONA_COLUMN_BITMASK;

		if (_originalSottozona == null) {
			_originalSottozona = _sottozona;
		}

		_sottozona = sottozona;
	}

	public String getOriginalSottozona() {
		return GetterUtil.getString(_originalSottozona);
	}

	@JSON
	@Override
	public String getZonaallerta() {
		if (_zonaallerta == null) {
			return "";
		}
		else {
			return _zonaallerta;
		}
	}

	@Override
	public void setZonaallerta(String zonaallerta) {
		_columnBitmask |= ZONAALLERTA_COLUMN_BITMASK;

		if (_originalZonaallerta == null) {
			_originalZonaallerta = _zonaallerta;
		}

		_zonaallerta = zonaallerta;
	}

	public String getOriginalZonaallerta() {
		return GetterUtil.getString(_originalZonaallerta);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Comuni_ws toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Comuni_ws)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		Comuni_wsImpl comuni_wsImpl = new Comuni_wsImpl();

		comuni_wsImpl.setIdIstat(getIdIstat());
		comuni_wsImpl.setComune(getComune());
		comuni_wsImpl.setProvincia(getProvincia());
		comuni_wsImpl.setSottozona(getSottozona());
		comuni_wsImpl.setZonaallerta(getZonaallerta());

		comuni_wsImpl.resetOriginalValues();

		return comuni_wsImpl;
	}

	@Override
	public int compareTo(Comuni_ws comuni_ws) {
		String primaryKey = comuni_ws.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Comuni_ws)) {
			return false;
		}

		Comuni_ws comuni_ws = (Comuni_ws)obj;

		String primaryKey = comuni_ws.getPrimaryKey();

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
		Comuni_wsModelImpl comuni_wsModelImpl = this;

		comuni_wsModelImpl._originalSottozona = comuni_wsModelImpl._sottozona;

		comuni_wsModelImpl._originalZonaallerta =
			comuni_wsModelImpl._zonaallerta;

		comuni_wsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Comuni_ws> toCacheModel() {
		Comuni_wsCacheModel comuni_wsCacheModel = new Comuni_wsCacheModel();

		comuni_wsCacheModel.idIstat = getIdIstat();

		String idIstat = comuni_wsCacheModel.idIstat;

		if ((idIstat != null) && (idIstat.length() == 0)) {
			comuni_wsCacheModel.idIstat = null;
		}

		comuni_wsCacheModel.comune = getComune();

		String comune = comuni_wsCacheModel.comune;

		if ((comune != null) && (comune.length() == 0)) {
			comuni_wsCacheModel.comune = null;
		}

		comuni_wsCacheModel.provincia = getProvincia();

		String provincia = comuni_wsCacheModel.provincia;

		if ((provincia != null) && (provincia.length() == 0)) {
			comuni_wsCacheModel.provincia = null;
		}

		comuni_wsCacheModel.sottozona = getSottozona();

		String sottozona = comuni_wsCacheModel.sottozona;

		if ((sottozona != null) && (sottozona.length() == 0)) {
			comuni_wsCacheModel.sottozona = null;
		}

		comuni_wsCacheModel.zonaallerta = getZonaallerta();

		String zonaallerta = comuni_wsCacheModel.zonaallerta;

		if ((zonaallerta != null) && (zonaallerta.length() == 0)) {
			comuni_wsCacheModel.zonaallerta = null;
		}

		return comuni_wsCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Comuni_ws, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Comuni_ws, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Comuni_ws, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Comuni_ws)this));
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
		Map<String, Function<Comuni_ws, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Comuni_ws, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Comuni_ws, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Comuni_ws)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		Comuni_ws.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		Comuni_ws.class, ModelWrapper.class
	};

	private String _idIstat;
	private String _comune;
	private String _provincia;
	private String _sottozona;
	private String _originalSottozona;
	private String _zonaallerta;
	private String _originalZonaallerta;
	private long _columnBitmask;
	private Comuni_ws _escapedModel;

}