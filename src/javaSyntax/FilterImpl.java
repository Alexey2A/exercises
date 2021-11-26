package javaSyntax;

import java.io.*;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class FilterImpl implements Filter{
    @Override
    public List<String> filter1(File file) {
        List<String> list = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.read() != -1) {
                list = bufferedReader.lines().map(m -> m.split("\\|"))
                                        .filter(f->f[2].contains("Black")
                                                ||Integer.parseInt(f[4])==0)
                                        .map(element -> element[0])
                                        .collect(Collectors.toList());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return list;
    }

    @Override
    public long filter2(File file) {
        long count = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.read() != -1) {
                count = bufferedReader.lines().map(m -> m.split("\\|"))
                        .filter(f->Integer.parseInt(f[3])>700
                                &&Integer.parseInt(f[3])<800)
                        .map(el->el[1])
                        .distinct().count();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return count;
    }

    @Override
    public String filter3(File file) {
        String color = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.read() != -1) {
                String[] auto = bufferedReader.lines().map(m -> m.split("\\|"))
                        .min((el1, el2)->Integer.parseInt(el2[3])-Integer.parseInt(el1[3])).get();
                color = auto[2];
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return color;
    }

    @Override
    public Double filter4(File file) {
        Double averagePrice = 0.0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.read() != -1) {
                OptionalDouble average = bufferedReader.lines().map(p -> p.split("\\|"))
                        .filter(hl->hl[1].contains("Camry"))
                        .mapToDouble(kkl->Double.parseDouble(kkl[3]))
                        .average();
                averagePrice = average.getAsDouble();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return averagePrice;
    }
}
