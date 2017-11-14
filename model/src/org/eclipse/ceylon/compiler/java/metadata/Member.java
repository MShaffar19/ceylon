/********************************************************************************
 * Copyright (c) {date} Red Hat Inc. and/or its affiliates and others
 *
 * This program and the accompanying materials are made available under the 
 * terms of the Apache License, Version 2.0 which is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: Apache-2.0 
 ********************************************************************************/
package org.eclipse.ceylon.compiler.java.metadata;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation applied to an interface in order to list all its members
 * that have been extracted out of it.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Member {
    
    /**
     * The member class if it can be pointed to
     */
    java.lang.Class<?> klass() default void.class;
    
    /**
     * The member class if it cannot be pointed to because local types interfere with visibility
     */
    String javaClassName() default "";
}
