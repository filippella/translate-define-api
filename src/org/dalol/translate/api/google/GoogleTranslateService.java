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
package org.dalol.translate.api.google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.dalol.translate.api.model.Callback;
import org.dalol.translate.api.model.ConnectionListener;
import org.dalol.translate.api.model.ConnectionType;
import org.dalol.translate.api.helper.DalolException;
import org.dalol.translate.api.model.Method;
import org.dalol.translate.api.model.TranslateRequest;
import org.dalol.translate.api.model.TranslateResponse;
import org.dalol.translate.api.signature.TranslateService;
import org.dalol.translate.api.utilities.TranslateUtil;
import org.dalol.translate.api.signature.WebConnection;
import org.dalol.translate.api.model.Word;

public class GoogleTranslateService implements TranslateService {

    private WebConnection connection;

    public GoogleTranslateService(WebConnection connection) {
        this.connection = connection;
    }

    @Override
    public void translate(int position, Callback callback) {
        try {
            this.connection.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            this.connection.setMethod(Method.GET);
            this.connection.setListener(new TranslationConnectionHandler(position, callback));
            this.connection.connect(ConnectionType.HTTP);

        } catch (Exception e) {
            callback.onError(e.getMessage());
        }
    }

    private class TranslationConnectionHandler implements ConnectionListener {

        private final int position;
        private final Callback callback;

        public TranslationConnectionHandler(int position, Callback callback) {
            this.position = position;
            this.callback = callback;
        }

        @Override
        public void onInputReceived(InputStream stream, TranslateRequest request) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
                String rawTranslation = reader.readLine();
                Word word = new Word();
                word.setOriginal(request.getWord());
                word.setTranslated(TranslateUtil.format(rawTranslation));
                TranslateResponse response = new TranslateResponse();
                response.setFrom(request.getFrom());
                response.setPosition(position);
                response.setTo(request.getTo());
                response.setRawTranslation(rawTranslation);
                response.setWord(word);
                callback.onTranslated(response);
                connection.close();
            } catch (UnsupportedEncodingException ex) {
                callback.onError(ex.getMessage());
            } catch (IOException ex) {
                callback.onError(ex.getMessage());
            } finally {
                try {
                    reader.close();
                } catch (IOException ex) {
                    callback.onError(ex.getMessage());
                }
            }
        }

        @Override
        public void onException(DalolException exception) {
            callback.onError(exception.getMessage());
        }
    }
}
