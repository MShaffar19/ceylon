/********************************************************************************
 * Copyright (c) {date} Red Hat Inc. and/or its affiliates and others
 *
 * This program and the accompanying materials are made available under the 
 * terms of the Apache License, Version 2.0 which is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: Apache-2.0 
 ********************************************************************************/
package ceylon.language;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;

import org.eclipse.ceylon.compiler.java.language.AbstractCallable;
import org.eclipse.ceylon.compiler.java.metadata.Ceylon;
import org.eclipse.ceylon.compiler.java.metadata.Defaulted;
import org.eclipse.ceylon.compiler.java.metadata.FunctionalParameter;
import org.eclipse.ceylon.compiler.java.metadata.Ignore;
import org.eclipse.ceylon.compiler.java.metadata.Method;
import org.eclipse.ceylon.compiler.java.metadata.Name;
import org.eclipse.ceylon.compiler.java.metadata.TypeInfo;
import org.eclipse.ceylon.compiler.java.runtime.model.TypeDescriptor;

@Ceylon(major = 8)
@Method
@SharedAnnotation$annotation$
@NativeAnnotation$annotation$(backends={})
public final class printStackTrace_ {
    public static void printStackTrace(
            @TypeInfo("ceylon.language::Throwable")
            @Name("exception") final java.lang.Throwable throwable,
            @TypeInfo("ceylon.language::Callable<ceylon.language::Anything,ceylon.language::Tuple<ceylon.language::String,ceylon.language::String,ceylon.language::Empty>>")
            @Defaulted @Name("write") @FunctionalParameter("!(string)")
            final Callable<? extends java.lang.Object> write) {
        PrintWriter writer = new PrintWriter(new Writer() {
            @Override
            public void write(char[] cbuf, int off, int len) throws IOException {
                write.$call$(String.instance(new java.lang.String(Arrays.copyOfRange(cbuf, off, off+len))));
            }
            @Override
            public void flush() throws IOException {}
            @Override
            public void close() throws IOException {}
        });
        throwable.printStackTrace(writer);
        writer.flush();
    }
    
    @Ignore
    public static void printStackTrace(final java.lang.Throwable throwable) {
        printStackTrace(throwable, printStackTrace$writeLine());
    }
    
    @Ignore
    public static Callable<java.lang.Object> printStackTrace$writeLine() {
        return new AbstractCallable<java.lang.Object>(Anything.$TypeDescriptor$, 
                TypeDescriptor.klass(Tuple.class, String.$TypeDescriptor$, String.$TypeDescriptor$, Empty.$TypeDescriptor$),
                "write", (short)-1) {
            @Override
            public java.lang.Object $call$(java.lang.Object arg) {
                System.err.print(arg);
                return null;
            }
        };
    }
    
    private printStackTrace_(){}
}
