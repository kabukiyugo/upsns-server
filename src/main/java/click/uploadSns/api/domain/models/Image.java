package click.uploadSns.api.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Image {

    private int id;

    private String imageFilePath;

    private int articleId;

}
