/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.service.launcher.testservices;

import org.apache.hadoop.service.launcher.AbstractLaunchableService;
import org.apache.hadoop.service.launcher.LauncherExitCodes;
import org.apache.hadoop.service.launcher.ServiceLaunchException;

/**
 * Try to stop() in service start; in execute() raise an exception.
 */
public class StoppingInStartLaunchableService
    extends AbstractLaunchableService {

  public static final String NAME =
      "org.apache.hadoop.service.launcher.testservices.StoppingInStartLaunchableService";
  public StoppingInStartLaunchableService(String name) {
    super(name);
  }

  @Override
  protected void serviceStart() throws Exception {
    super.serviceStart();
    stop();
    }

  @Override
  public int execute() throws Exception {
    throw new ServiceLaunchException(
        LauncherExitCodes.EXIT_SERVICE_LIFECYCLE_EXCEPTION,
        "Should not have been executed");
  }
}
