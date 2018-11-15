/*
 * Copyright (c) 2017-2018 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *   2018-09-29 - Rudy De Busscher
 *      Initially authored in Atbash Jessie
 */
package org.eclipse.microprofile.starter.addon.microprofile.servers.model;

import org.eclipse.microprofile.starter.core.model.MicroProfileVersion;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum SupportedServer {
    // @formatter:off
    WILDFLY_SWARM("wildfly-swarm", Collections.singletonList(MicroProfileVersion.MP12))
    , THORNTAIL_V2("thorntail-v2", Arrays.asList(MicroProfileVersion.MP12, MicroProfileVersion.MP13))
    , LIBERTY("liberty", Arrays.asList(MicroProfileVersion.MP12, MicroProfileVersion.MP13, MicroProfileVersion.MP14, MicroProfileVersion.MP20))
    , KUMULUZEE("kumuluzEE", Collections.singletonList(MicroProfileVersion.MP12))
    , PAYARA_MICRO("payara-micro", Arrays.asList(MicroProfileVersion.MP12, MicroProfileVersion.MP13, MicroProfileVersion.MP14, MicroProfileVersion.MP20));
    // @formatter:on

    private String name;
    private List<MicroProfileVersion> mpVersions;

    SupportedServer(String name, List<MicroProfileVersion> mpVersions) {
        this.name = name;
        this.mpVersions = mpVersions;
    }

    public String getName() {
        return name;
    }

    public List<MicroProfileVersion> getMpVersions() {
        return mpVersions;
    }

    public static SupportedServer valueFor(String data) {
        SupportedServer result = null;
        for (SupportedServer supportedServer : SupportedServer.values()) {
            if (supportedServer.name.equals(data)) {
                result = supportedServer;
            }
        }
        return result;
    }
}