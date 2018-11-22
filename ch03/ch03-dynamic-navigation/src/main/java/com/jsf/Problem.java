/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsf;

import java.io.Serializable;

public class Problem implements Serializable {

    private String question;
    private String answer;

    public Problem(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    // override for more sophisticated checking
    public boolean isCorrect(String response) {
        return response.trim().equalsIgnoreCase(answer);
    }
}
