package com.lily.d3_collections_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Room {
    private ArrayList<Card> cards = new ArrayList<>();
    //初始化54张牌
    {
        String[] numbers={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        String[] colors={"♥","♠","♦","♣"};
        int size=0;
        for (String number : numbers) {
            size++;
            for (String color : colors) {
                Card card = new Card(number, color,size);
                cards.add(card);
            }
        }
        cards.add(new Card("🐱‍","",++size));
        cards.add(new Card("🃏","",++size));
        System.out.println(cards);
    }

    public void start()
    {
        Collections.shuffle(cards);
        System.out.println(cards);
        ArrayList<Card> lfc = new ArrayList<>();
        ArrayList<Card> ryy = new ArrayList<>();
        ArrayList<Card> dfbb = new ArrayList<>();
        for (int i = 0; i < cards.size()-3; i++) {
            Card c= cards.get(i);
            if(i%3==0)
            {
                lfc.add(c);
            }
            else if(i%3==1)
            {
                ryy.add(c);
            }
            else
            {
                dfbb.add(c);
            }
        }
        List<Card> lastTreeCards = cards.subList(cards.size()-3,cards.size());
        lfc.addAll(lastTreeCards);
        System.out.println(lfc);
        System.out.println(ryy);
        System.out.println(dfbb);
        sortCard(lfc);
        sortCard(ryy);
        sortCard(dfbb);
        System.out.println(lfc);
        System.out.println(ryy);
        System.out.println(dfbb);

    }
    public void sortCard(List<Card> cards)
    {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o2.getSize()- o1.getSize();
            }
        });
    }

}
