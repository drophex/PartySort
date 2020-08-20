import java.time.LocalDateTime;

public class Vote {
    private LocalDateTime timestamp;
    private String name;
    private boolean isParticipating;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isParticipating() {
        return isParticipating;
    }

    public void setParticipating(boolean participating) {
        isParticipating = participating;
    }

    @Override
    public String toString() {
        return timestamp +
                ", '" + name + '\'' +
                ", " + (isParticipating ? "is participating" : "is NOT participating");
    }
}
