package org.firstinspires.ftc.teamcode.summer2023a;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public class S1_Robot {
    private LinearOpMode opMode;

    public S1_Drivetrain drivetrain;
    public S1_Lift lift;
    public S1_Collector collector;

    private ElapsedTime runtime = new ElapsedTime();

    public S1_Robot(LinearOpMode opMode){
        this.opMode = opMode;
    }

    public void init() {
        drivetrain = new S1_Drivetrain(opMode);
        lift = new S1_Lift(opMode);
        collector = new S1_Collector(opMode);
    }

}