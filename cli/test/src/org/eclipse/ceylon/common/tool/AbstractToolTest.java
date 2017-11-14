/********************************************************************************
 * Copyright (c) {date} Red Hat Inc. and/or its affiliates and others
 *
 * This program and the accompanying materials are made available under the 
 * terms of the Apache License, Version 2.0 which is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: Apache-2.0 
 ********************************************************************************/
package org.eclipse.ceylon.common.tool;

import org.eclipse.ceylon.common.tool.ToolFactory;
import org.eclipse.ceylon.common.tool.ToolLoader;
import org.eclipse.ceylon.common.tools.CeylonTool;

public class AbstractToolTest {
    protected final ToolFactory pluginFactory = new ToolFactory();
    protected final ToolLoader pluginLoader = new TestingToolLoader();

    protected CeylonTool getMainTool() {
        return pluginLoader.instance("", null);
    }
}
