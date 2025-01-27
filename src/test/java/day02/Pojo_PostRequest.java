package day02;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Pojo_PostRequest {

    @JsonProperty("name")
    private String name;
    @JsonProperty("location")
    private String location;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("courses")
    private String[] courses;

}

//@JsonIgnoreProperties(ignoreUnknown = true) anotasyonu, Jackson kütüphanesi tarafından bir JSON verisini Java nesnesine dönüştürürken (deserialization),
// JSON içinde tanınmayan veya Java sınıfında karşılığı olmayan alanlar bulunduğunda bir hata fırlatılmasını önlemek için kullanılır.