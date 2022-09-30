package click.uploadSns.api.domain.models.Dtos;

import lombok.Data;

@Data
public class ImageDto {

    private int id;

    private String imageFilePath;

    private String insertTime;

    private String updateTime;
}
