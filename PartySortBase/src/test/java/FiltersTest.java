import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class FiltersTest {
    @Test
    void testIfStreamLessFilterWorksCorrectly() {
        List<Vote> votes = new ArrayList<>();
        populateList(votes);
        Filter streamlessFilter = new StreamLessFilter();
        List<Vote> filteredVotes = streamlessFilter.filterResults(votes);
        Assertions.assertFalse((filteredVotes.isEmpty()));
        assertThat(filteredVotes.size(), CoreMatchers.equalTo(1));
        Assertions.assertTrue(filteredVotes.get(0).isParticipating());
    }

    @Test
    void testIfStreamsFilterWorksCorrectly() {
        List<Vote> votes = new ArrayList<>();
        populateList(votes);
        Filter streamlessFilter = new StreamsFilter();
        List<Vote> filteredVotes = streamlessFilter.filterResults(votes);
        Assertions.assertFalse((filteredVotes.isEmpty()));
        assertThat(filteredVotes.size(), CoreMatchers.equalTo(1));
        Assertions.assertTrue(filteredVotes.get(0).isParticipating());
    }

    private void populateList(List<Vote> votes) {
        votes.add(new Vote("Tanja", LocalDateTime.of(2020, 10, 4, 10, 17), false));
        votes.add(new Vote("Tanja", LocalDateTime.of(2020, 10, 12, 8, 54), true)); //latest participation (true)
        votes.add(new Vote("Tanja", LocalDateTime.of(2020, 9, 4, 15, 8), false));
        votes.add(new Vote("Tanja", LocalDateTime.of(2019, 7, 18, 22, 15), false));
    }

}
