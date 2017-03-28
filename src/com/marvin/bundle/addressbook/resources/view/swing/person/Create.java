package com.marvin.bundle.addressbook.resources.view.swing.person;

import com.marvin.bundle.framework.handler.Handler;
import com.marvin.bundle.swing.resources.view.FormView;
import java.util.HashMap;
import javax.swing.JFrame;

public class Create extends FormView {
    
    public Create(Handler handler) {
        super(handler, "personForm");
    }

    @Override
    protected void prepare(HashMap<String, Object> model, JFrame frame) throws Exception {
        super.prepare(model, frame);
        frame.setSize(500, 500);
    }
}
