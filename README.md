# translate-define-api

This project is a sample for a complete dictionar, translation java program, It can also be used for android.

 * Translate any word, phrase or sentence to any language.
 * Define any word

Translation Demo

```java

public class TranslateTest {

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
```

Definition Demo

```java

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
```

License
-------

Copyright 2016 Filippo Engidashet.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
