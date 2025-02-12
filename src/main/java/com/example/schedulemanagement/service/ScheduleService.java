package com.example.schedulemanagement.service;

import com.example.schedulemanagement.dto.ScheduleRequestDto;
import com.example.schedulemanagement.dto.ScheduleResponseDto;
import com.example.schedulemanagement.entity.Schedule;
import com.example.schedulemanagement.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    // 일정생성
    @Transactional
    public ScheduleResponseDto save(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto.getName(), requestDto.getTitle(), requestDto.getTask());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(
                savedSchedule.getId(),
                savedSchedule.getName(),
                savedSchedule.getTitle(),
                savedSchedule.getTask()
        );
    }

    // 일정 전체 조회
    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleResponseDto> dtoList = new ArrayList<>();
        for (Schedule schedule : schedules) {
            ScheduleResponseDto scheduleResponseDto =
                    new ScheduleResponseDto(
                            schedule.getId(),
                            schedule.getName(),
                            schedule.getTitle(),
                            schedule.getTask()
                    );
            dtoList.add(scheduleResponseDto);
        }
        return dtoList;
    }

    // 일정 단건 조회
    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long scheduleId) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);
        return new ScheduleResponseDto(schedule.getId(), schedule.getName(), schedule.getTitle(), schedule.getTask());
    }
}
