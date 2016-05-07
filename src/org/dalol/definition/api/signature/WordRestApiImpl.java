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
package org.dalol.definition.api.signature;

import org.dalol.pronounciation.api.signature.WordPronountiationApi;
import retrofit2.Retrofit;


public class WordRestApiImpl implements WordRestApi {
    
    private final Retrofit retrofit;

    public WordRestApiImpl(Retrofit retrofit) {
        this.retrofit = retrofit;
    }
    
    @Override
    public WordDefinitionApi getWordDefinitionApi() {
        return this.retrofit.create(WordDefinitionApi.class);
    }

    @Override
    public WordPronountiationApi getWordPronountiationApi() {
        return this.retrofit.create(WordPronountiationApi.class);
    }
}
