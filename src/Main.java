import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String path = "D:\\Downloads\\dadosConcurso.csv";

        List<Contestant> listContestants = new ArrayList<Contestant>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            line = br.readLine();
            while (line != null) {

                String[] vect = line.split(",");
                Integer identifier = Integer.parseInt(vect[0]);
                String name = vect[1];
                String birthData = vect[2];
                Integer score = Integer.parseInt(vect[3]);

                LocalDate birthDataConvert = LocalDate.parse(birthData, formatter);

                Contestant contestant = new Contestant(identifier, name, birthDataConvert, score);
                listContestants.add(contestant);

                line = br.readLine();
            }

            System.out.println("\t\t --- Lista de candidatos --- \n");
            for (Contestant c : listContestants) {
                System.out.println(c);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Comparator<Contestant> scoreCompare = (c1, c2) -> c2.getScore().compareTo(c1.getScore());

        Contestant[] array = listContestants.toArray(new Contestant[0]);

        InsertionSort<Contestant> isort = new InsertionSort<>();
        isort.sort(array, scoreCompare);

        System.out.println("\n\n\t --- Pessoas ordenadas pelo score e data de nascimento --- \n\n");

        for (Contestant c : array) {
            System.out.println(c);
        }

    }
}