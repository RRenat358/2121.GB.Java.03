import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CatLombok {
    public String name;
    private Integer age;

    public String info(String str1, String str2) {
        return str1 + str2;
    }

    private String info(String str, Integer integer) {
        return str + integer;
    }

}
