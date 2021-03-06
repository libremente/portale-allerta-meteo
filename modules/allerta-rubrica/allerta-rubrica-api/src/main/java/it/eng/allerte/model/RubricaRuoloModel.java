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

package it.eng.allerte.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the RubricaRuolo service. Represents a row in the &quot;rubrica_RubricaRuolo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.eng.allerte.model.impl.RubricaRuoloModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.eng.allerte.model.impl.RubricaRuoloImpl</code>.
 * </p>
 *
 * @author Pratola_L
 * @see RubricaRuolo
 * @generated
 */
@ProviderType
public interface RubricaRuoloModel extends BaseModel<RubricaRuolo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a rubrica ruolo model instance should use the {@link RubricaRuolo} interface instead.
	 */

	/**
	 * Returns the primary key of this rubrica ruolo.
	 *
	 * @return the primary key of this rubrica ruolo
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this rubrica ruolo.
	 *
	 * @param primaryKey the primary key of this rubrica ruolo
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id_ruolo of this rubrica ruolo.
	 *
	 * @return the id_ruolo of this rubrica ruolo
	 */
	public long getID_RUOLO();

	/**
	 * Sets the id_ruolo of this rubrica ruolo.
	 *
	 * @param ID_RUOLO the id_ruolo of this rubrica ruolo
	 */
	public void setID_RUOLO(long ID_RUOLO);

	/**
	 * Returns the descrizione of this rubrica ruolo.
	 *
	 * @return the descrizione of this rubrica ruolo
	 */
	@AutoEscape
	public String getDESCRIZIONE();

	/**
	 * Sets the descrizione of this rubrica ruolo.
	 *
	 * @param DESCRIZIONE the descrizione of this rubrica ruolo
	 */
	public void setDESCRIZIONE(String DESCRIZIONE);

	/**
	 * Returns the fk_ruolo_liferay of this rubrica ruolo.
	 *
	 * @return the fk_ruolo_liferay of this rubrica ruolo
	 */
	public long getFK_RUOLO_LIFERAY();

	/**
	 * Sets the fk_ruolo_liferay of this rubrica ruolo.
	 *
	 * @param FK_RUOLO_LIFERAY the fk_ruolo_liferay of this rubrica ruolo
	 */
	public void setFK_RUOLO_LIFERAY(long FK_RUOLO_LIFERAY);

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
	public int compareTo(it.eng.allerte.model.RubricaRuolo rubricaRuolo);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.eng.allerte.model.RubricaRuolo> toCacheModel();

	@Override
	public it.eng.allerte.model.RubricaRuolo toEscapedModel();

	@Override
	public it.eng.allerte.model.RubricaRuolo toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}