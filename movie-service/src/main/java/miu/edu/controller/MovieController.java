package miu.edu.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import miu.edu.dto.MotionPictureDTO;
import miu.edu.dto.MovieDTO;
import miu.edu.service.MotionPictureService;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController extends MotionPictureContoller {

    private final MotionPictureService motionPictureService;

    public MovieController(MotionPictureService motionPictureService) {
        super(motionPictureService);
        this.motionPictureService = motionPictureService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_OWNER')")
    public MotionPictureDTO addMotionPicture(@RequestBody MovieDTO movieDTO) {
        return motionPictureService.addMotionPicture(movieDTO);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    public MotionPictureDTO updateMotionPicture(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
        return motionPictureService.updateMotionPicture(id, movieDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    public Boolean deleteMotionPictureById(@PathVariable Long id) {
        return motionPictureService.removeMotionPicture(id);
    }
}
