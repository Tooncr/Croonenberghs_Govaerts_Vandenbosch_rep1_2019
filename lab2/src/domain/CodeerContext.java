package domain;

import java.util.ArrayList;
import java.util.List;

public class CodeerContext {
    private CodeerStrategy codeerInterface;

    public CodeerContext(){

    }

    public void setCodeerInterface(CodeerStrategy codeerInterface){
        this.codeerInterface = codeerInterface;
    }

    public String getGecodeerdeString(String zin){
        return codeerInterface.codeer(zin);
    }

    public String getGedecodeerdeString(String zin){
        return codeerInterface.decodeer(zin);
    }

    public List<String> getCodeerStrategies(){
        List<String> stratlijst = new ArrayList<>();
        for(CodeerEnum strat : CodeerEnum.values()){
            stratlijst.add(strat.toString());
        }
        return stratlijst;
    }
}
