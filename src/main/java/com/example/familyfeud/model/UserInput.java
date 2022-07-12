package com.example.familyfeud.model;

import org.springframework.stereotype.Component;

@Component
public class UserInput {
    private int question_id;
    private int option_a;
    private int option_b;
    private int option_c;
    private int option_d;
    private int option_e;

    public UserInput() {
    }

    public UserInput(int question_id, int option_a, int option_b, int option_c, int option_d, int option_e) {
        this.question_id = question_id;
        this.option_a = option_a;
        this.option_b = option_b;
        this.option_c = option_c;
        this.option_d = option_d;
        this.option_e = option_e;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getOption_a() {
        return option_a;
    }

    public void setOption_a(int option_a) {
        this.option_a = option_a;
    }

    public int getOption_b() {
        return option_b;
    }

    public void setOption_b(int option_b) {
        this.option_b = option_b;
    }

    public int getOption_c() {
        return option_c;
    }

    public void setOption_c(int option_c) {
        this.option_c = option_c;
    }

    public int getOption_d() {
        return option_d;
    }

    public void setOption_d(int option_d) {
        this.option_d = option_d;
    }

    public int getOption_e() {
        return option_e;
    }

    public void setOption_e(int option_e) {
        this.option_e = option_e;
    }
}
