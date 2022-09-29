package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class ArmTest extends LinearOpMode{
    private DcMotor armMotor;

    @Override
    public void runOpMode() {
        armMotor = hardwareMap.get(DcMotor.class, "armMotor");

        armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();

        armMotor.setTargetPosition(720);
        armMotor.setPower(.5);

        while(armMotor.isBusy()){ }

        armMotor.setPower(0.0);

        telemetry.addData("Status", "Running");
        telemetry.addData("armMotor", armMotor.getPower());
        telemetry.update();
    }
}