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

import org.dalol.translate.api.signature.TranslateService;
import org.dalol.translate.api.signature.TranslateApi;
import org.dalol.translate.api.model.Callback;


public class TranslateApiImpl implements TranslateApi {

    private TranslateService service;
    
    public TranslateApiImpl(TranslateService service) {
        this.service = service;
    }
    
    @Override
    public void translate(int position, Callback callback) {
        service.translate(position, callback);
    }
}
