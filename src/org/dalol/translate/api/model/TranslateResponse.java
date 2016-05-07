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
package org.dalol.translate.api.model;

import org.dalol.translate.api.model.Word;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class TranslateResponse {
    
    private int position;
    private String from;
    private String to;
    private String rawTranslation;
    private Word word;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getRawTranslation() {
        return rawTranslation;
    }

    public void setRawTranslation(String rawTranslation) {
        this.rawTranslation = rawTranslation;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }
}
