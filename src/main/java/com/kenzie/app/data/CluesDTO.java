package com.kenzie.app.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CluesDTO {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private List<Clues> clues;


    public List<Clues> getClues() {
        return clues;
    }

    public void setClues(List<Clues> clues) {
        this.clues = clues;
    }

    @Override
    public String toString() {
        return "CluesDTO{" +
                "clues=" + clues +
                '}';
    }
}
