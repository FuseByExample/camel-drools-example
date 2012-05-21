/*
 * Copyright 2012 FuseSource
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.mycompany.camel.drools;

import java.util.Collection;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.drools.runtime.ExecutionResults;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelContextXmlTest extends CamelSpringTestSupport {
	// templates to send to input endpoints
	@Produce(uri = "direct:paymentServiceEndpoint")
	protected ProducerTemplate inputEndpoint;

	@Test
	public void testCamelRoute() throws Exception {
		Person person = new Person();
		person.setName("Scott");
		person.setAge(21);

		ExecutionResults response = inputEndpoint.requestBody(person, ExecutionResults.class);

		assertNotNull(response);

		// Expecting single result value of type Person
		final Collection<String> identifiers = response.getIdentifiers();
		assertNotNull(identifiers);
		assertTrue(identifiers.size() >= 1);

		for (String identifier : identifiers) {
			final Object value = response.getValue(identifier);
			assertNotNull(value);
			assertIsInstanceOf(Person.class, value);
			System.out.println(identifier + " = " + value);
		}
	}

	@Override
	protected ClassPathXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
	}
}
