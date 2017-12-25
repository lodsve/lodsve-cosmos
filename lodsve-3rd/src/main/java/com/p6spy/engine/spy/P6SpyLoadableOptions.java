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

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import com.p6spy.engine.spy.appender.P6Logger;

import java.util.Set;

public interface P6SpyLoadableOptions extends P6LoadableOptions, P6SpyOptionsMBean {

    public Set<P6Factory> getModuleFactories();

    void setAutoflush(String autoflush);

    void setReloadProperties(String reloadproperties);

    void setReloadPropertiesInterval(String reloadpropertiesinterval);

    void setStackTrace(String stacktrace);

    void setAppend(String append);

    P6Logger getAppenderInstance();

    MessageFormattingStrategy getLogMessageFormatInstance();

    void setJmx(String jmx);
}
