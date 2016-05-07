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
package org.dalol.translate.api.core;

import org.dalol.translate.api.signature.WebConnection;
import org.dalol.translate.api.helper.DalolException;
import org.dalol.translate.api.model.TranslateRequest;
import org.dalol.translate.api.model.ConnectionType;
import org.dalol.translate.api.utilities.TranslateUtil;
import org.dalol.translate.api.model.Method;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class GoogleHTTPConnection extends WebConnection<HttpURLConnection> {

    private HttpURLConnection connection;

    public GoogleHTTPConnection(TranslateRequest request) {
        super(request);
    }

    @Override
    public void connect(ConnectionType type) {
        try {
            switch (type) {
                case HTTP:
                    this.connection = (HttpURLConnection) new URL(getUrl()).openConnection();
                    for (Map.Entry<String, String> header : headers.entrySet()) {
                        connection.addRequestProperty(header.getKey(), header.getValue());
                    }
                    this.connection.setRequestMethod(this.method == null ? Method.GET.name() : this.method.name());
                    this.connection.connect();
                    if (this.listener != null) {
                        this.inputStream = connection.getInputStream();
                        this.listener.onInputReceived(this.inputStream, this.request);
                    }
                    break;
                case HTTPS:
                    //Will be implemented if required
                    break;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            if (this.listener != null) {
                this.listener.onException(new DalolException(e));
            }
        }
    }

    @Override
    public String getUrl() {
        return TranslateUtil.encode(
                request.getFrom(),
                request.getTo(),
                request.getWord()
        );
    }

    @Override
    public InputStream getInputStream() {
        return this.inputStream;
    }

    @Override
    public void close() {
        this.connection.disconnect();
    }

    @Override
    public HttpURLConnection getConnection() {
        return this.connection;
    }
}
