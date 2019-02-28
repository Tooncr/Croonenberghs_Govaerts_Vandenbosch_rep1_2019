package domain;

import javax.print.DocFlavor;

public interface CodeerStrategy {

    String codeer(String zin);
    String decodeer(String zin);
}
