package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class AutoTest extends LinearOpMode {
    private DcMotor rightDriveMotor;
    private DcMotor leftDriveMotor;
    private Servo wristServo;
    private Servo clawServo;

    @Override
    public void runOpMode() {
        rightDriveMotor = hardwareMap.get(DcMotor.class, "rightDriveMotor");
        leftDriveMotor = hardwareMap.get(DcMotor.class, "leftDriveMotor");
        clawServo = hardwareMap.get(Servo.class, "clawServo");

        waitForStart();
    }
}