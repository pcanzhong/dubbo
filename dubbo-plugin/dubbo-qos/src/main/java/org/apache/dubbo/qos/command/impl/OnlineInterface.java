/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.qos.command.impl;

import org.apache.dubbo.common.utils.UrlUtils;
import org.apache.dubbo.qos.api.Cmd;
import org.apache.dubbo.rpc.model.FrameworkModel;
import org.apache.dubbo.rpc.model.ProviderModel;

@Cmd(name = "onlineInterface", summary = "online dubbo", example = {
        "onlineInterface dubbo",
        "onlineInterface xx.xx.xxx.service"
})
public class OnlineInterface extends BaseOnline {
    public OnlineInterface(FrameworkModel frameworkModel) {
        super(frameworkModel);
    }

    @Override
    protected void doExport(ProviderModel.RegisterStatedURL statedURL) {
        if (!UrlUtils.isServiceDiscoveryURL(statedURL.getRegistryUrl())) {
            super.doExport(statedURL);
        }
    }
}
