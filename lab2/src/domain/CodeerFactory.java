package domain;

public class CodeerFactory {
    public static CodeerStrategy createStrat(String strategyCode){
        CodeerEnum codeerEnum = CodeerEnum.valueOf(strategyCode);
        String klasseNaam = codeerEnum.getKlassenaam();
        CodeerStrategy strategy = null;
        try {
            Class stratClass = Class.forName(klasseNaam);
            Object stratObject = stratClass.newInstance();
            strategy = (CodeerStrategy) stratObject;
        } catch (Exception e){
            System.out.println("kapot");
        }
        return strategy;
    }
}
