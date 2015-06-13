/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jooby.internal.pac4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.pac4j.core.profile.UserProfile;

public class ClientType {

  @SuppressWarnings("unchecked")
  public static Class<? extends UserProfile> typeOf(final Class<?> client) {
    Type genericType = client.getGenericSuperclass();
    if (genericType instanceof ParameterizedType) {
      Type[] types = ((ParameterizedType) genericType).getActualTypeArguments();
      for (Type type : types) {
        if (UserProfile.class.isAssignableFrom((Class<?>) type)) {
          return (Class<? extends UserProfile>) type;
        }
      }
    }
    return UserProfile.class;
  }

}