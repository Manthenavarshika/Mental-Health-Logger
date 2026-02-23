package com.varshika.mentalhealthlogger.util;

import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;

import java.util.Properties;

public class NLPHelper {

    private static StanfordCoreNLP pipeline;

    static {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,parse,sentiment");
        pipeline = new StanfordCoreNLP(props);
    }

    public static String analyzeSentiment(String text) {
        CoreDocument doc = new CoreDocument(text);
        pipeline.annotate(doc);
        // We'll take sentiment of the first sentence for simplicity
        String sentiment = doc.sentences().get(0).sentiment();
        return sentiment; // VeryPositive, Positive, Neutral, Negative, VeryNegative
    }

    public static String detectEmotion(String text) {
        String sentiment = analyzeSentiment(text);
        switch(sentiment) {
            case "VeryPositive":
            case "Positive":
                return "Happy";
            case "Neutral":
                return "Neutral";
            case "Negative":
            case "VeryNegative":
                return "Stressed/Anxious";
            default:
                return "Unknown";
        }
    }
}
