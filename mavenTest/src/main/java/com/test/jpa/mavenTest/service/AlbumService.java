package com.test.jpa.mavenTest.service;

import com.test.jpa.mavenTest.dto.AlbumDto;
import com.test.jpa.mavenTest.entity.itemTable.Album;
import com.test.jpa.mavenTest.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    //음악앨범_저장
    @Transactional
    public Long albumCreate(AlbumDto albumDto) {
        Album album = Album.albumCreate(albumDto.getArtist(), albumDto.getEtc(), albumDto.getName(), albumDto.getPrice(), albumDto.getStockQuantity());
        Album saveAlbum = albumRepository.save(album);
        return saveAlbum.getId();
    }

    //음악앨범_단일조회
    public AlbumDto albumFindOne(Long id) {
        AlbumDto albumDto = albumRepository.findByIdByDto(id);
        return albumDto;
    }

    //음악앨범_전체조회
    public List<AlbumDto> albumFindAll() {
        List<AlbumDto> albumList = albumRepository.findByAllByDto();
        return albumList;
    }

    //음악앨범_수정
    @Transactional
    public Long albumUpdate(AlbumDto albumDto) {
        Optional<Album> optAlbum = albumRepository.findById(albumDto.getId());
        Album findAlbum = Optional.ofNullable(optAlbum.get()).get();
        Album updateAlbum = findAlbum.albumUpdate(albumDto.getId(), albumDto.getArtist(), albumDto.getEtc(), albumDto.getName(),
                                                   albumDto.getPrice(), albumDto.getStockQuantity());
        Album saveAlbum = albumRepository.save(updateAlbum);
        return saveAlbum.getId();
    }
}
