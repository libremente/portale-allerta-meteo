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

package it.eng.allerte.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.eng.allerte.model.RubricaNominativo;
import it.eng.allerte.model.RubricaNominativoModel;
import it.eng.allerte.model.RubricaNominativoSoap;

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
 * The base model implementation for the RubricaNominativo service. Represents a row in the &quot;rubrica_RubricaNominativo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>RubricaNominativoModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RubricaNominativoImpl}.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaNominativoImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class RubricaNominativoModelImpl
	extends BaseModelImpl<RubricaNominativo> implements RubricaNominativoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a rubrica nominativo model instance should use the <code>RubricaNominativo</code> interface instead.
	 */
	public static final String TABLE_NAME = "rubrica_RubricaNominativo";

	public static final Object[][] TABLE_COLUMNS = {
		{"ID_NOMINATIVO", Types.BIGINT}, {"COGNOME", Types.VARCHAR},
		{"NOME", Types.VARCHAR}, {"INDIRIZZO", Types.VARCHAR},
		{"FK_SITO_PROPRIETARIO", Types.BIGINT},
		{"FK_UTENTE_PORTALE", Types.BIGINT},
		{"FK_UTENTE_CREAZIONE", Types.BIGINT},
		{"DATA_CREAZIONE", Types.TIMESTAMP},
		{"FK_UTENTE_MODIFICA", Types.BIGINT},
		{"DATA_MODIFICA", Types.TIMESTAMP}, {"DISABLED", Types.BOOLEAN},
		{"MODIFICA_MINORE", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ID_NOMINATIVO", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("COGNOME", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("NOME", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("INDIRIZZO", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("FK_SITO_PROPRIETARIO", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("FK_UTENTE_PORTALE", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("FK_UTENTE_CREAZIONE", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("DATA_CREAZIONE", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("FK_UTENTE_MODIFICA", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("DATA_MODIFICA", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("DISABLED", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("MODIFICA_MINORE", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table rubrica_RubricaNominativo (ID_NOMINATIVO LONG not null primary key,COGNOME VARCHAR(128) null,NOME VARCHAR(128) null,INDIRIZZO VARCHAR(256) null,FK_SITO_PROPRIETARIO LONG,FK_UTENTE_PORTALE LONG,FK_UTENTE_CREAZIONE LONG,DATA_CREAZIONE DATE null,FK_UTENTE_MODIFICA LONG,DATA_MODIFICA DATE null,DISABLED BOOLEAN,MODIFICA_MINORE BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table rubrica_RubricaNominativo";

	public static final String ORDER_BY_JPQL =
		" ORDER BY rubricaNominativo.ID_NOMINATIVO ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY rubrica_RubricaNominativo.ID_NOMINATIVO ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		it.eng.rubrica.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.it.eng.allerte.model.RubricaNominativo"),
		false);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		it.eng.rubrica.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.it.eng.allerte.model.RubricaNominativo"),
		false);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		it.eng.rubrica.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.it.eng.allerte.model.RubricaNominativo"),
		true);

	public static final long COGNOME_COLUMN_BITMASK = 1L;

	public static final long FK_SITO_PROPRIETARIO_COLUMN_BITMASK = 2L;

	public static final long FK_UTENTE_CREAZIONE_COLUMN_BITMASK = 4L;

	public static final long FK_UTENTE_MODIFICA_COLUMN_BITMASK = 8L;

	public static final long FK_UTENTE_PORTALE_COLUMN_BITMASK = 16L;

	public static final long ID_NOMINATIVO_COLUMN_BITMASK = 32L;

	public static final long NOME_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static RubricaNominativo toModel(RubricaNominativoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		RubricaNominativo model = new RubricaNominativoImpl();

		model.setID_NOMINATIVO(soapModel.getID_NOMINATIVO());
		model.setCOGNOME(soapModel.getCOGNOME());
		model.setNOME(soapModel.getNOME());
		model.setINDIRIZZO(soapModel.getINDIRIZZO());
		model.setFK_SITO_PROPRIETARIO(soapModel.getFK_SITO_PROPRIETARIO());
		model.setFK_UTENTE_PORTALE(soapModel.getFK_UTENTE_PORTALE());
		model.setFK_UTENTE_CREAZIONE(soapModel.getFK_UTENTE_CREAZIONE());
		model.setDATA_CREAZIONE(soapModel.getDATA_CREAZIONE());
		model.setFK_UTENTE_MODIFICA(soapModel.getFK_UTENTE_MODIFICA());
		model.setDATA_MODIFICA(soapModel.getDATA_MODIFICA());
		model.setDISABLED(soapModel.isDISABLED());
		model.setMODIFICA_MINORE(soapModel.isMODIFICA_MINORE());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<RubricaNominativo> toModels(
		RubricaNominativoSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<RubricaNominativo> models = new ArrayList<RubricaNominativo>(
			soapModels.length);

		for (RubricaNominativoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		it.eng.rubrica.service.util.ServiceProps.get(
			"lock.expiration.time.it.eng.allerte.model.RubricaNominativo"));

	public RubricaNominativoModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ID_NOMINATIVO;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setID_NOMINATIVO(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ID_NOMINATIVO;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return RubricaNominativo.class;
	}

	@Override
	public String getModelClassName() {
		return RubricaNominativo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<RubricaNominativo, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<RubricaNominativo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RubricaNominativo, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((RubricaNominativo)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<RubricaNominativo, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<RubricaNominativo, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(RubricaNominativo)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<RubricaNominativo, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<RubricaNominativo, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<RubricaNominativo, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<RubricaNominativo, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<RubricaNominativo, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<RubricaNominativo, Object>>();
		Map<String, BiConsumer<RubricaNominativo, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<RubricaNominativo, ?>>();

		attributeGetterFunctions.put(
			"ID_NOMINATIVO",
			new Function<RubricaNominativo, Object>() {

				@Override
				public Object apply(RubricaNominativo rubricaNominativo) {
					return rubricaNominativo.getID_NOMINATIVO();
				}

			});
		attributeSetterBiConsumers.put(
			"ID_NOMINATIVO",
			new BiConsumer<RubricaNominativo, Object>() {

				@Override
				public void accept(
					RubricaNominativo rubricaNominativo, Object ID_NOMINATIVO) {

					rubricaNominativo.setID_NOMINATIVO((Long)ID_NOMINATIVO);
				}

			});
		attributeGetterFunctions.put(
			"COGNOME",
			new Function<RubricaNominativo, Object>() {

				@Override
				public Object apply(RubricaNominativo rubricaNominativo) {
					return rubricaNominativo.getCOGNOME();
				}

			});
		attributeSetterBiConsumers.put(
			"COGNOME",
			new BiConsumer<RubricaNominativo, Object>() {

				@Override
				public void accept(
					RubricaNominativo rubricaNominativo, Object COGNOME) {

					rubricaNominativo.setCOGNOME((String)COGNOME);
				}

			});
		attributeGetterFunctions.put(
			"NOME",
			new Function<RubricaNominativo, Object>() {

				@Override
				public Object apply(RubricaNominativo rubricaNominativo) {
					return rubricaNominativo.getNOME();
				}

			});
		attributeSetterBiConsumers.put(
			"NOME",
			new BiConsumer<RubricaNominativo, Object>() {

				@Override
				public void accept(
					RubricaNominativo rubricaNominativo, Object NOME) {

					rubricaNominativo.setNOME((String)NOME);
				}

			});
		attributeGetterFunctions.put(
			"INDIRIZZO",
			new Function<RubricaNominativo, Object>() {

				@Override
				public Object apply(RubricaNominativo rubricaNominativo) {
					return rubricaNominativo.getINDIRIZZO();
				}

			});
		attributeSetterBiConsumers.put(
			"INDIRIZZO",
			new BiConsumer<RubricaNominativo, Object>() {

				@Override
				public void accept(
					RubricaNominativo rubricaNominativo, Object INDIRIZZO) {

					rubricaNominativo.setINDIRIZZO((String)INDIRIZZO);
				}

			});
		attributeGetterFunctions.put(
			"FK_SITO_PROPRIETARIO",
			new Function<RubricaNominativo, Object>() {

				@Override
				public Object apply(RubricaNominativo rubricaNominativo) {
					return rubricaNominativo.getFK_SITO_PROPRIETARIO();
				}

			});
		attributeSetterBiConsumers.put(
			"FK_SITO_PROPRIETARIO",
			new BiConsumer<RubricaNominativo, Object>() {

				@Override
				public void accept(
					RubricaNominativo rubricaNominativo,
					Object FK_SITO_PROPRIETARIO) {

					rubricaNominativo.setFK_SITO_PROPRIETARIO(
						(Long)FK_SITO_PROPRIETARIO);
				}

			});
		attributeGetterFunctions.put(
			"FK_UTENTE_PORTALE",
			new Function<RubricaNominativo, Object>() {

				@Override
				public Object apply(RubricaNominativo rubricaNominativo) {
					return rubricaNominativo.getFK_UTENTE_PORTALE();
				}

			});
		attributeSetterBiConsumers.put(
			"FK_UTENTE_PORTALE",
			new BiConsumer<RubricaNominativo, Object>() {

				@Override
				public void accept(
					RubricaNominativo rubricaNominativo,
					Object FK_UTENTE_PORTALE) {

					rubricaNominativo.setFK_UTENTE_PORTALE(
						(Long)FK_UTENTE_PORTALE);
				}

			});
		attributeGetterFunctions.put(
			"FK_UTENTE_CREAZIONE",
			new Function<RubricaNominativo, Object>() {

				@Override
				public Object apply(RubricaNominativo rubricaNominativo) {
					return rubricaNominativo.getFK_UTENTE_CREAZIONE();
				}

			});
		attributeSetterBiConsumers.put(
			"FK_UTENTE_CREAZIONE",
			new BiConsumer<RubricaNominativo, Object>() {

				@Override
				public void accept(
					RubricaNominativo rubricaNominativo,
					Object FK_UTENTE_CREAZIONE) {

					rubricaNominativo.setFK_UTENTE_CREAZIONE(
						(Long)FK_UTENTE_CREAZIONE);
				}

			});
		attributeGetterFunctions.put(
			"DATA_CREAZIONE",
			new Function<RubricaNominativo, Object>() {

				@Override
				public Object apply(RubricaNominativo rubricaNominativo) {
					return rubricaNominativo.getDATA_CREAZIONE();
				}

			});
		attributeSetterBiConsumers.put(
			"DATA_CREAZIONE",
			new BiConsumer<RubricaNominativo, Object>() {

				@Override
				public void accept(
					RubricaNominativo rubricaNominativo,
					Object DATA_CREAZIONE) {

					rubricaNominativo.setDATA_CREAZIONE((Date)DATA_CREAZIONE);
				}

			});
		attributeGetterFunctions.put(
			"FK_UTENTE_MODIFICA",
			new Function<RubricaNominativo, Object>() {

				@Override
				public Object apply(RubricaNominativo rubricaNominativo) {
					return rubricaNominativo.getFK_UTENTE_MODIFICA();
				}

			});
		attributeSetterBiConsumers.put(
			"FK_UTENTE_MODIFICA",
			new BiConsumer<RubricaNominativo, Object>() {

				@Override
				public void accept(
					RubricaNominativo rubricaNominativo,
					Object FK_UTENTE_MODIFICA) {

					rubricaNominativo.setFK_UTENTE_MODIFICA(
						(Long)FK_UTENTE_MODIFICA);
				}

			});
		attributeGetterFunctions.put(
			"DATA_MODIFICA",
			new Function<RubricaNominativo, Object>() {

				@Override
				public Object apply(RubricaNominativo rubricaNominativo) {
					return rubricaNominativo.getDATA_MODIFICA();
				}

			});
		attributeSetterBiConsumers.put(
			"DATA_MODIFICA",
			new BiConsumer<RubricaNominativo, Object>() {

				@Override
				public void accept(
					RubricaNominativo rubricaNominativo, Object DATA_MODIFICA) {

					rubricaNominativo.setDATA_MODIFICA((Date)DATA_MODIFICA);
				}

			});
		attributeGetterFunctions.put(
			"DISABLED",
			new Function<RubricaNominativo, Object>() {

				@Override
				public Object apply(RubricaNominativo rubricaNominativo) {
					return rubricaNominativo.getDISABLED();
				}

			});
		attributeSetterBiConsumers.put(
			"DISABLED",
			new BiConsumer<RubricaNominativo, Object>() {

				@Override
				public void accept(
					RubricaNominativo rubricaNominativo, Object DISABLED) {

					rubricaNominativo.setDISABLED((Boolean)DISABLED);
				}

			});
		attributeGetterFunctions.put(
			"MODIFICA_MINORE",
			new Function<RubricaNominativo, Object>() {

				@Override
				public Object apply(RubricaNominativo rubricaNominativo) {
					return rubricaNominativo.getMODIFICA_MINORE();
				}

			});
		attributeSetterBiConsumers.put(
			"MODIFICA_MINORE",
			new BiConsumer<RubricaNominativo, Object>() {

				@Override
				public void accept(
					RubricaNominativo rubricaNominativo,
					Object MODIFICA_MINORE) {

					rubricaNominativo.setMODIFICA_MINORE(
						(Boolean)MODIFICA_MINORE);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getID_NOMINATIVO() {
		return _ID_NOMINATIVO;
	}

	@Override
	public void setID_NOMINATIVO(long ID_NOMINATIVO) {
		_columnBitmask |= ID_NOMINATIVO_COLUMN_BITMASK;

		if (!_setOriginalID_NOMINATIVO) {
			_setOriginalID_NOMINATIVO = true;

			_originalID_NOMINATIVO = _ID_NOMINATIVO;
		}

		_ID_NOMINATIVO = ID_NOMINATIVO;
	}

	public long getOriginalID_NOMINATIVO() {
		return _originalID_NOMINATIVO;
	}

	@JSON
	@Override
	public String getCOGNOME() {
		if (_COGNOME == null) {
			return "";
		}
		else {
			return _COGNOME;
		}
	}

	@Override
	public void setCOGNOME(String COGNOME) {
		_columnBitmask |= COGNOME_COLUMN_BITMASK;

		if (_originalCOGNOME == null) {
			_originalCOGNOME = _COGNOME;
		}

		_COGNOME = COGNOME;
	}

	public String getOriginalCOGNOME() {
		return GetterUtil.getString(_originalCOGNOME);
	}

	@JSON
	@Override
	public String getNOME() {
		if (_NOME == null) {
			return "";
		}
		else {
			return _NOME;
		}
	}

	@Override
	public void setNOME(String NOME) {
		_columnBitmask |= NOME_COLUMN_BITMASK;

		if (_originalNOME == null) {
			_originalNOME = _NOME;
		}

		_NOME = NOME;
	}

	public String getOriginalNOME() {
		return GetterUtil.getString(_originalNOME);
	}

	@JSON
	@Override
	public String getINDIRIZZO() {
		if (_INDIRIZZO == null) {
			return "";
		}
		else {
			return _INDIRIZZO;
		}
	}

	@Override
	public void setINDIRIZZO(String INDIRIZZO) {
		_INDIRIZZO = INDIRIZZO;
	}

	@JSON
	@Override
	public long getFK_SITO_PROPRIETARIO() {
		return _FK_SITO_PROPRIETARIO;
	}

	@Override
	public void setFK_SITO_PROPRIETARIO(long FK_SITO_PROPRIETARIO) {
		_columnBitmask |= FK_SITO_PROPRIETARIO_COLUMN_BITMASK;

		if (!_setOriginalFK_SITO_PROPRIETARIO) {
			_setOriginalFK_SITO_PROPRIETARIO = true;

			_originalFK_SITO_PROPRIETARIO = _FK_SITO_PROPRIETARIO;
		}

		_FK_SITO_PROPRIETARIO = FK_SITO_PROPRIETARIO;
	}

	public long getOriginalFK_SITO_PROPRIETARIO() {
		return _originalFK_SITO_PROPRIETARIO;
	}

	@JSON
	@Override
	public long getFK_UTENTE_PORTALE() {
		return _FK_UTENTE_PORTALE;
	}

	@Override
	public void setFK_UTENTE_PORTALE(long FK_UTENTE_PORTALE) {
		_columnBitmask |= FK_UTENTE_PORTALE_COLUMN_BITMASK;

		if (!_setOriginalFK_UTENTE_PORTALE) {
			_setOriginalFK_UTENTE_PORTALE = true;

			_originalFK_UTENTE_PORTALE = _FK_UTENTE_PORTALE;
		}

		_FK_UTENTE_PORTALE = FK_UTENTE_PORTALE;
	}

	public long getOriginalFK_UTENTE_PORTALE() {
		return _originalFK_UTENTE_PORTALE;
	}

	@JSON
	@Override
	public long getFK_UTENTE_CREAZIONE() {
		return _FK_UTENTE_CREAZIONE;
	}

	@Override
	public void setFK_UTENTE_CREAZIONE(long FK_UTENTE_CREAZIONE) {
		_columnBitmask |= FK_UTENTE_CREAZIONE_COLUMN_BITMASK;

		if (!_setOriginalFK_UTENTE_CREAZIONE) {
			_setOriginalFK_UTENTE_CREAZIONE = true;

			_originalFK_UTENTE_CREAZIONE = _FK_UTENTE_CREAZIONE;
		}

		_FK_UTENTE_CREAZIONE = FK_UTENTE_CREAZIONE;
	}

	public long getOriginalFK_UTENTE_CREAZIONE() {
		return _originalFK_UTENTE_CREAZIONE;
	}

	@JSON
	@Override
	public Date getDATA_CREAZIONE() {
		return _DATA_CREAZIONE;
	}

	@Override
	public void setDATA_CREAZIONE(Date DATA_CREAZIONE) {
		_DATA_CREAZIONE = DATA_CREAZIONE;
	}

	@JSON
	@Override
	public long getFK_UTENTE_MODIFICA() {
		return _FK_UTENTE_MODIFICA;
	}

	@Override
	public void setFK_UTENTE_MODIFICA(long FK_UTENTE_MODIFICA) {
		_columnBitmask |= FK_UTENTE_MODIFICA_COLUMN_BITMASK;

		if (!_setOriginalFK_UTENTE_MODIFICA) {
			_setOriginalFK_UTENTE_MODIFICA = true;

			_originalFK_UTENTE_MODIFICA = _FK_UTENTE_MODIFICA;
		}

		_FK_UTENTE_MODIFICA = FK_UTENTE_MODIFICA;
	}

	public long getOriginalFK_UTENTE_MODIFICA() {
		return _originalFK_UTENTE_MODIFICA;
	}

	@JSON
	@Override
	public Date getDATA_MODIFICA() {
		return _DATA_MODIFICA;
	}

	@Override
	public void setDATA_MODIFICA(Date DATA_MODIFICA) {
		_DATA_MODIFICA = DATA_MODIFICA;
	}

	@JSON
	@Override
	public boolean getDISABLED() {
		return _DISABLED;
	}

	@JSON
	@Override
	public boolean isDISABLED() {
		return _DISABLED;
	}

	@Override
	public void setDISABLED(boolean DISABLED) {
		_DISABLED = DISABLED;
	}

	@JSON
	@Override
	public boolean getMODIFICA_MINORE() {
		return _MODIFICA_MINORE;
	}

	@JSON
	@Override
	public boolean isMODIFICA_MINORE() {
		return _MODIFICA_MINORE;
	}

	@Override
	public void setMODIFICA_MINORE(boolean MODIFICA_MINORE) {
		_MODIFICA_MINORE = MODIFICA_MINORE;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, RubricaNominativo.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RubricaNominativo toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (RubricaNominativo)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RubricaNominativoImpl rubricaNominativoImpl =
			new RubricaNominativoImpl();

		rubricaNominativoImpl.setID_NOMINATIVO(getID_NOMINATIVO());
		rubricaNominativoImpl.setCOGNOME(getCOGNOME());
		rubricaNominativoImpl.setNOME(getNOME());
		rubricaNominativoImpl.setINDIRIZZO(getINDIRIZZO());
		rubricaNominativoImpl.setFK_SITO_PROPRIETARIO(
			getFK_SITO_PROPRIETARIO());
		rubricaNominativoImpl.setFK_UTENTE_PORTALE(getFK_UTENTE_PORTALE());
		rubricaNominativoImpl.setFK_UTENTE_CREAZIONE(getFK_UTENTE_CREAZIONE());
		rubricaNominativoImpl.setDATA_CREAZIONE(getDATA_CREAZIONE());
		rubricaNominativoImpl.setFK_UTENTE_MODIFICA(getFK_UTENTE_MODIFICA());
		rubricaNominativoImpl.setDATA_MODIFICA(getDATA_MODIFICA());
		rubricaNominativoImpl.setDISABLED(isDISABLED());
		rubricaNominativoImpl.setMODIFICA_MINORE(isMODIFICA_MINORE());

		rubricaNominativoImpl.resetOriginalValues();

		return rubricaNominativoImpl;
	}

	@Override
	public int compareTo(RubricaNominativo rubricaNominativo) {
		long primaryKey = rubricaNominativo.getPrimaryKey();

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

		if (!(obj instanceof RubricaNominativo)) {
			return false;
		}

		RubricaNominativo rubricaNominativo = (RubricaNominativo)obj;

		long primaryKey = rubricaNominativo.getPrimaryKey();

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
		RubricaNominativoModelImpl rubricaNominativoModelImpl = this;

		rubricaNominativoModelImpl._originalID_NOMINATIVO =
			rubricaNominativoModelImpl._ID_NOMINATIVO;

		rubricaNominativoModelImpl._setOriginalID_NOMINATIVO = false;

		rubricaNominativoModelImpl._originalCOGNOME =
			rubricaNominativoModelImpl._COGNOME;

		rubricaNominativoModelImpl._originalNOME =
			rubricaNominativoModelImpl._NOME;

		rubricaNominativoModelImpl._originalFK_SITO_PROPRIETARIO =
			rubricaNominativoModelImpl._FK_SITO_PROPRIETARIO;

		rubricaNominativoModelImpl._setOriginalFK_SITO_PROPRIETARIO = false;

		rubricaNominativoModelImpl._originalFK_UTENTE_PORTALE =
			rubricaNominativoModelImpl._FK_UTENTE_PORTALE;

		rubricaNominativoModelImpl._setOriginalFK_UTENTE_PORTALE = false;

		rubricaNominativoModelImpl._originalFK_UTENTE_CREAZIONE =
			rubricaNominativoModelImpl._FK_UTENTE_CREAZIONE;

		rubricaNominativoModelImpl._setOriginalFK_UTENTE_CREAZIONE = false;

		rubricaNominativoModelImpl._originalFK_UTENTE_MODIFICA =
			rubricaNominativoModelImpl._FK_UTENTE_MODIFICA;

		rubricaNominativoModelImpl._setOriginalFK_UTENTE_MODIFICA = false;

		rubricaNominativoModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<RubricaNominativo> toCacheModel() {
		RubricaNominativoCacheModel rubricaNominativoCacheModel =
			new RubricaNominativoCacheModel();

		rubricaNominativoCacheModel.ID_NOMINATIVO = getID_NOMINATIVO();

		rubricaNominativoCacheModel.COGNOME = getCOGNOME();

		String COGNOME = rubricaNominativoCacheModel.COGNOME;

		if ((COGNOME != null) && (COGNOME.length() == 0)) {
			rubricaNominativoCacheModel.COGNOME = null;
		}

		rubricaNominativoCacheModel.NOME = getNOME();

		String NOME = rubricaNominativoCacheModel.NOME;

		if ((NOME != null) && (NOME.length() == 0)) {
			rubricaNominativoCacheModel.NOME = null;
		}

		rubricaNominativoCacheModel.INDIRIZZO = getINDIRIZZO();

		String INDIRIZZO = rubricaNominativoCacheModel.INDIRIZZO;

		if ((INDIRIZZO != null) && (INDIRIZZO.length() == 0)) {
			rubricaNominativoCacheModel.INDIRIZZO = null;
		}

		rubricaNominativoCacheModel.FK_SITO_PROPRIETARIO =
			getFK_SITO_PROPRIETARIO();

		rubricaNominativoCacheModel.FK_UTENTE_PORTALE = getFK_UTENTE_PORTALE();

		rubricaNominativoCacheModel.FK_UTENTE_CREAZIONE =
			getFK_UTENTE_CREAZIONE();

		Date DATA_CREAZIONE = getDATA_CREAZIONE();

		if (DATA_CREAZIONE != null) {
			rubricaNominativoCacheModel.DATA_CREAZIONE =
				DATA_CREAZIONE.getTime();
		}
		else {
			rubricaNominativoCacheModel.DATA_CREAZIONE = Long.MIN_VALUE;
		}

		rubricaNominativoCacheModel.FK_UTENTE_MODIFICA =
			getFK_UTENTE_MODIFICA();

		Date DATA_MODIFICA = getDATA_MODIFICA();

		if (DATA_MODIFICA != null) {
			rubricaNominativoCacheModel.DATA_MODIFICA = DATA_MODIFICA.getTime();
		}
		else {
			rubricaNominativoCacheModel.DATA_MODIFICA = Long.MIN_VALUE;
		}

		rubricaNominativoCacheModel.DISABLED = isDISABLED();

		rubricaNominativoCacheModel.MODIFICA_MINORE = isMODIFICA_MINORE();

		return rubricaNominativoCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<RubricaNominativo, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<RubricaNominativo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RubricaNominativo, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((RubricaNominativo)this));
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
		Map<String, Function<RubricaNominativo, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<RubricaNominativo, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RubricaNominativo, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((RubricaNominativo)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		RubricaNominativo.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		RubricaNominativo.class, ModelWrapper.class
	};

	private long _ID_NOMINATIVO;

	private long _originalID_NOMINATIVO;
	private boolean _setOriginalID_NOMINATIVO;

	private String _COGNOME;

	private String _originalCOGNOME;

	private String _NOME;

	private String _originalNOME;

	private String _INDIRIZZO;

	private long _FK_SITO_PROPRIETARIO;

	private long _originalFK_SITO_PROPRIETARIO;
	private boolean _setOriginalFK_SITO_PROPRIETARIO;

	private long _FK_UTENTE_PORTALE;

	private long _originalFK_UTENTE_PORTALE;
	private boolean _setOriginalFK_UTENTE_PORTALE;

	private long _FK_UTENTE_CREAZIONE;

	private long _originalFK_UTENTE_CREAZIONE;
	private boolean _setOriginalFK_UTENTE_CREAZIONE;

	private Date _DATA_CREAZIONE;

	private long _FK_UTENTE_MODIFICA;

	private long _originalFK_UTENTE_MODIFICA;
	private boolean _setOriginalFK_UTENTE_MODIFICA;

	private Date _DATA_MODIFICA;

	private boolean _DISABLED;

	private boolean _MODIFICA_MINORE;

	private long _columnBitmask;
	private RubricaNominativo _escapedModel;

}