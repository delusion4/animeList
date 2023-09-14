package ms.animeservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import java.util.List;


@Entity
@Table(name = "anime")
@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Anime {

    @Id
    @Column(name = "mal_id")
    private Integer malId;

    private String url;

    @OneToMany
    @JoinColumn(name = "anime_id")
    @Cascade(CascadeType.ALL)
    @ToString.Exclude
    private List<Image> images;

    private String title;

    @Column(name = "title_english")
    private String titleEnglish;

    @Column(name = "title_japanese")
    private String titleJapanese;

    @OneToMany
    @JoinColumn(name = "anime_id")
    @Cascade(CascadeType.ALL)
    @ToString.Exclude
    private List<TitleSynonym> titleSynonyms;

    private String type;
    private Integer episodes;
    private Boolean airing;
    private String status;
    private String duration;
    private Integer year;

    @ManyToMany
    @Cascade(CascadeType.MERGE)
    @ToString.Exclude
    @JoinTable(
        name = "anime_genre",
        joinColumns = @JoinColumn(name = "anime_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    @ManyToMany
    @Cascade(CascadeType.MERGE)
    @ToString.Exclude
    @JoinTable(
        name = "anime_studio",
        joinColumns = @JoinColumn(name = "anime_id"),
        inverseJoinColumns = @JoinColumn(name = "studio_id"))
    private List<Studio> studios;
}
