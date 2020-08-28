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

package it.eng.bollettino.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the Icona service. Represents a row in the &quot;BOLLETTINO_Icona&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.eng.bollettino.model.impl.IconaModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.eng.bollettino.model.impl.IconaImpl</code>.
 * </p>
 *
 * @author GFAVINI
 * @see Icona
 * @generated
 */
@ProviderType
public interface IconaModel extends BaseModel<Icona> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a icona model instance should use the {@link Icona} interface instead.
	 */

	/**
	 * Returns the primary key of this icona.
	 *
	 * @return the primary key of this icona
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this icona.
	 *
	 * @param primaryKey the primary key of this icona
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this icona.
	 *
	 * @return the uuid of this icona
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this icona.
	 *
	 * @param uuid the uuid of this icona
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the ID of this icona.
	 *
	 * @return the ID of this icona
	 */
	public long getId();

	/**
	 * Sets the ID of this icona.
	 *
	 * @param id the ID of this icona
	 */
	public void setId(long id);

	/**
	 * Returns the path of this icona.
	 *
	 * @return the path of this icona
	 */
	@AutoEscape
	public String getPath();

	/**
	 * Sets the path of this icona.
	 *
	 * @param path the path of this icona
	 */
	public void setPath(String path);

	/**
	 * Returns the descrizione of this icona.
	 *
	 * @return the descrizione of this icona
	 */
	@AutoEscape
	public String getDescrizione();

	/**
	 * Sets the descrizione of this icona.
	 *
	 * @param descrizione the descrizione of this icona
	 */
	public void setDescrizione(String descrizione);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(it.eng.bollettino.model.Icona icona);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.eng.bollettino.model.Icona> toCacheModel();

	@Override
	public it.eng.bollettino.model.Icona toEscapedModel();

	@Override
	public it.eng.bollettino.model.Icona toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}