package org.magnum.mobilecloud.video.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface VideoRepository extends CrudRepository<Video, Long> {
    public Collection<Video> findByName(String title);
    public Video findById(long id);
    public Collection<Video> findByDurationLessThan(long duration);
}
