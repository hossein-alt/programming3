package com.jac.mvc.controller;

import com.jac.mvc.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequiredArgsConstructor
public class DemoController {
    private final Coach coach; // access via qualifier

    private final List<Coach> coaches; //access to all instances

    private final Coach partTimeCoach;
    //dependency injection by constructor
    @Autowired
    public DemoController(@Qualifier("soccer") Coach coach,
                          List<Coach> coaches,
                          @Qualifier("cricket") Coach partTimeCoach){
        this.coach = coach;
        this.coaches = coaches;
        this.partTimeCoach = partTimeCoach;
    }

    @GetMapping("/dailyWorkouts")
    public String getDailyWorkouts(){
        StringBuilder result = new StringBuilder();

        for(Coach coach : coaches){
            String program = coach.getDailyWorkout();
            result.append(program).append(" / ");
        }

        return result.toString();
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return coach.getDailyWorkout();
    }

    @GetMapping("/parttime/dailyWorkout")
    public String getPartTimeDailyWorkout(){
        return partTimeCoach.getDailyWorkout();
    }
}
