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

import java.text.SimpleDateFormat;
import java.util.Date;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.dalol.definition.api.model.Callback;
import org.dalol.definition.api.model.DefinitionResponse;
import org.dalol.definition.api.signature.DefinitionApi;
import org.dalol.definition.api.signature.DefinitionService;
import org.dalol.definition.api.signature.WordDefinitionApi;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DefinitionServiceImpl implements DefinitionService {

    private final DefinitionApi api;

    public DefinitionServiceImpl(DefinitionApi api) {
        this.api = api;
    }

    @Override
    public void define(int position, String originalPhrase, final Callback callback) {
        WordDefinitionApi definitionApi = this.api.getWordDefinitionApi();
        
        String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String date = format.format(new Date());
        
        Call<DefinitionResponse> call = definitionApi.getDefinition(
                originalPhrase,
                date,
                "8cfdb28ce722969bea9607bee858bfb0aeb02c0932f796b8");
        
        call.enqueue(new retrofit2.Callback<DefinitionResponse>() {

            @Override
            public void onResponse(Call<DefinitionResponse> call, Response<DefinitionResponse> rspns) {
                
                Request request = call.request();
                HttpUrl url = request.url();
                System.out.println(url);
                
                DefinitionResponse response = rspns.body();
                System.out.println("Response -> " + response);
                callback.onDefined(response);
            }

            @Override
            public void onFailure(Call<DefinitionResponse> call, Throwable thrwbl) {
                System.out.println("Flase");
                callback.onError(thrwbl.getMessage());
            }
        });
    }
}
