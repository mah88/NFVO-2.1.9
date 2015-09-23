/*
 * Copyright (c) 2015 Fraunhofer FOKUS
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

package org.project.openbaton.catalogue.mano.record;

import org.project.openbaton.catalogue.mano.descriptor.VNFComponent;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * Created by lto on 08/09/15.
 */
@Entity
public class VNFCInstance extends VNFComponent implements Serializable {

    protected String vim_id;
    protected String vc_id;
    protected String hostname;
    protected String vnfc_reference;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> floatingIps;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="vnfcinstance_ips")
    @MapKeyColumn(name="network")
    @Column(name="ip")
    private Map<String, String> ips;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getVim_id() {
        return vim_id;
    }

    public void setVim_id(String vim_id) {
        this.vim_id = vim_id;
    }

    public String getVc_id() {
        return vc_id;
    }

    public void setVc_id(String vc_id) {
        this.vc_id = vc_id;
    }

    public String getVnfc_reference() {
        return vnfc_reference;
    }

    public void setVnfc_reference(String vnc_reference) {
        this.vnfc_reference = vnc_reference;
    }

    @Override
    public String toString() {
        return "VNFCInstance{" +
                "vim_id='" + vim_id + '\'' +
                ", vc_id='" + vc_id + '\'' +
                ", hostname='" + hostname + '\'' +
                ", vnfc_reference='" + vnfc_reference + '\'' +
                '}';
    }

    public Set<String> getFloatingIps() {
        return floatingIps;
    }

    public void setFloatingIps(Set<String> floatingIps) {
        this.floatingIps = floatingIps;
    }

    public Map<String, String> getIps() {
        return ips;
    }

    public void setIps(Map<String, String> ips) {
        this.ips = ips;
    }
}