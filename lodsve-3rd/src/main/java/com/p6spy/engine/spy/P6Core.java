/**
 * P6Spy
 * <p>
 * Copyright (C) 2002 - 2017 P6Spy
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.p6spy.engine.spy;

import com.p6spy.engine.common.ConnectionInformation;
import com.p6spy.engine.event.JdbcEventListener;
import com.p6spy.engine.wrapper.ConnectionWrapper;

import java.sql.Connection;

/**
 * @author Quinton McCombs
 * @since 09/2013
 * @deprecated use {@link ConnectionWrapper} instead. Should be removed with next major release.
 */
public class P6Core {

    @SuppressWarnings("resource")
    public static Connection wrapConnection(Connection realConnection, ConnectionInformation connectionInformation) {
        if (realConnection == null) {
            return null;
        }
        return new ConnectionWrapper(realConnection, new DefaultJdbcEventListenerFactory().createJdbcEventListener(), connectionInformation).wrap();
    }

    public static JdbcEventListener getJdbcEventListener() {
        return new DefaultJdbcEventListenerFactory().createJdbcEventListener();
    }

}