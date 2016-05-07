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
package org.dalol.definition.api.demo;

import org.dalol.translate.api.model.Callback;
import org.dalol.translate.api.core.GoogleHTTPConnection;
import org.dalol.translate.api.google.GoogleTranslateService;
import org.dalol.translate.api.model.LanguageSet;
import org.dalol.translate.api.signature.TranslateApi;
import org.dalol.translate.api.core.TranslateApiImpl;
import org.dalol.translate.api.model.TranslateRequest;
import org.dalol.translate.api.model.TranslateResponse;
import org.dalol.translate.api.signature.TranslateService;
import org.dalol.translate.api.signature.WebConnection;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class TranslateDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TranslateRequest request = new TranslateRequest(
                LanguageSet.GOOGLE.getAuto(),
                LanguageSet.GOOGLE.getItalian(),
                "My name is Filippo - I am a senior programmer");
        
        WebConnection connection = new GoogleHTTPConnection(request);
        TranslateService translateService = new GoogleTranslateService(connection);        
        TranslateApi api = new TranslateApiImpl(translateService);
        api.translate(0, new Callback() {
            @Override
            public void onError(String error) {
                System.err.println("Error -> " + error);
            }

            @Override
            public void onTranslated(TranslateResponse response) {
                System.out.println(response.getWord());
            }
        });
    }
}
