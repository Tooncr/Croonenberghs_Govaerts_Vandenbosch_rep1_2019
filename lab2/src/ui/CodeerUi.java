package ui;

import javax.swing.*;

public class CodeerUi {
    private String algorithm;
    private String method;


    public void algorithmDetermination(){
        Object[] options = {"Caesar algoritme", "Spiegel algoritme", "? algoritme"};
        Object alg = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        this.algorithm = (String) alg;
    }

    public void encodeOrDecode(){
        Object[] options = {"encode", "decode"};
        Object meth = JOptionPane.showInputDialog(null, "Choose one", "Input", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        this.method = (String) meth;
    }

    public void showResult(String result){
        JOptionPane.showMessageDialog(null, result);
    }
}
