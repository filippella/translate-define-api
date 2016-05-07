/*
 * Copyright 2016 Filippo Engidashet.
 *
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
package org.dalol.translate.api.signature;

import org.dalol.translate.api.model.TranslateRequest;
import org.dalol.translate.api.model.ConnectionListener;
import org.dalol.translate.api.model.ConnectionType;
import org.dalol.translate.api.model.Method;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Filippo-TheAppExpert
 * @param <C>
 */
public abstract class WebConnection<C extends URLConnection>{
    
    protected final TranslateRequest request;
    protected ConnectionListener listener;
    protected final Map<String, String> headers = new ConcurrentHashMap<>();
    protected final Map<String, String> params = new ConcurrentHashMap<>();
    protected String url;
    protected Method method;
    protected InputStream inputStream;
    protected C connection;
    
    public WebConnection(TranslateRequest request) {
        this.request = request;
    }

    public synchronized void addParams(Map<String, String> params) {
        this.params.putAll(params);
    }

    public synchronized void addParam(String name, String value) {
        this.params.put(name, value);
    }

    public synchronized void addHeader(String name, String value) {
        this.headers.put(name, value);
    }

    public synchronized void addHeaders(Map<String, String> headers) {
        this.headers.putAll(headers);
    }

    public void setMethod(Method method) {
        this.method = method;
    }
    
    public void setListener(ConnectionListener listener) {
        this.listener = listener;
    }

    public abstract void connect(ConnectionType type);

    public abstract String getUrl();
    
    public abstract InputStream getInputStream();

    public abstract void close();
    
    public abstract C getConnection();
}
