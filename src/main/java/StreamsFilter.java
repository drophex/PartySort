import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class StreamsFilter implements Filter {
    public List<Vote> filterResults(List<Vote> unfilteredList) {
        unfilteredList.forEach(vote -> vote.setName(vote.getName().toUpperCase()));
        Map<String, List<Vote>> unsortedGroupedMap = unfilteredList.stream().collect(groupingBy(Vote::getName));

        unsortedGroupedMap.forEach((k, v) -> v.sort(sortVotesByDate()));
        List<Vote> latestVotes = new ArrayList<>();
        unsortedGroupedMap.forEach((k, v) ->  latestVotes.add(v.get(v.size()-1)));

        return latestVotes;
    }

    private Comparator<? super Vote> sortVotesByDate() {
        return Comparator.comparing(Vote::getTimestamp);
    }

}
