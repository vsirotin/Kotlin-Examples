package eu.sirotin.kotlin.examples.java;

import eu.sirotin.kotlin.examples.extensions.StringExtensionsKt;
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

        char c = StringExtensionsKt.lastChar("Java");
        System.out.println("last char in Java is: " + c);
    }
}
