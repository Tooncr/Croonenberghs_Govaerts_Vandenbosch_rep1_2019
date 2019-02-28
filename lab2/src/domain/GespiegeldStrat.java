package domain;

public class GespiegeldStrat implements CodeerStrategy {

    @Override
    public String codeer(String zin){
        String output = "";
        for(int i=zin.length()-1;i>=0;i--){
            output += zin.charAt(i);
        }
        return output;
    }

    public String decodeer(String zin){
        String output = "";
        for(int i=zin.length()-1;i>=0;i--){
            output += zin.charAt(i);
        }
        return output;
    }
}
