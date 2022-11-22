package miu.edu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import miu.edu.model.MotionPicture;
import miu.edu.service.MotionPictureService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/motionpictures")
public class MotionPictureContoller {

    private final MotionPictureService motionPictureService;

    @GetMapping
    public List<MotionPicture> getAllMotionPictures() {
        return motionPictureService.getAllMotionPictures();
    }

    @GetMapping("/{id}")
    public MotionPicture getMotionPictureById(@PathVariable Long id) {
        return motionPictureService.getMotionPictureById(id);
    }

    @GetMapping(path = "/filter", params = "releasedyear")
    public List<MotionPicture> findAllByReleasedYearEquals(@RequestParam(name = "releasedyear") Integer releasedYear) {
        return motionPictureService.findAllByReleasedYearEquals(releasedYear);
    }

    @GetMapping(path = "/filter", params = "minrating")
    public List<MotionPicture> findAllByRatingGreaterThanOrEquals(@RequestParam double minrating) {
        return motionPictureService.findAllByRatingGreaterThanOrEquals(minrating);
    }

    @GetMapping(path = "/filter", params = "maxrating")
    public List<MotionPicture> findAllByRatingLessThanOrEquals(double maxrating) {
        return motionPictureService.findAllByRatingLessThanOrEquals(maxrating);
    }

    @GetMapping(path = "/filter", params = { "minrating", "maxrating" })
    public List<MotionPicture> findAllByRatingBetween(@RequestParam double minrating, @RequestParam double maxrating) {
        return motionPictureService.findAllByRatingBetween(minrating, maxrating);
    }

    @GetMapping(path = "/filter", params = "rating")
    public List<MotionPicture> findAllByRatingEquals(double rating) {
        return motionPictureService.findAllByRatingEquals(rating);
    }

    @GetMapping(path = "/filter", params = "genre_id")
    public List<MotionPicture> findAllByGenresEquals(Long genre_id) {
        return motionPictureService.findAllByGenresId(genre_id);
    }

    @GetMapping(path = "/filter", params = "genre_name")
    public List<MotionPicture> findAllByGenresIn(String genre_name) {
        return motionPictureService.findAllByGenres_NameEquals(genre_name);
    }

    @GetMapping(path = "/filter", params = "director_id")
    public List<MotionPicture> findAllByDirectorIdEquals(Long director_id) {
        return motionPictureService.findAllByDirectorIdEquals(director_id);
    }

    @GetMapping(path = "/filter", params = "minduration")
    public List<MotionPicture> findAllByDurationGreaterThanOrEquals(double minduration) {
        return motionPictureService.findAllByDurationGreaterThanOrEquals(minduration);
    }

    @GetMapping(path = "/filter", params = "maxduration")
    public List<MotionPicture> findAllByDurationLessThanOrEquals(double maxduration) {
        return motionPictureService.findAllByDurationLessThanOrEquals(maxduration);
    }

    @GetMapping(path = "/filter", params = { "minduration", "maxduration" })
    public List<MotionPicture> findAllByDurationBetween(double minduration, double maxduration) {
        return motionPictureService.findAllByDurationBetween(minduration, maxduration);
    }

    @GetMapping(path = "/filter", params = "duration")
    public List<MotionPicture> findAllByDurationEquals(double duration) {
        return motionPictureService.findAllByDurationEquals(duration);
    }

    @GetMapping(path = "/filter", params = "actor_id")
    public List<MotionPicture> findAllByCharacters_ActorIdEquals(Long actor_id) {
        return motionPictureService.findAllByCharacters_ActorIdEquals(actor_id);
    }

    @PostMapping
    public MotionPicture getAllMotionPictures(@RequestBody MotionPicture motionPicture) {
        return motionPictureService.addMotionPicture(motionPicture);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteMotionPictureById(@PathVariable Long id) {
        return motionPictureService.removeMotionPicture(id);
    }

    @PutMapping("/{id}")
    public MotionPicture updateMotionPicture(@PathVariable Long id, @RequestBody MotionPicture motionPicture) {
        return motionPictureService.updateMotionPicture(id, motionPicture);
    }

}
