package Main.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Coordinates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private final String preNorth;
    private final String north;
    private final String preSouth;
    private final String south;
    private final String preWest;
    private final String west;
    private final String preEast;
    private final String east;

    private String parameter(String string, String preString) {
        return preString + ": " + (!string.equals("null") ? string
                : (preString.matches("[A-z]+") ? "No information" : "Нет информации"));
    }

    public String toString() {
        return "<ul class = 'coordinates'>"
                + "<li>" + parameter(north, preNorth) + "</li>"
                + "<li>" + parameter(south, preSouth) + "</li>"
                + "<li>" + parameter(west, preWest) + "</li>"
                + "<li>" + parameter(east, preEast) + "</li>" + "</ul>";
    }
}
