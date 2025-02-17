/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.bus;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * @author Dave Syer
 *
 */
@Data
@ConfigurationProperties("spring.cloud.bus")
public class BusProperties {

	/**
	 * Environment change event related properties.
	 */
	private Env env = new Env();
	/**
	 * Refresh event related properties.
	 */
	private Refresh refresh = new Refresh();
	/**
	 * Properties related to acks.
	 */
	private Ack ack = new Ack();
	/**
	 * Properties related to tracing of acks.
	 */
	private Trace trace = new Trace();
	/**
	 * Name of Spring Cloud Stream destination for messages.
	 */
	private String destination = "springCloudBus";

	/**
	 * Flag to indicate that the bus is enabled.
	 */
	private boolean enabled = true;

	@Data
	public static class Env {
		/**
		 * Flag to switch off environment change events (default on).
		 */
		private boolean enabled = true;
	}

	@Data
	public static class Refresh {
		/**
		 * Flag to switch off refresh events (default on).
		 */
		private boolean enabled = true;
	}

	@Data
	public static class Ack {
		/**
		 * Flag to switch off acks (default on).
		 */
		private boolean enabled = true;
		/**
		 * Service that wants to listen to acks. By default null (meaning all services).
		 */
		private String destinationService;
	}

	@Data
	public static class Trace {
		/**
		 * Flag to switch on tracing of acks (default off).
		 */
		private boolean enabled = false;
	}

}
