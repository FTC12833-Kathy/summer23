package org.firstinspires.ftc.teamcode.summer2023c;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Achilles", group = "MM")
public class S3_TeleOp extends LinearOpMode {
    public S3_Robot robot = new S3_Robot(this);

    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Initializing... Please Wait");
        telemetry.update();
        robot.init();
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while(opModeIsActive()) {
            robot.collector.runCollector();
            robot.BOB.runTransport();
            telemetry.update();
        }
    }
}
