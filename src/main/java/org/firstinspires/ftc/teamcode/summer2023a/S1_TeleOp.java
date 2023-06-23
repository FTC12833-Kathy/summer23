package org.firstinspires.ftc.teamcode.summer2023a;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="S1_TeleOp", group="MM")
@Disabled
public class S1_TeleOp extends LinearOpMode {
    public S1_Robot robot = new S1_Robot(this);

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initializing... Please wait");
        telemetry.update();
        robot.init();
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        while (opModeIsActive()) {
            robot.drivetrain.driveWithSticks();
            robot.lift.runLift();
            robot.collector.runCollector();
            telemetry.update();
        }
    }
}
