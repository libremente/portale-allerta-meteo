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
 * The base model interface for the BollettinoParametro service. Represents a row in the &quot;BOLLETTINO_BollettinoParametro&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.eng.bollettino.model.impl.BollettinoParametroModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.eng.bollettino.model.impl.BollettinoParametroImpl</code>.
 * </p>
 *
 * @author GFAVINI
 * @see BollettinoParametro
 * @generated
 */
@ProviderType
public interface BollettinoParametroModel
	extends BaseModel<BollettinoParametro> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a bollettino parametro model instance should use the {@link BollettinoParametro} interface instead.
	 */

	/**
	 * Returns the primary key of this bollettino parametro.
	 *
	 * @return the primary key of this bollettino parametro
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this bollettino parametro.
	 *
	 * @param primaryKey the primary key of this bollettino parametro
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the parametro ID of this bollettino parametro.
	 *
	 * @return the parametro ID of this bollettino parametro
	 */
	@AutoEscape
	public String getParametroId();

	/**
	 * Sets the parametro ID of this bollettino parametro.
	 *
	 * @param parametroId the parametro ID of this bollettino parametro
	 */
	public void setParametroId(String parametroId);

	/**
	 * Returns the valore of this bollettino parametro.
	 *
	 * @return the valore of this bollettino parametro
	 */
	@AutoEscape
	public String getValore();

	/**
	 * Sets the valore of this bollettino parametro.
	 *
	 * @param valore the valore of this bollettino parametro
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
		it.eng.bollettino.model.BollettinoParametro bollettinoParametro);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.eng.bollettino.model.BollettinoParametro>
		toCacheModel();

	@Override
	public it.eng.bollettino.model.BollettinoParametro toEscapedModel();

	@Override
	public it.eng.bollettino.model.BollettinoParametro toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}