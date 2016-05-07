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
package org.dalol.definition.api.model;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class Definition {

    private String text;
    private String sourceDictionary;
    private String attributionText;
    private String[] citations;
    private String[] relatedWords;
    private String sequence;
    private String[] labels;
    private String score;
    private String word;
    private String[] exampleUses;
    private String[] textProns;
    private String partOfSpeech;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSourceDictionary() {
        return sourceDictionary;
    }

    public void setSourceDictionary(String sourceDictionary) {
        this.sourceDictionary = sourceDictionary;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public String[] getCitations() {
        return citations;
    }

    public void setCitations(String[] citations) {
        this.citations = citations;
    }

    public String[] getRelatedWords() {
        return relatedWords;
    }

    public void setRelatedWords(String[] relatedWords) {
        this.relatedWords = relatedWords;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String[] getExampleUses() {
        return exampleUses;
    }

    public void setExampleUses(String[] exampleUses) {
        this.exampleUses = exampleUses;
    }

    public String[] getTextProns() {
        return textProns;
    }

    public void setTextProns(String[] textProns) {
        this.textProns = textProns;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    @Override
    public String toString() {
        return "DefinitionResponse [text = " + text + ", sourceDictionary = " + sourceDictionary + ", attributionText = " + attributionText + ", citations = " + citations + ", relatedWords = " + relatedWords + ", sequence = " + sequence + ", labels = " + labels + ", score = " + score + ", word = " + word + ", exampleUses = " + exampleUses + ", textProns = " + textProns + ", partOfSpeech = " + partOfSpeech + "]";
    }
}
