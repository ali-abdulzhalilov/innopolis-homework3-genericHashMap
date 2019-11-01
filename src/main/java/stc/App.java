package stc;

import java.util.HashMap;

public class App
{
    public static void main( String[] args )
    {
        MyGenericHashMap<Integer, Integer> gh = new MyGenericHashMap<>();

        for (int i = 0; i < 20; i++) {
            gh.put(i, i+1);
        }
        System.out.println(gh);
    }
}
