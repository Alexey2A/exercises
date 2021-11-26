package javaSyntax;

import java.io.File;
import java.util.List;

public interface Filter {
    List<String> filter1(File file);
    long filter2(File file);
    String filter3(File file);
    Double filter4(File file);

}
