/********************************************************************************
 * Copyright (c) 2011-2017 Red Hat Inc. and/or its affiliates and others
 *
 * This program and the accompanying materials are made available under the 
 * terms of the Apache License, Version 2.0 which is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: Apache-2.0 
 ********************************************************************************/
package org.eclipse.ceylon.compiler.java.language;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * Helper class for {@code java.io.Serializable} 
 * "singleton" instances (such as 
 * object declarations and value constructors). 
 * In their {@code writeReplace()} method they return a
 * {@code SerializationProxy} instance whose {@link #readResolve()}
 * will invoke the relevant getter during deserialization.
 */
public class SerializationProxy implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private final Class<?> clazz;
    private final Object outer;
    private final String name;

    public SerializationProxy(Class<?> clazz, String name) {
        this(null, clazz, name);
    }
    
    public SerializationProxy(Object outer, Class<?> clazz, String name) {
        this.outer = outer;
        this.clazz = clazz;
        this.name = name;
    }
    
    java.lang.Object readResolve() throws ObjectStreamException {
        Method method;
        try {
            method = clazz.getDeclaredMethod(name);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Could not find method " + name + " in " + clazz, e);
        }
        try {
            method.setAccessible(true);
            return method.invoke(outer);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Could not invoke " + method, e);
        }
    }
    
}
