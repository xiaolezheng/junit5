/*
 * Copyright 2015-2017 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.junit.jupiter.engine.descriptor;

import static org.junit.platform.commons.meta.API.Usage.Internal;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Optional;

import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.meta.API;
import org.junit.platform.engine.EngineExecutionListener;

/**
 * @since 5.0
 */
@API(Internal)
final class TestTemplateContainerExtensionContext extends AbstractExtensionContext<TestTemplateTestDescriptor>
		implements ContainerExtensionContext {

	TestTemplateContainerExtensionContext(ExtensionContext parent, EngineExecutionListener engineExecutionListener,
			TestTemplateTestDescriptor testDescriptor) {
		super(parent, engineExecutionListener, testDescriptor);
	}

	@Override
	public Optional<AnnotatedElement> getElement() {
		return Optional.of(getTestDescriptor().getTestMethod());
	}

	@Override
	public Optional<Class<?>> getTestClass() {
		return Optional.of(getTestDescriptor().getTestClass());
	}

	@Override
	public Optional<Object> getTestInstance() {
		// TODO Determine how to access the test instance
		return null;
	}

	@Override
	public Optional<Method> getTestMethod() {
		return Optional.of(getTestDescriptor().getTestMethod());
	}

}
