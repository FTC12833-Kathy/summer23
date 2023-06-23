package org.firstinspires.ftc.teamcode.summer2023b;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TeleOp", group="MM")
public class S2_TeleOp extends LinearOpMode {
    public S2_Robot robot = new S2_Robot(this);

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
