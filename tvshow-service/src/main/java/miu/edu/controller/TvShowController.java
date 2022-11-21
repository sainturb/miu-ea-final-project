package miu.edu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;
import miu.edu.service.MotionPictureService;

@RestController
// @RequiredArgsConstructor
@RequestMapping("api/v1/tvshows")
public class TvShowController extends MotionPictureContoller {

    public TvShowController(MotionPictureService motionPictureService) {
        super(motionPictureService);
    }

    // private final TvShowService TvShowService;

    // @GetMapping
    // public List<TvShow> getAllTvShows() {
    // return TvShowService.getAllTvShows();
    // }

    // @GetMapping("/{id}")
    // public TvShow getTvShowById(@PathVariable long id) {
    // return TvShowService.getTvShowById(id);
    // }

    // @PostMapping
    // public TvShow getAllTvShows(@RequestBody TvShow TvShow) {
    // return TvShowService.addTvShow(TvShow);
    // }

    // @DeleteMapping("/{id}")
    // public Boolean deleteTvShowById(@PathVariable long id) {
    // return TvShowService.removeTvShow(id);
    // }

    // @PutMapping("/{id}")
    // public TvShow updateTvShow(@PathVariable long id, @RequestBody TvShow TvShow)
    // {
    // return TvShowService.updateTvShow(id, TvShow);
    // }
}
