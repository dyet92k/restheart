/*-
 * ========================LICENSE_START=================================
 * restheart-commons
 * %%
 * Copyright (C) 2019 - 2020 SoftInstigate
 * %%
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
 * =========================LICENSE_END==================================
 */
package org.restheart.plugins;

import com.google.common.reflect.TypeToken;
import java.lang.reflect.Type;
import org.restheart.exchange.Request;
import org.restheart.exchange.Response;

/**
 * Abstract class to get the response and request implementation classes at
 * runtime
 *
 * @author Andrea Di Cesare <andrea@softinstigate.com>
 * @param <R>
 * @param <S>
 */
public interface ExchangeTypeResolver<R extends Request<?>, S extends Response<?>> {
    default Type requestType() {
        return new TypeToken<R>(getClass()) {
        }.getType();
    }

    default Type responseType() {
        return new TypeToken<S>(getClass()) {
        }.getType();
    }
}
