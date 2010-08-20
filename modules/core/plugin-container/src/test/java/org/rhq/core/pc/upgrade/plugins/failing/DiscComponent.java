/*
 * RHQ Management Platform
 * Copyright (C) 2005-2010 Red Hat, Inc.
 * All rights reserved.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package org.rhq.core.pc.upgrade.plugins.failing;

import java.util.Collections;
import java.util.Set;

import org.rhq.core.domain.resource.ResourceUpgradeReport;
import org.rhq.core.pluginapi.inventory.DiscoveredResourceDetails;
import org.rhq.core.pluginapi.inventory.InvalidPluginConfigurationException;
import org.rhq.core.pluginapi.inventory.ResourceComponent;
import org.rhq.core.pluginapi.inventory.ResourceDiscoveryComponent;
import org.rhq.core.pluginapi.inventory.ResourceDiscoveryContext;
import org.rhq.core.pluginapi.upgrade.ResourceUpgradeContext;
import org.rhq.core.pluginapi.upgrade.ResourceUpgradeFacet;

/**
 *
 * @author Lukas Krejci
 */
public class DiscComponent implements ResourceDiscoveryComponent<ResourceComponent>,
    ResourceUpgradeFacet<ResourceComponent> {
    
    private static final String RESOURCE_KEY = "resource-key-failing";
    private static final String RESOURCE_NAME = "resource-name-failing";
    private static final String RESOURCE_DESCRIPTION = "resource-description-failing";

    public Set<DiscoveredResourceDetails> discoverResources(ResourceDiscoveryContext<ResourceComponent> context)
        throws InvalidPluginConfigurationException, Exception {
        return Collections.singleton(new DiscoveredResourceDetails(context.getResourceType(), RESOURCE_KEY,
            RESOURCE_NAME, null, RESOURCE_DESCRIPTION, context.getDefaultPluginConfiguration(), null));
    }

    public ResourceUpgradeReport upgrade(ResourceUpgradeContext<ResourceComponent> inventoriedResource) {
        throw new RuntimeException("Failing the upgrade purposefully.");
    }
}
