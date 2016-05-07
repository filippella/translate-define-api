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

import java.util.List;
import org.dalol.definition.api.signature.WordRestApiImpl;
import org.dalol.definition.api.signature.WordRestApi;
import org.dalol.pronounciation.api.core.PronounciationServiceImpl;
import org.dalol.pronounciation.api.model.Callback;
import org.dalol.pronounciation.api.model.Pronounciation;
import org.dalol.pronounciation.api.model.PronounciationRequest;
import org.dalol.pronounciation.api.signature.PronounciationService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class PronountiationDemo {

    private final static String API_KEY = "a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5";

    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.wordnik.com")
                .build();

        WordRestApi api = new WordRestApiImpl(retrofit);
        PronounciationService service = new PronounciationServiceImpl(api);

        PronounciationRequest request = new PronounciationRequest(false, API_KEY);
        request.setLimit(50);
        request.setPhrase("Ethiopia");

        service.getPronounciation(request, new Callback() {

            @Override
            public void onPronountiation(List<Pronounciation> response) {
                System.out.println("----------------------------------------------------------------------");
                System.out.println("LIST OF WORD PRONOUNCIATION FOR -> " + response.get(0).getRawType());
                System.out.println("----------------------------------------------------------------------");

                for (Pronounciation pronounciation : response) {
                    System.out.println(pronounciation.getRaw() + " - (" + pronounciation.getSeq() + ") * " + pronounciation.getRawType());
                }
                System.exit(0);
            }

            @Override
            public void onError(String error) {
                System.err.println(error);
                System.exit(0);
            }
        });
    }
}
