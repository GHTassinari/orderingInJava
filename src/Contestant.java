import java.io.Serializable;
import java.time.LocalDate;

public class Contestant implements Comparable<Contestant>, Serializable {

    private static final long serialVersionUID = 1L;

    private Integer identifier;
    private String name;
    private LocalDate birthData;
    private Integer score;

    public Contestant(int identifier, String name, LocalDate birthData, int score) {
        this.identifier = identifier;
        this.name = name;
        this.birthData = birthData;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getBirthData() {
        return this.birthData;
    }

    public Integer getIdentifier() {
        return this.identifier;
    }

    public Integer getScore() {
        return this.score;
    }

    @Override
    public int compareTo(Contestant otherCandidate) {
        int compareScore = this.score.compareTo(otherCandidate.getScore());
        if (compareScore == 0) {
            return this.birthData.compareTo(otherCandidate.getBirthData());
        }

        return compareScore;
    }

    public String toString() {
        return "Identifier: " + this.getIdentifier() + " Name: " + this.getName() + " Birth Data: "
                + this.getBirthData() + " Score: " + this.getScore();
    }
}