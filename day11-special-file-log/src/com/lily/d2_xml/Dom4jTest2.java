package com.lily.d2_xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

public class Dom4jTest2 {
    public static void main(String[] args) throws Exception {
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read("day11-special-file-log/contact.xml");
        Element rootElement=document.getRootElement();
        List<Contact>  contacts=new ArrayList<>();
        List<Element> sonEles=rootElement.elements("contact");
        for (Element sonEle : sonEles) {
            Contact c=new Contact();
            c.setId(Integer.valueOf(sonEle.attributeValue("id")));
            c.setName(sonEle.elementTextTrim("name"));
            c.setGender(sonEle.elementTextTrim("gender").charAt(0));
            c.setEmail(sonEle.elementTextTrim("email"));
            contacts.add(c);
        }
        System.out.println(contacts);
    }
}
