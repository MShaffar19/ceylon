/********************************************************************************
 * Copyright (c) {date} Red Hat Inc. and/or its affiliates and others
 *
 * This program and the accompanying materials are made available under the 
 * terms of the Apache License, Version 2.0 which is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * SPDX-License-Identifier: Apache-2.0 
 ********************************************************************************/
package org.eclipse.ceylon.cmr.api;

import java.util.Objects;
import java.util.Set;

/**
 * Module info.
 *
 * @author <a href="mailto:ales.justin@jboss.org">Ales Justin</a>
 */
public final class ModuleInfo {
    private String namespace;
    private String filter;
    private String name;
    private String version;
    private String groupId;
    private String artifactId;
    private String classifier;
    private Set<ModuleDependencyInfo> dependencies;

    public ModuleInfo(String namespace, String name, String version, 
            String groupId, String artifactId, String classifier,
            String filter, Set<ModuleDependencyInfo> dependencies) {
        this.namespace = namespace;
        this.name = name;
        this.version = version;
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.classifier = classifier;
        this.filter = filter;
        this.dependencies = dependencies;
    }
    
    public String getNamespace() {
        return namespace;
    }
    
    public String getName(){
        return name;
    }
    
    public String getVersion(){
        return version;
    }
    
    public String getGroupId() {
        return groupId;
    }
    
    public String getArtifactId() {
        return artifactId;
    }
    
    public String getClassifier() {
        return classifier;
    }
    
    public Set<ModuleDependencyInfo> getDependencies() {
        return dependencies;
    }
    
    public String getFilter() {
        return filter;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModuleInfo that = (ModuleInfo) o;
        return Objects.equals(filter, that.filter)
            && Objects.equals(name, that.name)
            && Objects.equals(version, that.version)
            && dependencies.equals(that.dependencies);
    }

    @Override
    public int hashCode() {
        int ret = 17;
        ret = 37 * ret + (filter == null ? 0 : filter.hashCode());
        ret = 37 * ret + (name == null ? 0 : name.hashCode());
        ret = 37 * ret + (version == null ? 0 : version.hashCode());
        ret = 37 * ret + dependencies.hashCode();
        return ret;
    }

    @Override
    public String toString() {
        return "[filter: "+filter+", dependencies: "+dependencies+"]";
    }
}
