package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class RedBridge extends LinearOpMode{
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

        armMotor.setTargetPosition(520);
        armMotor.setPower(1);
        wristServo.setPosition(.7);

        //20 degree turn
        rightDriveMotor.setTargetPosition(2305);
        rightDriveMotor.setPower(1);

        while(rightDriveMotor.isBusy()){}

        //22.5in foward
        leftDriveMotor.setTargetPosition(-5102);
        rightDriveMotor.setTargetPosition(7407);
        leftDriveMotor.setPower(1);
        rightDriveMotor.setPower(1);

        while(rightDriveMotor.isBusy() && leftDriveMotor.isBusy()){ }

        //Grab block degres
        leftDriveMotor.setTargetPosition(-11617);
        leftDriveMotor.setPower(1);

        while(rightDriveMotor.isBusy()){ }

        //Point turn
        leftDriveMotor.setTargetPosition(-22892 );
        rightDriveMotor.setTargetPosition(642);
        leftDriveMotor.setPower(1);
        rightDriveMotor.setPower(1);

        //Drive foward
        leftDriveMotor.setTargetPosition(-27206);
        rightDriveMotor.setTargetPosition(4956);
        leftDriveMotor.setPower(1);
        rightDriveMotor.setPower(1);

        while(leftDriveMotor.isBusy() && rightDriveMotor.isBusy()){ }

        //90 degree turn
        leftDriveMotor.setTargetPosition(-118636);
        rightDriveMotor.setTargetPosition(13526);
        leftDriveMotor.setPower(1);
        rightDriveMotor.setPower(1);

        while(leftDriveMotor.isBusy() && rightDriveMotor.isBusy()){ }

        //Dive foward with block
        leftDriveMotor.setTargetPosition(-18636 - 8138);
        rightDriveMotor.setTargetPosition(13526 + 8138);
        leftDriveMotor.setPower(1);
        rightDriveMotor.setPower(1);

        while(leftDriveMotor.isBusy() && rightDriveMotor.isBusy()){ }

        //Drive backwards without block
        leftDriveMotor.setTargetPosition(-18636 - 8138 + 2713);
        rightDriveMotor.setTargetPosition(+13526 + 8138 - 2713);
        leftDriveMotor.setPower(1);
        rightDriveMotor.setPower(1);

        while(leftDriveMotor.isBusy() && rightDriveMotor.isBusy()){ }

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