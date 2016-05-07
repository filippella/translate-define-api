# translate-define-api

This project is a sample for a complete dictionar, translation java program, It can also be used for android.

 * Translate any word, phrase or sentence to any language.
 * Define any word

Translation Demo

```java

public class TranslateDemo {

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

public class DefinitionDemo {

    private final static String API_KEY = "a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5";

    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.wordnik.com")
                .build();

        WordRestApi api = new WordRestApiImpl(retrofit);
        DefinitionService service = new DefinitionServiceImpl(api);

        DefinitionRequest request = new DefinitionRequest(false, API_KEY);
        request.setLimit(50);
        request.setPhrase("Ethiopia");

        service.define(0, request, new Callback() {

            @Override
            public void onDefined(Definition[] response) {
                
                System.out.println("----------------------------------------------------------------------");
                System.out.println("LIST OF WORD DEFINITION FOR -> " + response[0].getWord());
                System.out.println("----------------------------------------------------------------------");
                
                for (Definition definition : response) {
                    System.out.println(definition.getWord() + " - (" + definition.getPartOfSpeech() + ") * " + definition.getText());
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

```
Pronountiation Demo

```java
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
