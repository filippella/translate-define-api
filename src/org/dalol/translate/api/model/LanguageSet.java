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

/**
 *
 * @author Filippo-TheAppExpert
 */
public enum LanguageSet {

    GOOGLE(1), GLOBSE(2);

    private final int languageId;

    private LanguageSet(int languageId) {
        this.languageId = languageId;
    }

    public String getAuto() {
        return this.languageId == 1 ? "auto" : this.languageId == 2 ? "auto" : "undefined";
    }
    
    public String getEnglish() {
        return this.languageId == 1 ? "en" : this.languageId == 2 ? "eng" : "undefined";
    }

    public String getItalian() {
        return this.languageId == 1 ? "it" : this.languageId == 2 ? "ita" : "undefined";
    }

    public String getFrench() {
        return this.languageId == 1 ? "fr" : this.languageId == 2 ? "fr" : "undefined";
    }

    public String getArabic() {
        return this.languageId == 1 ? "ar" : this.languageId == 2 ? "eng" : "undefined";
    }

    public String getAmharic() {
        return this.languageId == 1 ? "am" : this.languageId == 2 ? "eng" : "undefined";
    }

    public String getOromo() {
        return this.languageId == 1 ? "or" : this.languageId == 2 ? "eng" : "undefined";
    }

    public String getTigrigna() {
        return this.languageId == 1 ? "tg" : this.languageId == 2 ? "eng" : "undefined";
    }

    public String getHindi() {
        return this.languageId == 1 ? "hindi" : this.languageId == 2 ? "eng" : "undefined";
    }
}
