package eu.sirotin.kotlin.examples.eu.sirotin.kotlin.examples.kotlin.java;

import eu.sirotin.kotlin.examples.global.StringsKt;

import java.util.ArrayList;
import java.util.List;

public class KotlinCaller {
    public void callStringsKt(){
        List<Integer> lst = new ArrayList<Integer>();
        lst.add(3);
        lst.add(1);
        lst.add(4);
        String res = StringsKt.formatString(lst, ",", "{{", "}}");
        System.out.println("Res=" + res);
    }
}
