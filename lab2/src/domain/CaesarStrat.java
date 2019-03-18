package domain;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CaesarStrat implements CodeerStrategy {

    public char roteerKarakter(char input) {
        char alfabet[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char nieuweChar = input;
        boolean hoofdletter = !(nieuweChar == (Character.toLowerCase(nieuweChar)));

        for (int i = 0; i < 26; i++) {
            if (Character.toLowerCase(input) == alfabet[i]) {
                int geconverteerd = i + 3;
                if (geconverteerd >= 26) {
                    geconverteerd -= 26;
                }
                if (hoofdletter) {
                    nieuweChar = Character.toUpperCase(alfabet[geconverteerd]);
                }
                else{
                    nieuweChar= alfabet[geconverteerd];
                }
            }
        }
        return nieuweChar;
    }

    public char roteerKarakterTerug(char input) {
        char alfabet[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char nieuweChar = input;
        boolean hoofdletter = !(nieuweChar == (Character.toLowerCase(nieuweChar)));

        for (int i = 0; i < 26; i++) {
            if (Character.toLowerCase(input) == alfabet[i]) {
                int geconverteerd = i - 3;
                if (geconverteerd < 0) {
                    int ge2 = 3-i;
                    geconverteerd = 26-ge2;
                }
                if (hoofdletter) {
                    nieuweChar = Character.toUpperCase(alfabet[geconverteerd]);
                }
                else{
                    nieuweChar= alfabet[geconverteerd];
                }
            }
        }
        return nieuweChar;
    }

    @Override
    public String codeer(String zin){
        String output = "";

        for(int i = 0; i< zin.length();i++){
            char geconverteerd = roteerKarakter(zin.charAt(i));
            output += geconverteerd;
        }
        return output;
    }

    @Override
    public String decodeer(String zin){
        String output = "";

        for(int i=0; i<zin.length();i++){
            char geconverteerd = roteerKarakterTerug(zin.charAt(i));
            output+= geconverteerd;
        }
        return output;
    }
}
