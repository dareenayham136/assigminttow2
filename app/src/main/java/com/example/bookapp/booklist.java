package com.example.bookapp;

import android.os.Bundle;

import java.util.List;



public class booklist {


    private int numFound;
    private int start;
    private boolean numFoundExact;

    @Override
    public String toString() {
        return "booklist{" +
                "numFound=" + numFound +
                ", start=" + start +
                ", numFoundExact=" + numFoundExact +
                ", docs=" + docs +
                '}';
    }

    private List<Doc> docs;

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public boolean isNumFoundExact() {
        return numFoundExact;
    }

    public void setNumFoundExact(boolean numFoundExact) {
        this.numFoundExact = numFoundExact;
    }

    public List<Doc> getDocs() {
        return docs;
    }

    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

    public static class Doc {
        private String key;
        private String type;
        private List<String> seed;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<String> getSeed() {
            return seed;
        }

        public void setSeed(List<String> seed) {
            this.seed = seed;
        }
    }

}
