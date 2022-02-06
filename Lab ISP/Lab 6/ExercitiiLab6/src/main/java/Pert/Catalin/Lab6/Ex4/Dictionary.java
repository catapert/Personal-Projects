package Pert.Catalin.Lab6.Ex4;

import java.util.*;

public class Dictionary {
    private final Map<Word, Definition> words;

    public Dictionary() {
        this.words = new HashMap<>();
    }


    public void addWord(Word w, Definition d) {
        this.words.put(w, d);
    }

    public Definition getDefinition(Word w) {
        return this.words.get(w);
    }

    public Set<Word> getAllWords() {
        return this.words.keySet();
    }

    public List<Definition> getAllDefinitions() {
        return new ArrayList<>(this.words.values());
    }
}
