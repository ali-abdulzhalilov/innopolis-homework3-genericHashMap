package stc;

import java.util.HashMap;

public class App
{
    public static void main( String[] args )
    {
        MyGenericHashMap<String, Integer> gh = new MyGenericHashMap<>();

        for (int i = 0; i < 100; i++) {
            gh.put(i+"", i);
        }

        System.out.println(gh);
    }
}
