// package click.uploadSns.api.domain.services;

// import static org.mockito.Mockito.doNothing;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
// import org.springframework.test.context.junit.jupiter.SpringExtension;

// import click.uploadSns.api.domain.models.Image;
// import click.uploadSns.api.domain.models.Dtos.ImageDto;
// import click.uploadSns.api.domain.repositories.ImageMapper;

// @ExtendWith(SpringExtension.class)
// @MybatisTest
// public class ImageServiceTest {

// @Mock
// private ImageMapper _imageMapper;

// @InjectMocks
// private ImageServiceImpl _imageServiceImpl;

// @Test
// public void findAllTest() {

// List<ImageDto> mockList = new ArrayList<>();
// ImageDto imageDto = new ImageDto();
// mockList.add(imageDto);
// mockList.add(imageDto);

// when(_imageMapper.findAll()).thenReturn(mockList);

// List<ImageDto> resList = _imageServiceImpl.findAll();

// verify(_imageMapper, times(1)).findAll();

// Assertions.assertEquals(mockList.size(), resList.size());
// }

// @Test
// public void findByIdTest() {

// ImageDto imgDto = new ImageDto();

// when(_imageMapper.findById(123)).thenReturn(Optional.of(imgDto));

// ImageDto resDto = _imageServiceImpl.findById(123);

// verify(_imageMapper, times(1)).findById(123);

// Assertions.assertEquals(imgDto, resDto);
// }

// @Test
// public void insertTest() {

// Image image = new Image();
// ImageDto imageDto = new ImageDto();
// image.setId(123);
// imageDto.setId(123);

// doNothing().when(_imageMapper).insert(image);

// when(_imageMapper.findById(123)).thenReturn(Optional.of(imageDto));

// var res = _imageServiceImpl.insert(image);

// verify(_imageMapper, times(1)).insert(image);

// Assertions.assertEquals(123, res.getId());
// }

// @Test
// public void updateTest() {

// Image image = new Image();
// ImageDto imageDto = new ImageDto();
// image.setId(123);
// imageDto.setId(123);

// doNothing().when(_imageMapper).update(image);

// when(_imageMapper.findById(123)).thenReturn(Optional.of(imageDto));

// var res = _imageServiceImpl.update(image);

// verify(_imageMapper, times(1)).update(image);

// Assertions.assertEquals(123, res.getId());
// }

// @Test
// public void deleteTest() {

// doNothing().when(_imageMapper).delete(123);

// int resId = _imageServiceImpl.delete(123);

// verify(_imageMapper, times(1)).delete(123);

// Assertions.assertEquals(123, resId);
// }

// }
