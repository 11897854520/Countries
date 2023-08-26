package Main.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class City {

    public City(String name
            , InformationAboutCountryEng countryEng, InformationAboutCountryRus countryRus) {
        this.name = name;
        this.countryEng = countryEng;
        this.countryRus = countryRus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_eng_id")
    private InformationAboutCountryEng countryEng;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_rus_id")
    private InformationAboutCountryRus countryRus;
}
