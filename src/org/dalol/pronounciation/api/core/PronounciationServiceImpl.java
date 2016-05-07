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
package org.dalol.pronounciation.api.core;

import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.dalol.definition.api.signature.WordRestApi;
import org.dalol.pronounciation.api.model.Callback;
import org.dalol.pronounciation.api.model.Pronounciation;
import org.dalol.pronounciation.api.model.PronounciationRequest;
import org.dalol.pronounciation.api.signature.PronounciationService;
import org.dalol.pronounciation.api.signature.WordPronountiationApi;
import retrofit2.Call;
import retrofit2.Response;


public class PronounciationServiceImpl implements PronounciationService {

    private final WordRestApi api;

    public PronounciationServiceImpl(WordRestApi api) {
        this.api = api;
    }
    
    @Override
    public void getPronounciation(PronounciationRequest request, Callback callback) {
        WordPronountiationApi pronountiationApi = this.api.getWordPronountiationApi();
        Call<List<Pronounciation>> call = pronountiationApi.getPronounciation(
                request.getPhrase(),
                request.getLimit(),
                request.isUseCanonical(),
                request.getApiKey()
        );
        call.enqueue(new retrofit2.Callback<List<Pronounciation>>() {

            @Override
            public void onResponse(Call<List<Pronounciation>> call, Response<List<Pronounciation>> rspns) {
                Request request = call.request();
                HttpUrl url = request.url();
                System.out.println(url);

                List<Pronounciation> response = rspns.body();
                callback.onPronountiation(response);
            }

            @Override
            public void onFailure(Call<List<Pronounciation>> call, Throwable thrwbl) {
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
