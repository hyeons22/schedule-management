package com.example.schedulemanagement.controller;

import com.example.schedulemanagement.dto.ScheduleRequestDto;
import com.example.schedulemanagement.dto.ScheduleResponseDto;
import com.example.schedulemanagement.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 일정 생성
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto requestDto){
        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto);
        return ResponseEntity.ok(scheduleResponseDto);
    }

    // 일정 전체조회
    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponseDto>> findAll(){
        return ResponseEntity.ok(scheduleService.findAll());
    }

    // 일정 단건 조회
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long scheduleId){
        return ResponseEntity.ok(scheduleService.findById(scheduleId));
    }

    // 일정 수정
    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> update(@PathVariable Long scheduleId, @RequestBody ScheduleRequestDto requestDto){
        return ResponseEntity.ok(scheduleService.update(scheduleId, requestDto));
    }

    // 일정 삭제
    @DeleteMapping("/schedules/{scheduleId}")
    public void deleteById(@PathVariable Long scheduleId){
        scheduleService.deleteById(scheduleId);
    }

}
