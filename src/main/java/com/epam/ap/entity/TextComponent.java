package com.epam.ap.entity;

interface TextComponent {
    void toPlaneText(StringBuilder sb);
    int getCount(Text.Component c);
/*    <T extends TextComponent> void add(T t);
    <T extends TextComponent> boolean remove(T t);*/

}
