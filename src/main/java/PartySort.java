import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class PartySort {
    public static void main(String[] args) {
        FileParser fileParser = new FileParser();
        List<Vote> unfilteredList = fileParser.getListOfVotes();
        List<Vote> filteredList = filterResults(unfilteredList);
        filteredList.forEach(System.out::println);
    }

    private static List<Vote> filterResults(List<Vote> unfilteredList) {
        Map<String, List<Vote>> collect = unfilteredList.stream().collect(groupingBy(Vote::getName));
        //collect.forEach(...was genau :D ...); //TODO: finish this very soon
        System.out.println();
        return Collections.emptyList();
    }


}

