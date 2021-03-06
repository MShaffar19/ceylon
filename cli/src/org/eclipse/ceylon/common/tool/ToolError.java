/********************************************************************************
 * Copyright (c) 2011-2017 Red Hat Inc. and/or its affiliates and others
 *
 * This program and the accompanying materials are made available under the 
 * terms of the Apache License, Version 2.0 which is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: Apache-2.0 
 ********************************************************************************/
package org.eclipse.ceylon.common.tool;

/**
 * Interface for {@code Exception} classes which need to have control 
 * over how the ceylon tool reports the exception.
 * 
 * @see FatalToolError
 */
public abstract class ToolError extends RuntimeException {

    private static final long serialVersionUID = -6643856948547361957L;
    
    private int exitCode = -1;
    
    public ToolError(String message, Throwable cause) {
        super(message, cause);
    }

    public ToolError(String message) {
        super(message);
    }

    public ToolError(String message, int exitCode) {
        super(message);
        this.exitCode = exitCode;
    }

    public ToolError(Throwable cause) {
        super(cause);
    }

    public boolean getShowStacktrace() {
        return false;
    }
    
    /**
     * Gets the error message, which should be a single line of text.
     * This is the message which should be printed to stdout/stderr
     * and as such may be distinct from the exception's 
     * {@link Throwable#getMessage()} or {@link Throwable#getLocalizedMessage()}.
     */
    public String getErrorMessage() {
        return getLocalizedMessage();
    }

    public boolean isExitCodeProvided(){
        return exitCode != -1;
    }

    public int getExitCode(){
        return exitCode;
    }
}
