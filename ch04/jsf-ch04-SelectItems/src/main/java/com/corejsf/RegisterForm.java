/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corejsf;

import java.awt.Color;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.faces.model.SelectItem;

/**
 *
 * @author PC
 */
@Named(value = "form")
@SessionScoped
public class RegisterForm implements Serializable {
    
    public enum Education{HIGH_SCHOOL, BACHELOR, MASTER, DOCTOR}
    
    private String name;
    private boolean contactMe;
    private int[] bestDayToContact;
    private Integer yearOfBirth;
    private int[] colors;
    private Set<String> languages = new TreeSet<String>();
    private Education education = Education.BACHELOR;
    
    public RegisterForm() {
    }
    
    public static class Weekday
    {
        private int dayOfWeek;
        
        public Weekday(int dayOfWeek)
        {
            this.dayOfWeek = dayOfWeek;
        }
        
        public String getDayName()
        {
            DateFormatSymbols symbols = new DateFormatSymbols();
            String[] weekDays = symbols.getWeekdays();
            return weekDays[dayOfWeek];
        }
        
        public int getDayNumber()
        {
            return dayOfWeek;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isContactMe() {
        return contactMe;
    }

    public void setContactMe(boolean contactMe) {
        this.contactMe = contactMe;
    }

    public int[] getBestDayToContact() {
        return bestDayToContact;
    }

    public void setBestDayToContact(int[] bestDayToContact) {
        this.bestDayToContact = bestDayToContact;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int[] getColors() {
        return colors;
    }

    public void setColors(int[] colors) {
        this.colors = colors;
    }

    public Set<String> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<String> languages) {
        this.languages = languages;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }
    
    private static Collection<SelectItem> birthyears;
    static
    {
        birthyears = new ArrayList<SelectItem>();
        // el primer item es un "no selection" item
        birthyears.add(new SelectItem(null, "Elija un año", "", false, false, true));
        for(int i = 1900; i < 2020; i++)
        {
            birthyears.add(new SelectItem(i));
        }
    }
    
    private static Weekday[] daysOfTheWeek;
    static
    {
        daysOfTheWeek = new Weekday[7];
        for(int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++)
        {
            daysOfTheWeek[i - Calendar.SUNDAY] = new Weekday(i);
        }
    }
    
    private SelectItem[] colorItems =
    {
        new SelectItem(Color.RED.getRGB(), "Red"), // valor, label
        new SelectItem(Color.GREEN.getRGB(), "Green"),
        new SelectItem(Color.BLUE.getRGB(), "Blue"),
        new SelectItem(Color.YELLOW.getRGB(), "YELLOW"),
        new SelectItem(Color.ORANGE.getRGB(), "Orange", "", true) //deshabilitado
    };
    
    private static Map<String, Education> educationItems;
    static
    {
        educationItems = new LinkedHashMap<String, Education>();
        educationItems.put("High School", Education.HIGH_SCHOOL); // etiqueta, valor
        educationItems.put("Bachelor's", Education.BACHELOR);
        educationItems.put("Master's", Education.MASTER);
        educationItems.put("Doctorate", Education.DOCTOR);
    };
    
    private static SelectItem[] languageItems = 
    {
        new SelectItem("English"),
        new SelectItem("French"),
        new SelectItem("Russian"),
        new SelectItem("Italian"),
        new SelectItem("Esperanto", "Esperanto", "", true) // deshabilitado
    };
    
    public Collection<SelectItem> getYearItems()
    {
        return birthyears;
    }
    
    public Weekday[] getDaysOfTheWeek()
    {
        return daysOfTheWeek;
    }
    
    public SelectItem[] getLanguageItems()
    {
        return languageItems;
    }
    
    public SelectItem[] getColorItems()
    {
        return colorItems;
    }
    
    public Map<String, Education> getEducationItems()
    {
        return educationItems;
    }
    
    public String getBestDaysConcatenated()
    {
        return Arrays.toString(bestDayToContact);
    }
    
    public String getColorsConcatenated()
    {
        StringBuilder result = new StringBuilder();
        for(int color : colors)
        {
            result.append(String.format("%06x", color));
        }
        return result.toString();
    }
}
