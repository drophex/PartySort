import java.util.List;

public class PartySort {
    public static void main(String[] args) {
        FileParser fileParser = new FileParser("./PartySortBase/src/main/resources/participants.txt");
        Filter streamLessFilter = new StreamLessFilter();
        Filter streamsFilter = new StreamsFilter();

        List<Vote> unfilteredList = fileParser.getListOfVotes();

        Util.printHeader("streamless filter");
        List<Vote> filteredList = streamLessFilter.filterResults(unfilteredList);
        filteredList.forEach(System.out::println);

        Util.printHeader("filter with streams");
        filteredList = streamsFilter.filterResults(unfilteredList);
        filteredList.forEach(System.out::println);
    }




}

