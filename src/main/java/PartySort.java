import java.util.List;

public class PartySort {
    public static void main(String[] args) {
        FileParser fileParser = new FileParser();
        Filter filter = new StreamLessFilter();

        List<Vote> unfilteredList = fileParser.getListOfVotes();
        List<Vote> filteredList = filter.filterResults(unfilteredList);
        filteredList.forEach(System.out::println);
    }


}

