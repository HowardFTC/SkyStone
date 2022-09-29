package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;//Imports the code for LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;//Imports the TeleOp code
import com.qualcomm.robotcore.hardware.DcMotor;//Imports the code for the DcMotor
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp
public class Color extends LinearOpMode{
    private DcMotor rightDriveMotor;
    private ColorSensor color;

    @Override
    public void runOpMode(){
        rightDriveMotor = hardwareMap.get(DcMotor.class, "rightDriveMotor");
        color = hardwareMap.get(ColorSensor.class, "color");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while(opModeIsActive()){

        }
    }
}