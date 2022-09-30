package click.uploadSns.api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccessLog {
    private int id;
    private String accessUri;
    private int userId;

}
