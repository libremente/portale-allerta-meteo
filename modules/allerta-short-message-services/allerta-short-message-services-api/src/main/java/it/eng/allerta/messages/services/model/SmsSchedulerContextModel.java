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

/**
 * The base model interface for the SmsSchedulerContext service. Represents a row in the &quot;smsService_SmsSchedulerContext&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>it.eng.allerta.messages.services.model.impl.SmsSchedulerContextModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>it.eng.allerta.messages.services.model.impl.SmsSchedulerContextImpl</code>.
 * </p>
 *
 * @author Giorgianni_F
 * @see SmsSchedulerContext
 * @generated
 */
@ProviderType
public interface SmsSchedulerContextModel
	extends BaseModel<SmsSchedulerContext> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a sms scheduler context model instance should use the {@link SmsSchedulerContext} interface instead.
	 */

	/**
	 * Returns the primary key of this sms scheduler context.
	 *
	 * @return the primary key of this sms scheduler context
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this sms scheduler context.
	 *
	 * @param primaryKey the primary key of this sms scheduler context
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the var ID of this sms scheduler context.
	 *
	 * @return the var ID of this sms scheduler context
	 */
	@AutoEscape
	public String getVarId();

	/**
	 * Sets the var ID of this sms scheduler context.
	 *
	 * @param varId the var ID of this sms scheduler context
	 */
	public void setVarId(String varId);

	/**
	 * Returns the value of this sms scheduler context.
	 *
	 * @return the value of this sms scheduler context
	 */
	@AutoEscape
	public String getValue();

	/**
	 * Sets the value of this sms scheduler context.
	 *
	 * @param value the value of this sms scheduler context
	 */
	public void setValue(String value);

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
		it.eng.allerta.messages.services.model.SmsSchedulerContext
			smsSchedulerContext);

	@Override
	public int hashCode();

	@Override
	public CacheModel
		<it.eng.allerta.messages.services.model.SmsSchedulerContext>
			toCacheModel();

	@Override
	public it.eng.allerta.messages.services.model.SmsSchedulerContext
		toEscapedModel();

	@Override
	public it.eng.allerta.messages.services.model.SmsSchedulerContext
		toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}