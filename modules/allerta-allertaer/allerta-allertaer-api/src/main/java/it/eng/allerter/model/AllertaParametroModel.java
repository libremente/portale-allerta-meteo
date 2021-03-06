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

package it.eng.allerter.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the AllertaParametro service. Represents a row in the &quot;ALLERTER_AllertaParametro&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.eng.allerter.model.impl.AllertaParametroModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.eng.allerter.model.impl.AllertaParametroImpl</code>.
 * </p>
 *
 * @author GFAVINI
 * @see AllertaParametro
 * @generated
 */
@ProviderType
public interface AllertaParametroModel extends BaseModel<AllertaParametro> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a allerta parametro model instance should use the {@link AllertaParametro} interface instead.
	 */

	/**
	 * Returns the primary key of this allerta parametro.
	 *
	 * @return the primary key of this allerta parametro
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this allerta parametro.
	 *
	 * @param primaryKey the primary key of this allerta parametro
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the parametro ID of this allerta parametro.
	 *
	 * @return the parametro ID of this allerta parametro
	 */
	@AutoEscape
	public String getParametroId();

	/**
	 * Sets the parametro ID of this allerta parametro.
	 *
	 * @param parametroId the parametro ID of this allerta parametro
	 */
	public void setParametroId(String parametroId);

	/**
	 * Returns the valore of this allerta parametro.
	 *
	 * @return the valore of this allerta parametro
	 */
	@AutoEscape
	public String getValore();

	/**
	 * Sets the valore of this allerta parametro.
	 *
	 * @param valore the valore of this allerta parametro
	 */
	public void setValore(String valore);

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
	public int compareTo(
		it.eng.allerter.model.AllertaParametro allertaParametro);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.eng.allerter.model.AllertaParametro> toCacheModel();

	@Override
	public it.eng.allerter.model.AllertaParametro toEscapedModel();

	@Override
	public it.eng.allerter.model.AllertaParametro toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}