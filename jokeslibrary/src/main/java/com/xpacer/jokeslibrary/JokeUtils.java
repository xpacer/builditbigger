package com.xpacer.jokeslibrary;

import java.util.ArrayList;
import java.util.Random;

public class JokeUtils {
    private static JokeUtils sInstance;
    private ArrayList<String> jokes = new ArrayList<>();

    private JokeUtils() {
        seedJokes();
    }

    public static JokeUtils getInstance() {
        if (sInstance == null) {
            sInstance = new JokeUtils();
        }

        return sInstance;
    }

    private void setJokes(ArrayList<String> jokes) {
        this.jokes = jokes;
    }

    private ArrayList<String> getJokes() {
        return jokes;
    }

    private void seedJokes() {
        ArrayList<String> jokes = new ArrayList<>();
        jokes.add("I invented a new word! Plagiarism!");
        jokes.add("What's the best thing about Switzerland? I don’t know, but the flag is a big plus. ");
        jokes.add("Did you hear about the mathematician who’s afraid of negative numbers? He’ll stop at nothing to avoid them.");
        jokes.add("Why do we tell actors to 'break a leg?' Because every play has a cast.");

        setJokes(jokes);
    }

    public String tellAJoke() {
        int jokesSize = getJokes().size();

        if (jokesSize == 0) {
            return "I'm not feeling funny today. Bye!";
        }

        Random random = new Random();
        int jokeRandIndex = random.nextInt(jokesSize - 1);

        return getJokes().get(jokeRandIndex);
    }
}
