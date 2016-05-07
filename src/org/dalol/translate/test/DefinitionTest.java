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
package org.dalol.translate.test;

import org.dalol.definition.api.core.DefinitionServiceImpl;
import org.dalol.definition.api.model.Callback;
import org.dalol.definition.api.model.DefinitionResponse;
import org.dalol.definition.api.signature.DefinitionApi;
import org.dalol.definition.api.signature.DefinitionApiImpl;
import org.dalol.definition.api.signature.DefinitionService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class DefinitionTest {

    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.wordsapi.com")
                .build();

        DefinitionApi api = new DefinitionApiImpl(retrofit);

        DefinitionService service = new DefinitionServiceImpl(api);
        service.define(0, "water", new Callback() {

            @Override
            public void onDefined(DefinitionResponse response) {
                System.out.println(response);
                System.exit(0);
            }

            @Override
            public void onError(String error) {
                System.err.println(error + " error");
                System.exit(0);
            }
        });
    }
}
