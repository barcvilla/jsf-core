/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.jsf.ch02.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import ar.com.jsf.ch02.business.ProblemBean;

/**
 *
 * @author PC
 */
@Named(value = "quizBean")
@SessionScoped
public class QuizBean implements Serializable {

    private ArrayList<ProblemBean> problems = new ArrayList<ProblemBean>();
    private int currentIndex;
    private int score;
    
    public QuizBean() 
    {
        problems.add(new ProblemBean(new int[]{3,1,4,1,5},9)); //pi
        problems.add(new ProblemBean(new int[]{1,1,2,3,5},8)); //finonacci
        problems.add(new ProblemBean(new int[]{1,4,9,16,25},36)); //squares
        problems.add(new ProblemBean(new int[]{2,3,5,7,11},13)); //primes
        problems.add(new ProblemBean(new int[]{1,2,4,8,16},32)); //powersof 2
    }
    
    //propiedad solo lectura que establece los problemas del quiz
    public void setProblems(ArrayList<ProblemBean> newValue) {
        problems = newValue;
        currentIndex = 0;
        score = 0;
    }
    
    //read only property para obtener el score actual
    public int getScore(){return score;}
    
    //read only property para obtener el problema actual del quiz. El problema es de tipo ProblemBean
    public ProblemBean getCurrent(){return problems.get(currentIndex);}
    
    //propiedades para establecer y leer la respuesta del usuario
    public String getAnswer(){return "";}
    
    public void setAnswer(String newValue)
    {
        try
        {
            int answer = Integer.parseInt(newValue.trim());
            if(getCurrent().getSolution() == answer)
            {
                score++;
            }
            currentIndex = (currentIndex + 1) % problems.size();
        }
        catch(NumberFormatException ex){}
    }
}
