package miu.edu.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import miu.edu.dto.MotionPictureDTO;
import miu.edu.dto.TvShowDTO;
import miu.edu.service.MotionPictureService;

@RestController
@RequestMapping("api/v1/tvshows")
public class TvShowController extends MotionPictureContoller {

    private final MotionPictureService motionPictureService;

    public TvShowController(MotionPictureService motionPictureService) {
        super(motionPictureService);
        this.motionPictureService = motionPictureService;
    }

    @PostMapping
    public MotionPictureDTO addMotionPicture(@RequestBody TvShowDTO tvShowDTO) {
        return motionPictureService.addMotionPicture(tvShowDTO);
    }

    @PutMapping("/{id}")
    public MotionPictureDTO updateTvShow(@PathVariable Long id, @RequestBody TvShowDTO tvShowDTO) {
        return motionPictureService.updateMotionPicture(id, tvShowDTO);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteTvShowById(@PathVariable Long id) {
        return motionPictureService.removeMotionPicture(id);
    }
}
