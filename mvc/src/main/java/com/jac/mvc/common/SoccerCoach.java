package com.jac.mvc.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Qualifier("soccer")
public class SoccerCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Shoot 200 times into the net";
    }
}
