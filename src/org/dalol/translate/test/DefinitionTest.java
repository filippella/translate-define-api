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

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.dalol.definition.api.model.Definition;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class DefinitionTest {

    private String j = "[\n"
            + "    {\n"
            + "        \"textProns\": [],\n"
            + "        \"sourceDictionary\": \"ahd-legacy\",\n"
            + "        \"exampleUses\": [],\n"
            + "        \"relatedWords\": [],\n"
            + "        \"labels\": [],\n"
            + "        \"citations\": [],\n"
            + "        \"word\": \"car\",\n"
            + "        \"partOfSpeech\": \"noun\",\n"
            + "        \"attributionText\": \"from The American Heritage® Dictionary of the English Language, 4th Edition\",\n"
            + "        \"sequence\": \"0\",\n"
            + "        \"text\": \"An automobile.\",\n"
            + "        \"score\": 0\n"
            + "    },\n"
            + "    {\n"
            + "        \"textProns\": [],\n"
            + "        \"sourceDictionary\": \"ahd-legacy\",\n"
            + "        \"exampleUses\": [],\n"
            + "        \"relatedWords\": [],\n"
            + "        \"labels\": [],\n"
            + "        \"citations\": [],\n"
            + "        \"word\": \"car\",\n"
            + "        \"partOfSpeech\": \"noun\",\n"
            + "        \"attributionText\": \"from The American Heritage® Dictionary of the English Language, 4th Edition\",\n"
            + "        \"sequence\": \"1\",\n"
            + "        \"text\": \"A vehicle, such as a streetcar, that runs on rails:  a railroad car. \",\n"
            + "        \"score\": 0\n"
            + "    },\n"
            + "    {\n"
            + "        \"textProns\": [],\n"
            + "        \"sourceDictionary\": \"ahd-legacy\",\n"
            + "        \"exampleUses\": [],\n"
            + "        \"relatedWords\": [],\n"
            + "        \"labels\": [],\n"
            + "        \"citations\": [],\n"
            + "        \"word\": \"car\",\n"
            + "        \"partOfSpeech\": \"noun\",\n"
            + "        \"attributionText\": \"from The American Heritage® Dictionary of the English Language, 4th Edition\",\n"
            + "        \"sequence\": \"2\",\n"
            + "        \"text\": \"A boxlike enclosure for passengers and freight on a conveyance:  an elevator car. \",\n"
            + "        \"score\": 0\n"
            + "    }\n"
            + "]";

    private String json = "[\n"
            + "    {\n"
            + "        \"textProns\": [],\n"
            + "        \"sourceDictionary\": \"ahd-legacy\",\n"
            + "        \"exampleUses\": [],\n"
            + "        \"relatedWords\": [],\n"
            + "        \"labels\": [],\n"
            + "        \"citations\": [],\n"
            + "        \"word\": \"play\",\n"
            + "        \"partOfSpeech\": \"verb-intransitive\",\n"
            + "        \"attributionText\": \"from The American Heritage® Dictionary of the English Language, 4th Edition\",\n"
            + "        \"sequence\": \"0\",\n"
            + "        \"text\": \"To occupy oneself in amusement, sport, or other recreation:  children playing with toys. \",\n"
            + "        \"score\": 0\n"
            + "    },\n"
            + "    {\n"
            + "        \"textProns\": [],\n"
            + "        \"sourceDictionary\": \"ahd-legacy\",\n"
            + "        \"exampleUses\": [],\n"
            + "        \"relatedWords\": [],\n"
            + "        \"labels\": [],\n"
            + "        \"citations\": [],\n"
            + "        \"word\": \"play\",\n"
            + "        \"partOfSpeech\": \"verb-intransitive\",\n"
            + "        \"attributionText\": \"from The American Heritage® Dictionary of the English Language, 4th Edition\",\n"
            + "        \"sequence\": \"1\",\n"
            + "        \"text\": \"To take part in a game:  No minors are eligible to play. \",\n"
            + "        \"score\": 0\n"
            + "    },\n"
            + "    {\n"
            + "        \"textProns\": [],\n"
            + "        \"sourceDictionary\": \"ahd-legacy\",\n"
            + "        \"exampleUses\": [],\n"
            + "        \"relatedWords\": [],\n"
            + "        \"labels\": [],\n"
            + "        \"citations\": [],\n"
            + "        \"word\": \"play\",\n"
            + "        \"partOfSpeech\": \"verb-intransitive\",\n"
            + "        \"attributionText\": \"from The American Heritage® Dictionary of the English Language, 4th Edition\",\n"
            + "        \"sequence\": \"2\",\n"
            + "        \"text\": \"To participate in betting; gamble.\",\n"
            + "        \"score\": 0\n"
            + "    },\n"
            + "    {\n"
            + "        \"textProns\": [],\n"
            + "        \"sourceDictionary\": \"ahd-legacy\",\n"
            + "        \"exampleUses\": [],\n"
            + "        \"relatedWords\": [],\n"
            + "        \"labels\": [],\n"
            + "        \"citations\": [],\n"
            + "        \"word\": \"play\",\n"
            + "        \"partOfSpeech\": \"verb-intransitive\",\n"
            + "        \"attributionText\": \"from The American Heritage® Dictionary of the English Language, 4th Edition\",\n"
            + "        \"sequence\": \"3\",\n"
            + "        \"text\": \"To act in jest or sport:  They're not arguing in earnest, they're just playing. \",\n"
            + "        \"score\": 0\n"
            + "    },\n"
            + "    {\n"
            + "        \"textProns\": [],\n"
            + "        \"sourceDictionary\": \"ahd-legacy\",\n"
            + "        \"exampleUses\": [],\n"
            + "        \"relatedWords\": [],\n"
            + "        \"labels\": [],\n"
            + "        \"citations\": [],\n"
            + "        \"word\": \"play\",\n"
            + "        \"partOfSpeech\": \"verb-intransitive\",\n"
            + "        \"attributionText\": \"from The American Heritage® Dictionary of the English Language, 4th Edition\",\n"
            + "        \"sequence\": \"4\",\n"
            + "        \"text\": \"To deal or behave carelessly or indifferently; toy. See Synonyms at flirt.\",\n"
            + "        \"score\": 0\n"
            + "    }\n"
            + "]";

    public List<Definition> bindJson() {
        Gson gson = new Gson();
        return gson.fromJson(j, ArrayList.class);
    }

    public static void main(String[] args) {
        DefinitionTest test = new DefinitionTest();
        List<Definition> definitionList = test.bindJson();
        System.out.println(definitionList.size());
    }
}
