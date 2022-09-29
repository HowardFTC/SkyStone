package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class RedWall2 extends LinearOpMode{
    private DcMotor rightDriveMotor;
    private DcMotor leftDriveMotor;
    private DcMotor armMotor;
    private Servo wristServo;

    @Override
    public void runOpMode() {
        rightDriveMotor = hardwareMap.get(DcMotor.class, "rightDriveMotor");
        leftDriveMotor = hardwareMap.get(DcMotor.class, "leftDriveMotor");
        armMotor = hardwareMap.get(DcMotor.class, "armMotor");
        wristServo = hardwareMap.get(Servo.class, "wristServo");

        rightDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        waitForStart();

        wristServo.setPosition(.7);

        rightDriveMotor.setTargetPosition(5919);
        rightDriveMotor.setPower(1);
        leftDriveMotor.setTargetPosition(-5919);
        leftDriveMotor.setPower(1);

        while (rightDriveMotor.isBusy()){ }

        rightDriveMotor.setTargetPosition(5919 - 4510);
        rightDriveMotor.setPower(1);
        leftDriveMotor.setTargetPosition(-5919 - 4510);
        leftDriveMotor.setPower(1);

        while (rightDriveMotor.isBusy()){ }

        rightDriveMotor.setTargetPosition(5919 - 4510 + 2000);
        rightDriveMotor.setPower(1);
        leftDriveMotor.setTargetPosition(-5919 - 4510 - 2000);
        leftDriveMotor.setPower(1);

        while (rightDriveMotor.isBusy()){ }
        //Stops motors
        leftDriveMotor.setPower(0.0);
        rightDriveMotor.setPower(0.0);

        telemetry.addData("Status", "Running");
        telemetry.addData("rightDriveMotor", rightDriveMotor.getPower());
        telemetry.addData("leftDriveMotor", leftDriveMotor.getPower());
        telemetry.addData("armMotor", armMotor.getPower());
        telemetry.update();
    }
}