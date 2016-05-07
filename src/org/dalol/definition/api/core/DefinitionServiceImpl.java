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
package org.dalol.definition.api.core;

import okhttp3.HttpUrl;
import okhttp3.Request;
import org.dalol.definition.api.model.Callback;
import org.dalol.definition.api.model.Definition;
import org.dalol.definition.api.model.DefinitionRequest;
import org.dalol.definition.api.signature.WordRestApi;
import org.dalol.definition.api.signature.DefinitionService;
import org.dalol.definition.api.signature.WordDefinitionApi;
import retrofit2.Call;
import retrofit2.Response;

public class DefinitionServiceImpl implements DefinitionService {

    private final WordRestApi api;

    public DefinitionServiceImpl(WordRestApi api) {
        this.api = api;
    }

    @Override
    public void define(int position, final DefinitionRequest definitionRequest, final Callback callback) {
        WordDefinitionApi definitionApi = this.api.getWordDefinitionApi();
        Call<Definition[]> call = definitionApi.getDefinition(
                definitionRequest.getPhrase(),
                definitionRequest.getLimit(),
                definitionRequest.isUseCanonical(),
                definitionRequest.getApiKey()
        );
        call.enqueue(new retrofit2.Callback<Definition[]>() {

            @Override
            public void onResponse(Call<Definition[]> call, Response<Definition[]> rspns) {
                Request request = call.request();
                HttpUrl url = request.url();
                System.out.println(url);

                Definition[] response = rspns.body();
                callback.onDefined(definitionRequest.getPhrase(), response);
            }

            @Override
            public void onFailure(Call<Definition[]> call, Throwable thrwbl) {
                Request request = call.request();
                HttpUrl url = request.url();
                System.out.println(url);
                thrwbl.printStackTrace();
                System.err.println(thrwbl.getLocalizedMessage());

                callback.onError(thrwbl.getMessage());
            }
        });
    }
}
