package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class FiveSecondTest extends LinearOpMode{
    private DcMotor rightDriveMotor;
    private DcMotor leftDriveMotor;

    @Override
    public void runOpMode() {
        rightDriveMotor = hardwareMap.get(DcMotor.class, "rightDriveMotor");
        leftDriveMotor = hardwareMap.get(DcMotor.class, "leftDriveMotor");

        waitForStart();

        rightDriveMotor.setPower(1);
        leftDriveMotor.setPower(-1);

        sleep(5000);

        while(rightDriveMotor.isBusy() && leftDriveMotor.isBusy()){ }

        rightDriveMotor.setPower(0);
        leftDriveMotor.setPower(0);

        telemetry.addData("Status", "Running");
        telemetry.addData("rightDriveMotor", rightDriveMotor.getPower());
        telemetry.addData("leftDriveMotor", leftDriveMotor.getPower());
        telemetry.update();
    }
}