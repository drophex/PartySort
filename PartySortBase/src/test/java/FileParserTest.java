import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class FileParserTest {

    public static final String PATH = "../PartySortBase/src/main/resources/participants.txt";

    @Test
    void checkIfFileCanBeReadSuccessfully() {
        File file = new File(PATH);
        Assertions.assertDoesNotThrow(() -> {
            new BufferedReader(new FileReader(file));
        });
    }

    @Test
    void checkIfListOfVotesCanBeRetrieved() {
        FileParser fileParser = new FileParser(PATH);
        List<Vote> votes;
        votes = fileParser.getListOfVotes();
        Assertions.assertFalse((votes.isEmpty()));
        Assertions.assertFalse((votes.get(0).getName().isEmpty()));
    }

}
