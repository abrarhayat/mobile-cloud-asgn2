package org.magnum.mobilecloud.video.controller;

import java.util.Collection;

import org.magnum.mobilecloud.video.client.VideoSvcApi;
import org.magnum.mobilecloud.video.repository.Video;
import org.magnum.mobilecloud.video.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.common.collect.Lists;

import static org.magnum.mobilecloud.video.client.VideoSvcApi.TITLE_PARAMETER;
import static org.magnum.mobilecloud.video.client.VideoSvcApi.VIDEO_SVC_PATH;

@Controller
public class VideoController {

    @Autowired
    private VideoRepository videos;

    @RequestMapping(value = VIDEO_SVC_PATH, method = RequestMethod.POST)
    public @ResponseBody
    Video addVideo(@RequestBody Video v) {
        videos.save(v);
        return v;
    }

    @RequestMapping(value = VIDEO_SVC_PATH + "/{id}/like", method = RequestMethod.POST)
    public Void likeVideo(long id) {
        videos.findById(id);
        return null;
    }

    @RequestMapping(value = VIDEO_SVC_PATH + "/{id}/unlike", method = RequestMethod.POST)
    public Void unlikeVideo(long id) {
        return null;
    }

    @RequestMapping(value = VIDEO_SVC_PATH, method = RequestMethod.GET)
    public @ResponseBody
    Collection<Video> getVideoList() {
        return Lists.newArrayList(videos.findAll());
    }

    @RequestMapping(value = VIDEO_SVC_PATH  + "/{id}", method = RequestMethod.GET)
    public @ResponseBody Video getVideoById(@PathVariable long id) {
        return videos.findById(id);
    }

    @RequestMapping(value = VideoSvcApi.VIDEO_TITLE_SEARCH_PATH, method = RequestMethod.GET)
    public @ResponseBody
    Collection<Video> findByTitle(@RequestParam(TITLE_PARAMETER) String title) {
        return videos.findByName(title);
    }

    @RequestMapping(value = VideoSvcApi.VIDEO_DURATION_SEARCH_PATH, method = RequestMethod.GET)
    public @ResponseBody
    Collection<Video> findByDurationLessThan(@RequestParam long duration) {
        return videos.findByDurationLessThan(duration);
    }

}
