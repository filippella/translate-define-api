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

import org.dalol.definition.api.model.Definition;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 *
 * @author Filippo-TheAppExpert
 */
public interface WordDefinitionApi {

    @GET("/v4/word.json/{word}/definitions")
    Call<Definition[]> getDefinition(
            @Path("word") String word,
            @Query("limit") int limit,
            @Query("useCanonical") boolean useCanonical,
            @Query("api_key") String api_key
    );
}
