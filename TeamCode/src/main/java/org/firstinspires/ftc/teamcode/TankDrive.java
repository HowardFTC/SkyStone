package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class TankDrive extends LinearOpMode{
    private DcMotor rightDriveMotor;
    private DcMotor leftDriveMotor;

    @Override
    public void runOpMode(){
        rightDriveMotor = hardwareMap.get(DcMotor.class, "rightDriveMotor");
        leftDriveMotor = hardwareMap.get(DcMotor.class, "leftDriveMotor");

        waitForStart();

        double tgtPower1 = 0.0;
        double tgtPower2 = 0.0;
        while (opModeIsActive()){
            tgtPower1 = -this.gamepad1.right_stick_y;
            rightDriveMotor.setPower(tgtPower1);
            tgtPower2 = this.gamepad1.left_stick_y;
            leftDriveMotor.setPower(tgtPower2);

            telemetry.addData("Status", "Running");
            telemetry.addData("Target1 Power", tgtPower1);
            telemetry.addData("Target2 Power", tgtPower2);
            telemetry.addData("rightDriveMotor Power", rightDriveMotor.getPower());
            telemetry.addData("leftDriveMotor Power", leftDriveMotor.getPower());
            telemetry.update();
        }
    }
}