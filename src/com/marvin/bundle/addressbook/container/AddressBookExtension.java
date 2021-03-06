package com.marvin.bundle.addressbook.container;

import com.marvin.bundle.framework.FrameworkBundle;

import com.marvin.component.configuration.ConfigurationInterface;
import com.marvin.component.container.ContainerBuilder;
import com.marvin.component.container.extension.Extension;
import com.marvin.component.container.xml.XMLDefinitionReader;
import com.marvin.component.io.loader.ClassPathResourceLoader;
import com.marvin.component.io.loader.ResourceLoader;
import com.marvin.component.io.xml.XMLReader;

import java.util.Map;

public class AddressBookExtension extends Extension {

    @Override
    public void load(Map<String, Object> configs, ContainerBuilder builder) {
        ResourceLoader loader = new ClassPathResourceLoader(AddressBookExtension.class);
        XMLReader reader = new XMLDefinitionReader(loader, builder);

        reader.read("../resources/config/services.xml");

//        ConfigurationInterface configuration = getConfiguration();
//        Map<String, Object> config = processConfiguration(configuration, configs);

//            HashMap<String, Definition> taggedDefinitions = builder.findTaggedDefinitions("event_subscriber");
//            for (Map.Entry<String, Definition> entrySet : taggedDefinitions.entrySet()) {
//                String id = entrySet.getKey();
//                Definition definition = entrySet.getValue();
//                
//            }
    }

}
