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

import org.dalol.definition.api.model.DefinitionResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 *
 * @author Filippo-TheAppExpert
 */
public interface WordDefinitionApi {

    @Headers({
        "Host: www.wordsapi.com",
        "Connection: keep-alive",
        "Accept: application/json, text/javascript, */*; q=0.01",
        "X-Requested-With: XMLHttpRequest",
        "User-Agent: Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36",
        "Referer: https://www.wordsapi.com/",
        "Accept-Encoding: gzip, deflate, sdch",
        "Accept-Language: en-US,en;q=0.8",
        "Cookie: __cfduid=d8be99af6a6a59c4eddc16cd0a3fd1d621462618206;",
        "connect.sid: s%3AftjVCQ_C7Md2wZfM1RfreDRI91upTySi.MFzerBJk6HWGRE36mfym624Qe2mJCE7Qcy9j4i%2BXWFU;",
        "_ga: GA1.2.2142621747.1462618207"}
    )
    @GET("/words/{word}/definitions")
    Call<DefinitionResponse> getDefinition(@Path("word") String word, @Query("when") String when, @Query("encrypted") String encrypted);
}
