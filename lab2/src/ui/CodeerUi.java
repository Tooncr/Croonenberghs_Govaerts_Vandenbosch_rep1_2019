package ui;


import domain.CaesarStrat;
import domain.CodeerStrategy;
import domain.GespiegeldStrat;

import javax.swing.*;

public class CodeerUi {

    public void close(){
        System.exit(0);
    }

    public String getSentence(){
        String zin =  JOptionPane.showInputDialog(null, "welke zin wil je encoderen/decoderen?");
        if(zin == null || zin.equals("")) close();
        return zin;
    }

    public void algorithmDetermination(){
        Object[] options = {"Caesar algoritme", "Spiegel algoritme", "? algoritme"};
        Object alg = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if(alg == null || alg.equals("")) close();
        encodeOrDecode((String)alg, getSentence());
    }

    public void encodeOrDecode(String algoritme, String zin){
        Object[] options = {"encode", "decode"};
        Object meth = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if(meth == null || meth.equals("")) close();
        showResult(zin, algoritme, (String)meth);
    }

    public void showResult(String zin, String algoritme, String meth){
        CodeerStrategy strategy = null;
        String result = "";
        if(algoritme.equals("Caesar algoritme")){
            strategy = new CaesarStrat();
        } else if(algoritme.equals("Spiegel algoritme")){
            strategy = new GespiegeldStrat();
        }

        if(meth.equals("encode")){
            result = strategy.codeer(zin);
        } else {
            result = strategy.decodeer(zin);
        }
        JOptionPane.showMessageDialog(null, result);
    }
}
