import java.time.LocalDateTime;
import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class PartySort {
    public static void main(String[] args) {
        FileParser fileParser = new FileParser();
        List<Vote> unfilteredList = fileParser.getListOfVotes();
        List<Vote> filteredList = filterResults(unfilteredList);
        filteredList.forEach(System.out::println);
    }

    //TODO: try to get rid of for loop and use stream api
    private static List<Vote> filterResults(List<Vote> unfilteredList) {
        unfilteredList.forEach(vote -> vote.setName(vote.getName().toUpperCase()));
        Map<String, List<Vote>> unfilteredGroupedMap = unfilteredList.stream().collect(groupingBy(Vote::getName));
        List<Vote> filteredGroupedResults = new ArrayList<>();

        Iterator<Map.Entry<String, List<Vote>>> eachEntry = unfilteredGroupedMap.entrySet().iterator();
        while (unfilteredGroupedMap.entrySet().iterator().hasNext()) {
            List<Vote> votes = eachEntry.next().getValue();
            int key = 0;
            for (int i = 0; i < votes.size(); i++) {
                LocalDateTime currentTimestamp = votes.get(i).getTimestamp();

                if (i < votes.size()-1 && currentTimestamp.isBefore((votes.get(i+1).getTimestamp()))) {
                    key = i+1;
                }

                System.out.println();
            }
            filteredGroupedResults.add(votes.get(key));
            eachEntry.remove();
        }

        return filteredGroupedResults;
    }


}

