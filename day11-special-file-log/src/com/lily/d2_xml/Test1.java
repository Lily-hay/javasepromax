package com.lily.d2_xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Test1 {
    public static void main(String[] args) throws Exception {
        SAXReader saxReader=new SAXReader();
        //2、读成一个文件对象
        Document document=saxReader.read("day11-special-file-log/contact.xml");

        //3、文件对象中包含了XML所有的数据，提供了方法获取
        Element rootElement=document.getRootElement();
        System.out.println(rootElement.getName());

        //4、提取了元素对象
        List<Element> sonEles=rootElement.elements("contact");
        for (Element sonEle : sonEles) {
            System.out.println(sonEle.getName());
        }

        //给定获取单个子元素
        Element userEle=rootElement.element("user");
        System.out.println(userEle.getName());

        Element contactEle=rootElement.element("contact");//默认拿第一个contact
        System.out.println(contactEle.elementText("name"));

        //5、提取子元素的属性对象
        Attribute idAttr=contactEle.attribute("id");
        System.out.println(idAttr.getName());
        System.out.println(idAttr.getValue());

        //6、文本值
        //通过父元素拿到子元素文本值
        System.out.println(contactEle.elementText("name"));
        System.out.println(contactEle.elementTextTrim("name"));//去掉前后空格

        //先拿到元素对象，再提取其文本值
        Element emailEle=contactEle.element("email");
        System.out.println(emailEle.getText());
        System.out.println(emailEle.getTextTrim());


    }


}
