package com.marvin.bundle.addressbook.resources.view.swing;

import com.marvin.bundle.addressbook.model.Person;
import com.marvin.bundle.framework.handler.Handler;
import com.marvin.bundle.swing.model.ListAdapterListModel;
import com.marvin.bundle.swing.resources.view.SwingView;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

public class Home extends SwingView {

    private JList list;
    private JButton create;
    private JButton delete;

    public Home(Handler handler) {
        super(handler);
    }

    @Override
    protected void prepare(HashMap<String, Object> model, JFrame frame) {
        this.list = new JList();
        this.create = new JButton(createAction("Creer", "/addressbook/persons/save", frame));
        this.delete = new JButton(createAction("Supprimer", "/addressbook/persons/delete", frame));
    }

    @Override
    protected void display(HashMap<String, Object> model, JFrame frame) {
        frame.getContentPane().removeAll();
        
        List<Person> persons = (List<Person>) model.getOrDefault("persons", Collections.EMPTY_LIST);
        ListAdapterListModel<Person> listModel = new ListAdapterListModel<>();
        listModel.addAll(persons);
        
        this.list.setModel(listModel);
        add(create).add(delete).add(this.list);
        super.display(model, frame);
    }
}
