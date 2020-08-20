import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    public List<Vote> getListOfVotes() {

        File file = new File("myFile.txt");
        BufferedReader br;
        List<Vote> votes = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        lines.forEach(s -> addToVotes(s, votes));
        return votes;
    }

    private void addToVotes(String line, List<Vote> votes) {
        String[] parts = line.split(", ");
        Vote vote = new Vote();
        vote.setTimestamp(LocalDateTime.parse(parts[0]));
        vote.setName(parts[1]);
        vote.setParticipating(Boolean.parseBoolean(parts[2]));
        votes.add(vote);
    }
}
