package com.epam.workshops.cloudtomation;

import static javax.faces.application.FacesMessage.*;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("appForm")
@RequestScoped
public class AppFormBean {

  private String regex;

  private String text;

  public String getRegex() {
    return regex;
  }

  public void setRegex(String regex) {
    this.regex = regex;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String submit() {
    FacesContext context = FacesContext.getCurrentInstance();
    FacesMessage facesMessage = new FacesMessage(SEVERITY_ERROR,
        "Not yet implemented",
        "Implementation is yet to be developed.");
    context.addMessage(null, facesMessage);
    return null;
  }
}
