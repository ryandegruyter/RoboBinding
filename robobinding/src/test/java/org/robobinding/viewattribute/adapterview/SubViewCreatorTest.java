/**
 * Copyright 2012 Cheng Wei, Robert Taylor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.robobinding.viewattribute.adapterview;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.robobinding.presentationmodel.PresentationModelAdapter;
import org.robobinding.viewattribute.BindingAttributeValues;
import org.robobinding.viewattribute.MockPresentationModelAdapterBuilder;
import org.robobinding.viewattribute.MockResourcesBuilder;

import android.content.Context;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Cheng Wei
 */
public class SubViewCreatorTest
{
	@Test
	public void whenGetLayoutId_returnExpectedResult()
	{
		MockResourcesBuilder builder = new MockResourcesBuilder();
		int layoutId = builder.desclareLayoutResource(BindingAttributeValues.DEFAULT_LAYOUT_RESOURCE_NAME);
		Context mockContext = builder.build();
		
		SubViewCreator subViewCreator = new SubViewCreator(mockContext, BindingAttributeValues.DEFAULT_LAYOUT_RESOURCE);
		assertThat(subViewCreator.getLayoutId(), equalTo(layoutId));
	}
	
	@Test
	public void whenGetPresentationModel_returnExpectedResult()
	{
		SubViewCreator subViewCreator = new SubViewCreator(null, null);
		
		Object presentationModel = new Object();
		String presentationModelAttributeValue = BindingAttributeValues.ONE_WAY_BINDING_DEFAULT_PROPERTY_NAME; 
		
		PresentationModelAdapter mockPresentationModelAdapter = MockPresentationModelAdapterBuilder.createWithReadOnlyDefaultProperty(presentationModel);
		
		assertThat(subViewCreator.getPresentationModel(mockPresentationModelAdapter, presentationModelAttributeValue),
				equalTo(presentationModel));
	}
}
