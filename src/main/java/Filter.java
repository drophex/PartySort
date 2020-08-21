import java.util.List;

public interface Filter {
    List<Vote> filterResults(List<Vote> unfilteredList);
}
