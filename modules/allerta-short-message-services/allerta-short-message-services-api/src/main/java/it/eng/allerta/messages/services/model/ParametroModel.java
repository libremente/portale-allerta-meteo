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

package it.eng.allerta.messages.services.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Parametro service. Represents a row in the &quot;smsService_Parametro&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.eng.allerta.messages.services.model.impl.ParametroModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.eng.allerta.messages.services.model.impl.ParametroImpl</code>.
 * </p>
 *
 * @author Giorgianni_F
 * @see Parametro
 * @generated
 */
@ProviderType
public interface ParametroModel extends BaseModel<Parametro> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a parametro model instance should use the {@link Parametro} interface instead.
	 */

	/**
	 * Returns the primary key of this parametro.
	 *
	 * @return the primary key of this parametro
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this parametro.
	 *
	 * @param primaryKey the primary key of this parametro
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this parametro.
	 *
	 * @return the ID of this parametro
	 */
	public long getId();

	/**
	 * Sets the ID of this parametro.
	 *
	 * @param Id the ID of this parametro
	 */
	public void setId(long Id);

	/**
	 * Returns the ip of this parametro.
	 *
	 * @return the ip of this parametro
	 */
	@AutoEscape
	public String getIp();

	/**
	 * Sets the ip of this parametro.
	 *
	 * @param ip the ip of this parametro
	 */
	public void setIp(String ip);

	/**
	 * Returns the porta of this parametro.
	 *
	 * @return the porta of this parametro
	 */
	public int getPorta();

	/**
	 * Sets the porta of this parametro.
	 *
	 * @param porta the porta of this parametro
	 */
	public void setPorta(int porta);

	/**
	 * Returns the username of this parametro.
	 *
	 * @return the username of this parametro
	 */
	@AutoEscape
	public String getUsername();

	/**
	 * Sets the username of this parametro.
	 *
	 * @param username the username of this parametro
	 */
	public void setUsername(String username);

	/**
	 * Returns the password of this parametro.
	 *
	 * @return the password of this parametro
	 */
	@AutoEscape
	public String getPassword();

	/**
	 * Sets the password of this parametro.
	 *
	 * @param password the password of this parametro
	 */
	public void setPassword(String password);

	/**
	 * Returns the mittente of this parametro.
	 *
	 * @return the mittente of this parametro
	 */
	@AutoEscape
	public String getMittente();

	/**
	 * Sets the mittente of this parametro.
	 *
	 * @param mittente the mittente of this parametro
	 */
	public void setMittente(String mittente);

	/**
	 * Returns the nodo of this parametro.
	 *
	 * @return the nodo of this parametro
	 */
	@AutoEscape
	public String getNodo();

	/**
	 * Sets the nodo of this parametro.
	 *
	 * @param nodo the nodo of this parametro
	 */
	public void setNodo(String nodo);

	/**
	 * Returns the data connessione of this parametro.
	 *
	 * @return the data connessione of this parametro
	 */
	public Date getDataConnessione();

	/**
	 * Sets the data connessione of this parametro.
	 *
	 * @param dataConnessione the data connessione of this parametro
	 */
	public void setDataConnessione(Date dataConnessione);

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
		it.eng.allerta.messages.services.model.Parametro parametro);

	@Override
	public int hashCode();

	@Override
	public CacheModel<it.eng.allerta.messages.services.model.Parametro>
		toCacheModel();

	@Override
	public it.eng.allerta.messages.services.model.Parametro toEscapedModel();

	@Override
	public it.eng.allerta.messages.services.model.Parametro toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}