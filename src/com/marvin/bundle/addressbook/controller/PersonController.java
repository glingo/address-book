package com.marvin.bundle.addressbook.controller;

import com.marvin.bundle.framework.mvc.ModelAndView;
import com.marvin.bundle.framework.mvc.controller.Controller;
import com.marvin.bundle.framework.mvc.model.Model;
import com.marvin.component.form.FormTypeInterface;
import com.marvin.component.form.support.ButtonType;
import com.marvin.component.form.support.TextType;
import com.marvin.bundle.addressbook.business.PersonManager;
import com.marvin.bundle.addressbook.model.Person;

public class PersonController extends Controller {
    
    private PersonManager manager;
    
    public PersonController(PersonManager manager) {
        this.manager = manager;
    }
    
    public ModelAndView all(Model model) {
        model.put("persons", manager.getAll());
        ModelAndView mav = new ModelAndView("persons", model);
        return mav;
    }
    
    public ModelAndView save(Model model) {
        FormTypeInterface form = (FormTypeInterface) model.get("personForm");
        
        if(null != form) {
            model.remove("personForm");
            Person data = (Person) form.getData();
            this.manager.save(data);
            return new ModelAndView("persons", model);
        }
        
        form = createFormBuilder("person", new Person())
            .add("firstName", new TextType("firstName", "First name : "))
            .add("lastName", new TextType("lastName", "Last name : "))
            .add("email", new TextType("email", "Email : "))
            .add("connect", new ButtonType("validate", "Valider", "/addressbook/persons/save"))
            .add("cancel", new ButtonType("cancel", "Annuler", "/addressbook/persons"))
            .getForm();

        model.put("personForm", form);

        ModelAndView mav = new ModelAndView("person", model);
        return mav;
    }
}
