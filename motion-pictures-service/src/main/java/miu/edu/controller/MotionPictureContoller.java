package miu.edu.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import miu.edu.dto.MotionPictureDTO;
import miu.edu.service.MotionPictureService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/motionpictures")
public class MotionPictureContoller {

    private final MotionPictureService motionPictureService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<MotionPictureDTO> getAllMotionPictures() {
        return motionPictureService.getAllMotionPictures();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public MotionPictureDTO getMotionPictureById(@PathVariable Long id) {
        return motionPictureService.getMotionPictureById(id);
    }

    @GetMapping(path = "/filter", params = "releasedyear")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<MotionPictureDTO> findAllByReleasedYearEquals(
            @RequestParam(name = "releasedyear") Integer releasedYear) {
        return motionPictureService.findAllByReleasedYearEquals(releasedYear);
    }

    @GetMapping(path = "/filter", params = "minrating")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<MotionPictureDTO> findAllByRatingGreaterThanOrEquals(@RequestParam double minrating) {
        return motionPictureService.findAllByRatingGreaterThanOrEquals(minrating);
    }

    @GetMapping(path = "/filter", params = "maxrating")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<MotionPictureDTO> findAllByRatingLessThanOrEquals(double maxrating) {
        return motionPictureService.findAllByRatingLessThanOrEquals(maxrating);
    }

    @GetMapping(path = "/filter", params = { "minrating", "maxrating" })
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<MotionPictureDTO> findAllByRatingBetween(@RequestParam double minrating,
            @RequestParam double maxrating) {
        return motionPictureService.findAllByRatingBetween(minrating, maxrating);
    }

    @GetMapping(path = "/filter", params = "rating")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<MotionPictureDTO> findAllByRatingEquals(double rating) {
        return motionPictureService.findAllByRatingEquals(rating);
    }

    @GetMapping(path = "/filter", params = "genre_id")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<MotionPictureDTO> findAllByGenresEquals(Long genre_id) {
        return motionPictureService.findAllByGenresId(genre_id);
    }

    @GetMapping(path = "/filter", params = "genre_name")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<MotionPictureDTO> findAllByGenresIn(String genre_name) {
        return motionPictureService.findAllByGenres_NameEquals(genre_name);
    }

    @GetMapping(path = "/filter", params = "director_id")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<MotionPictureDTO> findAllByDirectorIdEquals(Long director_id) {
        return motionPictureService.findAllByDirectorIdEquals(director_id);
    }

    @GetMapping(path = "/filter", params = "minduration")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<MotionPictureDTO> findAllByDurationGreaterThanOrEquals(double minduration) {
        return motionPictureService.findAllByDurationGreaterThanOrEquals(minduration);
    }

    @GetMapping(path = "/filter", params = "maxduration")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<MotionPictureDTO> findAllByDurationLessThanOrEquals(double maxduration) {
        return motionPictureService.findAllByDurationLessThanOrEquals(maxduration);
    }

    @GetMapping(path = "/filter", params = { "minduration", "maxduration" })
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<MotionPictureDTO> findAllByDurationBetween(double minduration, double maxduration) {
        return motionPictureService.findAllByDurationBetween(minduration, maxduration);
    }

    @GetMapping(path = "/filter", params = "duration")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<MotionPictureDTO> findAllByDurationEquals(double duration) {
        return motionPictureService.findAllByDurationEquals(duration);
    }

    @GetMapping(path = "/filter", params = "actor_id")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<MotionPictureDTO> findAllByCharacters_ActorIdEquals(Long actor_id) {
        return motionPictureService.findAllByCharacters_ActorIdEquals(actor_id);
    }

}
