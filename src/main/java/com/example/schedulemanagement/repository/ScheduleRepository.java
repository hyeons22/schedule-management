package com.example.schedulemanagement.repository;

import com.example.schedulemanagement.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule , Long> {

    default Schedule findByIdOrElseThrow(Long id){
        return findById(id).orElseThrow(
                () -> new IllegalArgumentException("id에 맞는 일정이 없습니다.")
        );
    }
}
