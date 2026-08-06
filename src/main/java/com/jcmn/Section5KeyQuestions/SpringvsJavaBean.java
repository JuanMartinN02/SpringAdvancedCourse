package com.jcmn.Section5KeyQuestions;

import java.io.Serializable;

public class SpringvsJavaBean {

    // Spring bean is the ones we looked at last section
    // It's any java object thats managed by Spring

    // Java Bean (ALMOST NEVER USED!)
    class JavaBean implements Serializable { // 3.- Implements Serializable
        private String text;
        private int number;

        // 1.- public no-arg constructor
        public JavaBean(){}

        // 2.- getters and setters

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }

    // POJOs
    class pojo {
        private String text;
        private int number;

        public pojo(String text, int number) {
            this.text = text;
            this.number = number;
        }

        @Override
        public String toString() {
            return "pojo{" +
                    "text='" + text + '\'' +
                    ", number=" + number +
                    '}';
        }
    }
}
